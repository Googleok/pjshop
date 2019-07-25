package com.cafe24.pjshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.ProductDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.repository.AdminProductDao;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionValueVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao adminProductDao;

	// 상품전체리스트
	public List<ProductVo> getProductList() {
		return adminProductDao.getProductList();
	}

	// 상품하나
	public ProductVo getProductOne(Long no) {
		return adminProductDao.getProductOne(no);
	}

	// 상품상세정보
	public ProductDto getProductDetail(Long no) {

//		ProductVo productVo = adminProductDao.getProductOne(no);
//		List<OptionDto> optionList = adminProductDao.getProductOption(no);
//		List<ProductImageVo> productImageList = adminProductDao.getProductImageList(no);
//		
//		ProductDetailDto productDetailDto = new ProductDetailDto(productVo, optionList, productImageList);
//		
//		return productDetailDto;
		return adminProductDao.getProductDetail(no);
	}

	// 상품등록
	public Boolean addProduct(ProductVo productVo) {
		// 상품 추가하기
//		Long insertProductNo = adminProductDao.addProduct(productVo);
		System.out.println("===============================================================");
//		System.out.println(insertProductNo);
		System.out.println("===============================================================");

		// 상품이미지 등록
		for (ProductImageVo vo : productVo.getProductImageList()) {
//			vo.setProductNo(insertProductNo);
//			adminProductDao.addProductImage(vo);
		}

		boolean optionValueResult = false;
		boolean optionResult = false;
		// 옵션체크 있으면
		if (productVo.getOptionAvailability()) {
			List<OptionValueVo> optionValueVoList = productVo.getOptionValueList();
			List<OptionVo> optionVoList = productVo.getOptionList();
			
			// 옵션밸류를 한방에 넣기
			optionValueResult = adminProductDao.addOptionValues(optionValueVoList);
			// 옵션풀값을 한방에 넣기
			optionResult = adminProductDao.addOptions(optionVoList);
		}

		return optionValueResult && optionResult;
	}

	// 상품등록 ajax
	public Long addProductByAjax(ProductVo productVo) {
		return adminProductDao.addProduct(productVo);
	}

	// 상품수정
	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		boolean result = adminProductDao.modifyProduct(no, newVo);
		return result ? newVo : null;
	}

	// 상품삭제
	public boolean deleteProduct(Long no) {
		return adminProductDao.deleteProduct(no);
	}

	// 상품검색
	public List<ProductVo> getProductSearchList(SearchDto searchDto) {
		return adminProductDao.getProductSearchList(searchDto);
	}

	public List<OptionNameVo> getOptionNameList() {
		return adminProductDao.getOptionNameList();
	}

	public Long addOptionName(OptionNameVo vo) {
		boolean result = adminProductDao.existOptionName(vo.getOptionName()) == null ? true : false;
		return result? adminProductDao.addOptionName(vo) : 0L;
	}

	public boolean deleteOptionName(Long no) {
		return adminProductDao.deleteOptionName(no);
	}

	public Long addOptionValue(OptionValueVo vo) {
		return adminProductDao.addOptionValue(vo) ? vo.getNo() : 0L;
	}
	
	public boolean deleteOptionValue(Long no) {
		return adminProductDao.deleteOptionValue(no);
	}

	public boolean addProductImage(ProductImageVo vo) {
		return adminProductDao.addProductImage(vo);
	}

	public boolean addProductImageList(List<ProductImageVo> list) {
		for (ProductImageVo vo : list) {
			adminProductDao.addProductImage(vo);
		}
		return true;
	}

	public List<ProductImageVo> getProductImageList(Long productNo) {
		return adminProductDao.getProductImageList(productNo);
	}

	public boolean deleteProductImage(Long imageNo) {
		return adminProductDao.deleteProductImage(imageNo);
	}

	public boolean deleteProductImageList(Long productNo) {
		return adminProductDao.deleteProductImageList(productNo);
	}

	public Long addOption(OptionVo vo) {
		return adminProductDao.addOption(vo) ? vo.getNo() : null;
	}

	public boolean deleteOption(Long no) {
		return adminProductDao.deleteOption(no);
	}



}
