package com.shopware.shopwareRestClient.dto.transaction;

public class ArticleTransactionInfoDto {

	/**
	 * HTTP-Request status
	 */
	private int status;
	private String error;
	
	/**
	 * Image-URL (path) of GET api/media/mediaId
	 */
	private String imageUrl;
	private String articleName;
	private int articleStock;
	private int sellingPrice;
	private String ean;
	private String longDescription;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public int getArticleStock() {
		return articleStock;
	}
	public void setArticleStock(int articleStock) {
		this.articleStock = articleStock;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "ArticleTransactionInfoDto [status=" + status + ", error=" + error + ", imageUrl=" + imageUrl
				+ ", articleName=" + articleName + ", articleStock=" + articleStock + ", sellingPrice=" + sellingPrice
				+ ", ean=" + ean + ", longDescription=" + longDescription + "]";
	}
}