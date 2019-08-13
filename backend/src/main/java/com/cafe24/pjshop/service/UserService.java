package com.cafe24.pjshop.service;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.CartDto;
import com.cafe24.pjshop.dto.CartListDto;
import com.cafe24.pjshop.repository.UserDao;
import com.cafe24.pjshop.vo.AddressVo;
import com.cafe24.pjshop.vo.CartVo;
import com.cafe24.pjshop.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean join(UserVo vo) {
		return userDao.join(vo);
	}
	
	public Boolean existEmail(String email) {
		UserVo userVo = userDao.get(email);
		return userVo != null;
	}

	public UserVo login(UserVo vo) {
		return userDao.login(vo);
	}

	public Boolean modify(Long no,UserVo vo) {
		return userDao.modify(no, vo);
	}

	public UserVo findId(String name, String phone) {
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setPhone(phone);
		return userDao.findId(vo);
	}

	public String findPassword(String id, String name, String phone) {
		
		UserVo existId = userDao.existId(id);
		StringBuffer newPassword = new StringBuffer();
		boolean result = false;
		
		if(existId != null) {
			Random random = new Random();
			for(int i = 0; i < 15; i++) {
				if(random.nextBoolean()) {
					if(random.nextBoolean()) {
						newPassword.append((char)((int)(random.nextInt(26))+97));
					}else {
						newPassword.append((char)((int)(random.nextInt(26))+65));
					}
				}else {
					newPassword.append((random.nextInt(10)));
				}
			}
			result = userDao.updatePassword(newPassword.toString());
			System.out.println(newPassword);
			System.out.println(newPassword.toString());
		}
		
		return newPassword.toString();
	}

	public Long addToCart(CartVo vo) {
		try {
			userDao.addToCart(vo);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			boolean result = userDao.modifyCart(vo);
			System.out.println(result+"===============");
		}
		return vo.getNo();
	}

	public boolean deleteFromCart(Long no) {
		return userDao.deleteFromCart(no);
	}

	public boolean deleteFromCart(List<Long> deleteNoList) {
		return userDao.deleteFromCart(deleteNoList);
	}

	public boolean modifyCountFromCart(Long no, CartVo vo) {
		return userDao.modifyCountFromCart(no, vo);
	}

	public List<CartDto> getCartList(Long userNo, String nonUserNo) {
		List<CartDto> cartList = null;
		if(userNo != null) {
			cartList = userDao.getCartList(userNo);
		}else {
			cartList = userDao.getCartList(nonUserNo);
		}
		return cartList;
	}

	public Long addAddress(AddressVo vo) {
		boolean result = userDao.addAddress(vo);
		return result ? vo.getNo() : 0L;
	}

	public List<AddressVo> getAddressList(Long userNo) {
		return userDao.getAddressList(userNo);
	}

	public boolean deleteAddress(Long no) {
		return userDao.deleteAddress(no);
	}

	public Boolean addToCartList(CartListDto voList) {

		for (CartVo vo : voList.getCartList()) {
			try {
				userDao.addToCart(vo);
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
				boolean result = userDao.modifyCart(vo);
			}
		}
		return true;
	}

	public AddressVo getAddress(Long userNo) {
		return userDao.getAddress(userNo);
	}




	
	
}
