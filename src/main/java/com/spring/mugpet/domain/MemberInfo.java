package com.spring.mugpet.domain;

public class MemberInfo {
	private int u_id;			//primary key(userId)
	private String nickname;	//닉네임
	private String name;		//이름
	private String email;		//이메일(로그인할 아이디)
	private String pwd;			//비밀번호
	private String phoneNum;	//전화번호
	private String address;		//주소
	private String imageUrl;	//이미지 경로
	private int point;			//적립포인트

	
	public MemberInfo() {}

	public MemberInfo(int u_id, String nickname, String name, String email, String pwd, String phoneNum, String address,
			String imageUrl, int point) {
		this.u_id = u_id;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phoneNum = phoneNum;
		this.address = address;
		this.imageUrl = imageUrl;
		this.point = point;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}