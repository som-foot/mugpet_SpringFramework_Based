package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.Date;
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

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.CartService;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.OrderItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes("userSession")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private PetService petService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemController itemController;
	@Autowired
	private OrderItemController orderItemController;
	
	private int resetPoints = 0;
	int applyPoints = 0;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
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
	
	//장바구니 항목을 누르면 /cart/myCartList로 연결된다.
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	
	@RequestMapping("/cart/insertCart")
	   public ModelAndView addCart(@ModelAttribute("userSession") MemberInfo userSession,
			   						@RequestParam("item_id")int item_id, @RequestParam("qty")int qty,
			   						@RequestParam("tmp")int tmp) throws Exception {
		
		System.out.println(">>>>>item_id=" + item_id + ", qty=" + qty);
		
		ModelAndView mav = new ModelAndView();
		
		//isCart=1 (이미 카트에 존재하는 상품)
		int isCart = cartService.isCart(item_id, userSession.getU_id());
		if (isCart == 0) {
			Item item = itemService.getItem(item_id);
			int total = item.getPrice() * qty;
			   
			Cart newCart = new Cart(item_id, total, qty, userSession.getU_id());
			cartService.addCart(newCart);
		}
		
		if (tmp == 1) {
			mav = getCart(userSession);
		} else {
			mav = itemController.viewItem(userSession, item_id);
		}
		mav.addObject("isCart", isCart);
		   
		return mav;
	}
	
	
	//Cart(장바구니)에 담긴 아이템 조회 -> 장바구니 버튼 누르면 /cart/myCartList로 연결되는 방식
	@RequestMapping(value="/cart/myCartList", method=RequestMethod.GET)
	public ModelAndView getCart(@ModelAttribute("userSession") MemberInfo userSession) throws Exception{
	
		int spe_id = 1;
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		int u_id = userSession.getU_id();		
		
		List<Cart> cartItems = cartService.getMyCartList(u_id);	//장바구니에 담긴 아이템 조회
		if(cartItems.size() == 0) {
			ModelAndView mav = new ModelAndView("tiles/cart/noItemCart");
			mav.addObject("spe_id", spe_id);
			mav.addObject("spe", petService.getSpeName(spe_id));
			mav.addObject("petName", petName);
			
			return mav;
		}
			
		List<Item> cartItemsInfo = new ArrayList<Item>();			//Item 객체를 담을 list 생성 (item의 이름 등 정보들을 사용하기 위해서)
		List<Integer> cartItemsPrice = new ArrayList<Integer>();	//cartItem들의 각 가격을 담은 list 생성
		List<Integer> cartItemsQty = new ArrayList<Integer>();		//cartItem들의 각 개수를 담은 list 생성
		int cartItemQty = 0;
		int totalPrice = 0;											//총 가격
		int idx = 0;		
		int cartItemSize = cartItems.size();  						 //장바구니에 담긴 아이템의 개수
		for(Cart items : cartItems) {
			int item_id = items.getItem_id();
			Item info = cartService.getCartItemInfo(item_id);
			cartItemsInfo.add(info);
			cartItemQty = items.getCartQty();
			cartItemsQty.add(cartItemQty);
			cartItemsPrice.add(cartItemQty * info.getPrice());
			totalPrice += cartItemsPrice.get(idx);
			idx++;
		}

		
		ModelAndView mav = new ModelAndView("tiles/cart/myCartList");
		
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemSize", cartItemSize);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("petName", petName);
		
		return mav;
	}
	
	//각 장바구니 상품의 개수를 수정할 수 있는 메소드
	@RequestMapping(value="/cart/updateCartQuantities", method=RequestMethod.POST)
	public ModelAndView cartItemUpdate(HttpServletRequest request,@ModelAttribute("userSession") MemberInfo userSession) throws Exception{
		
		List<Cart> cartItems = cartService.getMyCartList(userSession.getU_id()); 
		int num = 0;
		for(Cart cartItem : cartItems){
			int item_id = cartItem.getItem_id(); //각 아이템의 item_id를 가지고 옴
			try {
					int quantity = Integer.parseInt(request.getParameter(Integer.toString(num))); //각 아이템의 변경된 값을 가지고 옴
					cartItem.setCartQty(quantity); //cart의 개수 필드 변경 cartItem은 가져온 각 아이템
					cartService.updateCart(quantity, item_id, userSession.getU_id());
				
					if(quantity < 1) {
						cartService.removeCart(item_id, userSession.getU_id());
					}
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
			num++;
		}
		
		return new ModelAndView("redirect:/cart/myCartList");
	}
	
	//각각의 물품 삭제할 수 있는 메소드 =>-버튼 클릭시 사라짐
	@RequestMapping(value="/cart/removeItemFromCart", method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("item_id") int item_id, @ModelAttribute("userSession") MemberInfo userSession) throws Exception{
		cartService.removeCart(item_id, userSession.getU_id());
		
		return new ModelAndView("redirect:/cart/myCartList");
	}

	//주문하기누르면 계산 페이지로 이동하는 메소드
	@RequestMapping(value="/cart/order", method=RequestMethod.GET)
	public ModelAndView cartToOrder(@ModelAttribute("userSession") MemberInfo userSession) throws Exception{
		
		int spe_id = 1;
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		List<Cart> cartItems = cartService.getMyCartList(userSession.getU_id());	//장바구니에 담긴 아이템 조회
		List<Item> cartItemsInfo = new ArrayList<Item>();							//Item 객체를 담을 list 생성
		List<Integer> cartItemsPrice = new ArrayList<Integer>();					//cartItem들의 각 가격을 담은 list 생성
		List<Integer> cartItemsQty = new ArrayList<Integer>();						//cartItem들의 각 개수를 담은 list 생성
		int cartItemSize = cartItems.size();										//장바구니에 담긴 아이템의 개수
		int cartItemQty = 0;
		int totalPrice = 0;
		applyPoints = 0;
		int idx = 0;
		for(Cart items : cartItems) {
			int item_id = items.getItem_id();
			Item info = cartService.getCartItemInfo(item_id);
			System.out.println("카트 첫번째 아이템 이름: " + info.getItemName());
			cartItemsInfo.add(info);
			cartItemQty = items.getCartQty();
			cartItemsQty.add(cartItemQty);
			cartItemsPrice.add(cartItemQty * info.getPrice());
			totalPrice += cartItemsPrice.get(idx);
			idx++;
		}
		
		MemberInfo memberInfo = memberService.login(userSession.getEmail(), userSession.getPwd());
		resetPoints = memberInfo.getPoint();
		
		ModelAndView mav = new ModelAndView("tiles/cart/order");
		
		mav.addObject("cartItemsInfo", cartItemsInfo);
		mav.addObject("cartItemsPrice", cartItemsPrice);
		mav.addObject("cartItemsQty", cartItemsQty);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("memberInfo", memberInfo);
		mav.addObject("applyPoints", applyPoints);
		mav.addObject("resetPoints", resetPoints);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("petName", petName);
		mav.addObject("oneItem", 0);
		mav.addObject("item_id", 0);
		mav.addObject("qty", 0);
		
		return mav;
	}
	
	
	@RequestMapping(value="/cart/order", method=RequestMethod.POST)
	public ModelAndView pointUpdate(HttpServletRequest request, @ModelAttribute("userSession") MemberInfo userSession, @ModelAttribute("command") CartCommand command) throws Exception{ 
			
			ModelAndView mav = cartToOrder(userSession);
			MemberInfo memberInfo = memberService.login(userSession.getEmail(), userSession.getPwd());		
			
			int allPoints = memberInfo.getPoint();
	
			if(request.getParameter("point") == "" || request.getParameter("point") == "0") { 
				applyPoints = 0;
				
				mav.addObject(applyPoints);
				return mav;
			}
			else {
				applyPoints = Integer.parseInt(request.getParameter("point"));
				try {
					if(allPoints > 0 && allPoints >= applyPoints) {
						resetPoints = allPoints - applyPoints;
					}
					else {
						applyPoints = 0;
						resetPoints = allPoints;
					}
				}catch(Exception ex) {
					
				}
				
				mav.addObject("applyPoints", applyPoints);			//적용된 적립금
				mav.addObject("resetPoints", resetPoints);			//적용된 후 사용자의 적립금
				
			}
			return mav;
	}

	@RequestMapping(value="/cart/ordering", method=RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, @ModelAttribute("userSession") MemberInfo userSession, 
							@ModelAttribute("orderItemCommand") OrderItemCommand command,
							@RequestParam("oneItem")int oneItem, @RequestParam(value="item_id", defaultValue="0")int item_id,
							@RequestParam(value="qty", defaultValue="0")int qty) throws Exception{ //매개변수 설정해야 함
		System.out.println(">>>>>>item_id=" + item_id + ",qty=" + qty);
		int spe_id = 1;
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		int u_id = userSession.getU_id();
		ModelAndView mav = new ModelAndView("tiles/cart/orderCompleted");
		MemberInfo memberInfo = memberService.login(userSession.getEmail(), userSession.getPwd());
		
		String phoneNum = memberInfo.getPhoneNum();
		String address = memberInfo.getAddress() + " " + request.getParameter("addrDetail");
		String req = request.getParameter("req");
		if(req =="")
			req = "없음";	


		List<Cart> orderItemList = new ArrayList<Cart>();
		List<Item> orderItemsInfo = new ArrayList<Item>();
		List<Integer> orderItemsPrice = new ArrayList<Integer>();
		
		int orderQty;					  //주문한 상품 종류 수
		List<Integer> orderItemsQtyList = new ArrayList<Integer>();//주문한 상품 하나 당 개수를 모은 리스트
		int orderItemQty = 0; 	//주문한 상품 하나 당 개수
		int totalPrice = 0;		//모든 상품 더한 총가격
		int itemPrice = 0;		//상품 하나 당 개수를 고려한 가격
		int idx = 0;
		Item info = new Item();
		
		if (oneItem == 1) {
				info = itemService.getItem(item_id);
				orderItemsInfo.add(info);
				orderItemsQtyList.add(qty);
				orderItemsPrice.add(info.getPrice() * qty);
				totalPrice = info.getPrice() * qty;
				orderQty = 1;
				
				OrderItem orderItem = new OrderItem(orderItemQty, address, phoneNum, item_id, itemPrice, applyPoints, req, u_id);
				orderItemService.insertOrderItem(orderItem);
				
		} else {
			//orderItem에 cartItems들을 넣음
			orderItemList = cartService.getMyCartList(userSession.getU_id());
			orderQty = orderItemList.size();
			for(Cart items : orderItemList) {
				item_id = items.getItem_id();
				System.out.println("아이템 아이디: " + item_id);
				info = cartService.getCartItemInfo(item_id);	//카트에 담긴 상품의 자세한 아이템 정보
				System.out.println("카트 첫번째 아이템 이름: " + info.getItemName());
				orderItemsInfo.add(info);
				orderItemQty = items.getCartQty();		//주문한 상품 하나 당 개수 I
				orderItemsQtyList.add(orderItemQty);	//주문한 상품의 개수들을 담은 리스트
				itemPrice = orderItemQty * info.getPrice();
				orderItemsPrice.add(itemPrice); 		//주문한 상품들의 가격들을 담은 리스트 : 상품 당 개수와 아이템 X 테이블로 얻어진 상품 가격 의 리스트
				totalPrice += orderItemsPrice.get(idx); //총 가격
				
				OrderItem orderItem = new OrderItem(orderItemQty, address, phoneNum, item_id, itemPrice, applyPoints, req, u_id);
				orderItemService.insertOrderItem(orderItem);
				
				idx++;
			}
		}
		
		//결제를 했으므로 사용자의 적립금 정보를 업데이트 해준다.(100원 적립)
		memberService.updatePoints(resetPoints + 100, userSession.getEmail(), userSession.getPwd());
		
		totalPrice = totalPrice - applyPoints;
		Date date = new Date();
		mav.addObject("memberInfo", memberInfo); //주문자, 전화번호
		mav.addObject("address", address);
		mav.addObject("req", req);
		mav.addObject("currentTime", date);
		mav.addObject("orderItemQtyList", orderItemsQtyList);
		mav.addObject("orderQty", orderQty);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("orderItemsPrice", orderItemsPrice);
		mav.addObject("orderItemsInfo", orderItemsInfo);
		mav.addObject("applyPoints", applyPoints);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("petName", petName);
		
		cartService.removeCartAll(u_id);

		return mav;
	
	}

}