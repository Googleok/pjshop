package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebConfig.class})
public class AdminProductControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// 상품리스트  요청 Test
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// 상품하나만  요청 Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 3L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품상세요청 ( 상품정보 + 상품옵션 + 옵션이름 + 대표이미지 + 카테고리 )
	@Test
	public void testGetDetailProductInfo() throws Exception{
		Long productNo = 9L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/detail/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());		
	}

	/**
	 * 페이지 전용 ( 한페이지에 모든 정보를 실어보내는 형식 )
	 * @throws Exception
	 */
	@Test
	public void testAddProduct() throws Exception {
		// 옵션 없는거
//		ProductVo voMock = new ProductVo(null, "빈티지바지", 30000L, null, true,
//				false, true, 1L, 400L, "cap.html",
//				2500L, 4L);
//	
//		ResultActions resultActions = 
//				mockMvc
//				.perform(post("/api/admin/product")
//				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
//				.andExpect(status().isOk())
//				.andDo(print());
		
		// 옵션 있는거
		List<OptionNameVo> optionNameList = new ArrayList<OptionNameVo>();
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "색상");
		OptionNameVo optionNameVoMock2 = new OptionNameVo(null, "사이즈");
		optionNameList.add(optionNameVoMock1);
		optionNameList.add(optionNameVoMock2);

		List<OptionVo> optionList = new ArrayList<OptionVo>();
		OptionVo optionVoMock1 = new OptionVo(null, "블랙", true, 1500L, null, null, "색상", 100L);
		OptionVo optionVoMock2 = new OptionVo(null, "화이트", true, 1500L, null, null, "색상", 100L);
		OptionVo optionVoMock3 = new OptionVo(null, "L", true, 1500L, null, null, "사이즈", 100L);
		OptionVo optionVoMock4 = new OptionVo(null, "M", true, 1500L, null, null, "사이즈", 100L);
		OptionVo optionVoMock5 = new OptionVo(null, "S", true, 1500L, null, null, "사이즈", 100L);
		optionList.add(optionVoMock1);
		optionList.add(optionVoMock2);
		optionList.add(optionVoMock3);
		optionList.add(optionVoMock4);
		optionList.add(optionVoMock5);
		
		List<ProductImageVo> productImageList = new ArrayList<ProductImageVo>();
		ProductImageVo productImageVoMock1 = new ProductImageVo(null, null, "https://image1", "main");
		ProductImageVo productImageVoMock2 = new ProductImageVo(null, null, "https://image2", "sub");
		ProductImageVo productImageVoMock3 = new ProductImageVo(null, null, "https://image3", "etc");
		productImageList.add(productImageVoMock1);
		productImageList.add(productImageVoMock2);
		productImageList.add(productImageVoMock3);
		
		ProductVo voMock = new ProductVo(null, "아디다스티", 40000L, null, true,
				true, true, 1L, 400L, "nike.html",
				2500L, 5L);
		voMock.setOptionNameList(optionNameList);
		voMock.setOptionList(optionList);
		voMock.setProductImageList(productImageList);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	/**
	 * 상품등록 (ajax - version)
	 * 상품 카테고리 선택
	 * 상품 등록
	 * 상품 옵션 가져오기
	 * 상품 옵션 이름 등록
	 * 상품 옵션 상세 등록
	 * 상품 이미지 등록
	 * @throws Exception
	 */
	@Test
	public void testAddProductByAjax() throws Exception{
		ProductVo voMock = new ProductVo(null, "빈티지청바지", 30000L, null, true,
		true, true, 1L, 400L, "jean.html",
		2500L, 5L);

		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/ajax")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testGetOptionName() throws Exception{
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/product/optionname"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testAddProductOptionName() throws Exception{
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "발사이즈");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/optionname")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionNameVoMock1)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testDeleteProductOptionName() throws Exception{
		Long deleteNo = 3L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/product/optionname/{no}", deleteNo))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testAddProductOption() throws Exception{
		OptionVo optionVoMock1 = new OptionVo(null, "진청", true, 1500L, 9L, 1L, null, 100L);

		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/optionvalue")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionVoMock1)))
		.andExpect(status().isOk())
		.andDo(print());

	}
	
	@Test
	public void testAddProductImage() throws Exception{
		ProductImageVo productImageVoMock = new ProductImageVo(null, 9L, "image2.jpg", "sub");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/image")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productImageVoMock)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testAddProductImageList() throws Exception{
		List<ProductImageVo> productImageList = new ArrayList<ProductImageVo>();
		ProductImageVo productImageVoMock1 = new ProductImageVo(null, 9L, "image1.jpg", "main");
		ProductImageVo productImageVoMock2 = new ProductImageVo(null, 9L, "image2.jpg", "sub");
		productImageList.add(productImageVoMock1);
		productImageList.add(productImageVoMock2);
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/imagelist")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productImageList)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 상품수정  Test
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo voMock = new ProductVo();
		voMock.setName("가죽자켓");
		voMock.setPrice(120000L);
		voMock.setCategoryNo(2L);

		Long modifyNo = 8L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/{modifyNo}", modifyNo)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품삭제  Test
	@Test
	public void testDeleteProduct() throws Exception {
		Long deleteNo = 5L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품검색리스트  요청 Test
	@Test
	public void testGetProductSearchList() throws Exception {
		String keyword = "cap";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}


}

