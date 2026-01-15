// src/layouts/CustomerLayout.tsx
// Customer용 모바일 레이아웃

import type { ReactNode } from 'react';
import { Outlet } from 'react-router-dom';
import BottomNav from '../components/customer/BottomNav';
import StoreFloatingBar from '../components/customer/StoreFloatingBar';

interface CustomerLayoutProps {
  children?: ReactNode;
}

export default function CustomerLayout({ children }: CustomerLayoutProps) {
  const content = children ?? <Outlet />;
  return (
    <div className="min-h-screen">
      {/* 모바일 컨테이너 */}
      <div className="container-mobile min-h-screen">
        {/* 상단 헤더 (나중에 추가) */}
        {/* <header className="py-4">
          <h2 className="font-doodle text-2xl">My Doodle Cafe</h2>
        </header> */}

        {/* 메인 컨텐츠 */}
        <main className="pb-nav-mobile">
          {children}
        </main>

        <StoreFloatingBar />
        <BottomNav />
      </div>
    </div>
  );
}
