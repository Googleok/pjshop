package com.cafe24.pjshop.dto;

import java.util.List;

public class OrderProductListDto {

	private List<OrderProductDto> orderProductList;
	
	public OrderProductListDto() {
		// TODO Auto-generated constructor stub
	}

	public List<OrderProductDto> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProductDto> orderProductList) {
		this.orderProductList = orderProductList;
	}

	@Override
	public String toString() {
		return "OrderProductListDto [orderProductList=" + orderProductList + "]";
	}
	
	
}
