-- 메뉴 테스트 데이터
INSERT INTO menus (id, name, price, category, description)
VALUES (RANDOM_UUID(), '아메리카노', 4500, 'COFFEE', '깊고 진한 에스프레소에 물을 더한 커피'),
       (RANDOM_UUID(), '카페라떼', 5000, 'COFFEE', '에스프레소와 스팀 우유의 조화'),
       (RANDOM_UUID(), '카푸치노', 5000, 'COFFEE', '에스프레소와 우유 거품의 완벽한 균형'),
       (RANDOM_UUID(), '바닐라라떼', 5500, 'COFFEE', '달콤한 바닐라 시럽이 들어간 라떼'),
       (RANDOM_UUID(), '카라멜마끼아또', 5500, 'COFFEE', '카라멜 시럽과 우유, 에스프레소'),
       (RANDOM_UUID(), '녹차라떼', 5500, 'BEVERAGE', '고소한 녹차와 우유'),
       (RANDOM_UUID(), '초코라떼', 5500, 'BEVERAGE', '진한 초콜릿과 우유'),
       (RANDOM_UUID(), '딸기스무디', 6000, 'BEVERAGE', '신선한 딸기로 만든 스무디'),
       (RANDOM_UUID(), '치즈케이크', 6000, 'DESSERT', '부드러운 크림치즈 케이크'),
       (RANDOM_UUID(), '티라미수', 6500, 'DESSERT', '이탈리아 전통 디저트');


-- 지점 테스트 데이터
INSERT INTO stores (name)
VALUES ('강남점'),
       ('홍대점'),
       ('신촌점'),
       ('잠실점'),
       ('판교점');


-- 사용자 테스트 데이터

-- 관리자 계정
INSERT INTO users (username, password, role, store_id)
VALUES ('admin', 'admin1234', 'ADMIN', NULL);

-- 판매자 계정
INSERT INTO users (username, password, role, store_id)
VALUES ('seller1', 'qwer1234', 'SELLER', 1),
       ('seller2', 'qwer1234', 'SELLER', 2),
       ('seller3', 'qwer1234', 'SELLER', 3);

-- 고객 계정
INSERT INTO users (username, password, role, store_id)
VALUES ('customer1', 'qwer1234', 'CUSTOMER', NULL),
       ('customer2', 'qwer1234', 'CUSTOMER', NULL);


-- 주문 테스트 데이터

-- 강남점 (storeId=1) 주문
INSERT INTO orders (order_id, customer_id, store_id, order_time, total_price, status, waiting_number)
VALUES
    (RANDOM_UUID(), 'customer1', 1, DATEADD('DAY', -2, NOW()), 5000, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer2', 1, DATEADD('DAY', -2, NOW()), 11000, 'COMPLETED', 2),
    (RANDOM_UUID(), 'customer1', 1, DATEADD('DAY', -1, NOW()), 6500, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer2', 1, NOW(), 4500, 'PREPARING', 1);

-- 홍대점 (storeId=2) 주문
INSERT INTO orders (order_id, customer_id, store_id, order_time, total_price, status, waiting_number)
VALUES
    (RANDOM_UUID(), 'customer1', 2, DATEADD('DAY', -3, NOW()), 10000, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer2', 2, DATEADD('DAY', -1, NOW()), 12000, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer1', 2, NOW(), 5500, 'READY', 1);

-- 신촌점 (storeId=3) 주문
INSERT INTO orders (order_id, customer_id, store_id, order_time, total_price, status, waiting_number)
VALUES
    (RANDOM_UUID(), 'customer2', 3, DATEADD('DAY', -4, NOW()), 15000, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer1', 3, DATEADD('DAY', -2, NOW()), 6000, 'COMPLETED', 2),
    (RANDOM_UUID(), 'customer2', 3, DATEADD('DAY', -1, NOW()), 11500, 'COMPLETED', 3);

-- 잠실점 (storeId=4) 주문
INSERT INTO orders (order_id, customer_id, store_id, order_time, total_price, status, waiting_number)
VALUES
    (RANDOM_UUID(), 'customer1', 4, DATEADD('DAY', -1, NOW()), 9000, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer2', 4, NOW(), 5000, 'ORDER_PLACED', 1);

-- 판교점 (storeId=5) 주문
INSERT INTO orders (order_id, customer_id, store_id, order_time, total_price, status, waiting_number)
VALUES
    (RANDOM_UUID(), 'customer1', 5, DATEADD('DAY', -5, NOW()), 12500, 'COMPLETED', 1),
    (RANDOM_UUID(), 'customer2', 5, DATEADD('DAY', -3, NOW()), 18000, 'COMPLETED', 2),
    (RANDOM_UUID(), 'customer1', 5, DATEADD('DAY', -1, NOW()), 7000, 'COMPLETED', 3);