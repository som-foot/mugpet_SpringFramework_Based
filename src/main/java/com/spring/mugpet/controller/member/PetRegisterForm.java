package com.spring.mugpet.controller.member;

import com.spring.mugpet.domain.Pet;

public class PetRegisterForm {
	
	private Pet pet;
	
	

	public PetRegisterForm() {
		this.pet = new Pet();
	}


	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	
	
	
	
	

}
