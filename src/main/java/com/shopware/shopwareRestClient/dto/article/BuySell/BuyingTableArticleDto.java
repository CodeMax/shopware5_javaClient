package com.shopware.shopwareRestClient.dto.article.BuySell;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BuyingTableArticleDto {
	public SimpleIntegerProperty buyCounter = new SimpleIntegerProperty();
    public SimpleStringProperty buyEan = new SimpleStringProperty();
	
	public Integer getBuyCounter() {
		return buyCounter.get();
	}
	public String getBuyEan() {
		return buyEan.get();
	}
}