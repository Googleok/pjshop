package com.cafe24.pjshop.frontend.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.dto.ProductDto;
import com.cafe24.pjshop.frontend.repository.ProductDao;
import com.cafe24.pjshop.frontend.vo.CategoryVo;
import com.cafe24.pjshop.frontend.vo.ProductVo;

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
		model.addAttribute("productDetail", jsonResultProductDetail.getData());
	}

	// DTO Class
	private static class JSONResultCategoryList extends JSONResult<List<CategoryVo>> {}
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {}
	private static class JSONResultProductDetail extends JSONResult<ProductDto> {}
}
