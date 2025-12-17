package com.cafe.order.domain.user.dto;

import com.cafe.order.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerDto {
    private Integer id;
    private String loginId;
    private String password;
    private String name;
    private Integer storeId;
    private String storeName;

    public SellerDto(User user, String storeName) {
        this.id = user.getId();
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.storeId = user.getStoreId();
        this.storeName = storeName;
    }
}
