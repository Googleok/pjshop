package com.cafe24.pjshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.dto.ProductDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.vo.ProductVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSession sqlSession;

	public List<ProductVo> getSearchProductList(SearchDto searchDto) {
		return sqlSession.selectList("product.getProductSearchList", searchDto);
	}

	public List<ProductVo> getProductList() {
		return sqlSession.selectList("product.getList");
	}

	public ProductVo getProductOne(Long no) {
		return sqlSession.selectOne("product.getOne", no);
	}
	
	public ProductDto getProductDetail(Long no) {
		return sqlSession.selectOne("product.getProductDetail", no);
	}
	
}
