package com.szw.trading.trade.web.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.szw.trading.persistence.entity.CustomerTradingAccount;
import com.szw.trading.persistence.entity.InvestmentSummary;
import com.szw.trading.persistence.entity.Order;
import com.szw.trading.persistence.repository.CustomerTradingAccountRepository;
import com.szw.trading.persistence.repository.InvestmentSummaryRepository;
import com.szw.trading.persistence.repository.OrderRepository;
import com.szw.trading.trade.web.service.TradeService;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.constants.Offsetted;
import com.szw.trading.web.constants.OrderStatus;
import com.szw.trading.web.constants.StatusCode;


@Service
public class TradeServiceImpl implements TradeService {

	private final Logger log = Logger.getLogger(TradeServiceImpl.class);

	@Autowired
	private CustomerTradingAccountRepository customerTradingAccountRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private InvestmentSummaryRepository investmentSummaryRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response tradeBuy(Order order) {

		log.info("【处理订单】开始...orderType = " + order.getOrderType());

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

		Order persistOrder = orderRepository.findByOrderNoAndTradingAccountId(order.getOrderNo(), cta.getTradingAccountId());

		if (null == persistOrder) {

			log.info("【买入】交易失败, 数据库中不存在此订单记录");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.UNKNOWN_ERROR.getCode(), StatusCode.UNKNOWN_ERROR.getDesc(), order);
		}

		if (OrderStatus.PENDING != persistOrder.getStatus() && OrderStatus.WAITING != persistOrder.getStatus()) {

			if (OrderStatus.CANCELED != persistOrder.getStatus()) {
				log.info("【买入】交易失败，订单号重复");
				order.setStatus(OrderStatus.FAIL);
				orderRepository.save(order);
				return Response.RESULT(StatusCode.ORDER_NO_EXISTS.getCode(), StatusCode.ORDER_NO_EXISTS.getDesc(), order);
			} else {
				log.info("【买入】交易失败，此订单已被取消，跳过处理");
				return Response.RESULT(StatusCode.ORDER_HAS_BEEN_CANCELED.getCode(), StatusCode.ORDER_HAS_BEEN_CANCELED.getDesc(), persistOrder);
			}
		}

		// 交易账户相关
		cta.setDepositAmount(cta.getDepositAmount().add(order.getOrderAmount()));
		cta.setUsableAmount(cta.getUsableAmount().subtract(order.getOrderAmount().add(order.getServiceAmount())));
		customerTradingAccountRepository.save(cta);

		// 持仓相关
		InvestmentSummary invest = investmentSummaryRepository.findByTradingAccountIdAndStockCode(cta.getTradingAccountId(), order.getStockCode());
		if (null == invest) {
			invest = new InvestmentSummary();
			invest.setDeposit(BigDecimal.ZERO);
			invest.setFloatingWinloss(BigDecimal.ZERO);
			invest.setHand(BigDecimal.ZERO);
			invest.setStockCode(order.getStockCode());
			invest.setTradingAccountId(cta.getTradingAccountId());
		}
		invest.setDeposit(invest.getDeposit().add(order.getOrderAmount()));
		invest.setHand(invest.getHand().add(order.getOrderHand()));
		investmentSummaryRepository.save(invest);

		// 订单相关
		order.setStatus(OrderStatus.SUCCESS);
		Order rtnOrder = orderRepository.save(order);

		log.info("【买入】交易成功, order = " + JSON.toJSONString(rtnOrder));

		log.info("【处理订单】结束...orderType = " + order.getOrderType());

		return Response.SUCCESS(rtnOrder);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response tradeSell(Order order) {
		CustomerTradingAccount cta = customerTradingAccountRepository.findOne(order.getTradingAccountId());

		if (null == cta) {
			log.info("【卖出】交易失败, 交易账户不存在");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.TRADING_ACCOUNT_NOT_EXISTS.getCode(), StatusCode.TRADING_ACCOUNT_NOT_EXISTS.getDesc(), order);
		}

		Order persistOrder = orderRepository.findByOrderNoAndTradingAccountId(order.getOrderNo(), cta.getTradingAccountId());

