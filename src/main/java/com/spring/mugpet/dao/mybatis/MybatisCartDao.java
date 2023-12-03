package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.CartDao;
import com.spring.mugpet.dao.mybatis.mapper.CartMapper;
import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

@Repository
public class MybatisCartDao implements CartDao{
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public Integer isCart(int item_id, int u_id) throws DataAccessException {
		return cartMapper.isCart(item_id, u_id);
	}
	
	@Override
	public List<Cart> getMyCartList(int u_id) throws DataAccessException{
		return cartMapper.getMyCartList(u_id);
	}
	
	@Override
	public int getMyCartItemQty(int item_id, int u_id) throws DataAccessException{
		return cartMapper.getMyCartItemQty(item_id, u_id);
	}
	
	@Override
	public Item getCartItemInfo(int item_id) throws DataAccessException{
		return cartMapper.getCartItemInfo(item_id);
	}
	
	@Override
	public Cart getMyCartItemCartType(int item_id, int u_id) throws DataAccessException{
		return cartMapper.getMyCartItemCartType(item_id, u_id);
	}
	
	@Override
	public void addCart(Cart cart) throws DataAccessException{
		cartMapper.addCart(cart);
	}

	@Override
	public void updateCart(int cartQty, int item_id, int u_id) throws DataAccessException{
		cartMapper.updateCart(cartQty, item_id, u_id);
	}

	@Override
	public void removeCart(int item_id, int u_id) throws DataAccessException{
		cartMapper.removeCart(item_id, u_id);
	}
	
	@Override
	public void removeCartAll(int u_id) throws DataAccessException{
		cartMapper.removeCartAll(u_id);
	}
	
}