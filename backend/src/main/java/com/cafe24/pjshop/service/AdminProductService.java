package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.AdminProductDao;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.ProductDetailVo;
import com.cafe24.pjshop.vo.ProductImageVo;
import com.cafe24.pjshop.vo.ProductVo;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao adminProductDao;

	// 상품전체리스트
	public List<ProductVo> getProductList() {
		return adminProductDao.getProductList();
	}

	// 상품하나
	public ProductVo getProductOne(Long no) {
		return adminProductDao.getProductOne(no);
	}

	// 상품상세정보
	public List<ProductDetailVo> getProductDetail(Long no) {
		return adminProductDao.getProductDetail(no);
	}

	// 상품등록
	public Boolean addProduct(ProductVo productVo) {
		List<OptionNameVo> newoptionNameList = new ArrayList<OptionNameVo>();

		// 상품 추가하기
		Long insertProductNo = adminProductDao.addProduct(productVo);
		System.out.println("===============================================================");
		System.out.println(insertProductNo);
		System.out.println("===============================================================");

		// 상품이미지 등록
		for (ProductImageVo vo : productVo.getProductImageList()) {
			System.out.println("상품이미지 == " + vo);
			vo.setProductNo(insertProductNo);
			adminProductDao.addProductImage(vo);
		}

		// 옵션체크 있으면
		if (productVo.getOptionAvailability()) {
			List<OptionNameVo> optionNameVos = productVo.getOptionNameList();
			List<OptionVo> optionVos = productVo.getOptionList();

			for (OptionNameVo optionNameVo : optionNameVos) {
				OptionNameVo existOptionName = adminProductDao.existOptionName(optionNameVo.getOptionName());
				if (existOptionName == null) {
					adminProductDao.addOptionName(optionNameVo);
					newoptionNameList.add(optionNameVo);
					continue;
				}
				newoptionNameList.add(existOptionName);
			}

			System.out.println("====================================================");
			System.out.println(newoptionNameList);
			System.out.println("====================================================");

			for (int i = 0; i < newoptionNameList.size(); i++) {
				for (OptionVo optionVo : optionVos) {
					if (optionVo.getOptionName().equals(newoptionNameList.get(i).getOptionName())) {
						optionVo.setProductNo(productVo.getNo());
						optionVo.setOptionNameNo(newoptionNameList.get(i).getNo());
						adminProductDao.addOption(optionVo);
					}
				}
			}

		}

		return true;
	}

	// 상품등록 ajax
	public Long addProductByAjax(ProductVo productVo) {
		return adminProductDao.addProduct(productVo);
	}

	// 상품수정
	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		boolean result = adminProductDao.modifyProduct(no, newVo);
		return result ? newVo : null;
	}

	// 상품삭제
	public boolean deleteProduct(Long no) {
		return adminProductDao.deleteProduct(no);
	}

	// 상품검색
	public List<ProductVo> getProductSearchList(String keyword) {
		List<ProductVo> searchList = new ArrayList<ProductVo>();
		ProductVo vo1 = new ProductVo(1L, "cap", 30000L, "2019-07-11", true, false, true, 1L, 400L, "cap.html", 2500L,
				3L);
		ProductVo vo2 = new ProductVo(2L, "cap", 40000L, "2019-07-12", true, false, true, 1L, 400L, "cap.html", 2500L,
				3L);
		ProductVo vo3 = new ProductVo(3L, "바지", 30000L, "2019-07-13", true, false, true, 1L, 400L, "cap.html", 2500L,
				3L);

		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("list[" + i + "].name=" + list.get(i).getName());
			if (list.get(i).getName().trim().equals(keyword)) {
				System.out.println("찾았다!");
				searchList.add(list.get(i));
			}
		}

		System.out.println("searchlist=" + searchList);
		return searchList;
	}

	public List<OptionNameVo> getOptionNameList() {
		return adminProductDao.getOptionNameList();
	}

	public Long addOptionName(OptionNameVo vo) {
		Long no = adminProductDao.addOptionName(vo);
		return no;
	}

	public boolean deleteOptionName(Long no) {
		return adminProductDao.deleteOptionName(no);
	}

	public Long addOptionValue(OptionVo vo) {
		return adminProductDao.addOption(vo) ? vo.getNo() : 0L;
	}

	public boolean addProductImage(ProductImageVo vo) {
		return adminProductDao.addProductImage(vo);
	}

	public boolean addProductImageList(List<ProductImageVo> list) {
		for (ProductImageVo vo : list) {
			adminProductDao.addProductImage(vo);
		}
		return true;
	}

}
