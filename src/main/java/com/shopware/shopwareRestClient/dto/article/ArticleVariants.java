package com.shopware.shopwareRestClient.dto.article;

import java.util.Arrays;

public class ArticleVariants {

	private String number;	
	private String supplierNumber;	
	private String additionalText;	
	private String weight;	
	private String width;	
	private String len;
	private String height;	
	private String ean;	
	private String purchaseUnit;	
	private String descriptionLong;	
	private String referenceUnit;	
	private String packUnit;	
	private String shippingTime;	
	private Price[] prices;
	private ConfiguratorOption[] configuratorOptions;	
	private Attribute attribute;
	
	/**
	 * 	primary key
	 */
	private int id;	
	
	/**
	 * foreign key for Article
	 */
	private int articleId;
	
	/**
	 * foreign key
	 */
	private int unitId;
	
	private int kind;
	private int inStock;
	private int position;
	private	int minPurchase;
	private int purchaseSteps;
	private int maxPurchase;
	private int releaseDate;
	private boolean active;	
	private boolean shippingFree;
	
	private int stockMin;
	private Image[] images;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getAdditionalText() {
		return additionalText;
	}
	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = len;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}
	public String getReferenceUnit() {
		return referenceUnit;
	}
	public void setReferenceUnit(String referenceUnit) {
		this.referenceUnit = referenceUnit;
	}
	public String getPackUnit() {
		return packUnit;
	}
	public void setPackUnit(String packUnit) {
		this.packUnit = packUnit;
	}
	public String getShippingTime() {
		return shippingTime;
	}
	public void setShippingTime(String shippingTime) {
		this.shippingTime = shippingTime;
	}
	public Price[] getPrices() {
		return prices;
	}
	public void setPrices(Price[] prices) {
		this.prices = prices;
	}
	public ConfiguratorOption[] getConfiguratorOptions() {
		return configuratorOptions;
	}
	public void setConfiguratorOptions(ConfiguratorOption[] configuratorOptions) {
		this.configuratorOptions = configuratorOptions;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
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
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getMinPurchase() {
		return minPurchase;
	}
	public void setMinPurchase(int minPurchase) {
		this.minPurchase = minPurchase;
	}
	public int getPurchaseSteps() {
		return purchaseSteps;
	}
	public void setPurchaseSteps(int purchaseSteps) {
		this.purchaseSteps = purchaseSteps;
	}
	public int getMaxPurchase() {
		return maxPurchase;
	}
	public void setMaxPurchase(int maxPurchase) {
		this.maxPurchase = maxPurchase;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isShippingFree() {
		return shippingFree;
	}
	public void setShippingFree(boolean shippingFree) {
		this.shippingFree = shippingFree;
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
		return "Detail [number=" + number + ", supplierNumber=" + supplierNumber + ", additionalText=" + additionalText
				+ ", weight=" + weight + ", width=" + width + ", len=" + len + ", height=" + height + ", ean=" + ean
				+ ", purchaseUnit=" + purchaseUnit + ", descriptionLong=" + descriptionLong + ", referenceUnit="
				+ referenceUnit + ", packUnit=" + packUnit + ", shippingTime=" + shippingTime + ", prices="
				+ Arrays.toString(prices) + ", configuratorOptions=" + Arrays.toString(configuratorOptions)
				+ ", attribute=" + attribute + ", id=" + id + ", articleId=" + articleId + ", unitId=" + unitId
				+ ", kind=" + kind + ", inStock=" + inStock + ", position=" + position + ", minPurchase=" + minPurchase
				+ ", purchaseSteps=" + purchaseSteps + ", maxPurchase=" + maxPurchase + ", releaseDate=" + releaseDate
				+ ", active=" + active + ", shippingFree=" + shippingFree + ", stockMin=" + stockMin + "]";
	}
}