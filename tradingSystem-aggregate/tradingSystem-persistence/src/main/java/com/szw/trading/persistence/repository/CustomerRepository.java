package com.szw.trading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.Customer;


@Repository(value = "customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(Integer customerId);
}
