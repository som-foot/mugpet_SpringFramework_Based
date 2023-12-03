package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;

public interface ReplyService {
	public List<Reply> getCommunityReplyList(int com_id);
	
	public List<Reply> getUsedGoodsReplyList(int g_id);
	
	public void insertComReply(NewReplyCommand replyCommand);
	
	public void insertGoodsReply(NewReplyCommand replyCommand);
	
	public void deleteComReply(int rp_id, int com_id);
	
	public void deleteGoodsReply(int rp_id, int g_id);
	
	public void deleteComAllReply(int com_id);
	
	public void deleteGoodsAllReply(int g_id);
	
	public int getU_IdByCommunityReply(int com_id, int rp_id);
	
	public int getU_IdByUsedGoodsReply(int g_id, int rp_id);
	
	public List<Reply> getMyReplyList(int u_id);
}