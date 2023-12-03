package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.Item;

public interface WishMapper {
	
	//로그인한 사용자의 위시리스트 가져오기
	List<Item> getMyWishList(@Param("u_id")int u_id);
	
	//위시여부 확인
	Integer isWish(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//위시리스트에 상품추가
	void insertWish(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//위시리스트에서 상품삭제
	void deleteWish(@Param("item_id")int item_id, @Param("u_id")int u_id);

	//위시리스트에 넣은 가장 오래된 아이템 3개만 출력
	List<Item> getMyWishListForMyHome(int u_id);
}
