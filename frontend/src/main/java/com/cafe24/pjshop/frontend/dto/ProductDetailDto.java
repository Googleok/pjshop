package com.cafe24.pjshop.frontend.dto;

import java.util.List;

import com.cafe24.pjshop.frontend.vo.ProductImageVo;
import com.cafe24.pjshop.frontend.vo.ProductVo;

public class ProductDetailDto {

	private ProductVo productVo;
	private List<OptionDto> optionDtoList;
	private List<ProductImageVo> productImageVoList;
	
	public ProductDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDetailDto(ProductVo productVo, List<OptionDto> optionDtoList,
			List<ProductImageVo> productImageVoList) {
		super();
		this.productVo = productVo;
		this.optionDtoList = optionDtoList;
		this.productImageVoList = productImageVoList;
	}

	public ProductVo getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	public List<OptionDto> getOptionDtoList() {
		return optionDtoList;
	}

	public void setOptionDtoList(List<OptionDto> optionDtoList) {
		this.optionDtoList = optionDtoList;
	}

	public List<ProductImageVo> getProductImageVoList() {
		return productImageVoList;
	}

	public void setProductImageVoList(List<ProductImageVo> productImageVoList) {
		this.productImageVoList = productImageVoList;
	}

	@Override
	public String toString() {
		return "ProductDetailDto [productVo=" + productVo + ", optionDtoList=" + optionDtoList + ", productImageVoList="
				+ productImageVoList + "]";
	}
	
	
	
}
