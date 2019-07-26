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
//		OrderVo vo = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com", "서울시 관악구",
//				"2019-07-12", "빨리요!", 2500L, 185000L, 1L);
//		return vo;
//	}

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

	public OrderVo orderProduct(OrderVo orderVo) {
		// 주문 저장 되고, 결제도 결제대기상태로 저장됨
		
		// 주문처리 
		boolean orderResult = orderDao.orderProduct(orderVo);
		// 주문상세처리
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
								"입금전",
								orderProduct.getCount(),
								orderVo.getNo());
				
				orderDetailResult = orderDao.detailOrderProduct(orderDetailVo);
				// 상품재고 count
				if(orderDetailResult) {
					subProductCountResult = productDao.productCountUpdate(orderProduct.getProductOptionNo());
				}
				
				// 주문 : 상품옵션 테이블에 추가
				orderOptionResult = orderDao.orderAndOptionNo(orderProduct.getProductOptionNo(), orderDetailVo.getNo());
			}
			
			// 결제상태
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
