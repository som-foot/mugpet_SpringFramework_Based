package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

public interface CartDao {
	
	public Integer isCart(int item_id, int u_id) throws DataAccessException;
	
	public List<Cart> getMyCartList(int u_id) throws DataAccessException;
	
	public int getMyCartItemQty(int item_id, int u_id) throws DataAccessException;
	
	public Item getCartItemInfo(int item_id) throws DataAccessException;
	
	public Cart getMyCartItemCartType(int item_id, int u_id) throws DataAccessException;
	
	public void addCart(Cart cart) throws DataAccessException;

	public void updateCart(int cartQty, int item_id, int u_id) throws DataAccessException;

	public void removeCart(int item_id, int u_id) throws DataAccessException;
	
	public void removeCartAll(int u_id) throws DataAccessException;
}