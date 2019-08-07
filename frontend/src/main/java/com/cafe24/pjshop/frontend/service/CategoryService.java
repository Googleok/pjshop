package com.cafe24.pjshop.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.repository.CategoryDao;
import com.cafe24.pjshop.frontend.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;


	@Autowired
	private OAuth2RestTemplate restTemplate;

	
	public void getList(Model model) {
		// 카테고리
		JSONResult<List<CategoryVo>> jsonResultCategory = restTemplate.getForObject("http://localhost:9999/v1/api/admin/category/list", JSONResultCategoryList.class);
		model.addAttribute("categoryList", jsonResultCategory.getData());
	}
	
	public Boolean registerCategory(CategoryVo vo) {
		JSONResultRegisterCategory jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/admin/category", vo, JSONResultRegisterCategory.class);
		return jsonResult.getData();
	}

	public List<CategoryVo> getCategoryList() {
		JSONResultCategoryList jsonResultCategoryList = restTemplate.getForObject("http://localhost:9999/v1/api/admin/category/list", JSONResultCategoryList.class);
		return jsonResultCategoryList.getData();
	}
	
	// DTO Class
	private static class JSONResultCategoryList extends JSONResult<List<CategoryVo>> {}
	private static class JSONResultRegisterCategory extends JSONResult<Boolean> {}

}
