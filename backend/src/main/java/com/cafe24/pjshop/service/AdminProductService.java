package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.OptionDto;
import com.cafe24.pjshop.dto.ProductDetailDto;
import com.cafe24.pjshop.dto.SearchDto;
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

	// ��ǰ��ü����Ʈ
	public List<ProductVo> getProductList() {
		return adminProductDao.getProductList();
	}

	// ��ǰ�ϳ�
	public ProductVo getProductOne(Long no) {
		return adminProductDao.getProductOne(no);
	}

	// ��ǰ������
	public ProductDetailDto getProductDetail(Long no) {

		ProductVo productVo = adminProductDao.getProductOne(no);
		List<OptionDto> optionList = adminProductDao.getProductOption(no);
		List<ProductImageVo> productImageList = adminProductDao.getProductImageList(no);
		
		ProductDetailDto productDetailDto = new ProductDetailDto(productVo, optionList, productImageList);
		
		return productDetailDto;
	}

	// ��ǰ���
	public Boolean addProduct(ProductVo productVo) {
		List<OptionNameVo> newoptionNameList = new ArrayList<OptionNameVo>();

		// ��ǰ �߰��ϱ�
		Long insertProductNo = adminProductDao.addProduct(productVo);
		System.out.println("===============================================================");
		System.out.println(insertProductNo);
		System.out.println("===============================================================");

		// ��ǰ�̹��� ���
		for (ProductImageVo vo : productVo.getProductImageList()) {
			System.out.println("��ǰ�̹��� == " + vo);
			vo.setProductNo(insertProductNo);
			adminProductDao.addProductImage(vo);
		}

		// �ɼ�üũ ������
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

	// ��ǰ��� ajax
	public Long addProductByAjax(ProductVo productVo) {
		return adminProductDao.addProduct(productVo);
	}

	// ��ǰ����
	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		boolean result = adminProductDao.modifyProduct(no, newVo);
		return result ? newVo : null;
	}

	// ��ǰ����
	public boolean deleteProduct(Long no) {
		return adminProductDao.deleteProduct(no);
	}

	// ��ǰ�˻�
	public List<ProductVo> getProductSearchList(SearchDto searchDto) {
		return adminProductDao.getProductSearchList(searchDto);
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
	
	public boolean deleteOptionValue(Long no) {
		return adminProductDao.deleteOption(no);
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

	public List<ProductImageVo> getProductImageList(Long productNo) {
		return adminProductDao.getProductImageList(productNo);
	}

	public boolean deleteProductImage(Long imageNo) {
		return adminProductDao.deleteProductImage(imageNo);
	}

	public boolean deleteProductImageList(Long productNo) {
		return adminProductDao.deleteProductImageList(productNo);
	}



}
