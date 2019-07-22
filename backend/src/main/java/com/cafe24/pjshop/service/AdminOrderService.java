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

	// �ֹ�����Ʈ ��û
	public List<OrderVo> getOrderList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com", "����� ���Ǳ�", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		list.add(new OrderVo(2L, "�ڼҿ�", "1234", "01040287755", "thdnjs9570@naver.com", "����� ��ȭ����", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		list.add(new OrderVo(3L, "������", "1234", "01040287755", "leap1004@naver.com", "����� ������", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		return list;
	}

	// �ֹ��Ѱ� ��û
	public OrderVo getOrderOne(Long no) {
		OrderVo vo = new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com", "����� ���Ǳ�", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L);
		return vo;
	}

	// ���ֹ� ��û
	public OrderDetailVo getOrderDetail(Long no) {

		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "����", "��/L", 20000L, "�������", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "����", "��/L", 20000L, "�������", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "����", "��/L", 20000L, "�������", 100L, 3L);
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

	// �ֹ� �Ա�Ȯ��üũ
	public OrderDetailVo orderDepositCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "����", "��/L", 20000L, "�������", 100L, 3L);
		vo.setShippingStatus("�����Ϸ�");
		return vo;
	}

	// �ֹ� ������üũ
	public OrderDetailVo orderDeliveryCheck(Long no) {
		OrderDetailVo vo = new OrderDetailVo(1L, "����", "��/L", 20000L, "�����Ϸ�", 100L, 3L);
		vo.setShippingStatus("�����");
		return vo;
	}

	// �ֹ��˻�
	public List<OrderVo> getOrderSearchList(String keyword) {

		List<OrderVo> searchList = new ArrayList<OrderVo>();
		List<OrderVo> list = new ArrayList<OrderVo>();
		list.add(new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com", "����� ���Ǳ�", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		list.add(new OrderVo(2L, "�ڼҿ�", "1234", "01012345678", "thdnjs9570@naver.com", "����� ��ȭ����", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		list.add(new OrderVo(3L, "������", "1234", "01040287755", "leap1004@naver.com", "����� ������", "2019-07-11",
				"���� �� ��Ź�����", 2500L, 123000L, 1L));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPhone().equals(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
}
