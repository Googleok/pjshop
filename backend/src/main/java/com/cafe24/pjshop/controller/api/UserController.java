package com.cafe24.pjshop.controller.api;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.pjshop.dto.JSONResult;
import com.cafe24.pjshop.service.UserService;
import com.cafe24.pjshop.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	// ȸ������
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo vo, BindingResult result) {

		// @valid ��ȿ�� ����
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		UserVo newVo = userService.join(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}

//	@ApiOperation(value="�̸��� ���� ����")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="email", value="�̸��� �ּ�", required = true) 
//	})
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(
			@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		Boolean exist = userService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	// �α���
	@PostMapping(value = "/login")
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * �̰� �� Set�̳� validator�� �ΰ� �޸� �ʵ嵵 �����ϱ� ������ �������� ��´�.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "email");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				
				 String message = messageSource.getMessage("Email.userVo.email", null, LocaleContextHolder.getLocale());
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

		validatorResults = validator.validateProperty(userVo, "password");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

//		List<String> checkFields = new ArrayList<String>();
//		checkFields.add("email");
//		checkFields.add("password");
//		ResponseEntity<JSONResult> result = nonValid(validator, userVo, checkFields, messageSource);
//		return result == null ? ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo)) : result;

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo));
	}

	public static ResponseEntity<JSONResult> nonValid(Validator validator, UserVo userVo, List<String> checkFields,
			MessageSource messageSource) {
		for (String checkField : checkFields) {
			Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, checkField);

			if (validatorResults.isEmpty() == false) {
				for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
					// String message = messageSource.getMessage("Email.userVo.email", null,
					// LocaleContextHolder.getLocale());

					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(JSONResult.fail(validatorResult.getMessage()));
				}
			}

		}
		return null;
	}
	// ȸ������ ����

	// �α׾ƿ�

	// ��ٱ��� ����Ʈ ��û

	// ��ٱ��� ��� - ajax

	// ��ٱ��� ���� - ajax

}
