package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

public interface CommunityMapper {
	
	//커뮤니티 전체 글 목록
	List<Community> getComList(); 
	
	//member가 쓴 글 목록
	List<Community> getMemberComList(int u_id);
	
	//글 상세보기
	Community getCom(@Param("com_id") int com_id); 
	
	//커뮤니티 글 추가
	void insertCom(NewCommunityCommand comCommand); 
	
	//커뮤니티 글 수정
	void updateCom(NewCommunityCommand comCommand); 
	
	//커뮤니티 글 삭제
	void deleteCom(int com_id); 
	
	//댓글 수 수정
	void updateReplyCnt(@Param("com_id") int com_id, @Param("amount") int amount);
	
	//게시글작성자의 u_id가져오기
	int getU_IdByCommunity(int com_id);
	
	//좋아요 수 수정
	void updateComLikesCnt(@Param("com_id") int com_id, @Param("amount") int amount);
}

