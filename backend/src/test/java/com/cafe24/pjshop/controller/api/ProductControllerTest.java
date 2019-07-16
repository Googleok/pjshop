package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class ProductControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// 상품검색 Test 
	@Test
	public void testProductSearchList() throws Exception{
		String keyword = "cap";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 상품리스트  요청 Test
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// 상품상세조회  요청 Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	

}
