package com.spring.mugpet.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.OrderItemDao;
import com.spring.mugpet.dao.mybatis.mapper.OrderItemMapper;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

@Repository
public class MybatisOrderItemDao implements OrderItemDao {

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Override
	public List<OrderItem> getOrderItemList(int u_id, String orderTime) throws DataAccessException{
		return orderItemMapper.getOrderItemList(u_id, orderTime);
	}

	@Override
	public List<String> getAllOrderTimeList(int u_id) throws DataAccessException{
		return orderItemMapper.getAllOrderTimeList(u_id);
	}
	
	@Override
	public Item getOrderItemInfo(int item_id) throws DataAccessException{
		return orderItemMapper.getOrderItemInfo(item_id);
	}
	
	@Override
	public List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime) throws DataAccessException{
		return orderItemMapper.getAllOrderItemList(u_id, orderTime);
	}
	
	@Override	
	public void insertOrderItem(OrderItem orderItem) throws DataAccessException{
		orderItemMapper.insertOrderItem(orderItem);
	}
	
	@Override
	public int getOrderItemCnt(int u_id) throws DataAccessException {
		return orderItemMapper.getOrderItemCnt(u_id);
	}

	@Override
	public OrderItem isCheckOrderItem(Map<String,Integer>param) throws DataAccessException {
		return orderItemMapper.isCheckOrderItem(param);
		
	}
	
}
