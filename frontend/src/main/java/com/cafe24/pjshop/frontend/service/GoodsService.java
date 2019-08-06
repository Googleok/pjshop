package com.cafe24.pjshop.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.frontend.dto.Goods;
import com.cafe24.pjshop.frontend.dto.JSONResult;

@Service
public class GoodsService {

	@Autowired
	private OAuth2RestTemplate restTemplate;

	public Goods get(Long no) {
		String endpoint = "http://localhost:8888/v1/hello";
		JSONResultGoods jsonResult = restTemplate.getForObject(endpoint, JSONResultGoods.class);
		System.out.println(jsonResult);
		return jsonResult.getData();
	}

	public String getList() {
		String endpoint = "http://localhost:8888/v1/hello";
		JSONResultGoodsList jsonResult = restTemplate.getForObject(endpoint, JSONResultGoodsList.class);
		System.out.println(jsonResult);
		return jsonResult.getData();
	}
	
	// DTO Class
	private static class JSONResultGoods extends JSONResult<Goods> {}
	private static class JSONResultGoodsList extends JSONResult<String> {}

}
