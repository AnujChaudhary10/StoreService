package com.walmart.hackthon.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.promotion.pojo.PromotionDetail;
import com.walmart.hackthon.service.StorePromotionMatcherServiceImpl;
import com.walmart.hackthon.store.pojo.StoreDetail;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {
	@Autowired
	StorePromotionMatcherServiceImpl impl;

	@GetMapping(value = "/{storeId}/{promotionId}")
	public Response<String> addPromotionToStore(@PathVariable String storeId, @PathVariable String promotionId) {
		return impl.addPromotionsToStore(storeId, promotionId);
	}
	
	@GetMapping(value = "allPromotion/{storeId}")
	public Response<Set<PromotionDetail>>  getAllPromotionForStore(@PathVariable String storeId) {
		return impl.getPromotionsForStoreId(storeId);
	}
	
	@GetMapping(value = "allStore/{promotionId}")
	public Response<Set<StoreDetail>>   getAllStoreForPromotion(@PathVariable String promotionId) {
		return impl.getStoreForPromotionId(promotionId);
	}

}
