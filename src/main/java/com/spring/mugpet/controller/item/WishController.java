package com.spring.mugpet.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.WishService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/wish")
public class WishController {
	
	@Autowired
	private WishService wishService;
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	@Autowired
	private PetService petService;
	public void setPetService(PetService petService) {
		this.petService = petService;
	}
	
	@Autowired
	private ItemController itemController;
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	

	//위시리스트에 아이템 추가 및 삭제
	@RequestMapping("/updateWish")

	public ModelAndView updateWish(@ModelAttribute("userSession") MemberInfo userSession, 
									@RequestParam("item_id") int item_id,
									@RequestParam("isWish") int isWish) {
		
		if (isWish == 0) {
			wishService.insertWish(item_id, userSession.getU_id());
		} else {
			wishService.deleteWish(item_id, userSession.getU_id());
		}
		isWish = wishService.isWish(item_id, userSession.getU_id());
		
		ModelAndView mav = itemController.viewItem(userSession, item_id);
		mav.addObject("isWish", isWish);
		
		return mav;
	}
	
	//위시리스트
	@RequestMapping(value="/myWishList", method=RequestMethod.GET)
	public ModelAndView getWishList(@ModelAttribute("userSession") MemberInfo userSession) {
		
		Pet pet = petService.getPetByU_id(userSession.getU_id());
		int spe_id = pet.getSpe_id();
		
		List<Item> wishItemsInfo = wishService.getMyWishList(userSession.getU_id());
		System.out.println("위시 아이템 개수" + wishItemsInfo.size());
	    
	    ModelAndView mav = itemController.viewItemListByCategory(userSession, spe_id, 1, 0);
	    mav.setViewName("tile/myPage/myWishList");
	    
	    mav.addObject("spe_id", spe_id);
	    mav.addObject("filterTmp", null);
	    mav.addObject("wishItemsInfo", wishItemsInfo);
	      
	    return mav;
	}
	
	//각각의 물품 삭제할 수 있는 메소드 =>-버튼 클릭시 사라짐
	@RequestMapping(value="/deleteWish", method=RequestMethod.GET)
	public ModelAndView handleRequest(@ModelAttribute("userSession") MemberInfo userSession,
										@RequestParam("item_id") int item_id) throws Exception{
		
		wishService.deleteWish(item_id, userSession.getU_id());
		ModelAndView mav = getWishList(userSession);

		return mav;
	}
	
}