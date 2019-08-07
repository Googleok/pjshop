package com.cafe24.pjshop.frontend.controller.admin;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.pjshop.frontend.service.UserService;
import com.cafe24.pjshop.frontend.vo.UserVo;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {
	
	
	@Autowired  //spring DI를 사용한 것이다
	private UserService userService;
	
	@PostMapping( "/login" )
	public String login(@ModelAttribute UserVo vo, Model model) {
		System.out.println("======================================="+vo);
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * 이게 왜 Set이냐 validator가 두개 달린 필드도 존재하기 때문에 순서없이 담는다.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(vo, "id");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("잘못된 아이디");
				return "/admin/login";
			}
		}

		validatorResults = validator.validateProperty(vo, "password");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("잘못된 패스워드");
				return "/admin/login";
			}
		}
		
		UserVo authUser = userService.login(vo);
		if(authUser == null) {
			return "/admins/login";
		}
		model.addAttribute("authUser", authUser);
		return "redirect: /admin";
	}
}
