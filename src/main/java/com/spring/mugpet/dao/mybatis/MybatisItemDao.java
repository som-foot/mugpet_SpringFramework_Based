package com.spring.mugpet.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.ItemDao;
import com.spring.mugpet.dao.mybatis.mapper.ItemMapper;
import com.spring.mugpet.domain.Item;

@Repository
public class MybatisItemDao implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public Item getItem(int item_id) throws DataAccessException {
		return itemMapper.getItem(item_id);
	}

	@Override
	public List<Item> getFilterItemList(Map<String, Object> param) throws DataAccessException {
		return itemMapper.getFilterItemList(param);
	}
	
	@Override
	public List<Item> orderByFiltering(Map<String, Object> param) throws DataAccessException {
		return itemMapper.orderByFiltering(param);
	}
	
	@Override
	public List<Item> orderByItem(int spe_id, int category_id, String stand, String od)
			throws DataAccessException {
		return itemMapper.orderByItem(spe_id, category_id, stand, od);
	}
}
