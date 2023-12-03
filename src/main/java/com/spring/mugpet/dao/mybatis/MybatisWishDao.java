package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.WishDao;
import com.spring.mugpet.dao.mybatis.mapper.WishMapper;
import com.spring.mugpet.domain.Item;

@Repository
public class MybatisWishDao implements WishDao{

	@Autowired
	private WishMapper wishMapper;
	
	@Override
	public List<Item> getMyWishList(int u_id) throws DataAccessException {
		return wishMapper.getMyWishList(u_id);
	}
	
	@Override
	public Integer isWish(int item_id, int u_id) throws DataAccessException {
		return wishMapper.isWish(item_id, u_id);
	}
	
	@Override
	public void insertWish(int item_id, int u_id) throws DataAccessException {
		wishMapper.insertWish(item_id, u_id);
	}

	@Override
	public void deleteWish(int item_id, int u_id) throws DataAccessException {
		wishMapper.deleteWish(item_id, u_id);
	}

	@Override
	public List<Item> getMyWishListForMyHome(int u_id) throws DataAccessException {
		return wishMapper.getMyWishListForMyHome(u_id);
	}
	
}