package com.walmart.hackthon.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.promotion.pojo.PromotionDetail;
import com.walmart.hackthon.service.PromotionManager;
import com.walmart.hackthon.service.StorePromotionMatcherServiceImpl;
import com.walmart.hackthon.store.pojo.StoreDetail;

@RestController
@RequestMapping(value = "/promotions")
public class PromotionController {
	@Autowired
	StorePromotionMatcherServiceImpl matcherImpl;

	@Autowired
	PromotionManager promotionManager;

	@GetMapping(value = "/{promotionId}")
	public Object getPromotion(@PathVariable String promotionId) {
		return matcherImpl.getStoreForPromotionId(promotionId);
	}

	@GetMapping(value = "/allPromotions/{id}")
	public Response<Set<StoreDetail>> getAllStoresForPromotion(@PathVariable String id) {
		return matcherImpl.getStoreForPromotionId(id);
	}
	
	
	@PostMapping(value = "/{id}")
	public Response<String> addPromotion(@PathVariable String id, @RequestBody PromotionDetail promotion) {
		return promotionManager.createPromotion(id, promotion);
	}

}
