package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
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
public class AdminOrderControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// 주문리스트  요청 Test
	@Test
	public void testGetOrderList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 주문한개  요청 Test
	@Test
	public void testGetOrderOne() throws Exception {

		Long orderNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상세주문  요청 Test
	@Test
	public void testGetOrderDetail() throws Exception {

		Long detailOrderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/detail/{no}", detailOrderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상세주문리스트  요청 Test
	@Test
	public void testGetOrderDetailList() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/detail/list/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 입금확인체크  Test
	@Test
	public void testOrderDepositCheck() throws Exception {
		Long orderDetailNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/depositcheck/{orderDetailNo}", orderDetailNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 배송출발체크  Test
	@Test
	public void testOrderDeliveryCheck() throws Exception {
		Long orderNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/deliverydeparturecheck/{orderNo}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 배송완료체크  Test
	@Test
	public void testOrderDeliveryCompleteCheck() throws Exception {
		Long orderNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/deliverycompletecheck/{orderNo}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 주문검색리스트  요청 Test
	@Test
	public void testGetOrderSearchList() throws Exception {
		SearchDto searchDto = new SearchDto("phone", "01040287755");
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/search?menu={menu}&keyword={keyword}", searchDto.getMenu(), searchDto.getKeyword()))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
}

