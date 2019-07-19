package com.cafe24.pjshop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminOrderDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean deleteProductInOrder(Long no) {
		return sqlSession.delete("order.deleteProductInOrder", no) >= 1;
	}
}
