package com.cafe24.pjshop.vo;

import com.cafe24.pjshop.dto.OptionDto;

public class CartVo {

	private Long no;
	private Long count;
	private Long userNo;
	private Long optionNo;
	private boolean isMember;
	private Long notMemberNo;
	private OptionDto optionDto;
	
	public CartVo() {
	}

	public CartVo(Long no, Long count, Long userNo, Long optionNo, boolean isMember, Long notMemberNo, OptionDto optionDto) {
		super();
		this.no = no;
		this.count = count;
		this.userNo = userNo;
		this.optionNo = optionNo;
		this.isMember = isMember;
		this.notMemberNo = notMemberNo;
		this.optionDto = optionDto;
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

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Long getNotMemberNo() {
		return notMemberNo;
	}

	public void setNotMemberNo(Long notMemberNo) {
		this.notMemberNo = notMemberNo;
	}
	
	public OptionDto getOptionDto() {
		return optionDto;
	}

	public void setOptionDto(OptionDto optionDto) {
		this.optionDto = optionDto;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", count=" + count + ", userNo=" + userNo + ", optionNo=" + optionNo + ", isMember="
				+ isMember + ", notMemberNo=" + notMemberNo + ", optionDto=" + optionDto + "]";
	}

}
