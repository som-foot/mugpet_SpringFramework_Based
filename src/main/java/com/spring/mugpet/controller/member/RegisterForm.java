package com.spring.mugpet.controller.member;

import java.io.Serializable;

import com.spring.mugpet.domain.MemberInfo;

@SuppressWarnings("serial")
public class RegisterForm implements Serializable {

	
	private MemberInfo account;
	private boolean newAccount;
	private String repeatedPassword;
	
	
	
	public RegisterForm(MemberInfo account) {
		this.account = account;
		this.newAccount = false;
	}
	
	
	
	public RegisterForm() {
		this.account = new MemberInfo();
		this.newAccount = true;
	}


	public MemberInfo getAccount() {
		return account;
	}



	public void setAccount(MemberInfo account) {
		this.account = account;
	}



	public boolean isNewAccount() {
		return newAccount;
	}
	public void setNewAccount(boolean newAccount) {
		this.newAccount = newAccount;
	}
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}



	@Override
	public String toString() {
		return "RegisterForm [account=" + account + ", newAccount=" + newAccount + ", repeatedPassword="
				+ repeatedPassword + "]";
	}
	
	
	
	
	
}
