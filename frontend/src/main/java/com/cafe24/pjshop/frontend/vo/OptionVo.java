package com.cafe24.pjshop.frontend.vo;

public class OptionVo {
	private Long no;
	private String optionValue;
	private Boolean stockAvailability;
	private Long productCount;
	private Long additionalPrice;
	private Long productNo;
	
	public OptionVo() {
		// TODO Auto-generated constructor stub
	}

	public OptionVo(Long no, String optionValue, Boolean stockAvailability, Long productCount, Long additionalPrice, Long productNo) {
		super();
		this.no = no;
		this.optionValue = optionValue;
		this.stockAvailability = stockAvailability;
		this.productCount = productCount;
		this.additionalPrice = additionalPrice;
		this.productNo = productNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Boolean getStockAvailability() {
		return stockAvailability;
	}

	public void setStockAvailability(Boolean stockAvailability) {
		this.stockAvailability = stockAvailability;
	}

	public Long getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(Long additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "OptionVo [no=" + no + ", optionValue=" + optionValue + ", stockAvailability=" + stockAvailability
				+ ", productCount=" + productCount + ", additionalPrice=" + additionalPrice + ", productNo=" + productNo
				+ "]";
	}

	
}
