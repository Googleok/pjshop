package com.cafe24.pjshop.frontend.controller.admin.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.frontend.dto.JSONResult2;
import com.cafe24.pjshop.frontend.service.CategoryService;
import com.cafe24.pjshop.frontend.vo.CategoryVo;

@RestController("adminCategoryAPIController")
@RequestMapping("/api/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping({"/list", ""})
	public ResponseEntity<JSONResult2> getCategoryList() {
		List<CategoryVo> list = categoryService.getCategoryList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(list));
	}
	
	@PostMapping("")
	public ResponseEntity<JSONResult2> registerCategory(@ModelAttribute CategoryVo vo) {
		Boolean result = categoryService.registerCategory(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(result));
	}
	
	@DeleteMapping("{no}")
	public ResponseEntity<JSONResult2> deleteCategory() {
		List<CategoryVo> list = categoryService.getCategoryList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(list));
	}
	
	
}
