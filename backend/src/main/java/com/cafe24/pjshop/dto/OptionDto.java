package com.cafe24.pjshop.dto;

public class OptionDto {
	
	private Long productNo;
	private String optionName;
	private String optionValue;
	private Long additionalPrice;
	private boolean stockAvailability;
	
	public OptionDto() {
	}

	public OptionDto(Long productNo, String optionName, String optionValue, Long additionalPrice,
			boolean stockAvailability) {
		this.productNo = productNo;
		this.optionName = optionName;
		this.optionValue = optionValue;
		this.additionalPrice = additionalPrice;
		this.stockAvailability = stockAvailability;
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

	public Long getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(Long additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public boolean isStockAvailability() {
		return stockAvailability;
	}

	public void setStockAvailability(boolean stockAvailability) {
		this.stockAvailability = stockAvailability;
	}

	@Override
	public String toString() {
		return "OptionDto [productNo=" + productNo + ", optionName=" + optionName + ", optionValue=" + optionValue
				+ ", additionalPrice=" + additionalPrice + ", stockAvailability=" + stockAvailability + "]";
	}

	
}
