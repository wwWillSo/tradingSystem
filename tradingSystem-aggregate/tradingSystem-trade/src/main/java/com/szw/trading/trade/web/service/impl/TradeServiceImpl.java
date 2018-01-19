package com.szw.trading.trade.web.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.szw.trading.persistence.entity.CustomerTradingAccount;
import com.szw.trading.persistence.entity.Order;
import com.szw.trading.persistence.repository.CustomerRepository;
import com.szw.trading.persistence.repository.CustomerTradingAccountRepository;
import com.szw.trading.persistence.repository.InvestmentSummaryRepository;
import com.szw.trading.persistence.repository.LoginRepository;
import com.szw.trading.persistence.repository.OrderRepository;
import com.szw.trading.trade.web.service.TradeService;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.constants.OrderStatus;
import com.szw.trading.web.constants.StatusCode;
import com.szw.util.OrderNoGenerator;
import com.szw.util.RedisCacheUtil;


@Service
public class TradeServiceImpl implements TradeService {

	private final Logger log = Logger.getLogger(TradeServiceImpl.class);

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
	private InvestmentSummaryRepository investmentSummaryRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response tradeBuy(Order order) {

		CustomerTradingAccount cta = customerTradingAccountRepository.findOne(order.getTradingAccountId());

		if (null == cta) {
			log.info("【买入】交易失败, 交易账户不存在");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.TRADING_ACCOUNT_NOT_EXISTS.getCode(), StatusCode.TRADING_ACCOUNT_NOT_EXISTS.getDesc(), order);
		}

		if (cta.getUsableAmount().compareTo(order.getOrderAmount().add(order.getServiceAmount())) < 0) {
			log.info("【买入】交易失败, 交易账户余额不足");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.USABLE_AMOUNT_NOT_ENOUGH.getCode(), StatusCode.USABLE_AMOUNT_NOT_ENOUGH.getDesc(), order);
		}

		if (null != orderRepository.findByOrderNoAndStatus(order.getOrderNo(), OrderStatus.SUCCESS)) {
			log.info("【买入】交易失败, 订单号重复");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.ORDER_NO_EXISTS.getCode(), StatusCode.ORDER_NO_EXISTS.getDesc(), order);
		}

		cta.setDepositAmount(cta.getDepositAmount().add(order.getOrderAmount()));
		cta.setUsableAmount(cta.getUsableAmount().subtract(order.getOrderAmount().add(order.getServiceAmount())));

		customerTradingAccountRepository.save(cta);

		order.setStatus(OrderStatus.SUCCESS);

		orderRepository.save(order);

		log.info("【买入】交易成功, order = " + order);

		return Response.SUCCESS(order);
	}

}
