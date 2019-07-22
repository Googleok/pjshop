package com.cafe24.pjshop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.ProductService;
import com.cafe24.pjshop.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "상품검색")
	@GetMapping("/search")
	public JSONResult getSearchProductList(@RequestParam(value = "keyword") String keyword) throws Exception{
		List<ProductVo> list = productService.getSearchProductList(keyword);
		return JSONResult.success(list);
	}
	
	@ApiOperation(value = "상품 리스트")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getProductList(){
		List<ProductVo> list = productService.getProductList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "상품 하나")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> getProductOne(@PathVariable("no") Long no){
		ProductVo vo = productService.getProductOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
}
