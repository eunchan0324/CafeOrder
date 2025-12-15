package com.cafe.order.domain.favorite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class FavoriteMenuId implements Serializable {

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "menu_id", nullable = false)
    private UUID menuId;

    public FavoriteMenuId(String customerId, UUID menuId) {
        this.customerId = customerId;
        this.menuId = menuId;
    }
}
