package com.spring.mugpet.dao;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberDao {

	public void insertAccount(MemberInfo account) throws DataAccessException;
	public MemberInfo getMemberInfoByEmailandPwd(String email,String pwd) throws DataAccessException;
	public void updatePoints(int point,String email, String pwd) throws DataAccessException;
	public String getNickNameByU_Id(int u_id) throws DataAccessException;
	public String isCheckDuplicatedEmail(String email);
	public String isCheckDuplicatedNickname(String nickname);
	public String isCheckDuplicatedPhoneNum(String phoneNum);
	public void updateAccount(MemberInfo account);
	


}

