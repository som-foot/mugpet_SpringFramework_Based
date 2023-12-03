package com.spring.mugpet.domain;

import java.util.Date;

public class Community {
	private int com_id;					//primary key
	private String imageUrl;			//이미지 경로
	private String title;				//제목
	private String content;				//내용
	private Date enrollDt;				//작성시간
	private int likes;					//좋아요 수
	private int replyCnt;				//댓글 수
	private int u_id;					//작성자 id
	
	public Community() {}
	
	public Community(int com_id, String imageUrl, String title, String content, Date enrollDt, int likes,
			int replyCnt, int u_id) {
		this.com_id = com_id;
		this.imageUrl = imageUrl;
		this.title = title;
		this.content = content;
		this.enrollDt = enrollDt;
		this.likes = likes;
		this.replyCnt = replyCnt;
		this.u_id = u_id;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
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

	public Date getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
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
