package com.spring.mugpet.controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.PetService;

@Controller
@RequestMapping("/pet")
public class PetController {


@Autowired
private PetService petService;
@Transactional
public void setPetService(PetService petService) {
	this.petService = petService;
}

@ModelAttribute("modifyPetInfo")
public ModifyPetInfo modifyPetInfoForm(HttpSession session) {
	MemberInfo userSession = (MemberInfo)session.getAttribute("userSession");
	Pet petInfo = petService.getPetByU_id((userSession.getU_id()));
	System.out.println(petInfo);
	String speices =  Integer.toString(petInfo.getSpe_id());
	ModifyPetInfo modifyPetInfo = new ModifyPetInfo(petInfo,speices);
	
	return modifyPetInfo;
}

@RequestMapping(value="/modifyPetInfo",method=RequestMethod.GET)
public String modifyPet(@ModelAttribute("modifyPetInfo")ModifyPetInfo modifyPetInfo) {
	
	return "tile/member/modifyPetInfo";
}

@RequestMapping(value="/modifyPetInfo",method=RequestMethod.POST)
public String modifyPetInfo(@ModelAttribute("modifyPetInfo")ModifyPetInfo modifyPetInfo) {
	
	
	int spe_id = Integer.parseInt(modifyPetInfo.getSpeices()); 
	modifyPetInfo.getPet().setSpe_id(spe_id);
	petService.updatePet(modifyPetInfo);
	
	return "redirect:/myPage/myHome";
}
	
	
}
