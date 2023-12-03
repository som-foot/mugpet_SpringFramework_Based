package com.spring.mugpet.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

@Component
public class UsedGoodsFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UsedGoods.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		NewUsedGoodsCommand goodsCommand = (NewUsedGoodsCommand) target;
		
		String title = goodsCommand.getTitle();
		if(title == null || title.trim().isEmpty()) {
			System.out.println("title 오류: 반드시 한 글자라도 입력해야 합니다.");
			errors.rejectValue("title", "emptyTitle");
		}
		
		int price = goodsCommand.getPrice();
		if(price == 0) {
			System.out.println("price 오류: 반드시 1원 이상 입력해야 합니다.");
			errors.rejectValue("price", "emptyPrice");
		}
		
		String content = goodsCommand.getContent();
		if(content == null || content.trim().isEmpty()) {
			System.out.println("content 오류: 반드시 한 글자라도 입력해야 합니다.");
			errors.rejectValue("content", "emptyContent");
		}
	}

}
