package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

public interface CartMapper {
	
	//Cart가 존재하는지 확인
	Integer isCart(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//Cart 목록 리스트 형태로 가져오기 (장바구니는 하나)
	List<Cart> getMyCartList(int u_id);
	
	//Cart 목록에 있는 카트 필드 정보 가져오기
	int getMyCartItemQty(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//Cart 목록에 있는 하나의 item 정보 가져오기 (상품명, 가격 등)
	Item getCartItemInfo(int item_id);
	
	//Cart 목록에 있는 하나의 item 정보를 Cart 타입으로 가져오기
	Cart getMyCartItemCartType(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//Cart 목록에 item 추가하기
	void addCart(Cart cart);

	//Cart 목록에 item 정보 수정하기
	void updateCart(@Param("cartQty")int cartQty, @Param("item_id")int item_id, @Param("u_id")int u_id);

	//Cart 목록에 item 삭제하기
	void removeCart(@Param("item_id")int item_id, @Param("u_id")int u_id);
	
	//Cart 목록의 모든 item 삭제하기
	void removeCartAll(int u_id);
}