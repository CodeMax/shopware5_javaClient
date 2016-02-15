package com.shopware.shopwareRestClient.dto.article;

public class Variants {
	private ArticleVariants data;
	private Boolean success;
	
	public ArticleVariants getData() {
		return data;
	}
	public void setData(ArticleVariants data) {
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
		return "Variants [data=" + data + ", success=" + success + "]";
	}
}