package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;

public interface ReplyMapper {
	
	//각 커뮤니티 글에 대한 댓글 목록
	List<Reply> getCommunityReplyList(int com_id);
	
	//각 중고거래 글에 대한 댓글 목록
	List<Reply> getUsedGoodsReplyList(int g_id);
	
	//커뮤니티 글에 댓글 작성
	void insertComReply(NewReplyCommand replyCommand);
	
	//중고거래 글에 댓글 작성
	void insertGoodsReply(NewReplyCommand replyCommand);
	
	//커뮤니티 글에서 댓글 삭제 - 해당 member만 가능
	void deleteComReply(@Param("rp_id") int rp_id, @Param("com_id") int com_id);
	
	//중고거래 글에서 댓글 삭제 - 해당 member만 가능
	void deleteGoodsReply(@Param("rp_id") int rp_id, @Param("g_id") int g_id);
	
	//커뮤니티 글 삭제 시 해당 댓글 전체 삭제
	void deleteComAllReply(int com_id);
	
	//중고거래 글 삭제 시 해당 댓글 전체 삭제
	void deleteGoodsAllReply(int g_id);
	
	//커뮤니티 글의 댓글 작성자 u_id 가져오기
	int getU_IdByCommunityReply(@Param("com_id") int com_id, @Param("rp_id") int rp_id);
	
	//중고거래 글의 댓글 작성자 u_id 가져오기
	int getU_IdByUsedGoodsReply(@Param("g_id") int g_id, @Param("rp_id") int rp_id);
	
	//member가 작성한 댓글목록 가져오기
	public List<Reply> getMyReplyList(int u_id);
	
}