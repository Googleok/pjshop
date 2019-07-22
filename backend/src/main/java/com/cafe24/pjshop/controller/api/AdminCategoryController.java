package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.AdminCategoryService;
import com.cafe24.pjshop.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminCategoryAPIController")
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService adminService;

	@ApiOperation(value = "카테고리 리스트")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getCategoryList(){
		List<CategoryVo> list = adminService.getCagegoryList();
		if(list == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "카테고리 등록")
	@PostMapping("")
	public ResponseEntity<JSONResult> addCategory(@RequestBody CategoryVo vo){
		Boolean result = adminService.addCategory(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "카테고리 수정")
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> modifyCategory(@PathVariable("no") Long no, @RequestBody CategoryVo vo){
		Boolean result = adminService.modifyCategory(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "카테고리 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> deleteCategory(@PathVariable("no") Long no){
		boolean result = adminService.deleteCategory(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
}

