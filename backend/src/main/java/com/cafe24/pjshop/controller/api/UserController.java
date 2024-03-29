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

import com.cafe24.pjshop.dto.CartDto;
import com.cafe24.pjshop.dto.CartListDto;
import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.UserService;
import com.cafe24.pjshop.vo.AddressVo;
import com.cafe24.pjshop.vo.CartVo;
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
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(returnResult));
	}

	@ApiOperation(value = "이메일 존재 여부")
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(
			@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		Boolean exist = userService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	@ApiOperation(value = "로그인")
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

	@ApiOperation(value = "회원정보수정")
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

	@ApiOperation(value = "아이디 찾기")
	@GetMapping("/find/id")
	public ResponseEntity<JSONResult> findId(@RequestParam(value = "name") String name,
											@RequestParam(value = "phone") String phone ) {
	
		UserVo findResultVo = userService.findId(name, phone);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(findResultVo));
	}
	
	@ApiOperation(value = "비밀번호 찾기")
	@GetMapping("/find/password")
	public ResponseEntity<JSONResult> findPassword(@RequestParam(value = "id") String id,
												   @RequestParam(value = "name") String name,
												   @RequestParam(value = "phone") String phone ) {
	
		String newPassword = userService.findPassword(id, name, phone);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newPassword));
	}
	
	@ApiOperation(value = "장바구니 리스트")
	@GetMapping({"/cart", "/cart/list"})
	public ResponseEntity<JSONResult> getCartList(@RequestParam(value = "id", defaultValue = "") Long no, @RequestParam(value = "nonUserId", defaultValue = "") String nonUserId) {
		List<CartDto> cartList = userService.getCartList(no, nonUserId);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cartList));
	}

	@ApiOperation(value = "장바구니 담기")
	@PostMapping("/cart")
	public ResponseEntity<JSONResult> addToCart(@RequestBody CartVo vo) {
		Long insertNo = userService.addToCart(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}

	@ApiOperation(value = "장바구니 여러개 담기")
	@PostMapping("/cart/add")
	public ResponseEntity<JSONResult> addToCart2(@RequestBody CartListDto voList) {
		System.out.println(voList);
		Boolean result = userService.addToCartList(voList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "장바구니 여러개 삭제")
	@DeleteMapping("/cart")
	public ResponseEntity<JSONResult> deleteFromCart(@RequestBody List<Long> deleteNoList) {
		boolean result = userService.deleteFromCart(deleteNoList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "장바구니 하나씩 삭제")
	@DeleteMapping("/cart/{no}")
	public ResponseEntity<JSONResult> deleteFromCart(@PathVariable(value = "no") Long no) {
		boolean result = userService.deleteFromCart(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "장바구니 수량 수정")
	@PutMapping("/cart/{no}")
	public ResponseEntity<JSONResult> modifyCountFromCart(@PathVariable(value = "no") Long no, @RequestBody CartVo vo) {
		boolean result = userService.modifyCountFromCart(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "주소 추가")
	@PostMapping("/address")
	public ResponseEntity<JSONResult> addAddress(@RequestBody AddressVo vo) {
		Long insertNo = userService.addAddress(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(insertNo));
	}
	
	@ApiOperation(value = "주소 리스트")
	@GetMapping("/address")
	public ResponseEntity<JSONResult> getAddressList(@RequestParam(value = "userno") Long userNo) {
		List<AddressVo> addressList = userService.getAddressList(userNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(addressList));
	}
	
	@ApiOperation(value = "주소 삭제")
	@DeleteMapping("/address/{no}")
	public ResponseEntity<JSONResult> DeleteAddress(@PathVariable(value = "no") Long no) {
		boolean result = userService.deleteAddress(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	@ApiOperation(value = "주소 리스트")
	@GetMapping("/address/{no}")
	public ResponseEntity<JSONResult> getAddress( @PathVariable(value = "no") Long userNo) {
		AddressVo address = userService.getAddress(userNo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(address));
	}
}
