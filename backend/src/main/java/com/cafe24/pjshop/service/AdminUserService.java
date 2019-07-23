package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	 * @param keyword
	 * @return
	 */
	public List<UserVo> getUserSearchList(String keyword) {
		List<UserVo> searchList = new ArrayList<UserVo>();
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박종억", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "이정은", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "박소원", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}

}
