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
import com.cafe24.pjshop.dto.SearchDto;

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

	// ��ǰ�˻� Test 
	@Test
	public void testProductSearchList() throws Exception{
		SearchDto searchDto = new SearchDto("name", "������ û����");
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/search?menu={menu}&keyword={keyword}", searchDto.getMenu(), searchDto.getKeyword()))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// ��ǰ����Ʈ  ��û Test
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// ��ǰ�Ѱ�  ��û Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	

	// ��ǰ�󼼿�û ( ��ǰ���� + ��ǰ�ɼ� + �ɼ��̸� + ��ǥ�̹��� + ī�װ� )
	@Test
	public void testGetDetailProductInfo() throws Exception{
		Long productNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/detail/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());		
	}
}
