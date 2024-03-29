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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.dto.ProductDetailDto;
import com.cafe24.pjshop.dto.ProductDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.service.AdminProductService;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionValueVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product")
public class AdminProductController {

	@Autowired
	private AdminProductService adminService;
	
	@ApiOperation(value = "상품 리스트")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "상품 하나")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> getProductOne(@PathVariable("no") Long no){
		ProductVo vo = adminService.getProductOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "상품상세정보")
	@GetMapping("/detail/{no}")
	public ResponseEntity<JSONResult> getProductDetail(@PathVariable("no") Long no){
//		ProductDetailDto productDetailDto = adminService.getProductDetail(no);
		ProductDto productDto = adminService.getProductDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productDto));
	}
	
	@ApiOperation(value = "상품등록")
	@PostMapping("")
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo productVo){
		Boolean result = adminService.addProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품등록 Ajax")
	@PostMapping("/ajax")
	public ResponseEntity<JSONResult> addProductByAjax(@RequestBody ProductVo productVo){
		Long productNo = adminService.addProductByAjax(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productNo));
	}

	@ApiOperation(value = "상품수정")
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> modifyProduct(@PathVariable("no") Long no, @RequestBody ProductVo vo){
		ProductVo newVo = adminService.modifyProduct(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	@ApiOperation(value = "상품삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> deleteProduct(@PathVariable("no") Long no){
		boolean result = adminService.deleteProduct(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "옵션 리스트")
	@GetMapping("/optionname")
	public ResponseEntity<JSONResult> getOptionList(){
		List<OptionNameVo> list = adminService.getOptionNameList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "옵션이름 추가")
	@PostMapping("/optionname")
	public ResponseEntity<JSONResult> addOptionName(@RequestBody OptionNameVo vo){
		Long insertNo = adminService.addOptionName(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	
	@ApiOperation(value = "옵션이름 삭제")
	@DeleteMapping("/optionname/{no}")
	public ResponseEntity<JSONResult> deleteOptionName(@PathVariable Long no){
		boolean result = adminService.deleteOptionName(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "옵션값 추가")
	@PostMapping("/optionvalue")
	public ResponseEntity<JSONResult> addOptionValue(@RequestBody OptionValueVo vo){
		Long insertNo = adminService.addOptionValue(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	
	@ApiOperation(value = "옵션값 삭제")
	@DeleteMapping("/optionvalue/{no}")
	public ResponseEntity<JSONResult> deleteOptionValue(@PathVariable Long no){
		boolean result = adminService.deleteOptionValue(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "옵션 추가")
	@PostMapping("/option")
	public ResponseEntity<JSONResult> addOption(@RequestBody OptionVo vo){
		Long insertNo = adminService.addOption(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	
	@ApiOperation(value = "옵션 삭제")
	@DeleteMapping("/option/{no}")
	public ResponseEntity<JSONResult> deleteOption(@PathVariable Long no){
		boolean result = adminService.deleteOption(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품이미지리스트 가져오기")
	@GetMapping("/image/{no}")
	public ResponseEntity<JSONResult> getProductImageList(@PathVariable(value = "no") Long productNo){
		List<ProductImageVo> productImageList = adminService.getProductImageList(productNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productImageList));
	}
	
	@ApiOperation(value = "상품이미지 추가")
	@PostMapping("/image")
	public ResponseEntity<JSONResult> addProductImage(@RequestBody ProductImageVo vo){
		boolean result = adminService.addProductImage(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품이미지리스트 추가")
	@PostMapping({"/image/list", "/imagelist"})
	public ResponseEntity<JSONResult> addProductImageList(@RequestBody List<ProductImageVo> list){
		boolean result = adminService.addProductImageList(list);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품이미지 삭제 (이미지번호로)")
	@DeleteMapping("/image/{no}")
	public ResponseEntity<JSONResult> deleteProductImage(@PathVariable(value = "no") Long imageNo){
		boolean result = adminService.deleteProductImage(imageNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품이미지리스트 삭제 (상품번호로)")
	@DeleteMapping({"/image/list/{no}", "/imagelist/{no}"})
	public ResponseEntity<JSONResult> deleteProductImageList(@PathVariable(value = "no") Long productNo){
		boolean result = adminService.deleteProductImageList(productNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "상품 검색")
	@GetMapping("/search")
	public ResponseEntity<JSONResult> getProductSearchList(
			@RequestParam(value = "menu") String menu,
			@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(new SearchDto(menu, keyword));
		if(list.size() == 0) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("일치하는 상품이 없습니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

}

