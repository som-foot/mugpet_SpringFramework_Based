package com.spring.mugpet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

public interface UsedGoodsService {
	public List<UsedGoods> getUsedGoodsList();
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id);
	
	public UsedGoods getUsedGoods(int g_id);
	
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand, MultipartFile file) throws Exception;
	
	public void insertUsedGoodsWithoutImgFile(NewUsedGoodsCommand goodsCommand);
	
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand, MultipartFile file) throws Exception;
	
	public void updateUsedGoodsWithoutImgFile(NewUsedGoodsCommand goodsCommand);
	
	public void deleteUsedGoods(int g_id);
	
	public int getU_IdByUsedGoods(int g_id);
	
	public void updateGoodsLikesCnt(int g_id, int amount);
	
	public int getUsedGoodsCntByU_id(int u_id);
}
