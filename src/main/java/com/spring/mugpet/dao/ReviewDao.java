package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Review;

public interface ReviewDao {
	
	public Review getReview(int r_id) throws DataAccessException;
	
	public List<Review> getItemReivewList(int item_id) throws DataAccessException;
	
	public List<Review> getMyReviewList(int u_id) throws DataAccessException;
	
	public void insertReview(Review review) throws DataAccessException;
	
	public void updateReview(Review review) throws DataAccessException;
	
	public void deleteReview(int r_id) throws DataAccessException;
}
