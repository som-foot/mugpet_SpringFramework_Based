package com.spring.mugpet.controller.member;

import com.spring.mugpet.domain.MemberInfo;


public class UserSession{

	private MemberInfo memberInfo;

	public UserSession(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

}
