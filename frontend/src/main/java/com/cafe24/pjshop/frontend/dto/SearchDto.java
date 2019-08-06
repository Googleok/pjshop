package com.cafe24.pjshop.frontend.dto;

public class SearchDto {

	private String menu;
	private String keyword;
	
	public SearchDto() {
	}

	public SearchDto(String menu, String keyword) {
		super();
		this.menu = menu;
		this.keyword = keyword;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchDto [menu=" + menu + ", keyword=" + keyword + "]";
	}
	
}
