package com.spring.mugpet.controller.member;

import java.io.Serializable;

import com.spring.mugpet.domain.MemberInfo;

@SuppressWarnings("serial")
public class ModifyMemberInfoForm implements Serializable {

	
	private MemberInfo account;
	private String repeatedPassword;
	
	
	
	public ModifyMemberInfoForm(MemberInfo account) {
		this.account = account;
	}
	
	
	
	public ModifyMemberInfoForm() {
		this.account = new MemberInfo();
	}


	public MemberInfo getAccount() {
		return account;
	}



	public void setAccount(MemberInfo account) {
		this.account = account;
	}




	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}



	@Override
	public String toString() {
		return "RegisterForm [account=" + account + ", repeatedPassword="
				+ repeatedPassword + "]";
	}
	
	
	
	
	
}
