package com.cafe24.pjshop.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.OrderService;
import com.cafe24.pjshop.frontend.vo.OrderVo;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping({""})
	public String order(Model model, OrderVo vo) {
		System.out.println(vo);
		OrderVo result = orderService.addOrder(vo);
		return "/user/order";
	}
	
}
