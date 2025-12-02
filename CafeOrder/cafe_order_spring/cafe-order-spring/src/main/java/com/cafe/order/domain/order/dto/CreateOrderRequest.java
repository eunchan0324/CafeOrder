package com.cafe.order.domain.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderRequest {

    // 주문 단위 값
    // TODO : 로그인 이후 @Setter 삭제 필요
    private String customerId;
    private OrderType orderType;

    // 여러 메뉴가 들어가므로 리스트
    private List<UUID> menuId;
    private List<String> temperature;
    private List<String> cupType;
    private List<String> options;
    private List<Integer> quantity;


}
