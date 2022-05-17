package com.team4.dispatch.repository;

import com.team4.dispatch.model.Order;
import com.team4.dispatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderID(Long id);

    Order findByOrderIDAndGuest(Long id, User guest);
}