		if (null == persistOrder) {

			log.info("【卖出】交易失败, 数据库中不存在此订单记录");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.UNKNOWN_ERROR.getCode(), StatusCode.UNKNOWN_ERROR.getDesc(), order);
		}

		if (OrderStatus.PENDING != persistOrder.getStatus() && OrderStatus.WAITING != persistOrder.getStatus()) {

			if (OrderStatus.CANCELED != persistOrder.getStatus()) {
				log.info("【卖出】交易失败，订单号重复");
				order.setStatus(OrderStatus.FAIL);
				orderRepository.save(order);
				return Response.RESULT(StatusCode.ORDER_NO_EXISTS.getCode(), StatusCode.ORDER_NO_EXISTS.getDesc(), order);
			} else {
				log.info("【卖出】交易失败，此订单已被取消，跳过处理");
				return Response.RESULT(StatusCode.ORDER_HAS_BEEN_CANCELED.getCode(), StatusCode.ORDER_HAS_BEEN_CANCELED.getDesc(), persistOrder);
			}
		}

		Order oldOrder = orderRepository.findByOrderNoAndTradingAccountId(order.getOffsetOrderNo(), cta.getTradingAccountId());
		if (null == oldOrder) {
			log.info("【卖出】交易失败, 要卖出的订单号不存在");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.OLD_ORDER_NO_NOT_EXISTS.getCode(), StatusCode.OLD_ORDER_NO_NOT_EXISTS.getDesc(), order);
		}

		if (OrderStatus.SUCCESS != oldOrder.getStatus()) {
			log.info("【卖出】交易失败, 要卖出的订单状态不允许卖出");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.OLD_ORDER_NOT_ALLOW_TO_SELL.getCode(), StatusCode.OLD_ORDER_NOT_ALLOW_TO_SELL.getDesc(), order);
		}

		if (oldOrder.getOrderHand().compareTo(order.getOrderHand()) != 0) {
			log.info("【卖出】卖出数与原订单买入数不符");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.QUANTITY_NOT_ENOUGH.getCode(), StatusCode.QUANTITY_NOT_ENOUGH.getDesc(), order);
		}

		if ((cta.getUsableAmount().add(oldOrder.getOrderAmount()).add(order.getOrderAmount().subtract(oldOrder.getOrderAmount())))
				.compareTo(order.getServiceAmount()) < 0) {
			log.info("【卖出】交易失败, 交易账户余额不足");

			order.setStatus(OrderStatus.FAIL);

			orderRepository.save(order);
			return Response.RESULT(StatusCode.USABLE_AMOUNT_NOT_ENOUGH.getCode(), StatusCode.USABLE_AMOUNT_NOT_ENOUGH.getDesc(), order);
		}

		// 旧订单相关
		oldOrder.setOffsetted(Offsetted.OFFSETTED);
		oldOrder.setStatus(OrderStatus.OFFSETTED);
		oldOrder.setUpdateTime(new Date());
		oldOrder.setWinLoss(order.getOrderAmount().subtract(oldOrder.getOrderAmount()));
		orderRepository.save(oldOrder);

		// 交易账户相关
		cta.setDepositAmount(cta.getDepositAmount().subtract(oldOrder.getOrderAmount()));
		cta.setUsableAmount(cta.getUsableAmount().add(oldOrder.getOrderAmount().add(oldOrder.getWinLoss())).subtract(order.getServiceAmount()));
		customerTradingAccountRepository.save(cta);

		// 持仓相关
		InvestmentSummary invest = investmentSummaryRepository.findByTradingAccountIdAndStockCode(cta.getTradingAccountId(), order.getStockCode());
		invest.setDeposit(invest.getDeposit().subtract(oldOrder.getOrderAmount()));
		invest.setHand(invest.getHand().subtract(oldOrder.getOrderHand()));
		investmentSummaryRepository.save(invest);

		// 订单相关
		order.setStatus(OrderStatus.SUCCESS);
		Order rtnOrder = orderRepository.save(order);

		log.info("【卖出】交易成功, order = " + JSON.toJSONString(rtnOrder));

		return Response.SUCCESS(rtnOrder);
	}

}
