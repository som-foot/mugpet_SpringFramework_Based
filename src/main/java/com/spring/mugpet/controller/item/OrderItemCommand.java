package com.spring.mugpet.controller.item;

public class OrderItemCommand {
	
	private int orderQty;		//구매하는 개수
	private String orderAddr;		//배송지
	private String orderPhoneNum; 	//전화번호
	private int item_id;		//구매한 item의 id
	private int itemPrice;		//구매한 아이템 당 개수를 고려한 가격
	private String orderTime;		//주문한 시간
	private int u_id;
	private String addrDetail;	//상세주소
	private String req;			//요청사항
	
	
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
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

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
	
}
