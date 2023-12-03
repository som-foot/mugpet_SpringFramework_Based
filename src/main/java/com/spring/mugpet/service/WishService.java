package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.domain.Item;

public interface WishService {
	
	List<Item> getMyWishList(int u_id);
	
	List<Item> getMyWishListForMyHome(int u_id);
	
	int isWish(int item_id, int u_id);
	
	void insertWish(int item_id, int u_id);
	
	void deleteWish(int item_id, int u_id);
}