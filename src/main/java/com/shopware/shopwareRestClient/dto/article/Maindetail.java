package com.shopware.shopwareRestClient.dto.article;

import java.util.Arrays;

public class Maindetail {

	private int id;
	private int articleId;
	private int unitId;
	
	/**
	 * Article Number (EAN for ScannerManager)
	 */
	private String number;
	
	private String supplierNumber;
	private int kind;
	private String additionalText;
	private boolean active;
	private int inStock;
	private int stockMin;
	private String weight;
	private Object width;
	private Object len;
	private Object height;
	private String ean;
	private int position;
	private int minPurchase;
	private Object purchaseSteps;
	private Object maxPurchase;
	private String purchaseUnit;
	private Object referenceUnit;
	private String packUnit;
	private Boolean shippingFree;
	private Object releaseDate;
	private String shippingTime;
	private Price[] prices;
	private Attribute attribute;
	private Object[] configuratorOptions;

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

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getAdditionalText() {
		return additionalText;
	}

	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Object getWidth() {
		return width;
	}

	public void setWidth(Object width) {
		this.width = width;
	}

	public Object getLen() {
		return len;
	}

	public void setLen(Object len) {
		this.len = len;
	}

	public Object getHeight() {
		return height;
	}

	public void setHeight(Object height) {
		this.height = height;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
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

	public Object getPurchaseSteps() {
		return purchaseSteps;
	}

	public void setPurchaseSteps(Object purchaseSteps) {
		this.purchaseSteps = purchaseSteps;
	}

	public Object getMaxPurchase() {
		return maxPurchase;
	}

	public void setMaxPurchase(Object maxPurchase) {
		this.maxPurchase = maxPurchase;
	}

	public String getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public Object getReferenceUnit() {
		return referenceUnit;
	}

	public void setReferenceUnit(Object referenceUnit) {
		this.referenceUnit = referenceUnit;
	}

	public String getPackUnit() {
		return packUnit;
	}

	public void setPackUnit(String packUnit) {
		this.packUnit = packUnit;
	}

	public Boolean getShippingFree() {
		return shippingFree;
	}

	public void setShippingFree(Boolean shippingFree) {
		this.shippingFree = shippingFree;
	}

	public Object getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Object releaseDate) {
		this.releaseDate = releaseDate;
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

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Object[] getConfiguratorOptions() {
		return configuratorOptions;
	}

	public void setConfiguratorOptions(Object[] configuratorOptions) {
		this.configuratorOptions = configuratorOptions;
	}

	@Override
	public String toString() {
		return "Maindetail [id=" + id + ", articleId=" + articleId + ", unitId=" + unitId + ", number=" + number
				+ ", supplierNumber=" + supplierNumber + ", kind=" + kind + ", additionalText=" + additionalText
				+ ", active=" + active + ", inStock=" + inStock + ", stockMin=" + stockMin + ", weight=" + weight
				+ ", width=" + width + ", len=" + len + ", height=" + height + ", ean=" + ean + ", position=" + position
				+ ", minPurchase=" + minPurchase + ", purchaseSteps=" + purchaseSteps + ", maxPurchase=" + maxPurchase
				+ ", purchaseUnit=" + purchaseUnit + ", referenceUnit=" + referenceUnit + ", packUnit=" + packUnit
				+ ", shippingFree=" + shippingFree + ", releaseDate=" + releaseDate + ", shippingTime=" + shippingTime
				+ ", prices=" + Arrays.toString(prices) + ", attribute=" + attribute + ", configuratorOptions="
				+ Arrays.toString(configuratorOptions) + "]";
	}
}