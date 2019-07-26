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
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionValueVo;
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
		Long productNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/detail/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());		
	}

	@Test
	public void testAddNotOptionProduct() throws Exception {
		// 옵션 없는거
		ProductVo voMock = new ProductVo(null, "찢어진 청바지", 30000L, null, true,
				false, true, 1L, 400L, "vintage.html",
				2500L, 3L);
	
		List<ProductImageVo> productImageList = new ArrayList<ProductImageVo>();
		ProductImageVo productImageVoMock1 = new ProductImageVo(null, null, "https://image1", "main");
		ProductImageVo productImageVoMock2 = new ProductImageVo(null, null, "https://image2", "sub");
		ProductImageVo productImageVoMock3 = new ProductImageVo(null, null, "https://image3", "etc");
		productImageList.add(productImageVoMock1);
		productImageList.add(productImageVoMock2);
		productImageList.add(productImageVoMock3);
		
		voMock.setProductImageList(productImageList);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
		
	
	}	
	
	/**
	 * 페이지 전용 ( 한페이지에 모든 정보를 실어보내는 형식 )
	 * @throws Exception
	 */
	@Test
	public void testAddOptionProduct() throws Exception {
	
		// 옵션 있는거
		
		// 옵션네임은 추가하면 추가하고 아니면 있는거 쓰고
		List<OptionNameVo> optionNameList = new ArrayList<OptionNameVo>();
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "색상");
		OptionNameVo optionNameVoMock2 = new OptionNameVo(null, "사이즈");
		optionNameList.add(optionNameVoMock1);
		optionNameList.add(optionNameVoMock2);

		List<OptionValueVo> optionValueList = new ArrayList<OptionValueVo>();
		OptionValueVo optionValueVoMock1 = new OptionValueVo(null, 1L, "블랙", 1L);
		OptionValueVo optionValueVoMock2 = new OptionValueVo(null, 1L, "화이트", 1L);
		OptionValueVo optionValueVoMock3 = new OptionValueVo(null, 2L, "L", 1L);
		OptionValueVo optionValueVoMock4 = new OptionValueVo(null, 2L, "M", 1L);
		OptionValueVo optionValueVoMock5 = new OptionValueVo(null, 2L, "S", 1L);
		optionValueList.add(optionValueVoMock1);
		optionValueList.add(optionValueVoMock2);
		optionValueList.add(optionValueVoMock3);
		optionValueList.add(optionValueVoMock4);
		optionValueList.add(optionValueVoMock5);
		
		List<OptionVo> optionList = new ArrayList<OptionVo>();
		
		OptionVo optionVoMock1 = new OptionVo(null, "블랙/L", true, 100L, 1500L, 1L);
		OptionVo optionVoMock2 = new OptionVo(null, "블랙/M", true, 100L, 1500L, 1L);
		OptionVo optionVoMock3 = new OptionVo(null, "블랙/S", true, 100L, 1500L, 1L);
		OptionVo optionVoMock4 = new OptionVo(null, "화이트/L", true, 100L, 1500L, 1L);
		OptionVo optionVoMock5 = new OptionVo(null, "화이트/M", true, 100L, 1500L, 1L);
		OptionVo optionVoMock6 = new OptionVo(null, "화이트/S", true, 100L, 1500L, 1L);
		
		optionList.add(optionVoMock1);
		optionList.add(optionVoMock2);
		optionList.add(optionVoMock3);
		optionList.add(optionVoMock4);
		optionList.add(optionVoMock5);
		optionList.add(optionVoMock6);
		
		List<ProductImageVo> productImageList = new ArrayList<ProductImageVo>();
		ProductImageVo productImageVoMock1 = new ProductImageVo(null, null, "https://image1", "main");
		ProductImageVo productImageVoMock2 = new ProductImageVo(null, null, "https://image2", "sub");
		ProductImageVo productImageVoMock3 = new ProductImageVo(null, null, "https://image3", "etc");
		productImageList.add(productImageVoMock1);
		productImageList.add(productImageVoMock2);
		productImageList.add(productImageVoMock3);
		
		ProductVo voMock = new ProductVo(null, "아디다스티", 40000L, null, true,
				true, true, 1L, 600L, "nike.html",
				2500L, 4L);
		voMock.setOptionValueList(optionValueList);
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
		2500L, 4L);

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
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "사이즈");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/optionname")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionNameVoMock1)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testDeleteProductOptionName() throws Exception{
		Long deleteNo = 7L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/product/optionname/{no}", deleteNo))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testAddProductOptionValue() throws Exception{
		OptionValueVo optionVoMock1 = new OptionValueVo(null, 1L, "레드", 1L);

		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/optionvalue")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionVoMock1)))
		.andExpect(status().isOk())
		.andDo(print());

	}
	@Test
	public void testDeleteProductOptionValue() throws Exception{
		Long deleteNo = 1L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/product/optionvalue/{no}", deleteNo))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testAddProductOption() throws Exception{
		OptionVo optionVoMock1 = new OptionVo(null, "레드/L", true, 100L, 1500L, 1L);

		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/option")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionVoMock1)))
		.andExpect(status().isOk())
		.andDo(print());

	}
	@Test
	public void testDeleteProductOption() throws Exception{
		Long deleteNo = 13L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/product/option/{no}", deleteNo))
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
		ProductImageVo productImageVoMock1 = new ProductImageVo(null, 3L, "image1.jpg", "main");
		ProductImageVo productImageVoMock2 = new ProductImageVo(null, 3L, "image2.jpg", "sub");
		productImageList.add(productImageVoMock1);
		productImageList.add(productImageVoMock2);
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product/imagelist")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productImageList)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testGetProductImageList() throws Exception{
		Long productNo = 3L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/image/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testDeleteProductImageOne() throws Exception{
		Long imageNo = 2L;
		
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/product/image/{no}", imageNo))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testDeleteProductImageList() throws Exception{
		Long productNo = 3L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/imagelist/{no}", productNo))
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
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품검색리스트  요청 Test
	@Test
	public void testGetProductSearchList() throws Exception {
		// 1. 이름 2. 컬러 3. 옵션여부, 판매여부, 전시여부, 카운트별, 등록일순 , 가격순, 카테고리 넘버
		SearchDto searchDto = new SearchDto("name", "아디다스");
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/search?menu={menu}&keyword={keyword}", searchDto.getMenu(), searchDto.getKeyword()))
				.andExpect(status().isOk())
				.andDo(print());
	}


}

