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

	// ��ǰ����Ʈ  ��û Test
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// ��ǰ�ϳ���  ��û Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 3L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// ��ǰ�󼼿�û ( ��ǰ���� + ��ǰ�ɼ� + �ɼ��̸� + ��ǥ�̹��� + ī�װ� )
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
		// �ɼ� ���°�
		ProductVo voMock = new ProductVo(null, "������ û����", 30000L, null, true,
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
	 * ������ ���� ( ���������� ��� ������ �Ǿ���� ���� )
	 * @throws Exception
	 */
	@Test
	public void testAddOptionProduct() throws Exception {
	
		// �ɼ� �ִ°�
		
		// �ɼǳ����� �߰��ϸ� �߰��ϰ� �ƴϸ� �ִ°� ����
		List<OptionNameVo> optionNameList = new ArrayList<OptionNameVo>();
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "����");
		OptionNameVo optionNameVoMock2 = new OptionNameVo(null, "������");
		optionNameList.add(optionNameVoMock1);
		optionNameList.add(optionNameVoMock2);

		List<OptionValueVo> optionValueList = new ArrayList<OptionValueVo>();
		OptionValueVo optionValueVoMock1 = new OptionValueVo(null, 1L, "��", 1L);
		OptionValueVo optionValueVoMock2 = new OptionValueVo(null, 1L, "ȭ��Ʈ", 1L);
		OptionValueVo optionValueVoMock3 = new OptionValueVo(null, 2L, "L", 1L);
		OptionValueVo optionValueVoMock4 = new OptionValueVo(null, 2L, "M", 1L);
		OptionValueVo optionValueVoMock5 = new OptionValueVo(null, 2L, "S", 1L);
		optionValueList.add(optionValueVoMock1);
		optionValueList.add(optionValueVoMock2);
		optionValueList.add(optionValueVoMock3);
		optionValueList.add(optionValueVoMock4);
		optionValueList.add(optionValueVoMock5);
		
		List<OptionVo> optionList = new ArrayList<OptionVo>();
		
		OptionVo optionVoMock1 = new OptionVo(null, "��/L", true, 100L, 1500L, 1L);
		OptionVo optionVoMock2 = new OptionVo(null, "��/M", true, 100L, 1500L, 1L);
		OptionVo optionVoMock3 = new OptionVo(null, "��/S", true, 100L, 1500L, 1L);
		OptionVo optionVoMock4 = new OptionVo(null, "ȭ��Ʈ/L", true, 100L, 1500L, 1L);
		OptionVo optionVoMock5 = new OptionVo(null, "ȭ��Ʈ/M", true, 100L, 1500L, 1L);
		OptionVo optionVoMock6 = new OptionVo(null, "ȭ��Ʈ/S", true, 100L, 1500L, 1L);
		
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
		
		ProductVo voMock = new ProductVo(null, "�Ƶ�ٽ�Ƽ", 40000L, null, true,
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
	 * ��ǰ��� (ajax - version)
	 * ��ǰ ī�װ� ����
	 * ��ǰ ���
	 * ��ǰ �ɼ� ��������
	 * ��ǰ �ɼ� �̸� ���
	 * ��ǰ �ɼ� �� ���
	 * ��ǰ �̹��� ���
	 * @throws Exception
	 */
	@Test
	public void testAddProductByAjax() throws Exception{
		ProductVo voMock = new ProductVo(null, "��Ƽ��û����", 30000L, null, true,
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
		OptionNameVo optionNameVoMock1 = new OptionNameVo(null, "������");
		
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
		OptionValueVo optionVoMock1 = new OptionValueVo(null, 1L, "����", 1L);

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
		OptionVo optionVoMock1 = new OptionVo(null, "����/L", true, 100L, 1500L, 1L);

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
	
	// ��ǰ����  Test
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo voMock = new ProductVo();
		voMock.setName("��������");
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
	
	// ��ǰ����  Test
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
	@Test
	public void testGetProductSearchList() throws Exception {
		// 1. �̸� 2. �÷� 3. �ɼǿ���, �Ǹſ���, ���ÿ���, ī��Ʈ��, ����ϼ� , ���ݼ�, ī�װ� �ѹ�
		SearchDto searchDto = new SearchDto("name", "�Ƶ�ٽ�");
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/search?menu={menu}&keyword={keyword}", searchDto.getMenu(), searchDto.getKeyword()))
				.andExpect(status().isOk())
				.andDo(print());
	}


}

