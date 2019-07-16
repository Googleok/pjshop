package com.cafe24.pjshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.pjshop.validator.constraints.ValidName;
import com.cafe24.pjshop.validator.constraints.ValidPassword;

public class NameValidator implements ConstraintValidator<ValidName, String>{

	private Pattern pattern = Pattern.compile("(^[��-�R]{2,4}|^[a-zA-Z]*$)");	
	@Override
	public void initialize(ValidName constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".equals(value) ) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}

}
