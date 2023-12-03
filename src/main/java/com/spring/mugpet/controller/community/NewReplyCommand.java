package com.spring.mugpet.controller.community;

public class NewReplyCommand {
	private int rp_id;
	private String content;
	private int u_id;
	private int com_id;
	private int g_id;
	
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
