package com.cafe24.pjshop.dto;

public class CartDto {
	
	private Long no;
	private Long userNo;
	private String nonUserId;
	private Long productOptionNo;
	private String optionValue;
	private Long additionalPrice;
	private String productName;
	private Long productNo;
	private Long price;
	private Long shippingFee;
	private Long count;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(Long no, Long userNo, String nonUserId, Long productOptionNo, String optionValue,
			Long additionalPrice, String productName, Long productNo, Long price, Long shippingFee, Long count) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.nonUserId = nonUserId;
		this.productOptionNo = productOptionNo;
		this.optionValue = optionValue;
		this.additionalPrice = additionalPrice;
		this.productName = productName;
		this.productNo = productNo;
		this.price = price;
		this.shippingFee = shippingFee;
		this.count = count;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getNonUserId() {
		return nonUserId;
	}

	public void setNonUserId(String nonUserId) {
		this.nonUserId = nonUserId;
	}

	public Long getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(Long productOptionNo) {
		this.productOptionNo = productOptionNo;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartDto [no=" + no + ", userNo=" + userNo + ", nonUserId=" + nonUserId + ", productOptionNo="
				+ productOptionNo + ", optionValue=" + optionValue + ", additionalPrice=" + additionalPrice
				+ ", productName=" + productName + ", productNo=" + productNo + ", price=" + price + ", shippingFee="
				+ shippingFee + ", count=" + count + "]";
	}

	
	
}
