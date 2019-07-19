package com.cafe24.pjshop.vo;

public class OptionVo {
	private Long no;
	private String optionValue;
	private Boolean stockAvailability;
	private Long additionalPrice;
	private Long productNo;
	private Long optionNameNo;
	private String optionName;
	private Long productCount;
	
	public OptionVo() {
		// TODO Auto-generated constructor stub
	}

	public OptionVo(Long no, String optionValue, Boolean stockAvailability, Long additionalPrice, Long productNo,
			Long optionNameNo, String optionName, Long productCount) {
		super();
		this.no = no;
		this.optionValue = optionValue;
		this.stockAvailability = stockAvailability;
		this.additionalPrice = additionalPrice;
		this.productNo = productNo;
		this.optionNameNo = optionNameNo;
		this.optionName = optionName;
		this.productCount = productCount;
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

	public Long getOptionNameNo() {
		return optionNameNo;
	}

	public void setOptionNameNo(Long optionNameNo) {
		this.optionNameNo = optionNameNo;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
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
				+ ", additionalPrice=" + additionalPrice + ", productNo=" + productNo + ", optionNameNo=" + optionNameNo
				+ ", optionName=" + optionName + ", productCount=" + productCount + "]";
	}




	
}
