package com.cafe24.pjshop.frontend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.CategoryService;
import com.cafe24.pjshop.frontend.service.ProductService;
import com.cafe24.pjshop.frontend.vo.ProductVo;

@Controller("adminProductController")
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping({"/register"})
	public String registerProductGET(Model model) {
		return "admin/manage/product/product-register";
	}
	
	@PostMapping({"/register"})
	public String registerProductPOST(@ModelAttribute ProductVo vo, Model model) {
		System.out.println(vo);
		return "admin/manage/product/product-register";
	}
}
