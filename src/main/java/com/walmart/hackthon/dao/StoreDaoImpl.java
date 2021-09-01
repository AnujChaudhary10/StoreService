package com.walmart.hackthon.dao;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.response.util.ResponseUtil;
import com.walmart.hackthon.store.pojo.StoreDetail;

@Repository
public class StoreDaoImpl {

	private final HashMap<String, StoreDetail> storeMap = new HashMap<>();

	public Collection<StoreDetail> getStores() {
		return storeMap.values();
	}

	public Response<String> createStore(StoreDetail newStore) {
		if (storeMap.containsKey(newStore.getStoreId())) {
			return ResponseUtil.createResponse(HttpStatus.CONFLICT, "Strore exist for store id");
		}
		storeMap.put(newStore.getStoreId(), newStore);

		return ResponseUtil.createResponse(HttpStatus.CREATED, "Store created for store id");
	}

	public StoreDetail getStorebyId(String storeId) {
		return storeMap.get(storeId);
	}

}
