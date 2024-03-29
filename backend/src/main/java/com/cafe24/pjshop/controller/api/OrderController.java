package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.OrderService;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.PaymentVo;

import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
		
	@ApiOperation(value = "주문신청")
	@PostMapping("")
	public ResponseEntity<JSONResult> orderProduct(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderProduct(orderVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
//	@ApiOperation(value = "주문 하나")
//	@GetMapping("/{no}")
//	public ResponseEntity<JSONResult> getOrderOneByNo(@PathVariable("no") Long no){
//		OrderVo vo = orderService.getOrderOneByNo(no);
//		return  ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
//	}
	
	@ApiOperation(value = "주문 하나")
	@GetMapping("/{userno}")
	public ResponseEntity<JSONResult> getOrderOneByUserNo(@PathVariable("userno") Long userNo){
		List<OrderVo> vo = orderService.getOrderOneByUserNo(userNo);
		return  ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "주문상세정보")
	@GetMapping("/detail/{no}")
	public ResponseEntity<JSONResult> getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = orderService.getOrderDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "주문상세정보 리스트")
	@GetMapping("/detail/list/{no}")
	public ResponseEntity<JSONResult> getOrderDetailList(@PathVariable("no") Long no){
		List<OrderDetailVo> voList = orderService.getOrderDetailList(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(voList));
	}
	
	@ApiOperation(value = "결제요청")
	@PutMapping("/payment/{no}")
	public ResponseEntity<JSONResult> payOrder(@PathVariable("no") Long no) {
		 Boolean result = orderService.payOrder(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
}

