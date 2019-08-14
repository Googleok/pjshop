package com.cafe24.pjshop.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.vo.OrderDetailVo;
import com.cafe24.pjshop.frontend.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OAuth2RestTemplate restTemplate;


	public OrderVo addOrder(OrderVo vo) {
		JSONResult<OrderVo> jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/order", vo, JSONResultOrder.class);
		return jsonResult.getData();
	}
	
	public List<OrderDetailVo> getOrderDetailList(Long no) {
		JSONResult<List<OrderDetailVo>> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/order/detail/list/"+no, JSONResultGetOrderDetailList.class);
		return jsonResult.getData();
	}

	public void getOrderList(Model model) {
		JSONResult<List<OrderVo>> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/admin/order/list", JSONResultGetOrderList.class);
		model.addAttribute("orderList", jsonResult.getData());
	}
	// DTO Class
	private static class JSONResultOrder extends JSONResult<OrderVo> {}
	private static class JSONResultGetOrderDetailList extends JSONResult<List<OrderDetailVo>> {}
	private static class JSONResultGetOrderList extends JSONResult<List<OrderVo>> {}
}
