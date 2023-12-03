package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;

public interface ReplyDao { 
	
	public List<Reply> getCommunityReplyList(int com_id) throws DataAccessException;
  
	public List<Reply> getUsedGoodsReplyList(int g_id) throws DataAccessException;
	
	public void insertComReply(NewReplyCommand replyCommand) throws DataAccessException;
  
	public void insertGoodsReply(NewReplyCommand replyCommand) throws DataAccessException;
	
	public void deleteComReply(int rp_id, int com_id) throws DataAccessException; 
	
	public void deleteGoodsReply(int rp_id, int g_id) throws DataAccessException;
	
	public void deleteComAllReply(int com_id) throws DataAccessException;
	
	public void deleteGoodsAllReply(int g_id) throws DataAccessException;
	
	public int getU_IdByCommunityReply(int com_id, int rp_id) throws DataAccessException;
	
	public int getU_IdByUsedGoodsReply(int g_id, int rp_id) throws DataAccessException;
	
	public List<Reply> getMyReplyList(int u_id) throws DataAccessException;
	
}