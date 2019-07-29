package com.cafe24.pjshop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.dto.SearchDto;
import com.cafe24.pjshop.vo.OrderDetailVo;
import com.cafe24.pjshop.vo.OrderVo;

@Repository
public class AdminOrderDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean deleteProductInOrder(Long no) {
		return sqlSession.delete("order.deleteProductInOrder", no) >= 1;
	}

	public List<OrderVo> getOrderList() {
		return sqlSession.selectList("order.getOrderList");
	}

	public OrderVo getOrderOne(Long no) {
		return sqlSession.selectOne("order.getOrderOneByNo", no);
	}

	public OrderDetailVo getOrderDetail(Long no) {
		return sqlSession.selectOne("order.getOrderDetail", no);
	}

	public List<OrderDetailVo> getOrderDetailList(Long no) {
		return sqlSession.selectList("order.getOrderDetailList", no);
	}

	public Boolean orderDepositCheck(Long no) {
		return sqlSession.update("order.orderDepositCheck", no) >= 1;
	}

	public Boolean orderDeliveryDepartureCheck(Long no) {
		return sqlSession.update("order.orderDeliveryDepartureCheck", no) >= 1;
	}

	public Boolean orderDeliveryCompleteCheck(Long no) {
		return sqlSession.update("order.orderDeliveryCompleteCheck", no) >= 1;
	}

	public List<OrderVo> getOrderSearchList(SearchDto searchDto) {
		return sqlSession.selectList("order.getOrderSearchList", searchDto);
	}
}
