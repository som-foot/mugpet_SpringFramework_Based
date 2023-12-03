package com.spring.mugpet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.controller.item.NewReviewCommand;
import com.spring.mugpet.dao.ReviewDao;

@Service
public class ReviewServiceImpl {

	@Autowired
	private ReviewDao reviewDao;
	
	
//	@Override
//	public void registerReview(NewReviewCommand newReview) {
//		reviewDao.insertReview(newReview);
//		
//	}

}
