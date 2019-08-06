package com.cafe24.pjshop.frontend.dto;

public class OrderProductDto {
	
	private Long productOptionNo;
	private Long count;
	
	public OrderProductDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderProductDto(Long productOptionNo, Long count) {
		super();
		this.productOptionNo = productOptionNo;
		this.count = count;
	}

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

	@Override
	public String toString() {
		return "OrderProductDto [productOptionNo=" + productOptionNo + ", count=" + count + "]";
	}
	
	

}
