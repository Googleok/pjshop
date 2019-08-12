package com.cafe24.pjshop.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping({"", "/checkout"})
	public String orderPage() {
		return "/user/checkout";
	}
	
}
