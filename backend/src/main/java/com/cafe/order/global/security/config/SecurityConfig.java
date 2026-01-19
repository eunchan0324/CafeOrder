package com.cafe.order.global.security.config;

import com.cafe.order.domain.user.service.UserService;
import com.cafe.order.global.security.handler.CustomAuthenticationSuccessHandler;
import com.cafe.order.global.security.jwt.JwtAuthenticationFilter;
import com.cafe.order.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    // JWT 관련 의존성 추가
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))

                // 1. JWT 필터 등록
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, userService),
                        UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth
                        // H2 콘솔 및 정적 리소스 허용
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico", "/error").permitAll()

                        // Health Check API 허용 (프론트 연결 테스트용)
                        .requestMatchers("/api/health").permitAll()

                        // [공통] 로그인 관련 경로 허용
                        .requestMatchers("/", "/login", "/users/signup", "/join", "/login-proc").permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll() // JWT 로그인 api 허용

                        // [API 권한 설정] - JWT 토큰이 있으면 필터가 인증 처리해줌
                        .requestMatchers("/api/v1/customer/**").hasRole("CUSTOMER")
                        .requestMatchers("/api/v1/seller/**").hasRole("SELLER")
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                        
                        // [기존 웹 페이지 권한 설정]
                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
                        .requestMatchers("/seller/**").hasRole("SELLER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                // 기존 폼 로그인 유지 (타임리프용)
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login-proc")
                        .usernameParameter("loginId")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    // CORS 설정 구체화
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 프론트엔드 주소 허용 (포트 5173)
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

        // 모든 헤더 허용
        configuration.setAllowedHeaders(List.of("*"));

        // 쿠키/세션 인증 정보 허용 (로그인 유지에 필수)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 적용
        return source;
    }
}