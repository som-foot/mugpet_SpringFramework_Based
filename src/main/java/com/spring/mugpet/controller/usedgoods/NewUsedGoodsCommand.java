package com.spring.mugpet.controller.usedgoods;

import java.util.Date;

public class NewUsedGoodsCommand {
	private int g_id;
	private String imageUrl;
	private String title;
	private String content;
	private Date enroillDt;
	private int price;
	private int likes;
	private int replyCnt;
	private int u_id;
	
	public int getG_id() {
		return g_id;
	}
	
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getEnroillDt() {
		return enroillDt;
	}
	
	public void setEnroillDt(Date enroillDt) {
		this.enroillDt = enroillDt;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public int getReplyCnt() {
		return replyCnt;
	}
	
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
