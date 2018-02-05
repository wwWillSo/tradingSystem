package com.szw.trading.web.service.impl;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szw.trading.mybatis.entity.Orders;
import com.szw.trading.mybatis.mapper.OrdersMapper;
import com.szw.trading.persistence.entity.Customer;
import com.szw.trading.persistence.entity.CustomerTradingAccount;
import com.szw.trading.persistence.entity.Login;
import com.szw.trading.persistence.entity.Order;
import com.szw.trading.persistence.repository.CustomerRepository;
import com.szw.trading.persistence.repository.CustomerTradingAccountRepository;
import com.szw.trading.persistence.repository.LoginRepository;
import com.szw.trading.persistence.repository.OrderRepository;
import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.SearchRequest;
import com.szw.trading.web.constants.Offsetted;
import com.szw.trading.web.constants.OrderQueueName;
import com.szw.trading.web.constants.OrderSide;
import com.szw.trading.web.constants.OrderStatus;
import com.szw.trading.web.constants.OrderType;
import com.szw.trading.web.service.BaseService;
import com.szw.trading.web.service.CustomerService;
import com.szw.util.OrderNoGenerator;
import com.szw.util.RedisCacheUtil;


@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerTradingAccountRepository customerTradingAccountRepository;
	@Autowired
	private RedisCacheUtil<Order> redisCacheUtil;
	@Autowired
	private OrderNoGenerator orderNoGenerator;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrdersMapper orderMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response createOrder(Principal principal, CreateOrderRequest request) {

		Login login = loginRepository.findByLoginId(Integer.valueOf(principal.getName()));
		Customer customer = customerRepository.findByCustomerId(login.getCustomerId());
		CustomerTradingAccount cta = customerTradingAccountRepository.findByCustomerId(customer.getCustomerId());

		Order order = new Order();
		order.setOrderNo(orderNoGenerator.getOrderNo("ST", login.getLoginName()));
		order.setCreateTime(new Date());
		order.setUpdateTime(new Date());
		order.setTradingAccountId(cta.getTradingAccountId());
		order.setOffsetted(Offsetted.NO_OFFSETTED);
		BeanUtils.copyProperties(request, order);
		order.setStatus(OrderStatus.PENDING);

		Order rtnOrder = orderRepository.save(order);

		if (OrderType.MARKET_ORDER == order.getOrderType()) {
			redisCacheUtil.pushCacheList(OrderQueueName.MARKET_ORDER_QUEUE.name(), rtnOrder);
		} else if (OrderType.LIMIT_ORDER == order.getOrderType()) {
			redisCacheUtil.pushCacheList(genLimitOrderQueueName(order.getStockCode()), rtnOrder);
		}

		return Response.SUCCESS(order);
	}

	@Override
	public Response queryOrder(Principal principal, SearchRequest request) {

		Login login = loginRepository.findByLoginId(Integer.valueOf(principal.getName()));
		CustomerTradingAccount cta = customerTradingAccountRepository.findByCustomerId(login.getCustomerId());

		PageHelper.startPage(request.getPageNo(), request.getPageSize());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tradingAccountId", cta.getTradingAccountId());
		map.put("stockCode", request.getKeyword());
		map.put("orderSide", OrderSide.BUY);
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMapper.selectByParams(map));

		return Response.SUCCESS(pageInfo);
	}

	public String genLimitOrderQueueName(String stockcode) {
		return OrderQueueName.LIMIT_ORDER_QUEUE.name() + ":" + stockcode;
	}

}
