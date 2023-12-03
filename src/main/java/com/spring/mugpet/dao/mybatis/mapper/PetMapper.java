package com.spring.mugpet.dao.mybatis.mapper;

import com.spring.mugpet.domain.Pet;

public interface PetMapper {

	//pet 가입
	void insertPet(Pet pet);
	
	//member의 pet 객체 가져오기
	Pet getPetByU_id(int u_id);
	
	void updatePet(Pet pet);

}
