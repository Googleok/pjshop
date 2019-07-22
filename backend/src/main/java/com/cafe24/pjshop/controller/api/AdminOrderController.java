package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.AdminOrderService;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminOrderAPIController")
@RequestMapping("/api/admin/order")
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminService;

	@ApiOperation(value = "주문 리스트")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getOrderList(){
		List<OrderVo> list = adminService.getOrderList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "주문 하나")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> getOrderOne(@PathVariable("no") Long no){
		OrderVo vo = adminService.getOrderOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "상세주문")
	@GetMapping("/detail/{no}")
	public ResponseEntity<JSONResult> getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = adminService.getOrderDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	@ApiOperation(value = "입금확인")
	@PutMapping("/depositcheck/{no}")
	public ResponseEntity<JSONResult> orderDepositCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDepositCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	@ApiOperation(value = "배송출발")
	@PutMapping("/deliverycheck/{no}")
	public ResponseEntity<JSONResult> orderDeliveryCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDeliveryCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	@ApiOperation(value = "주문검색")
	@GetMapping("/search")
	public ResponseEntity<JSONResult> getOrderSearchList(@RequestParam(value = "keyword") String keyword){
		List<OrderVo> list = adminService.getOrderSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
}

