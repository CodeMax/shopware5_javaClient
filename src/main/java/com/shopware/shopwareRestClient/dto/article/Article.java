package com.shopware.shopwareRestClient.dto.article;

import com.shopware.shopwareRestClient.dto.article.Data;

public class Article {

    private Data data;
    private Boolean success;
    private String message;
    
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Article [data=" + data + ", success=" + success + "]";
	}
}