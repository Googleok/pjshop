package com.cafe24.pjshop.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.pjshop.dto.CartDto;
import com.cafe24.pjshop.vo.AddressVo;
import com.cafe24.pjshop.vo.CartVo;
import com.cafe24.pjshop.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	public UserVo get(String email) {
		UserVo userVo = sqlSession.selectOne("user.getByEmail", email);
		return userVo;
	}

	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("user.login", vo);
	}

	public boolean join(UserVo vo) {
		int count = sqlSession.insert("user.join", vo);
		return 1 == count;
	}

	public Boolean modify(Long no, UserVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", vo);
		return sqlSession.update("user.modifyUser", map) == 1;
	}

	public UserVo findId(UserVo vo) {
		return sqlSession.selectOne("user.findId", vo);
	}

	public UserVo existId(String id) {
		return sqlSession.selectOne("user.existId", id);
	}

	public Boolean updatePassword(String newPassword) {
		return sqlSession.update("user.modifyPassword", newPassword) == 1;
	}

	public Boolean addToCart(CartVo vo) {
		return sqlSession.insert("user.addToCart", vo) == 1;
	}

	public boolean deleteFromCart(Long no) {
		return sqlSession.delete("user.deleteFromCart", no) == 1;
	}
	
	public boolean deleteFromCart(List<Long> deleteNoList) {
		return sqlSession.delete("user.deleteListFromCart", deleteNoList) == deleteNoList.size();
	}

	public boolean modifyCart(CartVo vo) {
		return sqlSession.update("user.modifyCart", vo) == 1;
	}

	public boolean modifyCountFromCart(Long no, CartVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("vo", vo);
		return sqlSession.update("user.modifyCount", map) == 1;
	}

	public List<CartDto> getCartList(Long userNo) {
		return sqlSession.selectList("user.getCartListByUser", userNo);
	}

	public List<CartDto> getCartList(String nonUserNo) {
		return sqlSession.selectList("user.getCartListByNonUser", nonUserNo);
	}

	public boolean addAddress(AddressVo vo) {
		return sqlSession.insert("address.addAddress", vo) == 1;
	}

	public List<AddressVo> getAddressList(Long userNo) {
		return sqlSession.selectList("address.getAddressList", userNo);
	}

	public boolean deleteAddress(Long no) {
		return sqlSession.delete("address.deleteAddress", no) == 1;
	}

	public AddressVo getAddress(Long userNo) {
		return sqlSession.selectOne("address.getAddress", userNo);
	}
	
}
