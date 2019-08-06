package com.cafe24.pjshop.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.pjshop.frontend.dto.JSONResult;
import com.cafe24.pjshop.frontend.repository.UserDao;
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
	
	// DTO Class
	private static class JSONResultJoin extends JSONResult<Boolean> {}
	private static class JSONResultLogin extends JSONResult<UserVo> {}
	private static class JSONResultGetUser extends JSONResult<UserVo> {}
}
