package com.shopware.shopwareRestClient.dto.article.BuySell;

import com.shopware.shopwareRestClient.dto.article.ArticleVariants;

public class PostArticleDto {

	/**
	 * Article name - Required
	 */
	private String name;

	private SellMaindetail mainDetail;
	
	/**
	 * Article-variants
	 */
	private ArticleVariants[] variants;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SellMaindetail getMainDetail() {
		return mainDetail;
	}

	public void setMainDetail(SellMaindetail mainDetail) {
		this.mainDetail = mainDetail;
	}
	
//	public ArticleVariants[] getVariants() {
//		return variants;
//	}
//
//	public void setVariants(ArticleVariants[] variants) {
//		this.variants = variants;
//	}

	@Override
	public String toString() {
		return "SellArticleDto [name=" + name + ", mainDetail=" + mainDetail + "]";
	}
}