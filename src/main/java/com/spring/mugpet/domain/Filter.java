package com.spring.mugpet.domain;

public class Filter {
	private int item_id;		//primary key & foreign key
	private int age;			//연령
	private String stuff;		//주원료
	private String feature;		//기능
	
	public Filter() {}
	
	public Filter(int item_id, int age, String stuff, String feature) {
		this.item_id = item_id;
		this.age = age;
		this.stuff = stuff;
		this.feature = feature;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStuff() {
		return stuff;
	}

	public void setStuff(String stuff) {
		this.stuff = stuff;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
}
