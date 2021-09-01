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
import com.walmart.hackthon.service.StoreManager;
import com.walmart.hackthon.service.StorePromotionMatcherServiceImpl;
import com.walmart.hackthon.store.pojo.StoreDetail;

@RestController
@RequestMapping(value = "/store")
public class StoreServiceController {

	@Autowired
	StoreManager storeManger;

	@Autowired
	StorePromotionMatcherServiceImpl matcherImpl;

	@GetMapping(value = "/{storeId}")
	public StoreDetail getStoreDetail(@PathVariable String storeId) {
		return storeManger.getStore(storeId);
	}

	@GetMapping(value = "/allPromotions/{storeId}")
	public Response<Set<PromotionDetail>> getAllPromotionsForStore(@PathVariable String storeId) {
		return matcherImpl.getPromotionsForStoreId(storeId);
	}
	
	@PostMapping(value = "/{id}")
	public Response<String> addPromotion(@PathVariable String id, @RequestBody StoreDetail store) {
		return storeManger.createStore(id, store);
	}

}
