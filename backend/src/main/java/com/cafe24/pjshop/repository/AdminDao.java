package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.vo.CategoryVo;

@Repository
public class AdminDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> getCategoryList() {
		return sqlSession.selectList("category.getList");
	}

	public Boolean addCategory(CategoryVo vo) {
		return sqlSession.insert("category.add", vo) == 1;
	}

	public Boolean modifyCategory(Long no, CategoryVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", vo);
		return sqlSession.update("category.modify", map) == 1 ;
	}

	public boolean deleteCategory(Long no) {
		return sqlSession.delete("category.delete", no) == 1;
	}
	
	
}
