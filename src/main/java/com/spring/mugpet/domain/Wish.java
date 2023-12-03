package com.spring.mugpet.domain;

public class Wish {
	
	private int w_id;		//primary key
	private int item_id;	//wish에 들어간 item_id
	private int u_id;		//wish에 넣은 u_id
	
	public Wish() {}

	public Wish(int w_id, int item_id, int u_id) {
		this.w_id = w_id;
		this.item_id = item_id;
		this.u_id = u_id;
	}

	public int getW_id() {
		return w_id;
	}

	public void setW_id(int w_id) {
		this.w_id = w_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
