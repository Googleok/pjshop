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
		list.add(new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com", "서울시 관악구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		list.add(new OrderVo(2L, "박소원", "1234", "01040287755", "thdnjs9570@naver.com", "서울시 광화문구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		list.add(new OrderVo(3L, "이정은", "1234", "01040287755", "leap1004@naver.com", "서울시 성복구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		return list;
	}

	// 주문한개 요청
	public OrderVo getOrderOne(Long no) {
		OrderVo vo = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com", "서울시 관악구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L);
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
		list.add(new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com", "서울시 관악구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		list.add(new OrderVo(2L, "박소원", "1234", "01012345678", "thdnjs9570@naver.com", "서울시 광화문구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		list.add(new OrderVo(3L, "이정은", "1234", "01040287755", "leap1004@naver.com", "서울시 성복구", "2019-07-11",
				"빨리 좀 부탁드려요", 2500L, 123000L, 1L));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
}
