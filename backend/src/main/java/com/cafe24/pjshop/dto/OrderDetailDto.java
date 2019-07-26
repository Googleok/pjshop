package com.cafe24.pjshop.dto;

public class OrderDetailDto {

	private String name;
	private String optionValue;
	private Long price;

	public OrderDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [name=" + name + ", optionValue=" + optionValue + ", price=" + price + "]";
	}
	
	
}
