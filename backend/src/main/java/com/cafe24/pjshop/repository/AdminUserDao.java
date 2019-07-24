package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.vo.UserVo;

@Repository
public class AdminUserDao {

	@Autowired
	private SqlSession sqlSession;

	public Boolean deleteProductInCart(Long no) {
		return sqlSession.delete("user.deleteProductInCart", no) >= 1;
	}

	public List<UserVo> getUserList() {
		return sqlSession.selectList("user.getUserList");
	}

	public boolean deleteUser(Long no) {
		return sqlSession.delete("user.deleteUser", no) == 1;
	}

	public boolean modifyUser(Long no, UserVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", vo);
		return sqlSession.update("user.modifyUser", map) == 1;
	}

	public List<UserVo> getUserSearchList(SearchDto searchDto) {
		return sqlSession.selectList("user.getUserSearchList", searchDto);
	}
	
	
}
