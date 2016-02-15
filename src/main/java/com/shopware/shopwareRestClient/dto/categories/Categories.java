package com.shopware.shopwareRestClient.dto.categories;

public class Categories {

	public Data data;
	public Boolean success;
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	@Override
	public String toString() {
		return "Categories [data=" + data + ", success=" + success + "]";
	}	
}