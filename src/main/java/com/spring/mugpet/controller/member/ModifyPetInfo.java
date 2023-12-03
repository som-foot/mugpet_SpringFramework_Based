package com.spring.mugpet.controller.member;

import java.io.Serializable;

import com.spring.mugpet.domain.Pet;

@SuppressWarnings("serial")
public class ModifyPetInfo implements Serializable {
	
	
	private Pet pet;
	private String speices;

	public ModifyPetInfo(Pet pet, String speices) {
		this.pet = pet;
		this.setSpeices(speices);
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getSpeices() {
		return speices;
	}

	public void setSpeices(String speices) {
		this.speices = speices;
	}

	

}
