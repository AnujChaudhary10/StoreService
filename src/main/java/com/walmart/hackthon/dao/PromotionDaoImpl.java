package com.walmart.hackthon.dao;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.promotion.pojo.PromotionDetail;
import com.walmart.hackthon.response.util.ResponseUtil;

@Repository
public class PromotionDaoImpl {

	private final HashMap<String, PromotionDetail> promotionMap = new HashMap<>();

	public Collection<PromotionDetail> getPromotions() {
		return promotionMap.values();
	}

	public Response<String> createPromotion(PromotionDetail newPromotion) {
		if (promotionMap.containsKey(newPromotion.getId())) {
			return ResponseUtil.createResponse(HttpStatus.CONFLICT, "Promtion exist for store id");
		}
		promotionMap.put(newPromotion.getId(), newPromotion);

		return ResponseUtil.createResponse(HttpStatus.CREATED, "Promotion created for store id");
	}

	public PromotionDetail getPromotionbyId(String id) {
		return promotionMap.get(id);
	}
}
