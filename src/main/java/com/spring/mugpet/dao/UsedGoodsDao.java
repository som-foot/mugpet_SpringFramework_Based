package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

public interface UsedGoodsDao {
	
	public List<UsedGoods> getUsedGoodsList() throws DataAccessException;
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id) throws DataAccessException;
	
	public UsedGoods getUsedGoods(int g_id) throws DataAccessException;
	
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException;
	
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException;
	
	public void deleteUsedGoods(int g_id) throws DataAccessException;
	
	public void updateGoodsReplyCnt(int g_id, int amount);
	
	public int getU_IdByUsedGoods(int g_id);
	
	public void updateGoodsLikesCnt(int g_id, int amount);

	public int getUsedGoodsCntByU_id(int u_id);
	
}