package com.spring.mugpet.domain;

public class Cart {
	
	private int cart_id;	//Primary key
	private int item_id;	//카트에 담은 item의 id
	private int total;		//총 가격(상품 가격 * 개수)
	private int cartQty;	//개수
	private int u_id;		//로그인한 사용자 id
	
	public Cart() {}

	public Cart(int cart_id, int item_id, int total, int cartQty, int u_id) {
		this.cart_id = cart_id;
		this.item_id = item_id;
		this.total = total;
		this.cartQty = cartQty;
		this.u_id = u_id;
	}
	
	public Cart(int item_id, int total, int cartQty, int u_id) {
		this.item_id = item_id;
		this.total = total;
		this.cartQty = cartQty;
		this.u_id = u_id;
	}

	
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}