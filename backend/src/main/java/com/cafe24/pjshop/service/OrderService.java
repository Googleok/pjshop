package com.cafe24.pjshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.dto.OrderDetailDto;
import com.cafe24.pjshop.dto.OrderProductDto;
import com.cafe24.pjshop.repository.OrderDao;
import com.cafe24.pjshop.repository.ProductDao;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.PaymentVo;
import com.cafe24.pjshop.vo.ProductDetailVo;
import com.cafe24.pjshop.vo.ProductVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;
	
//	public OrderVo getOrderOne(String id) {
//		OrderVo vo = new OrderVo(1L, "������", "1234", "01040287755", "whddjr2225@naver.com", "����� ���Ǳ�",
//				"2019-07-12", "������!", 2500L, 185000L, 1L);
//		return vo;
//	}

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

	public OrderVo orderProduct(OrderVo orderVo) {
		// �ֹ� ���� �ǰ�, ������ ���������·� �����
		
		// �ֹ�ó�� 
		boolean orderResult = orderDao.orderProduct(orderVo);
		// �ֹ���ó��
		boolean orderDetailResult = false;
		boolean subProductCountResult = false;
		boolean orderOptionResult = false;
		if(orderResult) {
			for (OrderProductDto orderProduct : orderVo.getOrderProductList()) {
				OrderDetailDto orderDetailDto = productDao.getProductDetailByProductOptionNo(orderProduct.getProductOptionNo());
				OrderDetailVo orderDetailVo = 
						new OrderDetailVo(
								null,
								orderDetailDto.getName(),
								orderDetailDto.getOptionValue(),
								orderDetailDto.getPrice(),
								"�Ա���",
								orderProduct.getCount(),
								orderVo.getNo());
				
				orderDetailResult = orderDao.detailOrderProduct(orderDetailVo);
				// ��ǰ��� count
				if(orderDetailResult) {
					subProductCountResult = productDao.productCountUpdate(orderProduct.getProductOptionNo());
				}
				
				// �ֹ� : ��ǰ�ɼ� ���̺� �߰�
				orderOptionResult = orderDao.orderAndOptionNo(orderProduct.getProductOptionNo(), orderDetailVo.getNo());
			}
			
			// ��������
			if(subProductCountResult) {
				orderDao.orderPayment(new PaymentVo(null, false, "bank", orderVo.getNo()));
			}
		}
		
		
		return orderVo;
	}

	public PaymentVo payOrder(Long no) {
	
		return new PaymentVo();
	}
	
	
}
