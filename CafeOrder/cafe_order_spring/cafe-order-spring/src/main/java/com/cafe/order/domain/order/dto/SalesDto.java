package com.cafe.order.domain.order.dto;

public class SalesDto {
    private String storeName; // 지점명
    private Integer orderCount; // 주문 수
    private Integer totalSales; // 총 매출

    public SalesDto(String storeName, Integer orderCount, Integer totalSales) {
        this.storeName = storeName;
        this.orderCount = orderCount;
        this.totalSales = totalSales;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }
}
