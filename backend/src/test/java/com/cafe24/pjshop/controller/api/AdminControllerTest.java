package com.cafe24.pjshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.pjshop.config.test.WebConfig;
import com.cafe24.pjshop.vo.CategoryVo;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductImageVo;
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
	
	// 카테고리 리스트 Test
	@Test
	public void testGetCategoryList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// 카테고리 등록 Test
	@Test
	public void testAddCategory() throws Exception {
		
		// 부모 카테고리 없는 경우
//		CategoryVo voMock1 = new CategoryVo(null, "상의", 1L, null, null);
//		
//		ResultActions resultActions = 
//				mockMvc
//				.perform(post("/api/admin/category")
//				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock1)))
//				.andExpect(status().isOk())
//				.andDo(print());
		
		// 부모 카테고리 있는 경우
		CategoryVo voMock = new CategoryVo(null, "티셔츠", 2L, 1L, 1L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 카테고리 수정 Test
	@Test
	public void testModifyCategory() throws Exception {
		CategoryVo voMock = new CategoryVo();
		voMock.setName("티셔츠");
		
		Long modifyNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/{modifyNo}", modifyNo)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 카테고리 삭제 Test
	@Test
	public void testDeleteCategory() throws Exception {
		Long deleteNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
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
		Long productNo = 6L;
		
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
				2500L, 2L);
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
	 * 상품 옵션 가져오기
	 * 상품 옵션 이름 등록
	 * 상품 옵션 상세 등록
	 * 상품 이미지 등록
	 * 상품 등록
	 * @throws Exception
	 */
	@Test
	public void testAddProductByAjax() throws Exception{
		ProductVo voMock = new ProductVo(null, "빈티지바지", 30000L, null, true,
		false, true, 1L, 400L, "cap.html",
		2500L, 3L);

		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/product")
		.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	@Test
	public void testGetProductOption() throws Exception{}
	@Test
	public void testAddProductOptionName() throws Exception{}
	@Test
	public void testAddProductOption() throws Exception{}
	@Test
	public void testAddProductImage() throws Exception{}
	
	// 상품수정  Test
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo voMock = new ProductVo();
		voMock.setName("가죽자켓");
		voMock.setPrice(120000L);
		
		Long modifyNo = 2L;
		
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
	
	// ===================================================================================================
	
	// 주문리스트  요청 Test
	@Ignore
	@Test
	public void testGetOrderList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// 주문한개  요청 Test
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
	
	// 상세주문  요청 Test
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
	
	// 입금확인체크  Test
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
	
	// 배송출발체크  Test
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
	
	// 주문검색리스트  요청 Test
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
	
	// 회원관리
	
	// 회원리스트 요청 Test
	@Ignore
	@Test
	public void testGetUserList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// 회원삭제  Test
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
	
	// 회원정보수정  Test
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
	
	// 회원검색리스트  요청 Test
	@Ignore
	@Test
	public void testGetUserSearchList() throws Exception {
		String keyword = "박종억";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
}

