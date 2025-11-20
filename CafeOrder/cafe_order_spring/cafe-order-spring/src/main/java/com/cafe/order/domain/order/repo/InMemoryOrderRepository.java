package com.cafe.order.domain.order.repo;

import com.cafe.order.domain.order.dto.Order;
import com.cafe.order.domain.order.dto.OrderItem;
import com.cafe.order.domain.order.dto.OrderStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class InMemoryOrderRepository {

    private final List<Order> orders;
    private final List<OrderItem> orderItems;

    // 생성자로 초기 데이터 로드
    public InMemoryOrderRepository() {
        this.orders = new ArrayList<>();
        this.orderItems = new ArrayList<>();

        // UUID 미리 생성 (Order와 OrderItem 연결용)
        UUID order1Id = UUID.randomUUID();
        UUID order2Id = UUID.randomUUID();
        UUID order3Id = UUID.randomUUID();
        UUID order4Id = UUID.randomUUID();
        UUID order5Id = UUID.randomUUID();
        UUID order6Id = UUID.randomUUID();
        UUID order7Id = UUID.randomUUID();
        UUID order8Id = UUID.randomUUID();
        UUID order9Id = UUID.randomUUID();
        UUID order10Id = UUID.randomUUID();
        UUID order11Id = UUID.randomUUID();
        UUID order12Id = UUID.randomUUID();
        UUID order13Id = UUID.randomUUID();
        UUID order14Id = UUID.randomUUID();
        UUID order15Id = UUID.randomUUID();

        // Menu UUID (더미)
        UUID americanoId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID latteId = UUID.fromString("22222222-2222-2222-2222-222222222222");
        UUID cakeId = UUID.fromString("33333333-3333-3333-3333-333333333333");

        // ===== 강남점 (storeId=1) =====
        orders.add(new Order(order1Id, "customer1", 1,
                LocalDateTime.now().minusDays(2), 5000, OrderStatus.COMPLETED, 1));
        orderItems.add(new OrderItem(
                order1Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "샷추가", 1, 5000
        ));

        orders.add(new Order(order2Id, "customer2", 1,
                LocalDateTime.now().minusDays(2), 11000, OrderStatus.COMPLETED, 2));
        orderItems.add(new OrderItem(
                order2Id, latteId, "카페라떼", 5000, "HOT", "매장컵", "없음", 1, 5000
        ));
        orderItems.add(new OrderItem(
                order2Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "시럽추가", 1, 6000
        ));

        orders.add(new Order(order3Id, "customer1", 1,
                LocalDateTime.now().minusDays(1), 6500, OrderStatus.COMPLETED, 3));
        orderItems.add(new OrderItem(
                order3Id, latteId, "카페라떼", 5000, "HOT", "개인컵", "샷추가", 1, 6500
        ));

        orders.add(new Order(order4Id, "customer2", 1,
                LocalDateTime.now(), 4500, OrderStatus.PREPARING, 4));
        orderItems.add(new OrderItem(
                order4Id, americanoId, "아메리카노", 4500, "HOT", "매장컵", "없음", 1, 4500
        ));

        // ===== 홍대점 (storeId=2) =====
        orders.add(new Order(order5Id, "customer1", 2,
                LocalDateTime.now().minusDays(3), 10000, OrderStatus.COMPLETED, 1));
        orderItems.add(new OrderItem(
                order5Id, latteId, "카페라떼", 5000, "ICE", "일회용컵", "없음", 2, 10000
        ));

        orders.add(new Order(order6Id, "customer2", 2,
                LocalDateTime.now().minusDays(1), 12000, OrderStatus.COMPLETED, 2));
        orderItems.add(new OrderItem(
                order6Id, americanoId, "아메리카노", 4500, "HOT", "매장컵", "없음", 1, 4500
        ));
        orderItems.add(new OrderItem(
                order6Id, cakeId, "초코케이크", 7500, null, null, "없음", 1, 7500
        ));

        orders.add(new Order(order7Id, "customer1", 2,
                LocalDateTime.now(), 5500, OrderStatus.READY, 3));
        orderItems.add(new OrderItem(
                order7Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "얼음많이", 1, 5500
        ));

        // ===== 신촌점 (storeId=3) =====
        orders.add(new Order(order8Id, "customer2", 3,
                LocalDateTime.now().minusDays(4), 15000, OrderStatus.COMPLETED, 1));
        orderItems.add(new OrderItem(
                order8Id, latteId, "카페라떼", 5000, "HOT", "매장컵", "샷추가", 2, 11000
        ));
        orderItems.add(new OrderItem(
                order8Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "없음", 1, 4000
        ));

        orders.add(new Order(order9Id, "customer1", 3,
                LocalDateTime.now().minusDays(2), 6000, OrderStatus.COMPLETED, 2));
        orderItems.add(new OrderItem(
                order9Id, latteId, "카페라떼", 5000, "ICE", "개인컵", "시럽추가", 1, 6000
        ));

        orders.add(new Order(order10Id, "customer2", 3,
                LocalDateTime.now().minusDays(1), 12000, OrderStatus.COMPLETED, 3));
        orderItems.add(new OrderItem(
                order10Id, cakeId, "초코케이크", 7500, null, null, "없음", 1, 7500
        ));
        orderItems.add(new OrderItem(
                order10Id, americanoId, "아메리카노", 4500, "HOT", "매장컵", "없음", 1, 4500
        ));

        // ===== 잠실점 (storeId=4) =====
        orders.add(new Order(order11Id, "customer1", 4,
                LocalDateTime.now().minusDays(1), 11500, OrderStatus.COMPLETED, 1));
        orderItems.add(new OrderItem(
                order11Id, latteId, "카페라떼", 5000, "HOT", "일회용컵", "샷추가", 1, 6500
        ));
        orderItems.add(new OrderItem(
                order11Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "얼음적게", 1, 5000
        ));

        orders.add(new Order(order12Id, "customer2", 4,
                LocalDateTime.now(), 5000, OrderStatus.ORDER_PLACED, 2));
        orderItems.add(new OrderItem(
                order12Id, latteId, "카페라떼", 5000, "HOT", "매장컵", "없음", 1, 5000
        ));

        // ===== 판교점 (storeId=5) =====
        orders.add(new Order(order13Id, "customer1", 5,
                LocalDateTime.now().minusDays(5), 16000, OrderStatus.COMPLETED, 1));
        orderItems.add(new OrderItem(
                order13Id, latteId, "카페라떼", 5000, "ICE", "일회용컵", "샷추가", 2, 11000
        ));
        orderItems.add(new OrderItem(
                order13Id, americanoId, "아메리카노", 4500, "HOT", "매장컵", "없음", 1, 5000
        ));

        orders.add(new Order(order14Id, "customer2", 5,
                LocalDateTime.now().minusDays(3), 19500, OrderStatus.COMPLETED, 2));
        orderItems.add(new OrderItem(
                order14Id, cakeId, "초코케이크", 7500, null, null, "없음", 2, 15000
        ));
        orderItems.add(new OrderItem(
                order14Id, americanoId, "아메리카노", 4500, "ICE", "일회용컵", "없음", 1, 4500
        ));

        orders.add(new Order(order15Id, "customer1", 5,
                LocalDateTime.now().minusDays(1), 6500, OrderStatus.COMPLETED, 3));
        orderItems.add(new OrderItem(
                order15Id, latteId, "카페라떼", 5000, "HOT", "개인컵", "샷추가", 1, 6500
        ));
    }


    /** 관리자용 */
    // READ : status로 필터링 (람다식)
    public List<Order> findByStatus(OrderStatus status) {
        return orders.stream()
            .filter(order -> order.getStatus() == status)
            .collect(Collectors.toList());
    }

    // READ : status로 필터링 (자바 원시 코드)
    @Deprecated
    public List<Order> findByStatusBasedRoop(OrderStatus status) {
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getStatus() == status) {
                result.add(order);
            }
        }

        return result;
    }


    /**
     * 판매자용
     */
    // READ : storeId로 List<Order> 조회
    public List<Order> findByStoreId(Integer storeId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStoreId().equals(storeId)) {
                // OrderItem 찾아서 설정
                List<OrderItem> items = new ArrayList<>();
                for (OrderItem item : orderItems) {
                    if (item.getOrderId().equals(order.getOrderId())) {
                        items.add(item);
                    }
                }
                order.setItems(items);
                result.add(order);
            }
        }

        return result;
    }

    // READ : OrderId로 Order(+OrderItem) 조회 (람다식)
    public Optional<Order> findById(UUID orderId) {
        // 1. Order 찾기
        Order order = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);

        // 2. OrderItem 찾기
        if (order != null) {
            List<OrderItem> items = orderItems.stream()
                    .filter(item -> item.getOrderId().equals(orderId))
                    .collect(Collectors.toList());
            order.setItems(items);
        }

        return Optional.ofNullable(order);
    }

    // READ : OrderId로 Order(+OrderItem) 조회 (원시 자바 반복문)
    @Deprecated
    public Optional<Order> findByIdBasedRoop(UUID orderId) {
        Order order = null;

        // 1. Order 찾기
        for (Order o : orders) {
            if (o.getOrderId().equals(orderId)) {
                order = o;
                break;
            }
        }

        // 2. 없으면 null 반환
        if (order == null) {
            return null;
        }

        // 3. OrderItem 찾기 (orderId로 필터링)
        List<OrderItem> items = new ArrayList<>();
        for (OrderItem item : orderItems) {
            if (item.getOrderId().equals(orderId)) {
                items.add(item);
            }
        }

        // 4. Order에 items 설정
        order.setItems(items);

        return Optional.of(order);
    }

    // UPDATE : 주문 상태 변경
    public Order update(Order order) {
        for (Order o : orders) {
            if (o.getOrderId().equals(order.getOrderId())) {
                o.setStatus(order.getStatus());
                break;

            }
        }
        return order;
    }





}
