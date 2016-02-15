package com.shopware.shopwareRestClient.dto.article;

import java.util.Arrays;

import com.shopware.shopwareRestClient.dto.article.Data;

public class ArticleList {

	private Data data[];
	private Boolean success;
	private int total;
	private String message;
    
	public Data[] getData() {
		return data;
	}
	public void setData(Data[] data) {
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ArticleList [data=" + Arrays.toString(data) + ", success=" + success + ", total=" + total + ", message="
				+ message + "]";
	}
}