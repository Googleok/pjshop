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

	@ApiOperation(value = "�ֹ� ����Ʈ")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getOrderList(){
		List<OrderVo> list = adminService.getOrderList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "�ֹ� �ϳ�")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> getOrderOne(@PathVariable("no") Long no){
		OrderVo vo = adminService.getOrderOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "���ֹ�")
	@GetMapping("/detail/{no}")
	public ResponseEntity<JSONResult> getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = adminService.getOrderDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "���ֹ�")
	@GetMapping("/detail/list/{no}")
	public ResponseEntity<JSONResult> getOrderDetailList(@PathVariable("no") Long no){
		List<OrderDetailVo> vo = adminService.getOrderDetailList(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	@ApiOperation(value = "�Ա�üũ")
	@PutMapping("/depositcheck/{no}")
	public ResponseEntity<JSONResult> orderDepositCheck(@PathVariable("no") Long no){
		Boolean result = adminService.orderDepositCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "������üũ")
	@PutMapping("/deliverydeparturecheck/{no}")
	public ResponseEntity<JSONResult> orderDeliveryDepartureCheck(@PathVariable("no") Long no){
		Boolean result = adminService.orderDeliveryDepartureCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "��ۿϷ�üũ")
	@PutMapping("/deliverycompletecheck/{no}")
	public ResponseEntity<JSONResult> orderDeliveryCompleteCheck(@PathVariable("no") Long no){
		Boolean result = adminService.orderDeliveryCompleteCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "�ֹ��˻�")
	@GetMapping("/search")
	public ResponseEntity<JSONResult> getOrderSearchList(
			@RequestParam(value = "menu") String menu,
			@RequestParam(value = "keyword") String keyword){
		List<OrderVo> list = adminService.getOrderSearchList(menu, keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
}

