package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.domain.Item;

public interface ItemService {
	
	Item getItem(int item_id);
	
	List<Item> getFilterItemList(int spe_id, int category_id, String age, List<String> stuff, List<String> feature);
	
	List<Item> orderByFiltering(int spe_id, int category_id, String age, List<String> stuff, List<String> feature, String stand, String od);
	
	List<Item> orderByItem(int spe_id, int category_id, String stand, String od);
	
	String getOrderByName(String standard, String od);
}
