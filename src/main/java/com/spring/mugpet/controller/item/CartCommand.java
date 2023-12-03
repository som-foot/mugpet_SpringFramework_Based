package com.spring.mugpet.controller.item;

import java.util.List;

import com.spring.mugpet.domain.Cart;

public class CartCommand {
	private List<Cart> cartItems;
	private String addrDetail;	//상세주소
	private String req;			//요청사항
	
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	
	protected List<Cart> getCartItems() {
		return cartItems;
	}

	protected void setCartItems(List<Cart> cartItems) {
		this.cartItems = cartItems;
	}
}
