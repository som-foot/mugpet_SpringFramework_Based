package com.spring.mugpet.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.mugpet.controller.member.RegisterForm;
import com.spring.mugpet.domain.MemberInfo;



@Component
public class RegisterFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	
	@Override
	public void validate(Object obj, Errors errors) {
		RegisterForm registerForm = (RegisterForm)obj;
		MemberInfo account = registerForm.getAccount();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.name", "FIRST_NAME_REQUIRED", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.nickname", "LAST_NAME_REQUIRED", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phoneNum", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address", "ADDRESS_REQUIRED", "Address (1) is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aggrement", "AGGRIMENT_REQUIRED", "aggriment is required.");
		
		if (registerForm.isNewAccount()) { //새로운 계정이면
			if (account.getPwd() == null || account.getPwd().length() < 1 ||
					!account.getPwd().equals(registerForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (account.getPwd() != null && account.getPwd().length() > 0) { // 새로운 계정이 아니고 패스워드를 정확히 입력 했을 
			if (!account.getPwd().equals(registerForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
		
	}

	
		
	
}
