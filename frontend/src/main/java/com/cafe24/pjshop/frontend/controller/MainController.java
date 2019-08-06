package com.cafe24.pjshop.frontend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pjshop.frontend.service.ProductService;
import com.cafe24.pjshop.frontend.vo.CategoryVo;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/")
	public String welcome() {
		return "main/welcome";
	}
	
	@RequestMapping( {"/main"} )
	public String main(Model model) {
		System.out.println("∏ﬁ¿Œ");
		productService.getMainPage(model, 3L);
		return "main/index";
	}
	
	
}
