package com.cafe24.pjshop.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.UserDao;
import com.cafe24.pjshop.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean join(UserVo vo) {
		System.out.println("¼­ºñ½º");
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






	
	
}
