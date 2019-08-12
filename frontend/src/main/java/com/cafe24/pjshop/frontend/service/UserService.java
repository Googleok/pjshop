package com.cafe24.pjshop.frontend.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.pjshop.frontend.dto.CartDto;
import com.cafe24.pjshop.frontend.dto.CartListDto;
import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.repository.UserDao;
import com.cafe24.pjshop.frontend.security.SecurityUser;
import com.cafe24.pjshop.frontend.vo.CartVo;
import com.cafe24.pjshop.frontend.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private OAuth2RestTemplate restTemplate;

	public Boolean join(UserVo vo) {
		JSONResultJoin jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/user/join", vo, JSONResultJoin.class);
		return jsonResult.getData();
	}

	public UserVo login(UserVo vo) {
		JSONResultLogin jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/user/login", vo, JSONResultLogin.class);
		return jsonResult.getData();
	}

	public UserVo get(String id) {
		JSONResultGetUser jsonResult = restTemplate.getForObject("http://localhost:9999/v1/api/admin/user?id="+id, JSONResultGetUser.class);
		return jsonResult.getData();
	}

	public Long addToCart(CartVo vo) {
		JSONResult<Long> jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/user/cart", vo, JSONResultAddToCart.class);
		return jsonResult.getData();
	}

	public void getCartList(Model model) {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		JSONResult<List<CartDto>> jsonResult = restTemplate.getForObject("http://localhost:9999/v1/api/user/cart?id="+user.getNo(), JSONResultGetCartList.class);
		model.addAttribute("cartList", jsonResult.getData());
	}

	public void getCartListAll(Model model) {
		JSONResult<List<CartDto>> jsonResult = restTemplate.getForObject("http://localhost:9999/v1/api/admin/user/cart", JSONResultGetCartList.class);
		model.addAttribute("cartList", jsonResult.getData());
	}
	
	public Boolean addToCartList(CartListDto voList) {
		JSONResult<Boolean> jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/user/cart/add", voList, JSONResultAddToCartList.class);
		return jsonResult.getData();
	}

	// DTO Class
	private static class JSONResultJoin extends JSONResult<Boolean> {}
	private static class JSONResultLogin extends JSONResult<UserVo> {}
	private static class JSONResultGetUser extends JSONResult<UserVo> {}
	private static class JSONResultAddToCart extends JSONResult<Long> {}
	private static class JSONResultGetCartList extends JSONResult<List<CartDto>> {}
	private static class JSONResultAddToCartList extends JSONResult<Boolean> {}
	
	
}
