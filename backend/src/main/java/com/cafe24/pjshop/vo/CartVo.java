package com.cafe24.pjshop.vo;

public class CartVo {

	private Long no;
	private Long count;
	private Long userNo;
	private Long optionNo;
	private boolean isMember;
	
	public CartVo() {
		// TODO Auto-generated constructor stub
	}
	
	public CartVo(Long no, Long count, Long userNo, Long optionNo, boolean isMember) {
		this.no = no;
		this.count = count;
		this.userNo = userNo;
		this.optionNo = optionNo;
		this.isMember = isMember;
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Long optionNo) {
		this.optionNo = optionNo;
	}
	public boolean getIsMember() {
		return isMember;
	}
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", userNo=" + userNo + ", optionNo=" + optionNo + ", isMember="
				+ isMember + "]";
	}
	
	
}
