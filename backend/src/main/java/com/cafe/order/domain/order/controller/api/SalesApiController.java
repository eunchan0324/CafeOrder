package com.cafe.order.domain.order.controller.api;

import com.cafe.order.domain.order.dto.SalesDto;
import com.cafe.order.domain.order.dto.SellerDailySalesResponse;
import com.cafe.order.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SalesApiController {

    private final OrderService orderService;

    /**
     * [관리자] 전체 매출 조회
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<SalesDto>> getAllSales() {
        return ResponseEntity.ok(orderService.getSalesByStore());
    }

    /**
     * [판매자] 오늘 매출 및 내역 조회
     */
    @GetMapping("/stores/{storeId}/today")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<SellerDailySalesResponse> getTodaySales(@PathVariable Integer storeId) {

        SellerDailySalesResponse response = orderService.getTodaySales(storeId);

        return ResponseEntity.ok(response);
    }
}
