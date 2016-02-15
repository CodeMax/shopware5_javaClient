package com.shopware.shopwareRestClient.dto.article.BuySell;

import java.util.Arrays;

import com.shopware.shopwareRestClient.dto.article.Image;

public class PostArticleVariantsDto {
	
	/**
	 * 	primary key
	 */
	private int id;	
	
	/**
	 * foreign keys
	 */
	private int articleId;
	private int unitId;
	
	private String number;	
	private String ean;	
	private int inStock;
	private int stockMin;
	private Image[] images;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public int getStockMin() {
		return stockMin;
	}
	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}
	public Image[] getImages() {
		return images;
	}
	public void setImages(Image[] images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return "PostArticleVariantsDto [id=" + id + ", articleId=" + articleId + ", unitId=" + unitId + ", number="
				+ number + ", ean=" + ean + ", inStock=" + inStock + ", stockMin=" + stockMin + ", images="
				+ Arrays.toString(images) + "]";
	}
}