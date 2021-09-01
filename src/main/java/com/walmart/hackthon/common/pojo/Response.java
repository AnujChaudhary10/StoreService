package com.walmart.hackthon.common.pojo;

import org.springframework.http.HttpStatus;

public class Response<T> {

	private HttpStatus status;

	private T t;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
