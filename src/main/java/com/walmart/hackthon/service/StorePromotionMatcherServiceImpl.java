package com.walmart.hackthon.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.dao.PromotionDaoImpl;
import com.walmart.hackthon.dao.StoreDaoImpl;
import com.walmart.hackthon.dao.StorePromotionDaoImpl;
import com.walmart.hackthon.promotion.pojo.PromotionDetail;
import com.walmart.hackthon.response.util.ResponseUtil;
import com.walmart.hackthon.store.pojo.StoreDetail;

@Service
public class StorePromotionMatcherServiceImpl {
	@Autowired
	StoreDaoImpl storeDao;
	@Autowired
	PromotionDaoImpl promotioDaoImpl;
	@Autowired
	StorePromotionDaoImpl mixDao;

	public Response<Set<PromotionDetail>> getPromotionsForStoreId(String storeId) {
		Set<String> promotionList = mixDao.getAllPromotionForStore(storeId);
		Set<PromotionDetail> promotions = new HashSet<>();
		if (promotionList != null) {

			for (String pid : promotionList) {

				promotions.add(promotioDaoImpl.getPromotionbyId(pid));

			}
		} else {
			return ResponseUtil.createResponse(HttpStatus.BAD_REQUEST, promotions);
		}

		return ResponseUtil.createResponse(HttpStatus.OK, promotions);
	}

	public Response<Set<StoreDetail>> getStoreForPromotionId(String promotionId) {
		Set<String> promotionList = mixDao.getAllStoreForPromotion(promotionId);
		Set<StoreDetail> stores = new HashSet<>();
		if (promotionList != null) {

			for (String pid : promotionList) {
				stores.add(storeDao.getStorebyId(pid));
			}
		} else {
			return ResponseUtil.createResponse(HttpStatus.BAD_REQUEST, stores);
		}

		return ResponseUtil.createResponse(HttpStatus.OK, stores);
	}
	
	public Response<String> addPromotionsToStore(String storeId, String promotionId) {
		return mixDao.addPromotionsToStore(storeId, promotionId);
	}

}
