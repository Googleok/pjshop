package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;
import com.cafe24.pjshop.vo.PaymentVo;

@Repository
public class OrderDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean orderProduct(OrderVo orderVo) {
		return sqlSession.insert("order.orderProduct", orderVo) == 1;
	}

	public boolean detailOrderProduct(OrderDetailVo orderDetailVo) {
		return sqlSession.insert("order.detailOrderProduct", orderDetailVo) == 1;
	}

	public void orderPayment(PaymentVo paymentVo) {
		sqlSession.insert("order.orderPayment", paymentVo);
	}

	public boolean orderAndOptionNo(Long productOptionNo, Long orderDetailNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productOptionNo", productOptionNo);
		map.put("orderDetailNo", orderDetailNo);
		return sqlSession.insert("order.orderAndOptionNo", map) == 1;
	}

	public OrderVo getOrderOneByNo(Long no) {
		return sqlSession.selectOne("order.getOrderOneByNo", no);
	}

	public List<OrderVo> getOrderOneByUserNo(Long userNo) {
		return sqlSession.selectList("order.getOrderByUserNo", userNo);
	}

	public OrderDetailVo getOrderDetail(Long no) {
		return sqlSession.selectOne("order.getOrderDetail", no);
	}

	public Boolean payOrder(Long no) {
		return sqlSession.update("order.payOrder", no) == 1;
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return sqlSession.selectList("order.getOrderDetailList", no);
	}

	public boolean orderDepositCheck(Long no) {
		return sqlSession.update("order.orderDepositCheck", no) >= 1;
	}
}
