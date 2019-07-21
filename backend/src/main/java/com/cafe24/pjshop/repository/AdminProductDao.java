package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductDetailVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;

@Repository
public class AdminProductDao {

	@Autowired
	private SqlSession sqlSession;

	public List<ProductVo> getProductList() {
		return sqlSession.selectList("product.getList");
	}
	
	public ProductVo getProductOne(Long no) {
		return sqlSession.selectOne("product.getOne", no);
	}

	public List<ProductDetailVo> getProductDetail(Long no) {
		return sqlSession.selectList("product.getProductDetail", no);
	}
	
	public Long addProduct(ProductVo vo) {
		sqlSession.insert("product.add", vo);
		return vo.getNo();
	}
	
	public boolean deleteProduct(Long no) {
		return sqlSession.delete("product.delete", no) >= 1;
	}

	public Long addOptionName(OptionNameVo optionNameVo) {
		sqlSession.insert("optionName.add", optionNameVo);
		return optionNameVo.getNo();
	}

	public Boolean addOptionNames(List<OptionNameVo> optionNameVos) {
		return sqlSession.insert("optionName.addList", optionNameVos) == optionNameVos.size();
	}

	public boolean deleteOptionName(Long no) {
		return sqlSession.delete("optionName.deleteName", no) == 1;
	}
	
	public Boolean addOption(OptionVo optionVo) {
		return sqlSession.insert("option.add", optionVo) == 1;
	}

	public Boolean addOptions(List<OptionVo> optionVos) {
		return sqlSession.insert("option.addList", optionVos) == optionVos.size();
	}

	public boolean getOptionNameCount(String optionName) {
		return sqlSession.selectOne("optionName.getCount", optionName);
	}

	public List<OptionNameVo> getOptionNameList() {
		return sqlSession.selectList("optionName.getList");
	}

	public OptionNameVo existOptionName(String optionName) {
		return sqlSession.selectOne("optionName.existOptionName", optionName);
	}

	public boolean deleteProductOption(Long no) {
		return sqlSession.delete("option.deleteProductOption", no) >= 1;
	}

	public boolean deleteProductImage(Long no) {
		return sqlSession.delete("image.deleteProductImage", no) >= 1;
	}

	public boolean addProductImage(ProductImageVo vo) {
		return sqlSession.insert("image.addProductImage", vo) == 1;
	}

	public boolean modifyProduct(Long no, ProductVo newVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", newVo);
		return sqlSession.update("product.modifyProduct", map) == 1;
	}
}
