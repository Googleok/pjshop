package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.AdminDao;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.ProductVo;
import com.cafe24.pjshop.vo.UserVo;

@Service
public class AdminService {

	
	@Autowired
	private AdminDao adminDao;

	// ?��?��?��체리?��?��
	public List<ProductVo> getProductList() {
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
			false, true, 1L, 400L, "cap.html",
			2500L, 3L));
		return list;
	}

	// ?��?��?��?��
	public ProductVo getProductOne(Long no) {
		ProductVo vo = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		return vo;
	}

	// ?��?��?���?
	public Boolean addProduct(ProductVo vo) {
		return vo != null;
	}

	// ?��?��?��?��
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

	// ?��?��?��?��
	public boolean deleteProduct(Long no) {
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
		int listSize1 = list.size();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.remove(i);
			}
		}
		int listSize2 = list.size();
		System.out.println(list);
		return listSize1 == listSize2+1;
	}

	// ?��?���??��
	public List<ProductVo> getProductSearchList(String keyword) {
		List<ProductVo> searchList = new ArrayList<ProductVo>();
		ProductVo vo1 = new ProductVo(1L, "cap", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "cap", 40000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "바�?", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("list["+i+"].name=" +list.get(i).getName());
			if(list.get(i).getName().trim().equals(keyword)) {
				System.out.println("찾았?��!");
				searchList.add(list.get(i));
			}
		}
		
		System.out.println("searchlist=" + searchList);
		return searchList;
	}

	//========================================================================================================
	
	// 주문�?�?
	
	// 주문리스?�� ?���?
	public List<OrderVo> getOrderList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "박종?��", "1234", "01040287755", "whddjr2225@naver.com",
			"?��?��?�� �??���?", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "박소?��", "1234", "01040287755", "thdnjs9570@naver.com",
				"?��?��?�� 광화문구", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "?��?��??", "1234", "01040287755", "leap1004@naver.com",
				"?��?��?�� ?��복구", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		return list;
	}

	// 주문?���? ?���?
	public OrderVo getOrderOne(Long no) {
		OrderVo vo = new OrderVo(1L, "박종?��", "1234", "01040287755", "whddjr2225@naver.com",
				"?��?��?�� �??���?", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L);
		return vo;
	}
	
	// ?��?��주문 ?���?
	public OrderDetailVo getOrderDetail(Long no) {
		
		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "모자", "�?/L", 20000L, "결제??�?", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "바�?", "�?/L", 20000L, "결제??�?", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "?��?��", "�?/L", 20000L, "결제??�?", 100L, 3L);
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

	// 주문 ?��금확?��체크
	public OrderDetailVo orderDepositCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "모자", "�?/L", 20000L, "결제??�?", 100L, 3L);
		vo.setShippingStatus("결제?���?");
		return vo;
	}
	
	// 주문 배송출발체크
	public OrderDetailVo orderDeliveryCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "모자", "�?/L", 20000L, "결제?���?", 100L, 3L);
		vo.setShippingStatus("배송�?");
		return vo;
	}

	// 주문�??��
	public List<OrderVo> getOrderSearchList(String keyword) {
		
		List<OrderVo> searchList = new ArrayList<OrderVo>();
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "박종?��", "1234", "01040287755", "whddjr2225@naver.com",
			"?��?��?�� �??���?", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "박소?��", "1234", "01012345678", "thdnjs9570@naver.com",
				"?��?��?�� 광화문구", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "?��?��??", "1234", "01040287755", "leap1004@naver.com",
				"?��?��?�� ?��복구", "2019-07-11", "빨리 �? �??��?��?��?��", 2500L, 123000L,1L));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
	
	//========================================================================================================
	
	// 고객�?�?

	public List<UserVo> getUserList() {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?��", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?��", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
	 * ?��?��?���? ?��?��
	 * @param no
	 * @param vo
	 * @return
	 */
	public UserVo modifyUser(Long no, UserVo vo) {
		UserVo resultVo = null;
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "�?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?��", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
	 * ?��?���??��
	 * @param keyword
	 * @return
	 */
	public List<UserVo> getUserSearchList(String keyword) {
		List<UserVo> searchList = new ArrayList<UserVo>();
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "박종?��", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "?��?��??", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "박소?��", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
