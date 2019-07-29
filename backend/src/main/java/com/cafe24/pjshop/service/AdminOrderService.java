package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.repository.AdminOrderDao;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;

@Service
public class AdminOrderService {
	@Autowired
	private AdminOrderDao adminOrderDao;

	// 주문리스트 요청
	public List<OrderVo> getOrderList() {
		return adminOrderDao.getOrderList();
	}
	
	// 주문한개 요청
	public OrderVo getOrderOne(Long no) {
		return adminOrderDao.getOrderOne(no);
	}

	// 상세주문 요청
	public OrderDetailVo getOrderDetail(Long no) {
		return adminOrderDao.getOrderDetail(no);
	}

	// 주문 입금확인체크
	public Boolean orderDepositCheck(Long no) {
		return adminOrderDao.orderDepositCheck(no);
	}

	// 주문 배송출발체크
	public Boolean orderDeliveryDepartureCheck(Long no) {
		return adminOrderDao.orderDeliveryDepartureCheck(no);
	}
	
	// 주문 배송완료체크
	public Boolean orderDeliveryCompleteCheck(Long no) {
		return adminOrderDao.orderDeliveryCompleteCheck(no);
	}

	// 주문검색
	public List<OrderVo> getOrderSearchList(String menu, String keyword) {
		return adminOrderDao.getOrderSearchList(new SearchDto(menu, keyword));
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return adminOrderDao.getOrderDetailList(no);
	}



}
