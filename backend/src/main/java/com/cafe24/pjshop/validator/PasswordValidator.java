package com.cafe24.pjshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.pjshop.validator.constraints.ValidPassword;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{

	private Pattern pattern = Pattern.compile("(^(?=.*[a-z])(?=.*\\d)[a-z\\d]{8,16}$)");	
	@Override
	public void initialize(ValidPassword constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".equals(value) ) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}

}
