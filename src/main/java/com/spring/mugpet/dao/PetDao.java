package com.spring.mugpet.dao;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Pet;

public interface PetDao {

	public void insertPet(Pet pet)throws DataAccessException;
	
	public Pet getPetByU_id(int u_id) throws DataAccessException;
	
	public void updatePet(Pet pet) throws DataAccessException;

}
