package com.cafe.order.domain.menustatus.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * 이 엔티티는 어떤 Menu와 어떤 Store의 조합인지” 식별하는 용도.
 * DB PK 역할
 */
@Getter
@Embeddable
public class MenuStatusId implements Serializable {
    private Integer storeId;
    private UUID menuId;


    protected MenuStatusId() {
    }

    public MenuStatusId(Integer storeId, UUID menuId) {
        this.storeId = storeId;
        this.menuId = menuId;
    }

    /**
     * JPA가 “식별자(PK)”를 비교할 때 equals/hashCode를 사용
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuStatusId that = (MenuStatusId) o;
        return Objects.equals(storeId, that.storeId) && Objects.equals(menuId, that.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, menuId);
    }
}
