package com.cafe24.pjshop.frontend.dto;

public class OptionDto {
	
	private Long productNo;
	private String optionName;
	private String optionValue;
	
	public OptionDto() {
	}

	public OptionDto(Long productNo, String optionName, String optionValue) {
		this.productNo = productNo;
		this.optionName = optionName;
		this.optionValue = optionValue;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	@Override
	public String toString() {
		return "OptionDto [productNo=" + productNo + ", optionName=" + optionName + ", optionValue=" + optionValue
				+ "]";
	}

	
	
}
