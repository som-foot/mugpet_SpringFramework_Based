package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import com.spring.mugpet.domain.Review;

public interface ReivewMapper {
	
	//하나의 리뷰 불러오기
	Review getReview(int r_id);
	
	//각 아이템의 리뷰목록 불러오기
	List<Review> getItemReivewList(int item_id);
	
	//member가 작성한 리뷰목록 불러오기
	List<Review> getMyReviewList(int u_id);
	
	//리뷰 추가(작성)하기
	void insertReview(Review review);
	
	//리뷰 수정하기
	void updateReview(Review review);
	
	//리뷰 삭제하기
	void deleteReview(int r_id);
}
