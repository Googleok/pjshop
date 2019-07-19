package com.cafe24.pjshop.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.AdminDao;
import com.cafe24.pjshop.repository.AdminOrderDao;
import com.cafe24.pjshop.repository.AdminProductDao;
import com.cafe24.pjshop.repository.AdminUserDao;
import com.cafe24.pjshop.repository.OrderDao;
import com.cafe24.pjshop.repository.ProductDao;
import com.cafe24.pjshop.repository.UserDao;
import com.cafe24.pjshop.vo.CategoryVo;
import com.cafe24.pjshop.vo.OptionNameVo;
import com.cafe24.pjshop.vo.OptionVo;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.ProductVo;
import com.cafe24.pjshop.vo.UserVo;

@Service
public class AdminService {

	
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminProductDao adminProductDao;
	
	@Autowired
	private AdminUserDao adminUserDao;
	
	@Autowired
	private AdminOrderDao adminOrderDao;
	
	
	// 카테고리 리스트
	public List<CategoryVo> getCagegoryList() {
		return adminDao.getCategoryList();
	}
	
	// 카테고리 등록
	public Boolean addCategory(CategoryVo vo) {
		vo.getCatgoryList();
		return adminDao.addCategory(vo);
	}

	// 카테고리 수정
	public Boolean modifyCategory(Long no, CategoryVo vo) {
		return adminDao.modifyCategory(no, vo);
	}
	
	// 카테고리 삭제
	public boolean deleteCategory(Long no) {
		return adminDao.deleteCategory(no);
	}
	
	// =============================================================================================================================
	
	// 상품전체리스트
	public List<ProductVo> getProductList() {
		return adminProductDao.getProductList();
	}

	// 상품하나
	public ProductVo getProductOne(Long no) {
		return adminProductDao.getProductOne(no);
	}

	// 상품등록
	public Boolean addProduct(ProductVo productVo) {
		List<OptionNameVo> newoptionNameList = new ArrayList<OptionNameVo>();
		
		// 상품 추가하기
		Long insertProductNo = adminProductDao.addProduct(productVo);
		System.out.println("===============================================================");
		System.out.println(insertProductNo);
		System.out.println("===============================================================");
		
		// 옵션체크 있으면
		if(productVo.getOptionAvailability()) {
			List<OptionNameVo> optionNameVos = productVo.getOptionNameList();
			List<OptionVo> optionVos = productVo.getOptionList();
			
			for(OptionNameVo optionNameVo : optionNameVos) {
				OptionNameVo existOptionName = adminProductDao.existOptionName(optionNameVo.getOptionName());
				if(existOptionName == null) {
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
					if(optionVo.getOptionName().equals(newoptionNameList.get(i).getOptionName())) {
						optionVo.setProductNo(productVo.getNo());
						optionVo.setOptionNameNo(newoptionNameList.get(i).getNo());
						adminProductDao.addOption(optionVo);
					}
				}
			}
	
		}
		
		return true;
	}

	// 상품수정
	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		ProductVo resultVo = null;
		
		ProductVo vo1 = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "모자", 30000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "모자", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.get(i).setName(newVo.getName());
				list.get(i).setPrice(newVo.getPrice());
				resultVo = list.get(i);
			}
		}
		
		return resultVo;
	}

	// 상품삭제
	public boolean deleteProduct(Long no) {
		// 장바구니 상품삭제
		boolean deleteProductInCartResult = adminUserDao.deleteProductInCart(no);
		// 주문옵션 상품삭제
		boolean deleteProductInOrderResult = adminOrderDao.deleteProductInOrder(no);
		// 상품옵션 상품삭제
		boolean deleteProductOptionResult = adminProductDao.deleteProductOption(no);
		// 대표이미지 상품삭제
		boolean deleteProductImageResult = adminProductDao.deleteProductImage(no);
		// 상품삭제
		boolean deleteProductResult = adminProductDao.deleteProduct(no);

		System.out.println(deleteProductInCartResult);
		System.out.println(deleteProductInOrderResult);
		System.out.println(deleteProductOptionResult);
		System.out.println(deleteProductImageResult);
		System.out.println(deleteProductResult);
		return true;
	}

	// 상품검색
	public List<ProductVo> getProductSearchList(String keyword) {
		List<ProductVo> searchList = new ArrayList<ProductVo>();
		ProductVo vo1 = new ProductVo(1L, "cap", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "cap", 40000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "바지", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("list["+i+"].name=" +list.get(i).getName());
			if(list.get(i).getName().trim().equals(keyword)) {
				System.out.println("찾았다!");
				searchList.add(list.get(i));
			}
		}
		
		System.out.println("searchlist=" + searchList);
		return searchList;
	}

	//========================================================================================================
	
	// 주문관리
	
	// 주문리스트 요청
	public List<OrderVo> getOrderList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com",
			"서울시 관악구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "박소원", "1234", "01040287755", "thdnjs9570@naver.com",
				"서울시 광화문구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "이정은", "1234", "01040287755", "leap1004@naver.com",
				"서울시 성복구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		return list;
	}

	// 주문한개 요청
	public OrderVo getOrderOne(Long no) {
		OrderVo vo = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com",
				"서울시 관악구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L);
		return vo;
	}
	
	// 상세주문 요청
	public OrderDetailVo getOrderDetail(Long no) {
		
		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "모자", "빨/L", 20000L, "결제대기", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "바지", "빨/L", 20000L, "결제대기", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "상의", "빨/L", 20000L, "결제대기", 100L, 3L);
		List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				newVo = list.get(i);
			}
		}
		return newVo;
	}

	// 주문 입금확인체크
	public OrderDetailVo orderDepositCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "모자", "빨/L", 20000L, "결제대기", 100L, 3L);
		vo.setShippingStatus("결제완료");
		return vo;
	}
	
	// 주문 배송출발체크
	public OrderDetailVo orderDeliveryCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "모자", "빨/L", 20000L, "결제완료", 100L, 3L);
		vo.setShippingStatus("배송중");
		return vo;
	}

	// 주문검색
	public List<OrderVo> getOrderSearchList(String keyword) {
		
		List<OrderVo> searchList = new ArrayList<OrderVo>();
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com",
			"서울시 관악구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "박소원", "1234", "01012345678", "thdnjs9570@naver.com",
				"서울시 광화문구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "이정은", "1234", "01040287755", "leap1004@naver.com",
				"서울시 성복구", "2019-07-11", "빨리 좀 부탁드려요", 2500L, 123000L,1L));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
	
	//========================================================================================================
	
	// 고객관리

	public List<UserVo> getUserList() {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "종", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "억", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		return list;
	}

	/**
	 * 
	 * @param no
	 * @return
	 */
	public boolean deleteUser(Long no) {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "종", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "억", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		int listSize1 = list.size();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.remove(i);
			}
		}
		int listSize2 = list.size();
		return listSize1 == listSize2+1;
	}

	/**
	 * 회원정보 수정
	 * @param no
	 * @param vo
	 * @return
	 */
	public UserVo modifyUser(Long no, UserVo vo) {
		UserVo resultVo = null;
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "종", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "억", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.get(i).setPhone(vo.getPhone());
				list.get(i).setGender(vo.getGender());
				resultVo = list.get(i);
			}
		}
		return resultVo;
	}

	/**
	 * 회원검색
	 * @param keyword
	 * @return
	 */
	public List<UserVo> getUserSearchList(String keyword) {
		List<UserVo> searchList = new ArrayList<UserVo>();
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박종억", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "이정은", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "박소원", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male", "User");
		List<UserVo> list = new ArrayList<UserVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
	
}
