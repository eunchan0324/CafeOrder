/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: '#0f766e',
          50: '#f0fdfa',
          100: '#ccfbf1',
          200: '#99f6e4',
          300: '#5eead4',
          400: '#2dd4bf',
          500: '#14b8a6',
          600: '#0d9488',
          700: '#0f766e', // Main
          800: '#115e59',
          900: '#134e4a',
        },
        secondary: {
          DEFAULT: '#fff7ed',
          50: '#fffbf5',
          100: '#fff7ed', // Main
          200: '#fef3e2',
          300: '#fdead7',
        },
        accent: {
          DEFAULT: '#f97316',
          50: '#fff7ed',
          100: '#ffedd5',
          200: '#fed7aa',
          300: '#fdba74',
          400: '#fb923c',
          500: '#f97316', // Main
          600: '#ea580c',
          700: '#c2410c',
          800: '#9a3412',
          900: '#7c2d12',
        },
        danger: {
          DEFAULT: '#ef4444',
          50: '#fef2f2',
          100: '#fee2e2',
          200: '#fecaca',
          300: '#fca5a5',
          400: '#f87171',
          500: '#ef4444', // Main
          600: '#dc2626',
          700: '#b91c1c',
          800: '#991b1b',
          900: '#7f1d1d',
        },
        success: {
          DEFAULT: '#22c55e',
          50: '#f0fdf4',
          100: '#dcfce7',
          200: '#bbf7d0',
          300: '#86efac',
          400: '#4ade80',
          500: '#22c55e', // Main
          600: '#16a34a',
          700: '#15803d',
          800: '#166534',
          900: '#14532d',
        },
      },
      fontFamily: {
        sans: ['Pretendard', 'system-ui', '-apple-system', 'sans-serif'],
      },
      borderRadius: {
        'cozy': '16px',
      },
      boxShadow: {
        'cozy': '0 4px 20px rgba(0, 0, 0, 0.08)',
        'cozy-hover': '0 8px 30px rgba(0, 0, 0, 0.12)',
      },
      // 레이아웃별 반응형 브레이크포인트
      screens: {
        'mobile': '375px',      // Customer (모바일)
        'tablet': '768px',      // Seller (포스기/태블릿)
        'desktop': '1024px',    // Admin (데스크탑)
        'wide': '1440px',       // Admin (와이드 모니터)
      },
      // 레이아웃별 최대 너비
      maxWidth: {
        'mobile': '430px',      // Customer 최대 너비
        'tablet': '1024px',     // Seller 최대 너비
        'desktop': '1920px',    // Admin 최대 너비
      },
      // 레이아웃별 간격
      spacing: {
        'mobile-safe': 'max(env(safe-area-inset-bottom), 1rem)',
        'nav-mobile': '60px',   // 모바일 하단 네비게이션 높이
        'nav-tablet': '80px',   // 태블릿 상단 네비게이션 높이
        'sidebar': '240px',     // 데스크탑 사이드바 너비
      },
    },
  },
  plugins: [],
}
