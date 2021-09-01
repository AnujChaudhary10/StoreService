package com.walmart.hackthon.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.walmart.hackthon.common.pojo.Response;

@Repository
public class StorePromotionDaoImpl {
	@Autowired
	StoreDaoImpl storeDao;
	@Autowired
	PromotionDaoImpl promotionDao;

	HashMap<String, Set<String>> storePromotionsdetail = new HashMap<>();

	HashMap<String, Set<String>> promotionsStoreDetail = new HashMap<>();

	public Set<String> getAllPromotionForStore(String id) {
		return storePromotionsdetail.get(id);
	}

	public Set<String> getAllStoreForPromotion(String id) {
		return promotionsStoreDetail.get(id);
	}

	public Response<String> addPromotionsToStore(String storeId, String promotionId) {

		if (storeDao.getStorebyId(storeId) == null) {
			return createResponse(HttpStatus.CONFLICT, " Store is not present");
		}
		if (promotionDao.getPromotionbyId(promotionId) == null) {
			return createResponse(HttpStatus.CONFLICT, " Promotion is not present");
		}

		addPromotionToStore(storeId, promotionId);

		return createResponse(HttpStatus.CREATED, " Promotion is added to store");
	}

	private void addPromotionToStore(String storeId, String promotionId) {

		Set<String> promotions = storePromotionsdetail.get(storeId);
		if (promotions == null) {
			promotions = new HashSet<String>();
			storePromotionsdetail.put(storeId, promotions);
		}
		promotions.add(promotionId);

		Set<String> stores = promotionsStoreDetail.get(promotionId);

		if (stores == null) {
			stores = new HashSet<String>();
			promotionsStoreDetail.put(promotionId, stores);
		}
		stores.add(storeId);

	}

	private Response<String> createResponse(HttpStatus status, String t) {
		Response<String> r = new Response<>();
		r.setStatus(status);
		r.setT(t);
		return r;
	}

}
