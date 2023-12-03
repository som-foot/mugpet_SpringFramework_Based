package com.spring.mugpet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface ItemDao {
	
	public Item getItem(int item_id) throws DataAccessException;
	
	public List<Item> getFilterItemList(Map<String, Object> param) throws DataAccessException;
	
	public List<Item> orderByFiltering(Map<String, Object> param) throws DataAccessException;
	
	public List<Item> orderByItem(int spe_id, int category_id, String stand, String od) throws DataAccessException;
}
