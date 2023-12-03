package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.dao.ReplyDao;
import com.spring.mugpet.dao.mybatis.mapper.ReplyMapper;

@Repository
public class MybatisReplyDao implements ReplyDao{
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<Reply> getCommunityReplyList(int com_id) throws DataAccessException{
		return replyMapper.getCommunityReplyList(com_id);
	}
	
	@Override
	public List<Reply> getUsedGoodsReplyList(int g_id) throws DataAccessException{
		return replyMapper.getUsedGoodsReplyList(g_id);
	}
	
	@Override
	public void insertComReply(NewReplyCommand replyCommand) throws DataAccessException{
		replyMapper.insertComReply(replyCommand);
	}
	
	@Override
	@Transactional
	public void insertGoodsReply(NewReplyCommand replyCommand) throws DataAccessException{
		replyMapper.insertGoodsReply(replyCommand);
	}
	
	@Override
	@Transactional
	public void deleteComReply(int rp_id, int com_id) throws DataAccessException{
		replyMapper.deleteComReply(rp_id, com_id);
	}

	@Override
	public void deleteGoodsReply(int rp_id, int g_id) throws DataAccessException{
		replyMapper.deleteGoodsReply(rp_id, g_id);
	}
	
	@Override
	public void deleteComAllReply(int com_id) throws DataAccessException {
		replyMapper.deleteComAllReply(com_id);
	}

	@Override
	public void deleteGoodsAllReply(int g_id) throws DataAccessException {
		replyMapper.deleteGoodsAllReply(g_id);
	}

	@Override
	public int getU_IdByCommunityReply(int com_id, int rp_id) throws DataAccessException {
		return replyMapper.getU_IdByCommunityReply(com_id, rp_id);
	}

	@Override
	public int getU_IdByUsedGoodsReply(int g_id, int rp_id) throws DataAccessException {
		return replyMapper.getU_IdByUsedGoodsReply(g_id, rp_id);
	}
	
	@Override
	public List<Reply> getMyReplyList(int u_id) throws DataAccessException {
		return replyMapper.getMyReplyList(u_id);
	}
	
}