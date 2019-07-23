package com.cafe24.pjshop.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.cafe24.pjshop.vo.CartVo;
import com.cafe24.pjshop.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { WebConfig.class })
public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testJoin() throws Exception {
		UserVo voMock = new UserVo(null, "whddjr2225", "Whddjr129", "������", "01040287755", "whddjr2225@naver.com",
				"1993-11-02", "male", "user");

		ResultActions resultActions = mockMvc.perform(
				post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testCheckEmail() throws Exception {

		String userEmail = "whddjr2225@naver.com";

		ResultActions resultActions = mockMvc.perform(get("/api/user/checkemail?email={email}", userEmail))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testUserLogin() throws Exception {
		UserVo userVo = new UserVo();

		// 1. Normal User's Login Data
		userVo.setId("whddjr2225");
		userVo.setPassword("i0613011m9J2YV6");

		ResultActions resultActions = mockMvc.perform(
				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // ����
																														// url

		resultActions.andExpect(status().isOk()).andDo(print());

//		// 2. Invalidation in Email :
//		userVo.setId("wh");
//		userVo.setPassword("Whddjr129");
//
//		resultActions = mockMvc.perform(
//				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // ����
//																														// url
//
//		resultActions.andExpect(status().isBadRequest()).andDo(print()).andExpect(jsonPath("$.result", is("fail")));
//
//		// 3. Invalidation in Password :
//		userVo.setId("whddjr2225");
//		userVo.setPassword("Whddjr");
//
//		resultActions = mockMvc.perform(
//				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // ����
//																														// url
//
//		resultActions.andExpect(status().isBadRequest()).andDo(print()).andExpect(jsonPath("$.result", is("fail")));

	}

	@Test
	public void testFindId() throws Exception {
		// ������ �̸��� ��ȣ�� �Է��ϰ� ������ȣ�� Ȯ���ؾ��ϴµ� 
		// ������ �׳� ������� �̸��� ��ȣ�� ������ ���̵� �����ִ°�
		String userName = "������";
		String userPhone = "01040287755";
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/find/id?name={name}&phone={phone}", userName, userPhone))
						.andExpect(status().isOk())
						.andDo(print());
	}
	
	@Test
	public void testFindPassword() throws Exception {
		// ������ ���̵� �Է��ϰ�  �̸��Ϸ� ���ο� ��й�ȣ�� �����ؼ� �����µ�
		// ������ ������� ��й�ȣ�� ���Ƿ� �����ϰ� �������ִ� ������ �ϰ���
		String id = "whddjr2225";
		String name = "������";
		String phone = "01040287755";
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/find/password?id={id}&name={name}&phone={phone}", id, name, phone))
						.andExpect(status().isOk())
						.andDo(print());
	}
	
	@Test
	public void testModify() throws Exception {
		UserVo voMock = new UserVo();
		voMock.setName("������");
		voMock.setEmail("qkrwhddjr3@gmail.com");
		voMock.setGender("male");
		voMock.setRole("admin");
		
		Long updateNo = 1L;

		ResultActions resultActions = mockMvc.perform(
				put("/api/user/{updateNo}", updateNo).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void testAddToCart() throws Exception{
		CartVo voMock = new CartVo();
		voMock.setUserNo(6L);
		voMock.setOptionNo(1L);
		voMock.setCount(3L);
		voMock.setIsMember(true);
		
	}

}
