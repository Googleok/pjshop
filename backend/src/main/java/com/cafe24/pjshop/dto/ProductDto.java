package com.cafe24.pjshop.dto;

import java.util.List;

import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductImageVo;

public class ProductDto {
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
	private List<OptionDto> optionDtoList;
	private List<OptionVo> optionList;
	private List<ProductImageVo> productImageVoList;
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDto(Long no, String name, Long price, String regDate, Boolean exhibitionAvailability,
			Boolean optionAvailability, Boolean sailsStatus, Long exhibitionRank, Long count, String detail,
			Long shippingFee, Long categoryNo, List<OptionDto> optionDtoList, List<OptionVo> optionList,
			List<ProductImageVo> productImageVoList) {
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
		this.optionDtoList = optionDtoList;
		this.optionList = optionList;
		this.productImageVoList = productImageVoList;
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

	public List<OptionDto> getOptionDtoList() {
		return optionDtoList;
	}

	public void setOptionDtoList(List<OptionDto> optionDtoList) {
		this.optionDtoList = optionDtoList;
	}

	public List<ProductImageVo> getProductImageVoList() {
		return productImageVoList;
	}

	public void setProductImageVoList(List<ProductImageVo> productImageVoList) {
		this.productImageVoList = productImageVoList;
	}

	@Override
	public String toString() {
		return "ProductDto [no=" + no + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", exhibitionAvailability=" + exhibitionAvailability + ", optionAvailability=" + optionAvailability
				+ ", sailsStatus=" + sailsStatus + ", exhibitionRank=" + exhibitionRank + ", count=" + count
				+ ", detail=" + detail + ", shippingFee=" + shippingFee + ", categoryNo=" + categoryNo
				+ ", optionDtoList=" + optionDtoList + ", optionList=" + optionList + ", productImageVoList="
				+ productImageVoList + "]";
	}

	
}
