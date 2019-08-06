package com.cafe24.pjshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidatorContext;

import com.cafe24.pjshop.validator.constraints.ValidId;

public class IdValidator implements javax.validation.ConstraintValidator<ValidId, String>{
	private Pattern pattern = Pattern.compile("(^[a-zA-Z]{1}[a-zA-Z0-9_]{3,11}$)");
	
	@Override
	public void initialize(ValidId constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".equals(value) ) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}
}
