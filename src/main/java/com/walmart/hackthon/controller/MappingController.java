package com.walmart.hackthon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.service.StorePromotionMatcherServiceImpl;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {
	@Autowired
	StorePromotionMatcherServiceImpl impl;

	@GetMapping(value = "/{storeId}/{promotionId}")
	Response<String> addPromotionToStore(@PathVariable String storeId, @PathVariable String promotionId) {
		return impl.addPromotionsToStore(storeId, promotionId);
	}

}
