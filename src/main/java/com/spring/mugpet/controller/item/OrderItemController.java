package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.OrderItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes({"userSession","petName"})
public class OrderItemController {
	
	@Autowired 
	private OrderItemService orderItemService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartController cartController;
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public void setPetService(PetService petService) {
		this.petService = petService;
	}
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void setCartController(CartController cartController) {
		this.cartController = cartController;
	}
	
	
	//아이템상세페이지에서 바로 구매하기
	@RequestMapping("/order/orderItem")
	public ModelAndView orderItem(@ModelAttribute("userSession") MemberInfo userSession,
									@RequestParam("item_id")int item_id, @RequestParam("qty")int qty) throws Exception {
		Item i = itemService.getItem(item_id);
		List<Item> item = new ArrayList<Item>();
		item.add(i);
		
		List<Integer> price = new ArrayList<Integer>();
		price.add(i.getPrice() * qty);
		
		List<Integer> qtys = new ArrayList<Integer>();
		qtys.add(qty);
		
		ModelAndView mav = cartController.cartToOrder(userSession);
		mav.addObject("cartItemsInfo", item);
		mav.addObject("cartItemsPrice", price);
		mav.addObject("cartItemsQty", qtys);
		mav.addObject("totalPrice", qty * i.getPrice());
		mav.addObject("oneItem", 1);
		mav.addObject("item_id", item_id);
		mav.addObject("qty", qty);
		return mav;
	}
	

	@RequestMapping(value="/myPage/myOrderList", method=RequestMethod.GET)
	public ModelAndView viewOrderList(@ModelAttribute("userSession") MemberInfo userSession, 
			@ModelAttribute("petName") String petName,
			@ModelAttribute("orderItemCommand") OrderItemCommand command) {
		int spe_id = 1;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		ModelAndView mav = new ModelAndView("tile/myPage/myOrderList");
		MemberInfo memberInfo = memberService.login(userSession.getEmail(), userSession.getPwd());
		Map<String, Object> orderItemsInfoList = new LinkedHashMap<String, Object>();
		List<String> orderTimeList = orderItemService.getAllOrderTimeList(userSession.getU_id()); 
		if(orderTimeList.size() == 0) {
			mav = new ModelAndView("tile/myPage/noItemOrder");
			mav.addObject("spe_id", spe_id);
			mav.addObject("spe", petService.getSpeName(spe_id));
			mav.addObject("petName", petName);
			
			return mav;
		}
		List<Integer> itemsSize = new ArrayList<>();
		int totalPrice = 0;
		List<Integer> orderItemsPrice = new ArrayList<Integer>();
		
		for(String orderTime : orderTimeList) { //OrderItem 테이블에서 각 주문의 시각을 얻어옴
			List<OrderItem> itemsByTime = orderItemService.getOrderItemList(userSession.getU_id(), orderTime); //각 주문시각에 해당하는 item행들을 얻어옴
			int count = itemsByTime.size();
			itemsSize.add(count);
			List<OrderItemInfos> orderItemsInfo = orderItemService.getAllOrderItemList(userSession.getU_id(), orderTime);	
			for (int i = 0; i < orderItemsInfo.size(); i++) {
				System.out.println(">>>>>>>item_id=" + orderItemsInfo.get(i).getItem_id() + ", address = " + orderItemsInfo.get(i).getOrderAddr());
			}
			
			for(OrderItem item : itemsByTime) { 
				totalPrice = totalPrice + item.getItemPrice();
				
			}
			orderItemsInfoList.put(orderTime, orderItemsInfo); //map에 ordertime의 값에 따른 item정보들을 value로 넣음
			orderItemsPrice.add(totalPrice);
			totalPrice = 0;
		}
		
		mav.addObject("memberInfo", memberInfo);
		mav.addObject("orderItemsInfoList", orderItemsInfoList); 
		mav.addObject("itemsSize", itemsSize);			  	//시간에 따라 담긴 아이템들의 총 개수
		mav.addObject("orderItemsPrice", orderItemsPrice); 	//시간에 따라 담긴 아이템들의 총 가격 리스트
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("petName", petName);
		
		return mav;
	}
}
