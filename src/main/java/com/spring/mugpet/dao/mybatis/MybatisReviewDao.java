package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.ReviewDao;
import com.spring.mugpet.dao.mybatis.mapper.ReivewMapper;
import com.spring.mugpet.domain.Review;

@Repository
public class MybatisReviewDao implements ReviewDao {
		
	@Autowired
	private ReivewMapper reviewMapper;

	@Override
	public Review getReview(int r_id) throws DataAccessException {
		return reviewMapper.getReview(r_id);
	}
	
	@Override
	public List<Review> getItemReivewList(int item_id) throws DataAccessException {
		return reviewMapper.getItemReivewList(item_id);
	}

	@Override
	public List<Review> getMyReviewList(int u_id) throws DataAccessException {
		return reviewMapper.getMyReviewList(u_id);
	}

	@Override
	public void insertReview(Review review) throws DataAccessException {
		reviewMapper.insertReview(review);
	}

	@Override
	public void updateReview(Review review) throws DataAccessException {
		reviewMapper.updateReview(review);
	}

	@Override
	public void deleteReview(int r_id) throws DataAccessException {
		reviewMapper.deleteReview(r_id);
	}
	
}
