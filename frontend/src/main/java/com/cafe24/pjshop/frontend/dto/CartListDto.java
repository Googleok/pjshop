package com.cafe24.pjshop.frontend.dto;

import java.util.List;

import com.cafe24.pjshop.frontend.vo.CartVo;

public class CartListDto {
	
	private Long userNo;
	private List<CartVo> cartList;

	public CartListDto() {
		// TODO Auto-generated constructor stub
	}

	public CartListDto(Long userNo, List<CartVo> cartList) {
		super();
		this.userNo = userNo;
		this.cartList = cartList;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public List<CartVo> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartVo> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "CartListDto [userNo=" + userNo + ", cartList=" + cartList + "]";
	}
	
	
	
}
