import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import CustomerLayout from '../../layouts/CustomerLayout';

export default function MyPage() {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('accessToken');
    if (!token) {
      navigate('/customer/login');
    }
  }, [navigate]);

  const handleLogout = () => {
    localStorage.removeItem('accessToken');
    sessionStorage.removeItem('selectedStoreId');
    sessionStorage.removeItem('selectedStoreName');
    sessionStorage.removeItem('customerActiveCategory');
    navigate('/customer/login');
  };

  return (
    <CustomerLayout>
      <div className="py-6 px-4 space-y-6">
        <h1 className="font-doodle text-3xl text-ink">
          마이 페이지
        </h1>
        <div className="card p-6 space-y-4">
          <p className="text-sm text-ink/60">
            로그인한 계정으로 주문 내역과 찜 목록을 확인할 수 있어요.
          </p>
          <button
            type="button"
            onClick={handleLogout}
            className="btn btn-danger w-full"
          >
            로그아웃
          </button>
        </div>
      </div>
    </CustomerLayout>
  );
}
