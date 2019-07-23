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

	// ��������

	public List<UserVo> getUserList() {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		return list;
	}

	/**
	 * 
	 * @param no
	 * @return
	 */
	public boolean deleteUser(Long no) {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		int listSize1 = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == no) {
				list.remove(i);
			}
		}
		int listSize2 = list.size();
		return listSize1 == listSize2 + 1;
	}

	/**
	 * ȸ������ ����
	 * 
	 * @param no
	 * @param vo
	 * @return
	 */
	public UserVo modifyUser(Long no, UserVo vo) {
		UserVo resultVo = null;
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "��", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == no) {
				list.get(i).setPhone(vo.getPhone());
				list.get(i).setGender(vo.getGender());
				resultVo = list.get(i);
			}
		}
		return resultVo;
	}

	/**
	 * ȸ���˻�
	 * 
	 * @param keyword
	 * @return
	 */
	public List<UserVo> getUserSearchList(String keyword) {
		List<UserVo> searchList = new ArrayList<UserVo>();
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "������", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "������", "01040287755", "whddjr2225@naver.com", "1993-11-02",
				"male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "�ڼҿ�", "01040287755", "whddjr2225@naver.com", "1993-11-02",
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