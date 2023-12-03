package com.spring.mugpet.domain;

import java.util.List;

public class OrderItem {
	private int o_id;				//primary key
	private int orderQty;			//구매하는 개수
	private String orderAddr;		//배송지
	private String orderPhoneNum; 	//전화번호
	private int item_id;			//구매한 item의 id
	private int itemPrice;			//구매한 아이템 당 개수를 고려한 가격
	private int applyPoints;		//적용한 적립금
	private String req;				//사용자 요청사항
	private String orderTime;		//주문한 시간
	private int u_id;				//로그인한 사용자 id

	private List<Cart> orderItemList;
	public OrderItem() {}

	public OrderItem(int o_id, int orderQty, String orderAddr, String orderPhoneNum, int item_id, int itemPrice, int applyPoints, String req, String orderTime, int u_id) {
		this.o_id = o_id;
		this.orderQty = orderQty;
		this.orderAddr = orderAddr;
		this.orderPhoneNum = orderPhoneNum;
		this.item_id = item_id;
		this.itemPrice = itemPrice;
		this.applyPoints = applyPoints;
		this.req = req;
		this.orderTime = orderTime;
		this.u_id = u_id;
		
	}
	
	public OrderItem(int orderQty, String orderAddr, String orderPhoneNum, int item_id, int itemPrice, int applyPoints, String req, int u_id) {		
		this.orderQty = orderQty;
		this.orderAddr = orderAddr;
		this.orderPhoneNum = orderPhoneNum;
		this.item_id = item_id;
		this.itemPrice = itemPrice;
		this.applyPoints = applyPoints;
		this.req = req;
		this.u_id = u_id;
		
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderPhoneNum() {
		return orderPhoneNum;
	}

	public void setOrderPhoneNum(String orderPhoneNum) {
		this.orderPhoneNum = orderPhoneNum;
	}
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getApplyPoints() {
		return applyPoints;
	}

	public void setApplyPoints(int applyPoints) {
		this.applyPoints = applyPoints;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<Cart> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<Cart> orderItemList) {
		this.orderItemList = orderItemList;
	}


	
	
}
