package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.AdminUserService;
import com.cafe24.pjshop.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminUserAPIController")
@RequestMapping("/api/admin/user")
public class AdminUserController {

	@Autowired
	private AdminUserService adminService;
	 
	@ApiOperation(value = "회원 리스트")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getUserList(){
		List<UserVo> list = adminService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "회원 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> deleteUser(@PathVariable("no") Long no){
		boolean result = adminService.deleteUser(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "회원 수정")
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> modifyUser(@PathVariable("no") Long no, @RequestBody UserVo vo){
		UserVo newVo = adminService.modifyUser(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	@ApiOperation(value = "회원 검색")
	@GetMapping("/search")
	public ResponseEntity<JSONResult> getUserSearchList(@RequestParam(value = "keyword") String keyword){
		List<UserVo> list = adminService.getUserSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
}

