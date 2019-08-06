package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;
import com.cafe24.pjshop.dto.SearchDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class ProductControllerTest {
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
	// 상품검색 Test 
	@Test
	public void testProductSearchList() throws Exception{
		SearchDto searchDto = new SearchDto("name", "찢어진 청바지");
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/search?menu={menu}&keyword={keyword}", searchDto.getMenu(), searchDto.getKeyword()))
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
	
	// 상품카테고리 리스트  요청 Test
	@Test
	public void testGetProductListByCategory() throws Exception {
		Long categoryNo = 3L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/list?category={no}", categoryNo))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 상품한개  요청 Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	

	// 상품상세요청 ( 상품정보 + 상품옵션 + 옵션이름 + 대표이미지 + 카테고리 )
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
