package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.dao.WishDao;
import com.spring.mugpet.domain.Item;

@Service
@Transactional
public class WishServiceImpl implements WishService {
	
	@Autowired
	private WishDao wishDao;

	public List<Item> getMyWishList(int u_id) {
		return wishDao.getMyWishList(u_id);
	}
	
	public int isWish(int item_id, int u_id) {
		Integer iswish = wishDao.isWish(item_id, u_id);
		if (iswish != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public void insertWish(int item_id, int u_id) {
		wishDao.insertWish(item_id, u_id);
	}

	public void deleteWish(int item_id, int u_id) {
		wishDao.deleteWish(item_id, u_id);
	}

	@Override
	public List<Item> getMyWishListForMyHome(int u_id) {
		return wishDao.getMyWishListForMyHome(u_id);
	}

}