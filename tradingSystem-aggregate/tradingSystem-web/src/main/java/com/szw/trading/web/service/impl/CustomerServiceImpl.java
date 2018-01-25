package com.szw.trading.web.service.impl;

import java.security.Principal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szw.trading.mybatis.entity.Orders;
import com.szw.trading.mybatis.entity.OrdersExample;
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
import com.szw.trading.web.constants.OrderQueue;
import com.szw.trading.web.constants.OrderStatus;
import com.szw.trading.web.constants.OrderType;
import com.szw.trading.web.service.CustomerService;
import com.szw.util.OrderNoGenerator;
import com.szw.util.RedisCacheUtil;


@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger log = Logger.getLogger(getClass());

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
			redisCacheUtil.pushCacheList(OrderQueue.MARKET_ORDER_QUEUE.name(), rtnOrder);
		} else if (OrderType.LIMIT_ORDER == order.getOrderType()) {
			redisCacheUtil.pushCacheList(OrderQueue.LIMIT_ORDER_QUEUE.name(), rtnOrder);
		}

		return Response.SUCCESS(order);
	}

	@Override
	public Response queryOrder(Principal principal, SearchRequest request) {

		Login login = loginRepository.findByLoginId(Integer.valueOf(principal.getName()));
		CustomerTradingAccount cta = customerTradingAccountRepository.findByCustomerId(login.getCustomerId());

		PageHelper.startPage(request.getPageNo(), request.getPageSize());
		OrdersExample example = new OrdersExample();
		example.createCriteria().andTradingAccountIdEqualTo(cta.getTradingAccountId().longValue()).andStockCodeLike(request.getKeyword());
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMapper.selectByExample(example));

		return Response.SUCCESS(pageInfo.getList());
	}

}
