package com.szw.trading.web.bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class CreateOrderRequest extends BaseRequest {

	private static final long serialVersionUID = 6673529968902140248L;
	/** 股票代码 */
	@NotEmpty(message = "必须输入")
	private String stockCode;
	/** 价格，市价单不需输入，限价单必须输入 */
	private BigDecimal orderPrice;
	/** 手数 */
	@NotNull(message = "必须输入")
	private BigDecimal orderHand;
	/** 下单类型 0：市价 1：限价 */
	@NotNull(message = "必须输入")
	private Integer orderType;
	/** 下单方向0：买入 1：卖出 */
	@NotNull(message = "必须输入")
	private Integer orderSide;

	/** 要卖出的单号 */
	private String offsetOrderNo;

	public String getOffsetOrderNo() {
		return offsetOrderNo;
	}

	public void setOffsetOrderNo(String offsetOrderNo) {
		this.offsetOrderNo = offsetOrderNo;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getOrderHand() {
		return orderHand;
	}

	public void setOrderHand(BigDecimal orderHand) {
		this.orderHand = orderHand;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderSide() {
		return orderSide;
	}

	public void setOrderSide(Integer orderSide) {
		this.orderSide = orderSide;
	}

}
