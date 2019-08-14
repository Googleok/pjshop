package com.cafe24.pjshop.frontend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.OrderService;

@Controller("adminOrderController")
@RequestMapping("/admin/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping({""})
	public String adminOrder(Model model) {
		orderService.getOrderList(model);
		return "admin/manage/order/order-list";
	}
}
