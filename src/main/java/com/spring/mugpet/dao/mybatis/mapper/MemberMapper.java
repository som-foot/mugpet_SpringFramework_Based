package com.spring.mugpet.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberMapper {
	
	//회원가입
	void insertAccount(MemberInfo account);
	
	//로그인시 사용
	MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);

	//적립금 수정
	void updatePoints(@Param("point")int point, @Param("email")String email, @Param("pwd") String pwd);

	//member의 닉네임가져오기 - Community, UsedGoods에서 사용
	String getNickNameByU_Id(int u_id);
	String isCheckDuplicatedEmail(String email);
	String isCheckDuplicatedPhoneNum(String phoneNum);
	String isCheckDuplicatedNickname(String nickname);
	void updateAccount(MemberInfo account);

}
