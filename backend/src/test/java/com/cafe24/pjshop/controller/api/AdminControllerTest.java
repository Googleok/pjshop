package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
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
import com.cafe24.pjshop.vo.CategoryVo;
import com.cafe24.pjshop.vo.ProductVo;
import com.cafe24.pjshop.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class AdminControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	// ī�װ� ����Ʈ Test
	@Ignore
	@Test
	public void testGetCategoryList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	// ī�װ� ��� Test
	@Ignore
	@Test
	public void testAddCategory() throws Exception {
		
		// �θ� ī�װ� ���� ���
		CategoryVo voMock = new CategoryVo(null, "����", 1L, null, null);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
		
		// �θ� ī�װ� �ִ� ���
//		voMock = new CategoryVo(null, "����", 2L, 1L, 1L);
//		
//		ResultActions resultActions = 
//				mockMvc
//				.perform(post("/api/admin/category")
//				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
//				.andExpect(status().isOk())
//				.andDo(print());
	}	
	
	// ī�װ� ���� Test
	@Ignore
	@Test
	public void testModifyCategory() throws Exception {
		CategoryVo voMock = new CategoryVo();
		voMock.setName("Ƽ����");
		
		Long modifyNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/{modifyNo}", modifyNo)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ī�װ� ���� Test
	@Ignore
	@Test
	public void testDeleteCategory() throws Exception {
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	
	
	// ��ǰ����Ʈ  ��û Test
	@Ignore
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// ��ǰ�ϳ���  ��û Test
	@Ignore
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	

	// ��ǰ���  Test
	@Ignore
	@Test
	public void testAddProduct() throws Exception {
		ProductVo voMock = new ProductVo(1L, "����", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ��ǰ����  Test
	@Ignore
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo voMock = new ProductVo();
		voMock.setName("��������");
		voMock.setPrice(120000L);
		
		Long modifyNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/{modifyNo}", modifyNo)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ��ǰ����  Test
	@Ignore
	@Test
	public void testDeleteProduct() throws Exception {
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ��ǰ�˻�����Ʈ  ��û Test
	@Ignore
	@Test
	public void testGetProductSearchList() throws Exception {
		String keyword = "cap";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// ===================================================================================================
	
	// �ֹ�����Ʈ  ��û Test
	@Ignore
	@Test
	public void testGetOrderList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// �ֹ��Ѱ�  ��û Test
	@Ignore
	@Test
	public void testGetOrderOne() throws Exception {

		Long orderNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ���ֹ�  ��û Test
	@Ignore
	@Test
	public void testGetOrderDetail() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/detail/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	
	// �Ա�Ȯ��üũ  Test
	@Ignore
	@Test
	public void testOrderDepositCheck() throws Exception {
		Long orderDetailNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/depositcheck/{orderDetailNo}", orderDetailNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ������üũ  Test
	@Ignore
	@Test
	public void testOrderDeliveryCheck() throws Exception {
		Long orderDetailNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/deliverycheck/{orderDetailNo}", orderDetailNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// �ֹ��˻�����Ʈ  ��û Test
	@Ignore
	@Test
	public void testGetOrderSearchList() throws Exception {
		String keyword = "01040287755";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// ======================================================================================
	
	// ȸ������
	
	// ȸ������Ʈ ��û Test
	@Ignore
	@Test
	public void testGetUserList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// ȸ������  Test
	@Ignore
	@Test
	public void testDeleteUser() throws Exception {
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/user/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ȸ����������  Test
	@Ignore
	@Test
	public void testModifyUser() throws Exception {
		UserVo voMock = new UserVo();
		voMock.setPhone("01012345678");
		voMock.setGender("female");
		
		Long modifyNo = 2L;
		
		ResultActions resultActions = 
					mockMvc
					.perform(put("/api/admin/user/{modifyNo}", modifyNo)
					.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
					.andExpect(status().isOk())
					.andDo(print());
	}	
	
	// ȸ���˻�����Ʈ  ��û Test
	@Ignore
	@Test
	public void testGetUserSearchList() throws Exception {
		String keyword = "������";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
}

