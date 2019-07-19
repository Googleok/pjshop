package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.AdminService;
import com.cafe24.pjshop.vo.CategoryVo;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.ProductVo;
import com.cafe24.pjshop.vo.UserVo;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// ī�װ� ����
	// category
	
	/**
	 * ī�װ� ����Ʈ
	 * @return
	 */
	@GetMapping({"/category", "/category/list"})
	public ResponseEntity<JSONResult> getCategoryList(){
		List<CategoryVo> list = adminService.getCagegoryList();
		if(list == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * ī�װ� ���
	 * @param vo
	 * @return
	 */
	@PostMapping("/category")
	public ResponseEntity<JSONResult> addCategory(@RequestBody CategoryVo vo){
		Boolean result = adminService.addCategory(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * ī�װ� ����
	 * @param no
	 * @param vo
	 * @return
	 */
	@PutMapping("/category/{no}")
	public ResponseEntity<JSONResult> modifyCategory(@PathVariable("no") Long no, @RequestBody CategoryVo vo){
		Boolean result = adminService.modifyCategory(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * ī�װ� ����
	 * @param no
	 * @return
	 */
	@DeleteMapping("/category/{no}")
	public ResponseEntity<JSONResult> deleteCategory(@PathVariable("no") Long no){
		boolean result = adminService.deleteCategory(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	// ��ǰ���� 
	// product
	
	/**
	 * ��ǰ����Ʈ
	 * @return
	 */
	@GetMapping({"/product", "/product/list"})
	public ResponseEntity<JSONResult> getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * ��ǰ �ϳ���
	 * @param no
	 * @return
	 */
	@GetMapping("/product/{no}")
	public ResponseEntity<JSONResult> getProductOne(@PathVariable("no") Long no){
		ProductVo vo = adminService.getProductOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	
	/**
	 * ��ǰ���
	 * @param vo
	 * @return
	 */
	@PostMapping("/product")
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo productVo){
		Boolean result = adminService.addProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	/**
	 * ��ǰ����
	 * @param no
	 * @param vo
	 * @return
	 */
	@PutMapping("/product/{no}")
	public ResponseEntity<JSONResult> modifyProduct(@PathVariable("no") Long no, @RequestBody ProductVo vo){
		ProductVo newVo = adminService.modifyProduct(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * ��ǰ����
	 * @param no
	 * @return
	 */
	@DeleteMapping("/product/{no}")
	public ResponseEntity<JSONResult> deleteProduct(@PathVariable("no") Long no){
		boolean result = adminService.deleteProduct(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * ��ǰ�˻�
	 * @param keyword
	 * @return
	 */
	@GetMapping("/product/search")
	public ResponseEntity<JSONResult> getProductSearchList(@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	// �ֹ�����
	// order
	
	/**
	 * ��ü�ֹ�����Ʈ ��û
	 * @return
	 */
	@GetMapping({"/order", "/order/list"})
	public ResponseEntity<JSONResult> getOrderList(){
		List<OrderVo> list = adminService.getOrderList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * �ֹ��Ѱ� ��û
	 * @param no
	 * @return
	 */
	@GetMapping("/order/{no}")
	public ResponseEntity<JSONResult> getOrderOne(@PathVariable("no") Long no){
		OrderVo vo = adminService.getOrderOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	/**
	 * ���ֹ� ��û
	 * @param no
	 * @return
	 */
	@GetMapping("/order/detail/{no}")
	public ResponseEntity<JSONResult> getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = adminService.getOrderDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	/**
	 * �Ա�Ȯ��üũ
	 * @param no
	 * @return
	 */
	@PutMapping("/order/depositcheck/{no}")
	public ResponseEntity<JSONResult> orderDepositCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDepositCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * ������üũ
	 * @param no
	 * @return
	 */
	@PutMapping("/order/deliverycheck/{no}")
	public ResponseEntity<JSONResult> orderDeliveryCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDeliveryCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * �ֹ��˻� --> �ʹ������� �ϴ� phone ��ȣ�� üũ
	 * @param keyword
	 * @return
	 */
	@GetMapping("/order/search")
	public ResponseEntity<JSONResult> getOrderSearchList(@RequestParam(value = "keyword") String keyword){
		List<OrderVo> list = adminService.getOrderSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

	// ȸ������
	// user
	 
	/**
	 * ȸ������Ʈ ��û
	 * @return
	 */
	@GetMapping({"/user", "/user/list"})
	public ResponseEntity<JSONResult> getUserList(){
		List<UserVo> list = adminService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * ȸ�� ����
	 * @param no
	 * @return
	 */
	@DeleteMapping("/user/{no}")
	public ResponseEntity<JSONResult> deleteUser(@PathVariable("no") Long no){
		boolean result = adminService.deleteUser(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * ȸ�� ���� ����
	 * @param no
	 * @param vo
	 * @return
	 */
	@PutMapping("/user/{no}")
	public ResponseEntity<JSONResult> modifyUser(@PathVariable("no") Long no, @RequestBody UserVo vo){
		UserVo newVo = adminService.modifyUser(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * ȸ���˻� --> �ʹ������� �ϴ� ID�� üũ
	 * @param keyword
	 * @return
	 */
	@GetMapping("/user/search")
	public ResponseEntity<JSONResult> getUserSearchList(@RequestParam(value = "keyword") String keyword){
		List<UserVo> list = adminService.getUserSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
}

