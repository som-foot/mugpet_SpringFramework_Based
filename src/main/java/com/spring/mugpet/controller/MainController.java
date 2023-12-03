package com.spring.mugpet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.spring.mugpet.controller.item.FilterCommand;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes({"userSession", "filtering","petName"})
public class MainController {
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	private PetService petService;
	public void setPetService(PetService petService) {
		this.petService = petService;
	}

	@ModelAttribute("userSession")
	public MemberInfo userSession(HttpServletRequest request) {
		MemberInfo userSession = (MemberInfo) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession == null) {
			return new MemberInfo();
		}
		return userSession;
	}
	@ModelAttribute("petName")
	public String petName() {
		String petName = null;
		return petName;
	}
	@ModelAttribute("filtering")
	public FilterCommand setFiltering() {
		FilterCommand filtering = new FilterCommand();
		filtering.setAge("퍼피");
		return filtering;
	}

	//main view
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView viewMain(@ModelAttribute("userSession") MemberInfo userSession,
								@RequestParam(value="spe_id", defaultValue="1") int spe_id,
								@RequestParam(value="isFiltering", defaultValue="0")int isFiltering) {
	
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, 0, "item_id", "ASC");	
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tiles/main");
		
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("filterTmp", "1");	//filterTmp가 1이면 필터링버튼 노출, 0이면 노출 안 함
		mav.addObject("category_id", 0);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("standard", "기본순");
		mav.addObject("petName", petName);
		mav.addObject("userSession", userSession);
		mav.addObject("isFiltering", isFiltering);
		
		return mav;
	}
	
	
	//종 선택 시 아이템 변경(session의 spe_id와는 무관하게)
	@RequestMapping(value="/main/speId", method=RequestMethod.GET)
	public ModelAndView viewSpeMain(@ModelAttribute("userSession") MemberInfo userSession,
								@RequestParam("spe_id") int spe_id,
								@RequestParam(value="isFiltering", defaultValue="0")int isFiltering) {
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, 0, "item_id", "ASC");
		
		ModelAndView mav = viewMain(userSession, spe_id, isFiltering);
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		
		return mav;
	}
  
	
	//main에서 아이템 정렬
	@RequestMapping("/main/orderByItem")
	public ModelAndView orderByItem(@ModelAttribute("userSession") MemberInfo userSession,
								@ModelAttribute("filtering") FilterCommand filtering,
								@RequestParam("spe_id") int spe_id,
								@RequestParam("stand") String stand, 
								@RequestParam("od") String od,
								@RequestParam("isFiltering")int isFiltering) {
		
		//isFiltering=1(필터링한 결과), isFiltering=0(필터링 안함)
		List<Item> itemList = new ArrayList<Item>();
		if (isFiltering == 1) {
			itemList = itemService.orderByFiltering(spe_id, 0, filtering.getAge(), filtering.getStuffs(), filtering.getFeatures(), stand, od);
		} else {
			itemList = itemService.orderByItem(spe_id, 0, stand, od);
		}
		
		ModelAndView mav = viewMain(userSession, spe_id, isFiltering);
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("standard", itemService.getOrderByName(stand, od));
		mav.addObject("isFiltering", isFiltering);
		
		return mav;
	}
}