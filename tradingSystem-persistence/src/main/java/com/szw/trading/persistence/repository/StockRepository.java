package com.szw.trading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.Stock;


@Repository("stockRepository")
public interface StockRepository extends JpaRepository<Stock, String> {

}
