package com.shopware.shopwareRestClient.dto.article;

public class Price {

	private int id;
	private int articleId;
	private int articleDetailsId;
	private String customerGroupKey;
	private int from;
	private String to;
	private float price;
	private int pseudoPrice;
	private float basePrice;
	private int percent;
	private CustomerGroup customerGroup;
	private float net;
	
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

	public int getArticleDetailsId() {
		return articleDetailsId;
	}

	public void setArticleDetailsId(int articleDetailsId) {
		this.articleDetailsId = articleDetailsId;
	}

	public String getCustomerGroupKey() {
		return customerGroupKey;
	}

	public void setCustomerGroupKey(String customerGroupKey) {
		this.customerGroupKey = customerGroupKey;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPseudoPrice() {
		return pseudoPrice;
	}

	public void setPseudoPrice(int pseudoPrice) {
		this.pseudoPrice = pseudoPrice;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup = customerGroup;
	}
	public float getNet() {
		return net;
	}

	public void setNet(float net) {
		this.net = net;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", articleId=" + articleId + ", articleDetailsId=" + articleDetailsId
				+ ", customerGroupKey=" + customerGroupKey + ", from=" + from + ", to=" + to + ", price=" + price
				+ ", pseudoPrice=" + pseudoPrice + ", basePrice=" + basePrice + ", percent=" + percent
				+ ", customerGroup=" + customerGroup + ", net=" + net + "]";
	}
}