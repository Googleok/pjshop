package com.cafe24.pjshop.frontend.controller.admin.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.frontend.dto.CartListDto;
import com.cafe24.pjshop.frontend.dto.JSONResult2;
import com.cafe24.pjshop.frontend.service.UserService;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping({"/cart"})
//	public ResponseEntity<JSONResult2> addToCart(@ModelAttribute CartVo vo, HttpServletRequest request) {
//		System.out.println(vo);
//		Long insertNo = userService.addToCart(vo);
//		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(insertNo));
//	}
	
	@PostMapping({"/cart"})
	public ResponseEntity<JSONResult2> addToCartList(@RequestBody CartListDto voList) {
		Boolean result = userService.addToCartList(voList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(result));
	}
	
	
	@DeleteMapping({"/cart/{no}"})
	public ResponseEntity<JSONResult2> deleteFromCart(@PathVariable(value = "no")Long no) {
		Boolean result = userService.deleteFromCart(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(result));
	}

	@DeleteMapping("/cart")
	public ResponseEntity<JSONResult2> deleteFromCartList(@RequestBody ArrayList<Long> deleteList ) {
		System.out.println(deleteList);
		Boolean result = userService.deleteFromCartList(deleteList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(null));
	}
	
}
