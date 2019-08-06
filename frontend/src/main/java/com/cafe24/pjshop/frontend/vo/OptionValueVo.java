package com.cafe24.pjshop.frontend.vo;

public class OptionValueVo {

	private Long no;
	private Long optionNameNo;
	private String optionValue;
	private Long productNo;
	
	public OptionValueVo() {
		// TODO Auto-generated constructor stub
	}

	public OptionValueVo(Long no, Long optionNameNo, String optionValue, Long productNo) {
		super();
		this.no = no;
		this.optionNameNo = optionNameNo;
		this.optionValue = optionValue;
		this.productNo = productNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getOptionNameNo() {
		return optionNameNo;
	}

	public void setOptionNameNo(Long optionNameNo) {
		this.optionNameNo = optionNameNo;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "OptionValueVo [no=" + no + ", optionNameNo=" + optionNameNo + ", optionValue=" + optionValue
				+ ", productNo=" + productNo + "]";
	}
	
	
}
