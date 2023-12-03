package com.spring.mugpet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

public interface OrderItemDao {
	
	public List<OrderItem> getOrderItemList(int u_id, String orderTime) throws DataAccessException; 

	public List<String> getAllOrderTimeList(int u_id) throws DataAccessException;

	OrderItem isCheckOrderItem(Map<String,Integer>param)throws DataAccessException;

	public Item getOrderItemInfo(int item_id) throws DataAccessException;
	
	public List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime) throws DataAccessException;
		
	public void insertOrderItem(OrderItem orderItem) throws DataAccessException;
	
	public int getOrderItemCnt(int u_id) throws DataAccessException;
}

