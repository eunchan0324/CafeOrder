package com.cafe.order.domain.order.service;

import com.cafe.order.domain.order.dto.Order;
import com.cafe.order.domain.order.dto.OrderStatus;
import com.cafe.order.domain.order.dto.SalesDto;
import com.cafe.order.domain.order.repo.InMemoryOrderRepository;
import com.cafe.order.domain.order.repo.JpaOrderRepository;
import com.cafe.order.domain.order.repo.SqlOrderRepository;
import com.cafe.order.domain.store.dto.Store;
import com.cafe.order.domain.store.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

//    private final JpaOrderRepository salesRepository;
//    private final SqlOrderRepository salesRepository;
    private final InMemoryOrderRepository salesRepository;

    private final StoreService storeService;


    public OrderService(InMemoryOrderRepository salesRepository, StoreService storeService) {
        this.salesRepository = salesRepository;
        this.storeService = storeService;
    }

    // READ : 전체 지점별 매출 조회
    public List<SalesDto> getSalesByStore() {
        // 1. COMPLETE된 주문만 가져오기
        List<Order> orders = salesRepository.findByStatus(OrderStatus.COMPLETED);

        // 2. storeId별 그룹핑 + 집계
        Map<Integer, SalesData> salesMap = new HashMap<>();

        for (Order order : orders) {
            int storeId = order.getStoreId();
            int price = order.getTotalPrice();

            // 그룹핑 : storeId를 key로
            if (!salesMap.containsKey(storeId)) {
                salesMap.put(storeId, new SalesData());
            }

            // 집계 : count 증가, 금액 누적
            SalesData data = salesMap.get(storeId);
            data.orderCount++; // 주문수 +1
            data.totalSales += price; // 매출 누적
        }

        // 3. Store 이름 조회 + DTO 반환
        List<SalesDto> result = new ArrayList<>();
        for (Map.Entry<Integer, SalesData> entry : salesMap.entrySet()) {
            int storeId = entry.getKey();
            SalesData data = entry.getValue();

            // Store 조회
            Store store = storeService.findById(storeId);

            // DTO 생성
            result.add(new SalesDto(
                store.getName(), // 지점명
                data.orderCount, //주문수
                data.totalSales // 총매출
            ));
        }

        return result;

    }



}

// 집게용 임시 클래스
class SalesData {
    int orderCount = 0;
    int totalSales = 0;
}
