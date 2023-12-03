package com.spring.mugpet.domain;

import java.util.Date;

public class Reply {
	private int rp_id;			//primary key
	private String content;		//댓글 내용
	private Date enrollDt;		//작성 시간
	private int u_id;			//작성자 id
	private int com_id;			//댓글 단 커뮤니티 글 id
	private int g_id;			//댓글 단 중고거래 글 id
	
	public Reply() {}
	
	public Reply(int rp_id, String content, Date enrollDt, int u_id, int com_id, int g_id) {
		this.rp_id = rp_id;
		this.content = content;
		this.enrollDt = enrollDt;
		this.u_id = u_id;
		this.com_id = com_id;
		this.g_id = g_id;
	}

	public int getRp_id() {
		return rp_id;
	}
	
	public void setRp_id(int rp_id) {
		this.rp_id = rp_id;
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
	
	public int getU_id() {
		return u_id;
	}
	
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	public int getCom_id() {
		return com_id;
	}
	
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
}
