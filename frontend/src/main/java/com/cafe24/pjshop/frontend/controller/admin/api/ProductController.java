package com.cafe24.pjshop.frontend.controller.admin.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.frontend.dto.JSONResult2;
import com.cafe24.pjshop.frontend.service.ProductService;
import com.cafe24.pjshop.frontend.vo.OptionNameVo;

@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping({"/optionname", "/optionname/list"})
	public ResponseEntity<JSONResult2> getCategoryList() {
		List<OptionNameVo> list = productService.getOptionnameList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult2.success(list));
	}
	
	
	
	
}
