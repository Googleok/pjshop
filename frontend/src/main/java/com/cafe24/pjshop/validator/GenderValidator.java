package com.cafe24.pjshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidatorContext;

import com.cafe24.pjshop.validator.constraints.ValidGender;

public class GenderValidator implements javax.validation.ConstraintValidator<ValidGender, String>{

	private Pattern pattern = Pattern.compile("male|female");
	
	@Override
	public void initialize(ValidGender constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".equals(value) ) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}

}
