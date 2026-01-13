package com.cafe.order.domain.order.dto;

import com.cafe.order.domain.menu.dto.CupType;
import com.cafe.order.domain.menu.dto.ShotOption;
import com.cafe.order.domain.menu.dto.Temperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateOrderRequest {

    // 주문 단위 값
    private OrderType orderType;

    // TODO : 추후 List<CustomerOrderItemRequest> items 형태로 리팩토링 예정 (#이슈번호)
    private List<UUID> menuId;
    private List<Temperature> temperature;
    private List<CupType> cupType;
    private List<ShotOption> options;
    private List<Integer> quantity;
}
