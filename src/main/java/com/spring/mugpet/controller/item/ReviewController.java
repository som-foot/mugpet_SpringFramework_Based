package com.spring.mugpet.controller.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Review;
import com.spring.mugpet.service.OrderItemService;

@Controller
@RequestMapping("/review")
@SessionAttributes({"userSession","petName"})
public class ReviewController {
	//@Autowired private ReviewService reviewService;
	
	
	@Autowired
	OrderItemService orderItemService;
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	@ModelAttribute("newReview")
	public Review newReview(@ModelAttribute("userSession")MemberInfo userSession,
							HttpServletRequest request) {
		int u_id = userSession.getU_id();
		int item_id = (int) request.getAttribute("item_id");
		
		Review review = null; 
		if(orderItemService.isCheckOrderItem(u_id,item_id)) {
			review = new Review();
			review.setU_id(u_id);
			review.setItem_id(item_id);
		}
		return review;
	}
	
	@RequestMapping(value="/newReview", method=RequestMethod.GET)
	public String writeReview(@RequestParam("item_id")int item_id,
							  @ModelAttribute("userSession")MemberInfo userSession,
							  @ModelAttribute("newReview")Review review,
							  ModelMap model) throws Exception {
		
		if(review == null) {
			return "tiles/main";
		}
		model.put("userSession",userSession);
		
		
		return "/review/newReivewForm";
	}
	@RequestMapping(value="/writeReviewForm", method=RequestMethod.POST)
	public String registerReview(@ModelAttribute("newReview")Review review) { //매개변수 설정해야 함
		
		
		
		
		
		return "a";
	}
}
