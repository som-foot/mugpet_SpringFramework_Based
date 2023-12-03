package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

public interface CommunityDao {
	
	public List<Community> getComList() throws DataAccessException;
	
	public List<Community> getMemberComList(int u_id) throws DataAccessException;
	
	public Community getCom(int com_id) throws DataAccessException;
	
	public void insertCom(NewCommunityCommand comCommand) throws DataAccessException;
	
	public void updateCom(NewCommunityCommand comCommand) throws DataAccessException;
	
	public void deleteCom(int com_id) throws DataAccessException;

	public void updateReplyCnt(int com_id, int amount);
	
	public int getU_IdByCommunity(int com_id);
	
	public void updateComLikesCnt(int com_id, int amount);
}

