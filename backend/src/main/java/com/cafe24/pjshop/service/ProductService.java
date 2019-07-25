package com.cafe24.pjshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.ProductDto;
import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.repository.ProductDao;
import com.cafe24.pjshop.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<ProductVo> getSearchProductList(SearchDto searchDto) {
		return productDao.getSearchProductList(searchDto);
	}

	public List<ProductVo> getProductList() {
		return productDao.getProductList();
	}

	public ProductVo getProductOne(Long no) {
		return productDao.getProductOne(no);
	}
	
	// 상품상세정보
	public ProductDto getProductDetail(Long no) {
		return productDao.getProductDetail(no);
	}

}
