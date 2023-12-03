package com.spring.mugpet.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

@Component
public class CommunityFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Community.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		NewCommunityCommand comCommad = (NewCommunityCommand) target;
		
		String title = comCommad.getTitle();
		if(title == null || title.trim().isEmpty()) {
			System.out.println("title 오류: 반드시 한 글자라도 입력해야 합니다.");
			errors.rejectValue("title", "emptyTitle");
		}
		
		String content = comCommad.getContent();
		if(content == null || content.trim().isEmpty()) {
			System.out.println("content 오류: 반드시 한 글자라도 입력해야 합니다.");
			errors.rejectValue("content", "emptyContent");
		}
	}
}
