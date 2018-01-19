package com.szw.trading.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {

	public Order findByOrderNoAndStatus(String orderNo, int status);

}
