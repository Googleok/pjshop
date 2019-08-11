package com.cafe24.pjshop.frontend.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.dto.ProductDto;
import com.cafe24.pjshop.frontend.repository.ProductDao;
import com.cafe24.pjshop.frontend.vo.CategoryVo;
import com.cafe24.pjshop.frontend.vo.OptionNameVo;
import com.cafe24.pjshop.frontend.vo.ProductVo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	public void getMainPage(Model model, Long categoryNo) {
		// 카테고리
		JSONResult<List<CategoryVo>> jsonResultCategory = restTemplate.getForObject("http://localhost:9999/v1/api/admin/category/list", JSONResultCategoryList.class);
		model.addAttribute("categoryList", jsonResultCategory.getData());
		// 상품
		JSONResult<List<ProductVo>> jsonResultProduct = restTemplate.getForObject("http://localhost:9999/v1/api/product/list?category="+categoryNo, JSONResultProductList.class);
		model.addAttribute("productList", jsonResultProduct.getData());
	}

	public void getProductDetail(Long productNo , Model model) {
		// 카테고리
		JSONResult<List<CategoryVo>> jsonResultCategory = restTemplate.getForObject("http://localhost:9999/v1/api/admin/category/list", JSONResultCategoryList.class);
		model.addAttribute("categoryList", jsonResultCategory.getData());
		// 상품상세
		JSONResult<ProductDto> jsonResultProductDetail = restTemplate.getForObject("http://localhost:9999/v1/api/product/detail/"+productNo, JSONResultProductDetail.class);
		System.out.println(jsonResultProductDetail.getData());
		model.addAttribute("productDetail", jsonResultProductDetail.getData());
	}

	public List<OptionNameVo> getOptionnameList() {
		// 카테고리
		JSONResult<List<OptionNameVo>> jsonResultOptionname = restTemplate.getForObject("http://localhost:9999/v1/api/admin/product/optionname", JSONResultOptionnameList.class);
		return jsonResultOptionname.getData();
	}

	public Boolean registerProduct(ProductVo vo) {
		JSONResult<Boolean> jsonResultRegisterProduct = restTemplate.postForObject("http://localhost:9999/v1/api/admin/product", vo, JSONResultRegisterProduct.class);
		return jsonResultRegisterProduct.getData();
	}

	public void getProductList(Model model) {
		JSONResult<List<ProductVo>> jsonResultProductList = restTemplate.getForObject("http://localhost:9999/v1/api/admin/product/list", JSONResultProductList.class);
		model.addAttribute("productList", jsonResultProductList.getData());
	}

	public void deleteProduct(Long no) {
		ResponseEntity<JSONResultDeleteProduct> jsonResultDeleteProduct = restTemplate.exchange("http://localhost:9999/v1/api/admin/product/"+no, HttpMethod.DELETE, null,JSONResultDeleteProduct.class);
		System.out.println(jsonResultDeleteProduct.getBody().getData());
	}

	// DTO Class
	private static class JSONResultCategoryList extends JSONResult<List<CategoryVo>> {}
	private static class JSONResultOptionnameList extends JSONResult<List<OptionNameVo>> {}
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {}
	private static class JSONResultProductDetail extends JSONResult<ProductDto> {}
	private static class JSONResultRegisterProduct extends JSONResult<Boolean> {}
	private static class JSONResultDeleteProduct extends JSONResult<Boolean> {}







}
