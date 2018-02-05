package com.szw.trading.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.szw.trading.mybatis.entity.Orders;
import com.szw.trading.mybatis.entity.OrdersExample;


public interface OrdersMapper {
	long countByExample(OrdersExample example);

	int deleteByPrimaryKey(Long orderId);

	int insert(Orders record);

	int insertSelective(Orders record);

	List<Orders> selectByExample(OrdersExample example);

	Orders selectByPrimaryKey(Long orderId);

	int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	List<Orders> selectByParams(Map<String, Object> map);
}