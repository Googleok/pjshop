package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.dto.OrderDetailDto;
import com.cafe24.pjshop.dto.ProductDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.vo.ProductDetailVo;
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
	
	public List<ProductVo> getProductList(Long categoryNo) {
		return sqlSession.selectList("product.getListByCategory", categoryNo);
	}

	public ProductVo getProductOne(Long no) {
		return sqlSession.selectOne("product.getOne", no);
	}
	
	public ProductDto getProductDetail(Long no) {
		return sqlSession.selectOne("product.getProductDetail", no);
	}

	public OrderDetailDto getProductDetailByProductOptionNo(Long productOptionNo) {
		return sqlSession.selectOne("product.getProductDetailByProductOptionNo", productOptionNo);
	}
	
	public Boolean productCountUpdate(Long productOptionNo, Long count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productOptionNo", productOptionNo);
		map.put("count", count);
		return sqlSession.update("product.productCountUpdate", map) == 1;
	}
	
}
