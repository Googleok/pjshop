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

	// 주문내역  요청 Test (id)
	@Test
	public void testGetOrderOneById() throws Exception {

		String id = "whddjr2225";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/{id}", id))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 주문내역  요청 Test (회원no)
	@Test
	public void testGetOrderOneByNo() throws Exception {

		Long no = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/{no}", no))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 상세주문  요청 Test
	@Test
	public void testGetOrderDetail() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/detail/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 회원상품주문 Test
	@Test
	public void testProductOrder() throws Exception {
		Long authUser = 1L;
		// 회원 이름, 이메일, 폰번호, 주소지 가져오기
		OrderVo voMock = new OrderVo(null, "박종억", null, "01040287755", "whddjr2225@naver.com",
				"서울시 관악구", "2019-07-12", "빨리요", 2500L, 185000L, authUser);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 배송지 추가 Test
	@Test
	public void testAddAddress() throws Exception{
		
		AddressVo voMock = new AddressVo(null, "12345", "서울시 관악구", "벨1234*", "부재시 현관 앞", 1L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/address")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 배송지 가져오기 Test
	@Test
	public void testGetAddressList() throws Exception{
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/user/address?userno={userno}", 1L))
				.andExpect(status().isOk())
				.andDo(print());
	}

	// 배송지 삭제 Test
	@Test
	public void testDeleteAddress() throws Exception{
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/user/address/{no}", 3L))
				.andExpect(status().isOk())
				.andDo(print());
	}

	
	// 장바구니 상품주문 Test
	@Test
	public void testProductOrderFromCart() throws Exception {
		Long authUser = 1L;
		OrderVo voMock = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com",
				"서울시 관악구", "2019-07-12", "빨리요", 2500L, 185000L, authUser);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	
	
	// 상품결제 Test
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
