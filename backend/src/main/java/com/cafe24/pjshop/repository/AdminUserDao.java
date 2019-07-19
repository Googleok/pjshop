package com.cafe24.pjshop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserDao {

	@Autowired
	private SqlSession sqlSession;

	public Boolean deleteProductInCart(Long no) {
		return sqlSession.delete("user.deleteProductInCart", no) >= 1;
	}
	
	
}