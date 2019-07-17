package com.cafe24.pjshop.controller.api;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.UserService;
import com.cafe24.pjshop.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "회원가입")
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo vo, BindingResult result) {

		// @valid 유효성 검증
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		boolean returnResult = userService.join(vo);
		System.out.println("returnResult : " + returnResult);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnResult));
	}

	@ApiOperation(value = "이메일 존재 여부")
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(
			@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		Boolean exist = userService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	// 로그인
	@PostMapping(value = "/login")
	public ResponseEntity<JSONResult> login(@RequestBody UserVo vo) {

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * 이게 왜 Set이냐 validator가 두개 달린 필드도 존재하기 때문에 순서없이 담는다.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(vo, "id");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
//				String message = messageSource.getMessage("Email.userVo.email", null, LocaleContextHolder.getLocale());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

		validatorResults = validator.validateProperty(vo, "password");
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JSONResult.fail(validatorResult.getMessage()));
			}
		}
		
		UserVo newVo = userService.login(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}

	// 회원정보 수정
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> modify(@PathVariable("no") Long no,@RequestBody UserVo vo, BindingResult result) {
		
		// @valid 유효성 검증
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		boolean modifyResult = userService.modify(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(modifyResult));
	}

	// 장바구니 리스트 요청
	@GetMapping({"/cart", "/cart/list"})
	public ResponseEntity<JSONResult> getCartList() {
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}

	// 장바구니 담기
	@PostMapping("/cart")
	public ResponseEntity<JSONResult> addToCart(@RequestBody UserVo vo) {
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	// 장바구니 삭제
	@DeleteMapping("/cart/{no}")
	public ResponseEntity<JSONResult> deleteFromCart(@RequestBody UserVo vo) {

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
}
