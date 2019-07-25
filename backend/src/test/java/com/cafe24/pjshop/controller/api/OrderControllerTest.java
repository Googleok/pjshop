package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;
import com.cafe24.pjshop.vo.AddressVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class OrderControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// �ֹ�����  ��û Test (id)
	@Test
	public void testGetOrderOneById() throws Exception {

		String id = "whddjr2225";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/{id}", id))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// �ֹ�����  ��û Test (ȸ��no)
	@Test
	public void testGetOrderOneByNo() throws Exception {

		Long no = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/{no}", no))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// ���ֹ�  ��û Test
	@Test
	public void testGetOrderDetail() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/detail/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ȸ����ǰ�ֹ� Test
	@Test
	public void testProductOrder() throws Exception {
		Long authUser = 1L;
		// ȸ�� �̸�, �̸���, ����ȣ, �ּ��� ��������
		OrderVo voMock = new OrderVo(null, "������", null, "01040287755", "whddjr2225@naver.com",
				"����� ���Ǳ�", "2019-07-12", "������", 2500L, 185000L, authUser);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// ����� �߰� Test
	@Test
	public void testAddAddress() throws Exception{
		
		AddressVo voMock = new AddressVo(null, "12345", "����� ���Ǳ�", "��1234*", "����� ���� ��", 1L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/address")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// ����� �������� Test
	@Test
	public void testGetAddressList() throws Exception{
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/user/address?userno={userno}", 1L))
				.andExpect(status().isOk())
				.andDo(print());
	}

	// ����� ���� Test
	@Test
	public void testDeleteAddress() throws Exception{
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/user/address/{no}", 3L))
				.andExpect(status().isOk())
				.andDo(print());
	}

	
	// ��ٱ��� ��ǰ�ֹ� Test
	@Test
	public void testProductOrderFromCart() throws Exception {
		Long authUser = 1L;
		OrderVo voMock = new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com",
				"����� ���Ǳ�", "2019-07-12", "������", 2500L, 185000L, authUser);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	
	
	// ��ǰ���� Test
	@Test
	public void testPayOrder() throws Exception {
		Long orderNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/order/payment/{orderNo}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
