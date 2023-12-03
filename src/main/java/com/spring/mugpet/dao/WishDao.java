package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface WishDao {

	public List<Item> getMyWishList(int u_id) throws DataAccessException;
	
	public Integer isWish(int item_id, int u_id) throws DataAccessException;

	public void insertWish(int item_id, int u_id) throws DataAccessException;
	
	public void deleteWish(int item_id, int u_id) throws DataAccessException;

	public List<Item> getMyWishListForMyHome(int u_id) throws DataAccessException;
}
