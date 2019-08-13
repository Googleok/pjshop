package com.cafe24.pjshop.frontend.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.pjshop.frontend.dto.OrderProductDto;
import com.cafe24.pjshop.frontend.dto.OrderProductListDto;
import com.cafe24.pjshop.frontend.service.UserService;
import com.cafe24.pjshop.frontend.vo.UserVo;

@Controller
@RequestMapping( "/user"  )
public class UserController {
	
	@Autowired  //spring DI를 사용한 것이다
	private UserService userService;

	@GetMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";//이건 view forward
	} 
	
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		// @valid 유효성 검증
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
		 * 이게 왜 Set이냐 validator가 두개 달린 필드도 존재하기 때문에 순서없이 담는다.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(vo, "id");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("잘못된 아이디");
				return "/user/login";
			}
		}

		validatorResults = validator.validateProperty(vo, "password");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				System.out.println("잘못된 패스워드");
				return "/user/login";
			}
		}
		
		UserVo authUser = userService.login(vo);
		if(authUser == null) {
			return "/user/login";
		}
		model.addAttribute("authUser", authUser);
		return "redirect: /main";
	}
	
	
	@GetMapping("/cart")
	public String cartGet(Model model) {
		userService.getCartList(model);
		return "/user/cart";
	}
	
	@RequestMapping({"/cart/delete/{no}"})
	public String deleteFromCart(@PathVariable(value = "no")Long no) {
		Boolean result = userService.deleteFromCart(no);
		return "redirect: /user/cart";
	}
	
	@DeleteMapping("/cart")
	public String deleteFromCartList(@RequestParam(value = "deleteList")List<Long> list ) {
		System.out.println(list);
//		Boolean result = userService.deleteFromCartList(list);
		return "redirect: /user/cart";
	}
	
	@GetMapping("/order")
	public String orderPage() {
		return "/user/order";
	}
	
	@GetMapping("/update")
	public String mypage() {
		return "/user/update";
	}
	
	@GetMapping("/address")
	public String getAddress() {
		return "/user/address";
	}
	
	@PostMapping({"/checkout"})
	public String checkoutPage(Model model, OrderProductListDto orderProductList) {
		userService.getUser(model);
		userService.getAddress(model);
		model.addAttribute("orderProductList", orderProductList.getOrderProductList());
		return "/user/checkout";
	}
	
}
