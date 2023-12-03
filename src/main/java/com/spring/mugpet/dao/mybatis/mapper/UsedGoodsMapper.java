package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

public interface UsedGoodsMapper {
	
	//전체 중고거래 글 목록
	List<UsedGoods> getUsedGoodsList();
	
	//member가 쓴 중고거래 글 목록
	List<UsedGoods> getMemberUsedGoodsList(int u_id);
	
	//중고거래 글 상세보기 -> 로그인한 id와 u_id가 같으면 수정 가능
	UsedGoods getUsedGoods(@Param("g_id") int g_id);
	
	//중고거래 글 작성
	void insertUsedGoods(NewUsedGoodsCommand goodsCommand);
	
	//중고거래 글 수정
	void updateUsedGoods(NewUsedGoodsCommand goodsCommand);
	
	//중고거래 글 삭제
	void deleteUsedGoods(int g_id);
	
	//댓글 수 수정
	void updateGoodsReplyCnt(@Param("g_id") int g_id, @Param("amount") int amount);
	
	//작성자 u_id 가져오기
	int getU_IdByUsedGoods(int g_id);
	
	//좋아요 수 수정
	void updateGoodsLikesCnt(@Param("g_id") int g_id, @Param("amount") int amount);

	//member가 올린 중고거래 글 개수 가져오기
	int getUsedGoodsCntByU_id(int u_id);
	
}
