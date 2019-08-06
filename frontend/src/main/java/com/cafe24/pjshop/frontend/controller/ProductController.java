package com.cafe24.pjshop.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pjshop.frontend.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping({"/", "/list"})
	public String main(@RequestParam(value = "category_no") Long categoryNo , Model model) {
		productService.getMainPage(model, categoryNo);
		return "main/index";
	}
	
	@GetMapping("/detail/{no}")
	public String productDetail(@PathVariable(value = "no") Long productNo , Model model) {
		productService.getProductDetail(productNo, model);
		return "goods/item";
	}
}
