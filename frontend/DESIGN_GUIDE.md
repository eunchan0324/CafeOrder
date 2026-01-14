# 🎨 카페오더 디자인 가이드

## 디자인 컨셉
**"Cozy & Modern"** - 따뜻하고 현대적인 카페 분위기

---

## 🎭 3가지 레이아웃 전략

### 1️⃣ Customer (구매자) - 모바일 앱 레이아웃

**컨셉**: 스마트폰으로 편하게 주문하는 모바일 앱 느낌

**특징**:
- 📱 세로 스크롤 중심
- 👆 큰 터치 영역 (최소 44px)
- 🔽 하단 플로팅 버튼/네비게이션
- 🌈 밝고 따뜻한 색상 (secondary 배경)
- 📸 비주얼 중심 (메뉴 이미지 강조)

**레이아웃 스펙**:
```css
- 최대 너비: 430px (중앙 정렬)
- 패딩: 16px (좌우)
- 하단 네비게이션 높이: 60px
- 카드 라운드: 16px (cozy)
- 버튼 높이: 48px 이상
```

**주요 페이지**:
- 지점 선택
- 메뉴판
- 장바구니
- 주문 내역

**Tailwind 클래스 예시**:
```tsx
<div className="max-w-mobile mx-auto px-4 pb-nav-mobile">
  <button className="btn btn-accent w-full h-12">
    주문하기
  </button>
</div>
```

---

### 2️⃣ Seller (판매자) - 포스기/태블릿 레이아웃

**컨셉**: 매장에서 사용하는 포스기 느낌 (가로 방향 태블릿)

**특징**:
- 📊 가로 방향 (Landscape)
- 🖐️ 큰 터치 영역 (포스기처럼)
- 🔢 그리드 레이아웃 (주문 목록 + 상세)
- ⚡ 빠른 액션 버튼 (주문 승인/거부)
- 🎯 시각적 피드백 강조

**레이아웃 스펙**:
```css
- 최대 너비: 1024px
- 2단 레이아웃 (주문 목록 60% + 상세 40%)
- 상단 네비게이션 높이: 80px
- 버튼 크기: 최소 56px x 56px
- 아이콘 크기: 32px
```

**주요 페이지**:
- 실시간 주문 현황
- 주문 상세
- 지점 정보 관리
- 메뉴 재고 관리

**Tailwind 클래스 예시**:
```tsx
<div className="max-w-tablet mx-auto h-screen flex">
  <div className="w-3/5 p-6">
    {/* 주문 목록 */}
  </div>
  <div className="w-2/5 bg-white p-6">
    {/* 주문 상세 */}
  </div>
</div>
```

---

### 3️⃣ Admin (관리자) - 웹 대시보드 레이아웃

**컨셉**: 전통적인 관리자 대시보드 (데스크탑)

**특징**:
- 🖥️ 좌측 사이드바 + 메인 컨텐츠
- 📊 테이블/차트 중심
- 🔍 검색/필터 기능 강조
- 📈 데이터 시각화
- 🎨 깔끔한 화이트 배경

**레이아웃 스펙**:
```css
- 사이드바 너비: 240px (고정)
- 메인 컨텐츠: 나머지 영역
- 상단 헤더 높이: 64px
- 카드 패딩: 24px
- 테이블 행 높이: 48px
```

**주요 페이지**:
- 대시보드 (통계)
- 지점 관리 (CRUD)
- 판매자 관리
- 메뉴 관리
- 주문 관리

**Tailwind 클래스 예시**:
```tsx
<div className="flex h-screen">
  <aside className="w-sidebar bg-white border-r">
    {/* 사이드바 */}
  </aside>
  <main className="flex-1 overflow-auto bg-gray-50">
    <header className="h-16 bg-white border-b px-6">
      {/* 헤더 */}
    </header>
    <div className="p-6">
      {/* 메인 컨텐츠 */}
    </div>
  </main>
</div>
```

---

## 🎨 컬러 팔레트

### Primary (Deep Teal) - `#0f766e`
**용도**: 브랜드 컬러, 헤더, 주요 액션
- Customer: 헤더, 탭 선택 상태
- Seller: 주문 승인 버튼
- Admin: 사이드바 선택 항목

### Secondary (Warm Orange White) - `#fff7ed`
**용도**: 배경색 (따뜻한 느낌)
- Customer: 전체 배경
- Seller: 비활성 영역
- Admin: 사용 최소화 (화이트 중심)

### Accent (Bright Orange) - `#f97316`
**용도**: 강조, 주문/결제 버튼
- Customer: 주문하기, 장바구니 담기
- Seller: 긴급 주문 알림
- Admin: 중요 액션 (생성, 저장)

