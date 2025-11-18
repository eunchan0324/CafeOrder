package com.cafe.order.domain.order.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @Column(columnDefinition = "BINARY(16)", name = "order_id")
    private UUID orderId;

    @Column(nullable = false, name = "customer_id")
    private String customerId;

    @Column(nullable = false, name = "store_id")
    private Integer storeId;

    @Column(nullable = false, updatable = false, name = "order_time")
    private LocalDateTime orderTime;

    @Column(nullable = false, name = "total_price")
    private Integer totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    @Column(name = "waiting_number")
    private Integer waitingNumber;

    // 신규 주문 생성자
    public Order(String customerId, Integer storeId, Integer totalPrice, OrderStatus status) {
        this.orderId = UUID.randomUUID();
        this.customerId = customerId;
        this.storeId = storeId;
        this.orderTime = LocalDateTime.now();
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // DB 로드 생성자
    public Order(UUID orderId, String customerId, Integer storeId, LocalDateTime orderTime, Integer totalPrice, OrderStatus status, Integer waitingNumber) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.storeId = storeId;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.status = status;
        this.waitingNumber = waitingNumber;
    }
}
