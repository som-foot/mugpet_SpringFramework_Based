package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.dao.UsedGoodsDao;
import com.spring.mugpet.dao.mybatis.mapper.UsedGoodsMapper;
import com.spring.mugpet.domain.UsedGoods;

@Repository
public class MybatisUsedGoodsDao implements UsedGoodsDao{
	
	@Autowired
	private UsedGoodsMapper goodsMapper;
	
	@Override
	public List<UsedGoods> getUsedGoodsList() throws DataAccessException{
		return goodsMapper.getUsedGoodsList();
	}

	@Override
	public List<UsedGoods> getMemberUsedGoodsList(int u_id) throws DataAccessException{
		return goodsMapper.getMemberUsedGoodsList(u_id);
	}

	@Override
	public UsedGoods getUsedGoods(int g_id) throws DataAccessException{
		return goodsMapper.getUsedGoods(g_id);
	}

	@Override
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException{
		goodsMapper.insertUsedGoods(goodsCommand);
	}

	@Override
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException{
		goodsMapper.updateUsedGoods(goodsCommand);
	}

	@Override
	public void deleteUsedGoods(int g_id) throws DataAccessException{
		goodsMapper.deleteUsedGoods(g_id);
	}

	@Override
	public void updateGoodsReplyCnt(int g_id, int amount) {
		goodsMapper.updateGoodsReplyCnt(g_id, amount);
	}

	@Override
	public int getU_IdByUsedGoods(int g_id) {
		return goodsMapper.getU_IdByUsedGoods(g_id);
	}

	@Override
	public void updateGoodsLikesCnt(int g_id, int amount) {
		goodsMapper.updateGoodsLikesCnt(g_id, amount);
	}

	@Override
	public int getUsedGoodsCntByU_id(int u_id) {
		return goodsMapper.getUsedGoodsCntByU_id(u_id);
	}

}