### Danger (Red) - `#ef4444`
**용도**: 삭제, 거부, 품절
- Customer: 품절 표시
- Seller: 주문 거부
- Admin: 삭제 버튼

### Success (Green) - `#22c55e`
**용도**: 완료, 성공
- Customer: 주문 완료
- Seller: 주문 승인
- Admin: 성공 메시지

---

## 📐 간격 시스템

```
xs:  4px   (0.5rem)
sm:  8px   (1rem)
md:  16px  (2rem)
lg:  24px  (3rem)
xl:  32px  (4rem)
```

**레이아웃별 권장 패딩**:
- Customer: 16px (모바일 최적화)
- Seller: 24px (터치 영역 확보)
- Admin: 24px (정보 밀도 높음)

---

## 🔤 타이포그래피

### 폰트 패밀리
**Pretendard** (웹폰트, CDN)
- 가독성 우수
- 한글 최적화
- 다양한 굵기 지원

### 폰트 크기

**Customer (모바일)**:
```
제목 (H1): 24px (font-bold)
부제목 (H2): 20px (font-semibold)
본문: 16px (font-normal)
캡션: 14px (text-gray-600)
```

**Seller (태블릿)**:
```
제목: 28px (font-bold)
부제목: 22px (font-semibold)
본문: 18px (font-normal)
```

**Admin (데스크탑)**:
```
페이지 제목: 32px (font-bold)
섹션 제목: 20px (font-semibold)
본문: 16px (font-normal)
테이블: 14px (font-normal)
```

---

## 🧩 공통 컴포넌트 스타일

### 버튼

**Customer**:
```tsx
<button className="btn btn-accent w-full h-12 text-base">
  주문하기
</button>
```

**Seller**:
```tsx
<button className="btn btn-primary h-14 px-8 text-lg">
  승인
</button>
```

**Admin**:
```tsx
<button className="btn btn-primary h-10 px-6 text-sm">
  저장
</button>
```

### 카드

**Customer**:
```tsx
<div className="card hover:shadow-cozy-hover cursor-pointer">
  {/* 메뉴 카드 */}
</div>
```

**Seller**:
```tsx
<div className="bg-white rounded-lg shadow-lg p-6">
  {/* 주문 카드 */}
</div>
```

**Admin**:
```tsx
<div className="bg-white rounded-lg border border-gray-200 p-6">
  {/* 통계 카드 */}
</div>
```

### 입력 필드

**모든 레이아웃 공통**:
```tsx
<input className="input" placeholder="검색어 입력" />
```

---

## 📱 반응형 가이드

### Breakpoints

```js
mobile:  375px   // Customer 기본
tablet:  768px   // Seller 기본
desktop: 1024px  // Admin 기본
wide:    1440px  // Admin 와이드
```

### 사용 예시

```tsx
<div className="
  grid grid-cols-1           // 모바일: 1열
  tablet:grid-cols-2         // 태블릿: 2열
  desktop:grid-cols-3        // 데스크탑: 3열
">
  {/* 카드 목록 */}
</div>
```

---

## ✅ 개발 시 체크리스트

### 공통
- [ ] Pretendard 폰트 로드 확인
- [ ] 색상은 tailwind.config.js의 커스텀 컬러 사용
- [ ] 버튼은 `.btn` 클래스 활용
- [ ] 카드는 `.card` 클래스 또는 커스텀 스타일

### Customer (모바일)
- [ ] 최대 너비 430px 제한
- [ ] 하단 플로팅 요소 고려 (pb-nav-mobile)
- [ ] 터치 영역 최소 44px
- [ ] 세이프 에어리어 대응 (노치)
- [ ] secondary 배경색 사용

### Seller (태블릿)
- [ ] 가로 방향 레이아웃
- [ ] 2단 구조 (목록 + 상세)
- [ ] 터치 영역 최소 56px
- [ ] 시각적 피드백 명확히

### Admin (데스크탑)
- [ ] 사이드바 + 메인 레이아웃
- [ ] 테이블 스타일 일관성
- [ ] 마우스 호버 효과
- [ ] 화이트 배경 중심

---

## 🎯 디자인 원칙

1. **일관성**: 같은 레이아웃 내에서는 동일한 패턴 유지
2. **접근성**: 색상 대비 4.5:1 이상, 키보드 네비게이션 지원
3. **성능**: 불필요한 애니메이션 최소화
4. **반응성**: 각 디바이스에 최적화된 경험 제공
5. **명확성**: 사용자가 다음 액션을 쉽게 파악할 수 있도록

---

## 📚 참고 자료

- Tailwind CSS 공식 문서: https://tailwindcss.com
- Pretendard 폰트: https://github.com/orioncactus/pretendard
- 컬러 팔레트 도구: https://coolors.co

---

**⚠️ 중요**: 모든 개발 시 이 디자인 가이드를 참고하세요!
