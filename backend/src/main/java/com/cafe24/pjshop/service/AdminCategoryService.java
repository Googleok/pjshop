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
	
	// ī�װ� ����Ʈ
	public List<CategoryVo> getCagegoryList() {
		return adminCategoryDao.getCategoryList();
	}

	// ī�װ� ���
	public Boolean addCategory(CategoryVo vo) {
		vo.getCatgoryList();
		return adminCategoryDao.addCategory(vo);
	}

	// ī�װ� ����
	public Boolean modifyCategory(Long no, CategoryVo vo) {
		return adminCategoryDao.modifyCategory(no, vo);
	}

	// ī�װ� ����
	public boolean deleteCategory(Long no) {
		return adminCategoryDao.deleteCategory(no);
	}

	public List<CategoryVo> getChildCagegoryList() {
		return adminCategoryDao.getChildCategoryList();
	}
}
