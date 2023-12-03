package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.Item;

public interface ItemMapper {
	
	//하나의 item정보 가져오기
	Item getItem(@Param("item_id") int item_id);
	
	//필터링한 item목록 가져오기
	List<Item> getFilterItemList(Map<String, Object> param);
	
	//필터링한 item목록 정렬하기
	List<Item> orderByFiltering(Map<String, Object> param);
	
	//카테고리별 item 정렬하기
	List<Item> orderByItem(@Param("spe_id")int spe_id, @Param("category_id")int category_id, @Param("stand")String stand, @Param("od")String od);
}
