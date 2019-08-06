package com.cafe24.pjshop.frontend.vo;

public class ProductDetailVo {
	private Long no;
	private String name;
	private Long price;
	private String regDate;
	private Boolean exhibitionAvailability;
	private Boolean optionAvailability;
	private Boolean sailsStatus;
	private Long exhibitionRank;
	private Long count;
	private String detail;
	private Long shippingFee;
	private String option;
	private String imageUrl;
	private String imageRole;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Boolean getExhibitionAvailability() {
		return exhibitionAvailability;
	}
	public void setExhibitionAvailability(Boolean exhibitionAvailability) {
		this.exhibitionAvailability = exhibitionAvailability;
	}
	public Boolean getOptionAvailability() {
		return optionAvailability;
	}
	public void setOptionAvailability(Boolean optionAvailability) {
		this.optionAvailability = optionAvailability;
	}
	public Boolean getSailsStatus() {
		return sailsStatus;
	}
	public void setSailsStatus(Boolean sailsStatus) {
		this.sailsStatus = sailsStatus;
	}
	public Long getExhibitionRank() {
		return exhibitionRank;
	}
	public void setExhibitionRank(Long exhibitionRank) {
		this.exhibitionRank = exhibitionRank;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
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
		return "ProductDetailVo [no=" + no + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", exhibitionAvailability=" + exhibitionAvailability + ", optionAvailability=" + optionAvailability
				+ ", sailsStatus=" + sailsStatus + ", exhibitionRank=" + exhibitionRank + ", count=" + count
				+ ", detail=" + detail + ", shippingFee=" + shippingFee + ", option=" + option + ", imageUrl="
				+ imageUrl + ", imageRole=" + imageRole + "]";
	}
	
	
	

}
