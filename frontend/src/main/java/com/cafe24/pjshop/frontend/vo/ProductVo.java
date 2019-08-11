package com.cafe24.pjshop.frontend.vo;

import java.util.List;

public class ProductVo {
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
	private Long categoryNo;
	private String mainImageUrl;
	private List<OptionValueVo> optionValueList;
	private List<OptionVo> optionList;  // optionName optionValue count
	private List<ProductImageVo> productImageList;
	private List<String> optionFullList;
	private List<String> optionNameNoList;
	private List<String> optionNameValueList;

	
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductVo(Long no, String name, Long price, String regDate, Boolean exhibitionAvailability,
			Boolean optionAvailability, Boolean sailsStatus, Long exhibitionRank, Long count, String detail,
			Long shippingFee, Long categoryNo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.exhibitionAvailability = exhibitionAvailability;
		this.optionAvailability = optionAvailability;
		this.sailsStatus = sailsStatus;
		this.exhibitionRank = exhibitionRank;
		this.count = count;
		this.detail = detail;
		this.shippingFee = shippingFee;
		this.categoryNo = categoryNo;
	}

	
	
	public ProductVo(Long no, String name, Long price, String regDate, Boolean exhibitionAvailability,
			Boolean optionAvailability, Boolean sailsStatus, Long exhibitionRank, Long count, String detail,
			Long shippingFee, Long categoryNo, List<OptionValueVo> optionValueList, List<OptionVo> optionList,
			List<ProductImageVo> productImageList, List<String> optionFullList, List<String> optionNameNoList,
			List<String> optionNameValueList) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.exhibitionAvailability = exhibitionAvailability;
		this.optionAvailability = optionAvailability;
		this.sailsStatus = sailsStatus;
		this.exhibitionRank = exhibitionRank;
		this.count = count;
		this.detail = detail;
		this.shippingFee = shippingFee;
		this.categoryNo = categoryNo;
		this.optionValueList = optionValueList;
		this.optionList = optionList;
		this.productImageList = productImageList;
		this.optionFullList = optionFullList;
		this.optionNameNoList = optionNameNoList;
		this.optionNameValueList = optionNameValueList;
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

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public List<OptionVo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<OptionVo> optionList) {
		this.optionList = optionList;
	}



	public List<OptionValueVo> getOptionValueList() {
		return optionValueList;
	}

	public void setOptionValueList(List<OptionValueVo> optionValueList) {
		this.optionValueList = optionValueList;
	}

	public List<ProductImageVo> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImageVo> productImageList) {
		this.productImageList = productImageList;
	}
	
	public List<String> getOptionFullList() {
		return optionFullList;
	}

	public void setOptionFullList(List<String> optionFullList) {
		this.optionFullList = optionFullList;
	}

	public List<String> getOptionNameNoList() {
		return optionNameNoList;
	}

	public void setOptionNameNoList(List<String> optionNameNoList) {
		this.optionNameNoList = optionNameNoList;
	}

	public List<String> getOptionNameValueList() {
		return optionNameValueList;
	}

	public void setOptionNameValueList(List<String> optionNameValueList) {
		this.optionNameValueList = optionNameValueList;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", exhibitionAvailability=" + exhibitionAvailability + ", optionAvailability=" + optionAvailability
				+ ", sailsStatus=" + sailsStatus + ", exhibitionRank=" + exhibitionRank + ", count=" + count
				+ ", detail=" + detail + ", shippingFee=" + shippingFee + ", categoryNo=" + categoryNo
				+ ", mainImageUrl=" + mainImageUrl + ", optionValueList=" + optionValueList + ", optionList="
				+ optionList + ", productImageList=" + productImageList + ", optionFullList=" + optionFullList
				+ ", optionNameNoList=" + optionNameNoList + ", optionNameValueList=" + optionNameValueList + "]";
	}

	
		
	
	
}
