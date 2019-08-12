package com.cafe24.pjshop.frontend.controller.admin;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.UserService;
import com.cafe24.pjshop.frontend.vo.UserVo;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {
	
	
	@Autowired  //spring DI�� ����� ���̴�
	private UserService userService;
	
	@PostMapping( "/login" )
	public String login(@ModelAttribute UserVo vo, Model model) {
		System.out.println("======================================="+vo);
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * �̰� �� Set�̳� validator�� �ΰ� �޸� �ʵ嵵 �����ϱ� ������ �������� ��´�.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(vo, "id");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("�߸��� ���̵�");
				return "/admin/login";
			}
		}

		validatorResults = validator.validateProperty(vo, "password");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("�߸��� �н�����");
				return "/admin/login";
			}
		}
		
		UserVo authUser = userService.login(vo);
		if(authUser == null) {
			return "/admin/login";
		}
		model.addAttribute("authUser", authUser);
		return "redirect: /admin";
	}
	
	@GetMapping("/cart")
	public String getCartList(Model model) {
		userService.getCartListAll(model);
		return "/admin/manage/user/user-cart";
	}
	
	@GetMapping({"", "/list"})
	public String getUserList(Model model) {
		userService.getUserList(model);
		return "/admin/manage/user/user-list";
	}
	
	@RequestMapping("/delete/{no}")
	public String deleteUser(@PathVariable(value = "no")Long no) {
		Boolean result = userService.deleteUser(no);
		return "redirect: /admin/user/list";
	}
	
}
