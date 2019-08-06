package com.cafe24.pjshop.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;
import com.cafe24.pjshop.dto.OptionDto;
import com.cafe24.pjshop.vo.CartVo;
import com.cafe24.pjshop.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { WebConfig.class })
@AutoConfigureMockMvc
public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    private String accessToken;  //= "ec9d4b8c-2d03-4ba3-9968-13967318d7ac";

	
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain).build();
	
		// Access Token
        if(accessToken != null) {
        	return;
        }
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        
        params.add("grant_type", "client_credentials");
        params.add("scope", "read");
        params.add("scope", "write");
        
        ResultActions result = mockMvc
            	.perform( post("/oauth/token")
            				.params(params)
                    		.header("Authorization", "Basic " + new String(Base64.encode(("pjshop:1234").getBytes())))
                            .accept("application/json; charset=UTF-8")
                            .contentType(MediaType.APPLICATION_JSON))
    			.andDo(print())
    			.andExpect(status().isOk());            	

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        accessToken = jsonParser.parseMap(resultString).get("access_toke" + "n").toString();
	}

	@Test
	public void testJoin() throws Exception {
		UserVo voMock = new UserVo(null, "test", "test1234", "박종억", "01040287755", "whddjr2225@naver.com",
				"1993-11-02", "male", "admin");

		UserVo voMock2 = new UserVo(null, "nonuser", "Nonuser123", "비회원", "01040287755", "whddjr2225@naver.com",
				"1993-11-02", "male", "user");

		
		ResultActions resultActions = mockMvc.perform(
				post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)).header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testCheckEmail() throws Exception {

		String userEmail = "whddjr2225@naver.com";

		ResultActions resultActions =
				mockMvc.perform(get("/api/user/checkemail?email={email}", userEmail)
						.header("Authorization", "Bearer " + accessToken))
					.andExpect(status().isOk())
					.andDo(print());

	}

	@Test
	public void testUserLogin() throws Exception {
		UserVo userVo = new UserVo();

		// 1. Normal User's Login Data
		userVo.setId("test");
		userVo.setPassword("test1234");

		ResultActions resultActions = mockMvc.perform(
				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)).header("Authorization", "Bearer " + accessToken)); // 없는
																														// url

		resultActions.andExpect(status().isOk()).andDo(print());

//		// 2. Invalidation in Email :
//		userVo.setId("wh");
//		userVo.setPassword("Whddjr129");
//
//		resultActions = mockMvc.perform(
//				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // 없는
//																														// url
//
//		resultActions.andExpect(status().isBadRequest()).andDo(print()).andExpect(jsonPath("$.result", is("fail")));
//
//		// 3. Invalidation in Password :
//		userVo.setId("whddjr2225");
//		userVo.setPassword("Whddjr");
//
//		resultActions = mockMvc.perform(
//				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // 없는
//																														// url
//
//		resultActions.andExpect(status().isBadRequest()).andDo(print()).andExpect(jsonPath("$.result", is("fail")));

	}

	@Test
	public void testFindId() throws Exception {
		// 원래는 이름과 번호를 입력하고 인증번호로 확인해야하는데 
		// 지금은 그냥 약식으로 이름과 번호를 보내면 아이디를 보내주는것
		String userName = "박종억";
		String userPhone = "01040287755";
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/find/id?name={name}&phone={phone}", userName, userPhone).header("Authorization", "Bearer " + accessToken))
						.andExpect(status().isOk())
						.andDo(print());
	}
	
	@Test
	public void testFindPassword() throws Exception {
		// 원래는 아이디를 입력하고  이메일로 새로운 비밀번호를 생성해서 보내는데
		// 지금은 약식으로 비밀번호를 임의로 생성하고 리턴해주는 식으로 하겠음
		String id = "whddjr2225";
		String name = "박종억";
		String phone = "01040287755";
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/find/password?id={id}&name={name}&phone={phone}", id, name, phone).header("Authorization", "Bearer " + accessToken))
						.andExpect(status().isOk())
						.andDo(print());
	}
	
	@Test
	public void testUserModify() throws Exception {
		UserVo voMock = new UserVo();
		voMock.setName("박종억");
		voMock.setEmail("qkrwhddjr3@gmail.com");
		voMock.setGender("male");
		voMock.setRole("admin");
		
		Long updateNo = 1L;

		ResultActions resultActions = mockMvc.perform(
				put("/api/user/{updateNo}", updateNo).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)).header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testAddToCartByUser() throws Exception{

		// 옵션 상품 하나
		CartVo voMock = new CartVo();
		voMock.setUserNo(1L);
		voMock.setCount(3L);
		voMock.setProductOptionNo(3L);
		
		ResultActions resultActions = 
				mockMvc.perform(post("/api/user/cart")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(voMock)).header("Authorization", "Bearer " + accessToken))
					    .andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testAddToCartByNotUser() throws Exception{

		// 옵션 상품 하나
		CartVo voMock = new CartVo();
		voMock.setNonUserId("nonuser1");
		voMock.setCount(10L);
		voMock.setProductOptionNo(1L);
		
		ResultActions resultActions = 
				mockMvc.perform(post("/api/user/cart")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(voMock)).header("Authorization", "Bearer " + accessToken))
					    .andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testDeleteProductFromCart() throws Exception{
		Long deleteNo = 3L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/user/cart/{no}", deleteNo).header("Authorization", "Bearer " + accessToken))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testDeleteProductListFromCart() throws Exception{
		List<Long> deleteNoList = new ArrayList<Long>();
		deleteNoList.add(5L);
		deleteNoList.add(4L);
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/user/cart")
		.contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(deleteNoList)).header("Authorization", "Bearer " + accessToken))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testModifyCountFromCart() throws Exception{
		
		Long columnNo = 23L;
		CartVo voMock = new CartVo();
		voMock.setCount(30L);
		ResultActions resultActions = 
		mockMvc
		.perform(put("/api/user/cart/{no}", columnNo)
		.contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(voMock)).header("Authorization", "Bearer " + accessToken))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testGetCartListByUser() throws Exception {
		
		Long userNo = 1L;
		String nonUserId = null;
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/cart?id={id}&nonUserId={nonUserId}", userNo, nonUserId).header("Authorization", "Bearer " + accessToken))
						.andExpect(status().isOk())
						.andDo(print());
	}

	@Test
	public void testGetCartListByNonUser() throws Exception {
		
		Long userNo = null;
		String nonUserId = "nonUser1";
		
		ResultActions resultActions = 
				mockMvc.perform(get("/api/user/cart?id={id}&nonUserId={nonUserId}", userNo, nonUserId).header("Authorization", "Bearer " + accessToken))
						.andExpect(status().isOk())
						.andDo(print());
	}
}
