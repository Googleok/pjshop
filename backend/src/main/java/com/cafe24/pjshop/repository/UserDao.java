package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	public UserVo get(String email) {
		UserVo userVo = sqlSession.selectOne("user.getByEmail", email);
		return userVo;
	}

	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("user.login", vo);
	}

	public boolean join(UserVo vo) {
		int count = sqlSession.insert("user.join", vo);
		return 1 == count;
	}

	public Boolean modify(Long no, UserVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", vo);
		return sqlSession.update("user.modify", map) == 1;
	}

	public UserVo findId(UserVo vo) {
		return sqlSession.selectOne("user.findId", vo);
	}

	public UserVo existId(String id) {
		return sqlSession.selectOne("user.existId", id);
	}

	public Boolean updatePassword(String newPassword) {
		return sqlSession.update("user.modifyPassword", newPassword) == 1;
	}
	
}
