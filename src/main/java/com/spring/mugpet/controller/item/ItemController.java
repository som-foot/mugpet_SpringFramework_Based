package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.WishService;

@Controller
@RequestMapping("/item")
@SessionAttributes({"userSession", "filtering"})
public class ItemController {
	
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
	
	@Autowired
	private WishService wishService;
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	//종 및 카테고리에 맞는 아이템 리스트 출력
	@RequestMapping("/itemList")
	public ModelAndView viewItemListByCategory(@ModelAttribute("userSession") MemberInfo userSession,
										@RequestParam("spe_id") int spe_id, 
										@RequestParam("category_id") int category_id,
										@RequestParam(value="isFiltering", defaultValue="0")int isFiltering) {
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, category_id, "item_id", "ASC");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tiles/item/itemList");
		
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("filterTmp", "1");
		mav.addObject("standard", "기본순");
		mav.addObject("category_id", category_id);
		mav.addObject("petName", petName);
		mav.addObject("userSession", userSession);
		mav.addObject("isFiltering", isFiltering);
		
		return mav;
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public ModelAndView viewItem(@ModelAttribute("userSession") MemberInfo userSession, 
									@RequestParam("item_id") int item_id) {
		
		//비로그인 상태이면 wish=0
		int isWish = 0; 
		if(userSession.getU_id() != 0) {
			//wish에 해당 아이템이 있으면 1 반환, 없으면 0 반환
			isWish = wishService.isWish(item_id, userSession.getU_id());
			System.out.println(">>>>isWish=" + isWish);
		}
		Item item = itemService.getItem(item_id);
		
		ModelAndView mav = viewItemListByCategory(userSession, item.getSpe_id(), item.getCategory_id(), 0);
		mav.setViewName("tiles/item/itemDetail");
		
		mav.addObject("item", item);
		mav.addObject("isWish", isWish);
		mav.addObject("filterTmp", null);
		mav.addObject("isCart", null);
		
		return mav;
	}
	
	//아이템 정렬
	@RequestMapping("/orderByItem")
	public ModelAndView orderItem(@ModelAttribute("userSession") MemberInfo userSession,
									@ModelAttribute("filtering") FilterCommand filtering,
									@RequestParam("spe_id") int spe_id, @RequestParam("category_id") int category_id, 
									@RequestParam("stand") String stand, @RequestParam("od") String od, 
									@RequestParam("isFiltering") int isFiltering) {
		
		//isFiltering=1(필터링한 결과), isFiltering=0(필터링 안함)
		List<Item> itemList = new ArrayList<Item>();
		if (isFiltering == 1) {
			itemList = itemService.orderByFiltering(spe_id, category_id, filtering.getAge(), filtering.getStuffs(), filtering.getFeatures(), stand, od);
		} else {
			itemList = itemService.orderByItem(spe_id, category_id, stand, od);
		}
		
		ModelAndView mav = viewItemListByCategory(userSession, spe_id, category_id, isFiltering);
		mav.addObject("itemList", itemList);
		mav.addObject("standard", itemService.getOrderByName(stand, od));
		
		return mav;
	}
}
