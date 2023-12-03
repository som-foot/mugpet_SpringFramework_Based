package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.dao.CommunityDao;
import com.spring.mugpet.dao.mybatis.mapper.CommunityMapper;
import com.spring.mugpet.domain.Community;

@Repository
public class MybatisCommunityDao implements CommunityDao{
	
	@Autowired
	private CommunityMapper comMapper;
	
	@Override
	public List<Community> getComList() throws DataAccessException{
		return comMapper.getComList();
	}

	@Override
	public List<Community> getMemberComList(int u_id) throws DataAccessException{
		return comMapper.getMemberComList(u_id);
	}

	@Override
	public Community getCom(int com_id) throws DataAccessException{
		return comMapper.getCom(com_id);
	}

	@Override
	public void insertCom(NewCommunityCommand comCommand) throws DataAccessException{
		comMapper.insertCom(comCommand);
	}

	@Override
	public void updateCom(NewCommunityCommand comCommand) throws DataAccessException{
		comMapper.updateCom(comCommand);
	}

	@Override
	public void deleteCom(int com_id) throws DataAccessException{
		comMapper.deleteCom(com_id);
	}

	@Override
	public void updateReplyCnt(int com_id, int amount) {
		comMapper.updateReplyCnt(com_id, amount);
	}

	@Override
	public int getU_IdByCommunity(int com_id) {
		return comMapper.getU_IdByCommunity(com_id);
	}

	@Override
	public void updateComLikesCnt(int com_id, int amount) {
		comMapper.updateComLikesCnt(com_id, amount);
	}	

}