package com.szw.trading.trade.web.service;

import com.szw.trading.persistence.entity.Order;
import com.szw.trading.web.bean.Response;


public interface TradeService {

	/**
	 * 买入
	 * 
	 * @param order
	 * @return
	 * @author 苏镇威 2018年1月19日 下午2:54:06
	 */
	public Response tradeBuy(Order order);
}
