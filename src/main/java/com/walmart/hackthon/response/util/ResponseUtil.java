package com.walmart.hackthon.response.util;

import org.springframework.http.HttpStatus;

import com.walmart.hackthon.common.pojo.Response;

public class ResponseUtil {

	public static <T> Response<T> createResponse(HttpStatus status, T t) {
		Response<T> r = new Response<>();
		r.setStatus(status);
		r.setT(t);
		return r;
	}

}
