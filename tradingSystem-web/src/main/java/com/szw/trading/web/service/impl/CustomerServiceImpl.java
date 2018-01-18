package com.szw.trading.web.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
import com.szw.trading.web.constants.OrderQueue;
import com.szw.trading.web.constants.StatusCode;
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
	private OrderRepository orderRepository;
	@Autowired
	private RedisCacheUtil<Order> redisCacheUtil;
	@Autowired
	private OrderNoGenerator orderNoGenerator;

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

		// 计算
		BigDecimal cost = request.getOrderPrice().multiply(request.getOrderHand());
		BigDecimal serv = cost.multiply(BigDecimal.valueOf(0.001));
		cost = cost.add(serv);

		order.setOrderAmount(cost);
		order.setServiceAmount(serv);
		order.setTradingAccountId(cta.getTradingAccountId());
		BeanUtils.copyProperties(request, order);

		// 普通单买入,需要扣余额
		if (0 == request.getOrderSide() && 0 == request.getIsOffset()) {
			// 余额不足
			if (cta.getUsableAmount().compareTo(order.getOrderAmount()) < 0) {
				return Response.RESULT(StatusCode.NOTENOUGH.getCode(), StatusCode.NOTENOUGH.getDesc());
			}
			// 减少余额
			cta.setUsableAmount(cta.getUsableAmount().subtract(order.getOrderAmount()));
			customerTradingAccountRepository.saveAndFlush(cta);
		}

		redisCacheUtil.insertCacheList(OrderQueue.ORIGINAL_QUEUE.name(), order);
		orderRepository.save(order);

		return Response.SUCCESS(order);
	}

}
