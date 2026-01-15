// src/components/customer/BottomNav.tsx
import { NavLink } from 'react-router-dom';

type NavItem = {
  label: string;
  path: string;
  icon: string;
};

const navItems: NavItem[] = [
  { label: '메뉴', path: '/customer/menus', icon: '☕' },
  { label: '추천', path: '/customer/pick', icon: '👍' },
  { label: '내역', path: '/customer/history', icon: '🧾' },
  { label: '마이', path: '/customer/my', icon: '🙂' },
];

export default function BottomNav() {
  return (
    <nav
      className="fixed bottom-0 left-0 right-0 z-50 bg-white border-t-2 border-ink"
      aria-label="하단 네비게이션"
    >
      <div className="max-w-mobile mx-auto px-4">
        <ul className="flex items-center justify-between py-2">
          {navItems.map((item) => (
            <li key={item.path} className="flex-1">
              <NavLink
                to={item.path}
                className={({ isActive }) =>
                  `flex flex-col items-center justify-center gap-1 text-xs font-sans transition-all duration-150 ${
                    isActive
                      ? 'text-crayon -translate-y-1'
                      : 'text-ink/40'
                  }`
                }
              >
                <span className="text-lg">{item.icon}</span>
                <span>{item.label}</span>
              </NavLink>
            </li>
          ))}
        </ul>
      </div>
    </nav>
  );
}
