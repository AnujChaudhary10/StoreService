package com.walmart.hackthon.promotion.pojo;

import java.util.Date;

public class PromotionDetail {

	private String Id;
	private String name;
	private String detail;
	private String distcountPercentage;
	private Date validity;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDistcountPercentage() {
		return distcountPercentage;
	}

	public void setDistcountPercentage(String distcountPercentage) {
		this.distcountPercentage = distcountPercentage;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromotionDetail other = (PromotionDetail) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
