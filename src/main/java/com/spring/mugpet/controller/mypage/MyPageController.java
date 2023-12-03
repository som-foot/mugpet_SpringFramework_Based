package com.spring.mugpet.controller.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.controller.item.ItemController;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.OrderItemService;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.UsedGoodsServiceImpl;
import com.spring.mugpet.service.WishService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/myPage")
public class MyPageController {
	
	@Autowired
	private UsedGoodsServiceImpl goodsService;
	
	@Autowired
	private PetService petService;
	@Transactional
	public void setPetberService(PetService petService) {
		this.petService = petService;
	}
	
	@Autowired 
	private OrderItemService orderItemService;
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	private WishService wishService;
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	
	@RequestMapping(value="/myHome",method=RequestMethod.GET)
	public String myHome(@ModelAttribute("userSession")MemberInfo userSession,ModelMap model) throws Exception {
		
		int u_id = userSession.getU_id();
		Pet pet = petService.getPetByU_id(u_id);
		String petName = pet.getName();
		List<Item> wishList = wishService.getMyWishListForMyHome(u_id);
		int orderCount = orderItemService.getOrderItemCnt(u_id);
		int usedGoodsCount = goodsService.getUsedGoodsCntByU_id(u_id);
		model.put("wishList", wishList);
		model.put("userSession", userSession);	
		model.put("petName", petName);
		model.put("orderCount", orderCount);
		model.put("usedGoodsCount", usedGoodsCount);
		
		
		return "tile/myPage/myHome";
	}

	
	
	
}
