package com.szw.trading.trade.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.persistence.entity.Order;
import com.szw.trading.trade.web.service.TradeService;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.constants.OrderSide;


@Controller
public class TradeController {

	private Logger log = Logger.getLogger(getClass());

	@Autowired
	private TradeService tradeService;

	@RequestMapping("/trade")
	@ResponseBody
	public Response trade(@RequestBody Order order) {

		if (OrderSide.BUY == order.getOrderSide())
			return tradeService.tradeBuy(order);
		else
			return tradeService.tradeSell(order);
	}

}
