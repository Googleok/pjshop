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

	// �ֹ�����Ʈ ��û
	public List<OrderVo> getOrderList() {
		return adminOrderDao.getOrderList();
	}
	
	// �ֹ��Ѱ� ��û
	public OrderVo getOrderOne(Long no) {
		return adminOrderDao.getOrderOne(no);
	}

	// ���ֹ� ��û
	public OrderDetailVo getOrderDetail(Long no) {
		return adminOrderDao.getOrderDetail(no);
	}

	// �ֹ� �Ա�Ȯ��üũ
	public Boolean orderDepositCheck(Long no) {
		return adminOrderDao.orderDepositCheck(no);
	}

	// �ֹ� ������üũ
	public Boolean orderDeliveryDepartureCheck(Long no) {
		return adminOrderDao.orderDeliveryDepartureCheck(no);
	}
	
	// �ֹ� ��ۿϷ�üũ
	public Boolean orderDeliveryCompleteCheck(Long no) {
		return adminOrderDao.orderDeliveryCompleteCheck(no);
	}

	// �ֹ��˻�
	public List<OrderVo> getOrderSearchList(String menu, String keyword) {
		return adminOrderDao.getOrderSearchList(new SearchDto(menu, keyword));
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return adminOrderDao.getOrderDetailList(no);
	}



}
