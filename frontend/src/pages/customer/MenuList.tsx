// src/pages/customer/MenuList.tsx
import CustomerLayout from '../../layouts/CustomerLayout';

export default function MenuList() {
  return (
    <CustomerLayout>
      <div className="py-6 px-4">
        <h1 className="font-doodle text-3xl text-ink">
          메뉴판
        </h1>
        <p className="mt-2 font-sans text-base text-ink/70">
          오늘의 메뉴를 골라주세요 ☕
        </p>

        <div className="mt-6 grid grid-cols-1 gap-4">
          <div className="card p-6">
            <p className="font-sans text-center text-ink/60">
              메뉴 리스트가 곧 추가됩니다!
            </p>
          </div>
        </div>
      </div>
    </CustomerLayout>
  );
}
