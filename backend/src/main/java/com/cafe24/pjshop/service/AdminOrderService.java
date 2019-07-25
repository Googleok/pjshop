package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.AdminOrderDao;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;

@Service
public class AdminOrderService {
	@Autowired
	private AdminOrderDao adminOrderDao;

	// 주문리스트 요청
	public List<OrderVo> getOrderList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		return list;
	}

	// 주문한개 요청
//	public OrderVo getOrderOne(Long no) {
//		return vo;
//	}

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
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == no) {
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
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
}
