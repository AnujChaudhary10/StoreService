package com.walmart.hackthon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.hackthon.common.pojo.Response;
import com.walmart.hackthon.dao.StoreDaoImpl;
import com.walmart.hackthon.store.pojo.StoreDetail;

@Service
public class StoreManager {
	@Autowired
	StoreDaoImpl dao;
	
	public StoreDetail getStore(String storeId) {
		return dao.getStorebyId(storeId);
	}
	

	public Response<String> createStore(String id,StoreDetail store) {
		return dao.createStore(store);
	}

}
