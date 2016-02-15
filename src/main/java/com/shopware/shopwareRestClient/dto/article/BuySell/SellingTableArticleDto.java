package com.shopware.shopwareRestClient.dto.article.BuySell;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SellingTableArticleDto {
	public SimpleIntegerProperty sellCounter = new SimpleIntegerProperty();
    public SimpleStringProperty sellEan = new SimpleStringProperty();
	
	public Integer getSellCounter() {
		return sellCounter.get();
	}
	public String getSellEan() {
		return sellEan.get();
	}
}