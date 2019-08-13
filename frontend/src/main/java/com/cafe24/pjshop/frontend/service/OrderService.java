package com.cafe24.pjshop.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OAuth2RestTemplate restTemplate;


	public OrderVo addOrder(OrderVo vo) {
		JSONResult<OrderVo> jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/order", vo, JSONResultOrder.class);
		return jsonResult.getData();
	}
	

	// DTO Class
	private static class JSONResultOrder extends JSONResult<OrderVo> {}
}
