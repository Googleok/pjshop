package com.cafe24.pjshop.frontend.controller.admin.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.frontend.dto.JSONResult2;
import com.cafe24.pjshop.frontend.service.OrderService;
import com.cafe24.pjshop.frontend.vo.OrderDetailVo;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/detail/list/{no}")
	public ResponseEntity<JSONResult2> getOrderDetailList(@PathVariable(value = "no") Long no) {
		List<OrderDetailVo> orderDetailList = orderService.getOrderDetailList(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(orderDetailList));
	}

	
}
