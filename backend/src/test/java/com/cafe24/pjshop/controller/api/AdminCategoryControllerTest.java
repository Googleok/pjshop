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
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;
import com.cafe24.pjshop.vo.CategoryVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class AdminCategoryControllerTest {
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
	
	// ī�װ� ����Ʈ Test
	@Test
	public void testGetCategoryList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category").header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// ī�װ� ��� Test
	@Test
	public void testAddParentCategory() throws Exception {
		
		// �θ� ī�װ� ���� ���
		CategoryVo voMock1 = new CategoryVo(null, "�ƿ���", 1L, null, null);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category").header("Authorization", "Bearer " + accessToken)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock1)))
				.andExpect(status().isOk())
				.andDo(print());
	
	}	
	
	@Test
	public void testAddChildCategory() throws Exception {
		
		// �θ� ī�װ� �ִ� ���
		CategoryVo voMock = new CategoryVo(null, "Ƽ����", 2L, 1L, 1L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category").header("Authorization", "Bearer " + accessToken)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	
	// ī�װ� ���� Test
	@Test
	public void testModifyCategory() throws Exception {
		CategoryVo voMock = new CategoryVo();
		voMock.setName("Ƽ����");
		
		Long modifyNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/{modifyNo}", modifyNo).header("Authorization", "Bearer " + accessToken)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ī�װ� ���� Test
	@Test
	public void testDeleteCategory() throws Exception {
		Long deleteNo = 7L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{deleteNo}", deleteNo).header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
}

