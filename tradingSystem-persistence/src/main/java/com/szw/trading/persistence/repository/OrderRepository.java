package com.szw.trading.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.Order;


@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, BigInteger> {

}
