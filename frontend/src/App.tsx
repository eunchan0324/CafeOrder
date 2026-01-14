// src/App.tsx
import './App.css'

function App() {
  return (
    <div className="min-h-screen flex flex-col items-center justify-center p-6">
      {/* 테스트용 컴포넌트 - My Doodle Cafe 디자인 확인 */}
      <div className="max-w-md w-full space-y-6">
        
        {/* 헤더 */}
        <div className="text-center">
          <h1 className="font-doodle text-5xl text-ink mb-3">
            My Doodle Cafe
          </h1>
          <p className="font-sans text-base text-ink/70">
            🐕 Naive Design 테스트 페이지
          </p>
        </div>

        {/* 컬러 팔레트 테스트 */}
        <div className="card">
          <h3 className="font-doodle text-2xl text-ink mb-4">
            컬러 팔레트 🎨
          </h3>
          <div className="space-y-3">
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-paper border-2 border-ink rounded-lg"></div>
              <span className="font-sans text-sm">Paper (배경)</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-ink rounded-lg"></div>
              <span className="font-sans text-sm">Ink (먹색)</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-crayon rounded-lg"></div>
              <span className="font-sans text-sm">Crayon (오렌지)</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-doodle-yellow rounded-lg"></div>
              <span className="font-sans text-sm">형광펜 노랑</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-doodle-pink rounded-lg"></div>
              <span className="font-sans text-sm">크레파스 핑크</span>
            </div>
          </div>
        </div>

        {/* 버튼 스타일 테스트 */}
        <div className="card">
          <h3 className="font-doodle text-2xl text-ink mb-4">
            버튼 스타일 🖍️
          </h3>
          <div className="space-y-3">
            <button className="btn btn-primary w-full">
              기본 버튼 (Ink)
            </button>
            <button className="btn btn-crayon w-full">
              🛒 주문하기 버튼 (Crayon)
            </button>
            <button className="btn btn-danger w-full">
              ❌ 삭제 버튼
            </button>
          </div>
          <p className="mt-3 text-xs text-ink/60 font-sans">
            💡 버튼에 마우스를 올려보세요! (그림자 효과)
          </p>
        </div>

        {/* 입력 필드 테스트 */}
        <div className="card">
          <h3 className="font-doodle text-2xl text-ink mb-4">
            입력 필드 ✏️
          </h3>
          <input 
            type="text" 
            placeholder="이메일을 입력하세요" 
            className="input mb-3"
          />
          <input 
            type="password" 
            placeholder="비밀번호를 입력하세요" 
            className="input"
          />
        </div>

        {/* 배지 테스트 */}
        <div className="card">
          <h3 className="font-doodle text-2xl text-ink mb-4">
            배지/스티커 🏷️
          </h3>
          <div className="flex flex-wrap gap-2">
            <span className="inline-block px-3 py-1 bg-doodle-yellow border-2 border-ink rounded-full text-sm font-semibold">
              인기 🔥
            </span>
            <span className="inline-block px-3 py-1 bg-doodle-pink border-2 border-ink rounded-full text-sm font-semibold">
              신메뉴 ✨
            </span>
            <span className="inline-block px-3 py-1 bg-doodle-blue border-2 border-ink rounded-full text-sm font-semibold">
              할인 💰
            </span>
            <span className="inline-block px-3 py-1 bg-doodle-green border-2 border-ink rounded-full text-sm font-semibold">
              품절 😢
            </span>
          </div>
        </div>

        {/* 타이포그래피 테스트 */}
        <div className="card">
          <h3 className="font-doodle text-2xl text-ink mb-4">
            타이포그래피 📝
          </h3>
          <div className="space-y-2">
            <p className="font-doodle text-3xl">KCC임권택체 (타이틀)</p>
            <p className="font-sans text-base">Pretendard (본문) - 가독성이 좋아요</p>
            <p className="font-sans text-sm text-ink/70">작은 텍스트 (캡션)</p>
          </div>
        </div>

        <div className="text-center">
          <p className="font-sans text-sm text-ink/60">
            🎨 My Doodle Cafe - Naive Design
          </p>
          <p className="font-sans text-xs text-ink/50 mt-1">
            강아지와 함께하는 따뜻한 카페 ☕
          </p>
        </div>
      </div>
    </div>
  )
}

export default App