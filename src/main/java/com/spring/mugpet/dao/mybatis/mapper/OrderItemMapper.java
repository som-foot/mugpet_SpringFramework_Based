package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

public interface OrderItemMapper {

	//member의 주문 아이디에 해당하는 item 목록 가져오기
	List<OrderItem> getOrderItemList(@Param("u_id")int u_id, @Param("orderTime") String orderTime); 

	//member의 모든 주문 item 목록 가져오기
	List<String> getAllOrderTimeList(int u_id);
	
	//주문 목록에 있는 하나의 item 정보 가져오기 (상품명, 가격 등)
	Item getOrderItemInfo(int item_id);
	
	//주문 상세정보 가져오기
	List<OrderItemInfos> getAllOrderItemList(@Param("u_id")int u_id, @Param("orderTime")String orderTime);
	
	//주문 목록에 item 추가하기	
	void insertOrderItem(OrderItem orderItem);
	
	//member가 주문한 item 개수 가져오기
	int getOrderItemCnt(int u_id);

	//member가 주문한 item인지 체크
	OrderItem isCheckOrderItem(Map<String, Integer> param);


}
