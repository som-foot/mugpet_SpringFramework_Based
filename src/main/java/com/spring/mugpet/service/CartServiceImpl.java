package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.CartDao;
import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	//Cart가 존재하는지 확인
	@Override
	public Integer isCart(int item_id, int u_id) {
		Integer isCart = cartDao.isCart(item_id, u_id);
		if (isCart != null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	//Cart 목록 리스트 형태로 가져오기 (장바구니는 하나)
	public List<Cart> getMyCartList(int u_id){
		return cartDao.getMyCartList(u_id);
	}
	//Cart 목록에 있는 카트 필드 정보 가져오기
	public int getMyCartItemQty(int item_id, int u_id) {
		return cartDao.getMyCartItemQty(item_id, u_id);
	}
	//Cart 목록에 있는 하나의 아이템 정보 가져오기
	public Item getCartItemInfo(int item_id) {
		return cartDao.getCartItemInfo(item_id);
	}
		
	//Cart 목록에 있는 하나의 아이템 정보를 Cart 타입으로 가져오기
	public Cart getMyCartItemCartType(int item_id, int u_id) {
		return cartDao.getMyCartItemCartType(item_id, u_id);
	}
	
	//Cart 목록에 item 추가하기
	public void addCart(Cart cart) {
		cartDao.addCart(cart);
	}
	
	//Cart 목록에 item 정보 수정하기
	public void updateCart(int cartQty, int item_id, int u_id) {
		cartDao.updateCart(cartQty, item_id, u_id);
	}

	//Cart 목록에 item 삭제하기
	public void removeCart(int item_id, int u_id) {
		cartDao.removeCart(item_id, u_id);
	}

	//Cart 목록의 모든 아이템 삭제하기
	public void removeCartAll(int u_id) {
		cartDao.removeCartAll(u_id);
	}
	
}