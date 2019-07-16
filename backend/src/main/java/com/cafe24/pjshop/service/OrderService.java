package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.repository.OrderDao;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.PaymentVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public OrderVo getOrderOne(String id) {
		OrderVo vo = new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com", "����� ���Ǳ�",
				"2019-07-12", "������!", 2500L, 185000L, 1L);
		return vo;
	}

	public OrderDetailVo getOrderDetail(Long no) {
		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "����", "��/L", 20000L, "�������", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "����", "��/L", 20000L, "�������", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "����", "��/L", 20000L, "�������", 100L, 3L);
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

	public OrderVo orderProduct(OrderVo vo) {
		// �ֹ� ���� �ǰ�, ������ ���������·� �����
		return vo;
	}

	public PaymentVo payOrder(Long no) {
		PaymentVo newVo = null;
		List<PaymentVo> list = new ArrayList<PaymentVo>();
		list.add(new PaymentVo(1L, "�������", "īī������", 1L));
		list.add(new PaymentVo(2L, "�������", "�������Ա�", 2L));
		list.add(new PaymentVo(3L, "�������", "�ſ�ī��", 3L));
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.get(i).setPaymentStatus("�����Ϸ�");
				// �����Ϸ� ���·� �����ϸ� ���� ��ۻ��µ� �����Ų��.
				newVo = list.get(i);
			}
		}
		return newVo;
	}
	
	
}
