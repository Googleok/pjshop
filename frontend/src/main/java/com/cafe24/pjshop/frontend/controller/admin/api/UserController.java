package com.cafe24.pjshop.frontend.controller.admin.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.frontend.dto.JSONResult2;
import com.cafe24.pjshop.frontend.service.UserService;
import com.cafe24.pjshop.frontend.vo.CartVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping({"/cart"})
	public ResponseEntity<JSONResult2> addToCart(@ModelAttribute CartVo vo, HttpServletRequest request) {
		System.out.println(vo);
		Long insertNo = userService.addToCart(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(insertNo));
	}
	
	
	
	
}
