package com.spring.mugpet.service;


import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.member.ModifyMemberInfoForm;
import com.spring.mugpet.domain.MemberInfo;

public interface MemberService {

	
	public MemberInfo login(String email,String pwd);
	public void creatAccount(MemberInfo account,MultipartFile file) throws Exception;
	public void creatAccountWithoutImgFile(MemberInfo account) throws Exception;
	public void updateAccount(ModifyMemberInfoForm modifyForm);
	public MemberInfo checkAccount(String email, String pwd);
	public String isCheckDuplicatedEmail(String email);
	public String isCheckDuplicatedNickname(String nickname);
	public String isCheckDuplicatedPhoneNum(String phoneNum);
	public void updatePoints(int point, String email, String pwd);
	//Community, UsedGoods에서 사용
	public String getNickNameByU_Id(int u_id);
}

