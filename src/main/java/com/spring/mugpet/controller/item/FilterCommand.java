package com.spring.mugpet.controller.item;

import java.util.List;

public class FilterCommand {
	
	private String age;					//연령
	private List<String> stuffs;		//주원료
	private List<String> features;		//기능
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public List<String> getStuffs() {
		return stuffs;
	}
	
	public void setStuffs(List<String> stuffs) {
		this.stuffs = stuffs;
	}
	
	public List<String> getFeatures() {
		return features;
	}
	
	public void setFeatures(List<String> features) {
		this.features = features;
	}
}
