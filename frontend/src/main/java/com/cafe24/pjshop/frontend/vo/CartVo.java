package com.cafe24.pjshop.frontend.vo;

public class CartVo {

	private Long no;
	private Long userNo;
	private Long productOptionNo;
	private String nonUserId;
	private Long count;
	
	public CartVo() {
	}

	public CartVo(Long no, Long userNo, Long productOptionNo, String nonUserId, Long count) {
		this.no = no;
		this.userNo = userNo;
		this.productOptionNo = productOptionNo;
		this.nonUserId = nonUserId;
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

	public Long getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(Long productOptionNo) {
		this.productOptionNo = productOptionNo;
	}

	public String getNonUserId() {
		return nonUserId;
	}

	public void setNonUserId(String nonUserId) {
		this.nonUserId = nonUserId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", userNo=" + userNo + ", productOptionNo=" + productOptionNo + ", nonUserId="
				+ nonUserId + ", count=" + count + "]";
	}
	
	

}
