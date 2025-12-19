package com.cafe.order.global.security.service;

import com.cafe.order.domain.user.entity.User;
import com.cafe.order.domain.user.repo.JpaUserRepository;
import com.cafe.order.global.security.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final JpaUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. DB에서 loginId로 조회
        User user = userRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디를 가진 유저가 없습니다: " + username));

        // 2. 시큐리티가 이해할 수 있는 CustomUserDetails로 감싸서 반환
        // (비밀번호 검증은 시큐리티가 알아서 함)
        return new CustomUserDetails(user);
    }
}
