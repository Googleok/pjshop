package com.cafe24.pjshop.frontend.dto;

public class OrderProductDto {
	
	private Long productOptionNo;
	private Long count;
	private Long productPrice;
	
	public Long getProductOptionNo() {
		return productOptionNo;
	}
	public void setProductOptionNo(Long productOptionNo) {
		this.productOptionNo = productOptionNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "OrderProductDto [productOptionNo=" + productOptionNo + ", count=" + count + ", productPrice="
				+ productPrice + "]";
	}
	
	
	

}
