package com.cafe.order.domain.order.repo;

import com.cafe.order.common.util.UUIDUtils;
import com.cafe.order.domain.order.dto.Order;
import com.cafe.order.domain.order.dto.OrderStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class SqlOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public SqlOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // READ : status = COMPLETE인 전체 지점 매출 조회
    public List<Order> findByStatus(OrderStatus status) {
        String sql = "SELECT order_id, customer_id, store_id, order_time, total_price, status, waiting_number FROM orders WHERE status = ?";

        return jdbcTemplate.query(sql, orderRowMapper(), status.name());
    }


    // ResultSet -> Order 변환
    public RowMapper<Order> orderRowMapper() {
        return ((rs, rowNum) -> {
            Order order = new Order();

            // UUID 변환
            byte[] orderIdBytes = rs.getBytes("order_id");
            order.setOrderId(UUIDUtils.convertBytesToUUID(orderIdBytes));

            order.setCustomerId(rs.getString("customer_id"));
            order.setStoreId(rs.getInt("store_id"));
            order.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());
            order.setTotalPrice(rs.getInt("total_price"));
            order.setStatus(OrderStatus.valueOf(rs.getString("status")));

            // waitingNumber는 null 가능
            int waitingNumber = rs.getInt("waiting_number");
            order.setWaitingNumber(rs.wasNull() ? null : waitingNumber);

            return order;
        } );
    }

}