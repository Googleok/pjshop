package com.cafe24.pjshop.frontend.vo;

public class AddressVo {

	private Long no;
	private String zipCode;
	private String address;
	private String entrancePassword;
	private String message;
	private Long userNo;
	private String recipientName;
	private String recipientPhone;
	
	public AddressVo() {
	}

	public AddressVo(Long no, String zipCode, String address, String entrancePassword, String message, Long userNo,
			String recipientName, String recipientPhone) {
		super();
		this.no = no;
		this.zipCode = zipCode;
		this.address = address;
		this.entrancePassword = entrancePassword;
		this.message = message;
		this.userNo = userNo;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntrancePassword() {
		return entrancePassword;
	}

	public void setEntrancePassword(String entrancePassword) {
		this.entrancePassword = entrancePassword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Override
	public String toString() {
		return "AddressVo [no=" + no + ", zipCode=" + zipCode + ", address=" + address + ", entrancePassword="
				+ entrancePassword + ", message=" + message + ", userNo=" + userNo + ", recipientName=" + recipientName
				+ ", recipientPhone=" + recipientPhone + "]";
	}
	
	
}
