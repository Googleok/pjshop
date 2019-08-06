package com.cafe24.pjshop.frontend.vo;

public class ProductImageVo {

	private Long no;
	private Long productNo;
	private String imageUrl;
	private String imageRole;
	
	public ProductImageVo() {
		// TODO Auto-generated constructor stub
	}

	public ProductImageVo(Long no, Long productNo, String imageUrl, String imageRole) {
		super();
		this.no = no;
		this.productNo = productNo;
		this.imageUrl = imageUrl;
		this.imageRole = imageRole;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageRole() {
		return imageRole;
	}

	public void setImageRole(String imageRole) {
		this.imageRole = imageRole;
	}

	@Override
	public String toString() {
		return "ProductImageVo [no=" + no + ", productNo=" + productNo + ", imageUrl=" + imageUrl + ", imageRole="
				+ imageRole + "]";
	}
	
	
	
}
