package com.cafe24.pjshop.vo;

import java.util.List;

public class OrderVo {

	private Long no;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String shipping_message;
	private String entrance_password;
	private String regDate;
	private Long shippingFee;
	private Long totalPrice;
	private Long userNo;
	private Long productOptionNo;
	private List<String> productOptionNoList;
	private Long productCount;
	
	public OrderVo() {
	}

	public OrderVo(Long no, String name, String password, String phone, String email, String address,
			String shipping_message, String entrance_password, String regDate, Long shippingFee, Long totalPrice,
			Long userNo) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.shipping_message = shipping_message;
		this.entrance_password = entrance_password;
		this.regDate = regDate;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.userNo = userNo;
	}

	public OrderVo(Long no, String name, String password, String phone, String email, String address,
			String shipping_message, String entrance_password, String regDate, Long shippingFee, Long totalPrice,
			Long userNo, Long productOptionNo, List<String> productOptionNoList, Long productCount) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.shipping_message = shipping_message;
		this.entrance_password = entrance_password;
		this.regDate = regDate;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.userNo = userNo;
		this.productOptionNo = productOptionNo;
		this.productOptionNoList = productOptionNoList;
		this.productCount = productCount;
	}



	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShipping_message() {
		return shipping_message;
	}

	public void setShipping_message(String shipping_message) {
		this.shipping_message = shipping_message;
	}

	public String getEntrance_password() {
		return entrance_password;
	}

	public void setEntrance_password(String entrance_password) {
		this.entrance_password = entrance_password;
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

	public List<String> getProductOptionNoList() {
		return productOptionNoList;
	}

	public void setProductOptionNoList(List<String> productOptionNoList) {
		this.productOptionNoList = productOptionNoList;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", shipping_message=" + shipping_message + ", entrance_password="
				+ entrance_password + ", regDate=" + regDate + ", shippingFee=" + shippingFee + ", totalPrice="
				+ totalPrice + ", userNo=" + userNo + ", productOptionNo=" + productOptionNo + ", productOptionNoList="
				+ productOptionNoList + ", productCount=" + productCount + "]";
	}


	
}
