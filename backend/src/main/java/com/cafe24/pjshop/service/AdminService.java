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

	// ?ƒ?’ˆ? „ì²´ë¦¬?Š¤?Š¸
	public List<ProductVo> getProductList() {
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(new ProductVo(1L, "ëª¨ì", 30000L, "2019-07-11", true,
			false, true, 1L, 400L, "cap.html",
			2500L, 3L));
		return list;
	}

	// ?ƒ?’ˆ?•˜?‚˜
	public ProductVo getProductOne(Long no) {
		ProductVo vo = new ProductVo(1L, "ëª¨ì", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		return vo;
	}

	// ?ƒ?’ˆ?“±ë¡?
	public Boolean addProduct(ProductVo vo) {
		return vo != null;
	}

	// ?ƒ?’ˆ?ˆ˜? •
	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		ProductVo resultVo = null;
		
		ProductVo vo1 = new ProductVo(1L, "ëª¨ì", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "ëª¨ì", 30000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "ëª¨ì", 30000L, "2019-07-13", true,
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

	// ?ƒ?’ˆ?‚­? œ
	public boolean deleteProduct(Long no) {
		ProductVo vo1 = new ProductVo(1L, "ëª¨ì", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "ëª¨ì", 30000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "ëª¨ì", 30000L, "2019-07-13", true,
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

	// ?ƒ?’ˆê²??ƒ‰
	public List<ProductVo> getProductSearchList(String keyword) {
		List<ProductVo> searchList = new ArrayList<ProductVo>();
		ProductVo vo1 = new ProductVo(1L, "cap", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "cap", 40000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "ë°”ì?", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("list["+i+"].name=" +list.get(i).getName());
			if(list.get(i).getName().trim().equals(keyword)) {
				System.out.println("ì°¾ì•˜?‹¤!");
				searchList.add(list.get(i));
			}
		}
		
		System.out.println("searchlist=" + searchList);
		return searchList;
	}

	//========================================================================================================
	
	// ì£¼ë¬¸ê´?ë¦?
	
	// ì£¼ë¬¸ë¦¬ìŠ¤?Š¸ ?š”ì²?
	public List<OrderVo> getOrderList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "ë°•ì¢…?–µ", "1234", "01040287755", "whddjr2225@naver.com",
			"?„œ?š¸?‹œ ê´??•…êµ?", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "ë°•ì†Œ?›", "1234", "01040287755", "thdnjs9570@naver.com",
				"?„œ?š¸?‹œ ê´‘í™”ë¬¸êµ¬", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "?´? •??", "1234", "01040287755", "leap1004@naver.com",
				"?„œ?š¸?‹œ ?„±ë³µêµ¬", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		return list;
	}

	// ì£¼ë¬¸?•œê°? ?š”ì²?
	public OrderVo getOrderOne(Long no) {
		OrderVo vo = new OrderVo(1L, "ë°•ì¢…?–µ", "1234", "01040287755", "whddjr2225@naver.com",
				"?„œ?š¸?‹œ ê´??•…êµ?", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L);
		return vo;
	}
	
	// ?ƒ?„¸ì£¼ë¬¸ ?š”ì²?
	public OrderDetailVo getOrderDetail(Long no) {
		
		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "ëª¨ì", "ë¹?/L", 20000L, "ê²°ì œ??ê¸?", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "ë°”ì?", "ë¹?/L", 20000L, "ê²°ì œ??ê¸?", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "?ƒ?˜", "ë¹?/L", 20000L, "ê²°ì œ??ê¸?", 100L, 3L);
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

	// ì£¼ë¬¸ ?…ê¸ˆí™•?¸ì²´í¬
	public OrderDetailVo orderDepositCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "ëª¨ì", "ë¹?/L", 20000L, "ê²°ì œ??ê¸?", 100L, 3L);
		vo.setShippingStatus("ê²°ì œ?™„ë£?");
		return vo;
	}
	
	// ì£¼ë¬¸ ë°°ì†¡ì¶œë°œì²´í¬
	public OrderDetailVo orderDeliveryCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "ëª¨ì", "ë¹?/L", 20000L, "ê²°ì œ?™„ë£?", 100L, 3L);
		vo.setShippingStatus("ë°°ì†¡ì¤?");
		return vo;
	}

	// ì£¼ë¬¸ê²??ƒ‰
	public List<OrderVo> getOrderSearchList(String keyword) {
		
		List<OrderVo> searchList = new ArrayList<OrderVo>();
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "ë°•ì¢…?–µ", "1234", "01040287755", "whddjr2225@naver.com",
			"?„œ?š¸?‹œ ê´??•…êµ?", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		list.add(new OrderVo(2L, "ë°•ì†Œ?›", "1234", "01012345678", "thdnjs9570@naver.com",
				"?„œ?š¸?‹œ ê´‘í™”ë¬¸êµ¬", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		list.add(new OrderVo(3L, "?´? •??", "1234", "01040287755", "leap1004@naver.com",
				"?„œ?š¸?‹œ ?„±ë³µêµ¬", "2019-07-11", "ë¹¨ë¦¬ ì¢? ë¶??ƒ?“œ? ¤?š”", 2500L, 123000L,1L));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
	
	//========================================================================================================
	
	// ê³ ê°ê´?ë¦?

	public List<UserVo> getUserList() {
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "ë°?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "ì¢?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?–µ", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "ë°?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "ì¢?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?–µ", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
	 * ?šŒ?›? •ë³? ?ˆ˜? •
	 * @param no
	 * @param vo
	 * @return
	 */
	public UserVo modifyUser(Long no, UserVo vo) {
		UserVo resultVo = null;
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "ë°?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "ì¢?", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "?–µ", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
	 * ?šŒ?›ê²??ƒ‰
	 * @param keyword
	 * @return
	 */
	public List<UserVo> getUserSearchList(String keyword) {
		List<UserVo> searchList = new ArrayList<UserVo>();
		UserVo vo1 = new UserVo(1L, "whddjr2225", "1234", "ë°•ì¢…?–µ", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo2 = new UserVo(2L, "whddjr2225", "1234", "?´? •??", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
		UserVo vo3 = new UserVo(3L, "whddjr2225", "1234", "ë°•ì†Œ?›", "01040287755", "whddjr2225@naver.com", "1993-11-02", "male");
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
