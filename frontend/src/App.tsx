// src/App.tsx
import './App.css'

function App() {
  return (
    <div className="min-h-screen flex flex-col items-center justify-center p-6">
      {/* 테스트용 컴포넌트 - Cozy & Modern 디자인 확인 */}
      <div className="max-w-md w-full space-y-6">
        <div className="text-center">
          <h1 className="text-4xl font-bold text-primary mb-2">
            ☕ Cafe Order
          </h1>
          <p className="text-gray-600">
            Cozy & Modern 디자인이 적용되었습니다!
          </p>
        </div>

        {/* 컬러 팔레트 테스트 */}
        <div className="card">
          <h3 className="text-lg font-semibold mb-4">컬러 팔레트 테스트</h3>
          <div className="space-y-2">
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-primary rounded-lg shadow"></div>
              <span className="text-sm">Primary (Deep Teal)</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-accent rounded-lg shadow"></div>
              <span className="text-sm">Accent (Bright Orange)</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-success rounded-lg shadow"></div>
              <span className="text-sm">Success</span>
            </div>
            <div className="flex items-center gap-3">
              <div className="w-12 h-12 bg-danger rounded-lg shadow"></div>
              <span className="text-sm">Danger</span>
            </div>
          </div>
        </div>

        {/* 버튼 스타일 테스트 */}
        <div className="card">
          <h3 className="text-lg font-semibold mb-4">버튼 스타일 테스트</h3>
          <div className="space-y-3">
            <button className="btn btn-primary w-full">
              Primary 버튼
            </button>
            <button className="btn btn-accent w-full">
              주문하기 버튼 (Accent)
            </button>
            <button className="btn btn-danger w-full">
              삭제 버튼 (Danger)
            </button>
          </div>
        </div>

        {/* 입력 필드 테스트 */}
        <div className="card">
          <h3 className="text-lg font-semibold mb-4">입력 필드 테스트</h3>
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

        <p className="text-center text-sm text-gray-500">
          🎨 Pretendard 폰트가 적용되었습니다
        </p>
      </div>
    </div>
  )
}

export default App