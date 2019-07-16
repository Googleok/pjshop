package com.cafe24.pjshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.UserDao;
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






	
	
}
