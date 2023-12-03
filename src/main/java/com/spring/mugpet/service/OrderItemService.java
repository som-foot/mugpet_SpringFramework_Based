package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

public interface OrderItemService {
	//member의 주문 아이템 목록 가져오기
	List<OrderItem> getOrderItemList(int u_id, String orderTime); 

	//member의 모든 주문 아이템 목록 가져오기
	List<String> getAllOrderTimeList(int u_id);
	
	//주문 목록에 있는 하나의 아이템 정보 가져오기 (상품명, 가격 등)
	Item getOrderItemInfo(int item_id);
	
	List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime);
	
	//주문 목록에 상품 추가하기	
	void insertOrderItem(OrderItem orderItem);
	
	int getOrderItemCnt(int u_id);
	
	//member가 주문한 아이템인지 확인하는 메소드
	boolean isCheckOrderItem(int u_id,int item_id);
}
