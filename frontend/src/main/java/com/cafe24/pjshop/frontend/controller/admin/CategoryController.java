package com.cafe24.pjshop.frontend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.CategoryService;

@Controller("adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping({"", "/list"})
	public String categoryList(Model model) {
		categoryService.getList(model);
		return "admin/manage/category/category-list";
	}
	
}
