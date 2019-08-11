package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.CartDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.repository.AdminUserDao;
import com.cafe24.pjshop.vo.UserVo;

@Service
public class AdminUserService {
	@Autowired
	private AdminUserDao adminUserDao;

	// 고객관리

	public List<UserVo> getUserList() {
		return adminUserDao.getUserList();
	}
	
	public UserVo getUser(String id) {
		return adminUserDao.getUser(id);
	}

	/**
	 * 
	 * @param no
	 * @return
	 */
	public boolean deleteUser(Long no) {
		return adminUserDao.deleteUser(no);
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param no
	 * @param vo
	 * @return
	 */
	public UserVo modifyUser(Long no, UserVo vo) {
		boolean result = adminUserDao.modifyUser(no, vo);
		return result ? vo : null;
	}

	/**
	 * 회원검색
	 * 
	 * @param searchDto
	 * @return
	 */
	public List<UserVo> getUserSearchList(SearchDto searchDto) {
		return adminUserDao.getUserSearchList(searchDto);
	}

	public List<CartDto> getCartList() {
		return adminUserDao.getCartList();
	}

	

}
