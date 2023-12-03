package com.spring.mugpet.domain;

public class Pet {
	private int pet_id;			//primary key
	private String name;		//반려동물 이름
	private int spe_id;			//반려동물 종(강아지 or 고양이 or 소동물)
	private String birth;		//반려동물 생일
	private int u_id;			//반려인 u_id
	
	
	public Pet() {};	

	public Pet(int pet_id, String name, int spe_id, String birth, int u_id) {
		this.pet_id = pet_id;
		this.name = name;
		this.spe_id = spe_id;
		this.birth = birth;
		this.u_id = u_id;
	}
	
	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpe_id() {
		return spe_id;
	}

	public void setSpe_id(int spe_id) {
		this.spe_id = spe_id;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getU_id() {
		return u_id;
	}
	
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}