package com.spring.mugpet.service;

import com.spring.mugpet.controller.member.ModifyPetInfo;
import com.spring.mugpet.domain.Pet;

public interface PetService {

	public void addPet(Pet pet);
	
	public Pet getPetByU_id (int u_id);
	
	public String getSpeName(int spe_id);
	
	public void updatePet(ModifyPetInfo pet);

}


