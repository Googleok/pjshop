package com.cafe24.pjshop.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cafe24.pjshop.frontend.dto.CartDto;
import com.cafe24.pjshop.frontend.dto.CartListDto;
import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.repository.UserDao;
import com.cafe24.pjshop.frontend.security.SecurityUser;
import com.cafe24.pjshop.frontend.vo.AddressVo;
import com.cafe24.pjshop.frontend.vo.CartVo;
import com.cafe24.pjshop.frontend.vo.OrderVo;
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

	public Boolean deleteFromCart(Long no) {
		ResponseEntity<JSONResultDeleteFromCart> jsonResultDeleteProduct = restTemplate.exchange("http://localhost:9999/v1/api/user/cart/"+no, HttpMethod.DELETE, null,JSONResultDeleteFromCart.class);
		return jsonResultDeleteProduct.getBody().getData();
	}
	
	public Boolean deleteFromCartList(List<Long> list) {
		HttpEntity<List<Long>> requestEntity = new HttpEntity<List<Long>>(list, null);
		ResponseEntity<JSONResultDeleteFromCart> jsonResultDeleteProduct = restTemplate.exchange("http://localhost:9999/v1/api/user/cart", HttpMethod.DELETE, requestEntity,JSONResultDeleteFromCart.class);
		return jsonResultDeleteProduct.getBody().getData();
	}

	public void getUserList(Model model) {
		JSONResult<List<UserVo>> jsonResult = restTemplate.getForObject("http://localhost:9999/v1/api/admin/user/list", JSONResultGetUserList.class);
		model.addAttribute("userList", jsonResult.getData());
	}

	public Boolean deleteUser(Long no) {
		ResponseEntity<JSONResultDeleteUser> jsonResultDeleteProduct = restTemplate.exchange("http://localhost:9999/v1/api/user/cart/"+no, HttpMethod.DELETE, null,JSONResultDeleteUser.class);
		return jsonResultDeleteProduct.getBody().getData();

	}

	public Long addAddress(AddressVo vo) {
		JSONResult<Long> jsonResult = restTemplate.postForObject("http://localhost:9999/v1/api/user/address", vo, JSONResultAddAddress.class);
		return jsonResult.getData();
	}

	public List<AddressVo> getAddressList(Long userNo) {
		JSONResult<List<AddressVo>> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/user/address?userno="+userNo, JSONResultGetAddressList.class);
		return jsonResult.getData();
	}

	public boolean deleteAddress(Long no) {
		ResponseEntity<JSONResultDeleteAddress> jsonResultDeleteProduct = restTemplate.exchange("http://localhost:9999/v1/api/user/address/"+no, HttpMethod.DELETE, null,JSONResultDeleteAddress.class);
		return jsonResultDeleteProduct.getBody().getData();
	}

	public void getUser(Model model) {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		JSONResult<List<UserVo>> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/admin/user/search?menu=no&keyword="+user.getNo(), JSONResultGetUserList.class);
		model.addAttribute("userInfo", jsonResult.getData().get(0));
	}

	public void getAddress(Model model) {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		JSONResult<AddressVo> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/user/address/"+user.getNo(), JSONResultGetAddress.class);
		model.addAttribute("mainAddress", jsonResult.getData());
	}

	public void getOrderList(Model model) {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		JSONResult<List<OrderVo>> jsonResult =restTemplate.getForObject("http://localhost:9999/v1/api/order/"+user.getNo(), JSONResultGetOrderList.class);
		model.addAttribute("orderList", jsonResult.getData());
	}

	// DTO Class
	private static class JSONResultJoin extends JSONResult<Boolean> {}
	private static class JSONResultLogin extends JSONResult<UserVo> {}
	private static class JSONResultGetUser extends JSONResult<UserVo> {}
	private static class JSONResultDeleteUser extends JSONResult<Boolean> {}
	private static class JSONResultAddToCart extends JSONResult<Long> {}
	private static class JSONResultGetCartList extends JSONResult<List<CartDto>> {}
	private static class JSONResultGetUserList extends JSONResult<List<UserVo>> {}
	private static class JSONResultAddToCartList extends JSONResult<Boolean> {}
	private static class JSONResultDeleteFromCart extends JSONResult<Boolean> {}
	private static class JSONResultAddAddress extends JSONResult<Long> {}
	private static class JSONResultGetAddressList extends JSONResult<List<AddressVo>> {}
	private static class JSONResultGetAddress extends JSONResult<AddressVo> {}
	private static class JSONResultDeleteAddress extends JSONResult<Boolean> {}
	private static class JSONResultGetOrderList extends JSONResult<List<OrderVo>> {}
	
}
