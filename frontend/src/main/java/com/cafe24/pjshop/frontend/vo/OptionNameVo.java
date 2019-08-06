package com.cafe24.pjshop.frontend.vo;

public class OptionNameVo {
	private Long no;
	private String optionName;
	
	public OptionNameVo() {
		// TODO Auto-generated constructor stub
	}

	public OptionNameVo(Long no, String optionName) {
		super();
		this.no = no;
		this.optionName = optionName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	@Override
	public String toString() {
		return "OptionNameVo [no=" + no + ", optionName=" + optionName + "]";
	}
	
	
}
