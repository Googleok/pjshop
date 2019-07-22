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
import com.cafe24.pjshop.service.AdminProductService;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductDetailVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product")
public class AdminProductController {

	@Autowired
	private AdminProductService adminService;
	
	@ApiOperation(value = "��ǰ ����Ʈ")
	@GetMapping({"", "/list"})
	public ResponseEntity<JSONResult> getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "��ǰ �ϳ�")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> getProductOne(@PathVariable("no") Long no){
		ProductVo vo = adminService.getProductOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "��ǰ������")
	@GetMapping("/detail/{no}")
	public ResponseEntity<JSONResult> getProductDetail(@PathVariable("no") Long no){
		List<ProductDetailVo> vo = adminService.getProductDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "��ǰ���")
	@PostMapping("")
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo productVo){
		Boolean result = adminService.addProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "��ǰ��� Ajax")
	@PostMapping("/ajax")
	public ResponseEntity<JSONResult> addProductByAjax(@RequestBody ProductVo productVo){
		Long productNo = adminService.addProductByAjax(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productNo));
	}

	@ApiOperation(value = "��ǰ����")
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> modifyProduct(@PathVariable("no") Long no, @RequestBody ProductVo vo){
		ProductVo newVo = adminService.modifyProduct(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	@ApiOperation(value = "��ǰ����")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> deleteProduct(@PathVariable("no") Long no){
		boolean result = adminService.deleteProduct(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "�ɼ� ����Ʈ")
	@GetMapping("/optionname")
	public ResponseEntity<JSONResult> getOptionList(){
		List<OptionNameVo> list = adminService.getOptionNameList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	@ApiOperation(value = "�ɼ��̸� �߰�")
	@PostMapping("/optionname")
	public ResponseEntity<JSONResult> addOptionName(@RequestBody OptionNameVo vo){
		Long insertNo = adminService.addOptionName(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	@ApiOperation(value = "�ɼ��̸� ����")
	@DeleteMapping("/optionname/{no}")
	public ResponseEntity<JSONResult> deleteOptionName(@PathVariable Long no){
		boolean result = adminService.deleteOptionName(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	@ApiOperation(value = "�ɼǰ� �߰�")
	@PostMapping("/optionvalue")
	public ResponseEntity<JSONResult> addOptionValue(@RequestBody OptionVo vo){
		Long insertNo = adminService.addOptionValue(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	@ApiOperation(value = "��ǰ�̹��� �߰�")
	@PostMapping("/image")
	public ResponseEntity<JSONResult> addProductImage(@RequestBody ProductImageVo vo){
		boolean result = adminService.addProductImage(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	@ApiOperation(value = "��ǰ�̹�������Ʈ �߰�")
	@PostMapping("/imagelist")
	public ResponseEntity<JSONResult> addProductImageList(@RequestBody List<ProductImageVo> list){
		boolean result = adminService.addProductImageList(list);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "��ǰ �˻�")
	@GetMapping("/search")
	public ResponseEntity<JSONResult> getProductSearchList(@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

}

