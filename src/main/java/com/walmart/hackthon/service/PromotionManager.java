package com.walmart.hackthon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.dao.PromotionDaoImpl;
import com.walmart.hackthon.promotion.pojo.PromotionDetail;

@Service
public class PromotionManager {
	@Autowired
	PromotionDaoImpl dao;

	public PromotionDetail getPromotion(String promotionId) {
		return dao.getPromotionbyId(promotionId);
	}
	
	
	public Response<String> createPromotion(String id,PromotionDetail promotion) {
		return dao.createPromotion(promotion);
	}

}
