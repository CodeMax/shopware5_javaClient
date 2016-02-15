package com.shopware.shopwareRestClient.dto.article.BuySell;


public class SellMaindetail {

	public int id;
	/**
	 * Article Number (EAN for ScannerManager)
	 */
	public String number;
	
	public int inStock;
	public String ean;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	@Override
	public String toString() {
		return "MinimalPostMaindetail [id=" + id + ", number=" + number + ", inStock=" + inStock + ", ean=" + ean + "]";
	}
}