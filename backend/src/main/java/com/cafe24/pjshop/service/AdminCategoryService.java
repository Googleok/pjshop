package com.cafe24.pjshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.AdminCategoryDao;
import com.cafe24.pjshop.vo.CategoryVo;

@Service
public class AdminCategoryService {
	
	@Autowired
	private AdminCategoryDao adminCategoryDao;
	
	// 카테고리 리스트
	public List<CategoryVo> getCagegoryList() {
		return adminCategoryDao.getCategoryList();
	}

	// 카테고리 등록
	public Boolean addCategory(CategoryVo vo) {
		vo.getCatgoryList();
		return adminCategoryDao.addCategory(vo);
	}

	// 카테고리 수정
	public Boolean modifyCategory(Long no, CategoryVo vo) {
		return adminCategoryDao.modifyCategory(no, vo);
	}

	// 카테고리 삭제
	public boolean deleteCategory(Long no) {
		return adminCategoryDao.deleteCategory(no);
	}

	public List<CategoryVo> getChildCagegoryList() {
		return adminCategoryDao.getChildCategoryList();
	}
}
