package com.szw.trading.trade.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.persistence.entity.Order;
import com.szw.trading.trade.web.service.TradeService;
import com.szw.trading.web.bean.Response;


@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@RequestMapping("/trade/buy")
	@ResponseBody
	public Response trade(@RequestBody Order order) {

		return tradeService.tradeBuy(order);
	}

}
