package com.cafe24.pjshop.frontend.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.UserService;
import com.cafe24.pjshop.frontend.vo.UserVo;

@Controller
@RequestMapping( "/user"  )
public class UserController {
	
	@Autowired  //spring DI�� ����� ���̴�
	private UserService userService;

	@GetMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";//�̰� view forward
	} 
	
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		vo.setRole("user");
		// @valid ��ȿ�� ����
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		return userService.join(vo)? "redirect:/user/joinsuccess" : "redirect:/user/join";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	} 
	
	@GetMapping( "/login" )
	public String login() {
		return "user/login";
	}
	
	@PostMapping( "/login" )
	public String login(@ModelAttribute UserVo vo, Model model) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * �̰� �� Set�̳� validator�� �ΰ� �޸� �ʵ嵵 �����ϱ� ������ �������� ��´�.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(vo, "id");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("�߸��� ���̵�");
				return "/user/login";
			}
		}

		validatorResults = validator.validateProperty(vo, "password");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("�߸��� �н�����");
				return "/user/login";
			}
		}
		
		UserVo authUser = userService.login(vo);
		
		if(authUser == null) {
			return "/user/login";
		}
		model.addAttribute("authUser", authUser);
		return "main/index";
	}
}
