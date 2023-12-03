package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.dao.CommunityDao;
import com.spring.mugpet.dao.ReplyDao;
import com.spring.mugpet.dao.UsedGoodsDao;
import com.spring.mugpet.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDao replyDAO;
	
	@Autowired
	private CommunityDao comDAO;
	
	@Autowired
	private UsedGoodsDao usedgoodsDAO;
	
	@Override
	public List<Reply> getCommunityReplyList(int com_id) {
		return replyDAO.getCommunityReplyList(com_id);
	}

	@Override
	public List<Reply> getUsedGoodsReplyList(int g_id) {
		return replyDAO.getUsedGoodsReplyList(g_id);
	}

	@Override
	public void insertComReply(NewReplyCommand replyCommand) {
		comDAO.updateReplyCnt(replyCommand.getCom_id(), 1);
		replyDAO.insertComReply(replyCommand);
	}

	@Override
	public void insertGoodsReply(NewReplyCommand replyCommand) {
		usedgoodsDAO.updateGoodsReplyCnt(replyCommand.getG_id(), 1);
		replyDAO.insertGoodsReply(replyCommand);
	}

	@Override
	public void deleteComReply(int rp_id, int com_id) {
		comDAO.updateReplyCnt(com_id, -1);
		replyDAO.deleteComReply(rp_id, com_id);
	}

	@Override
	public void deleteGoodsReply(int rp_id, int g_id) {
		usedgoodsDAO.updateGoodsReplyCnt(g_id, -1);
		replyDAO.deleteGoodsReply(rp_id, g_id);
	}
	
	@Override
	public void deleteComAllReply(int com_id) {
		replyDAO.deleteComAllReply(com_id);
	}

	@Override
	public void deleteGoodsAllReply(int g_id) {
		replyDAO.deleteGoodsAllReply(g_id);
	}

	@Override
	public int getU_IdByCommunityReply(int com_id, int rp_id) {
		return replyDAO.getU_IdByCommunityReply(com_id, rp_id);
	}

	@Override
	public int getU_IdByUsedGoodsReply(int g_id, int rp_id) {
		return replyDAO.getU_IdByUsedGoodsReply(g_id, rp_id);
	}

	@Override
	public List<Reply> getMyReplyList(int u_id) {
		return replyDAO.getMyReplyList(u_id);
	}
}