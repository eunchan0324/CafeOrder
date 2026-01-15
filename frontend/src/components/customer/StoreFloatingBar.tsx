// src/components/customer/StoreFloatingBar.tsx
import type { MouseEvent } from 'react';

interface StoreFloatingBarProps {
  storeName?: string;
  onClick?: (event: MouseEvent<HTMLButtonElement>) => void;
}

export default function StoreFloatingBar({
  storeName = '강남역 1호점',
  onClick,
}: StoreFloatingBarProps) {
  const handleClick = (event: MouseEvent<HTMLButtonElement>) => {
    if (onClick) {
      onClick(event);
      return;
    }
    // 임시 핸들러 (나중에 매장 변경 모달 연결)
    console.log('매장 변경 클릭');
  };

  return (
    <div className="fixed left-0 right-0 bottom-16 z-40 px-4">
      <button
        type="button"
        onClick={handleClick}
        className="w-full max-w-mobile mx-auto flex items-center justify-center gap-2
                   bg-crayon text-white font-doodle text-base
                   border-2 border-ink
                   shadow-[2px_2px_0px_#18181B]
                   rounded-[16px_12px_18px_10px/10px_18px_12px_16px]
                   rotate-[-1deg] py-3"
      >
        <span aria-hidden>📍</span>
        <span>현재: {storeName}</span>
      </button>
    </div>
  );
}
