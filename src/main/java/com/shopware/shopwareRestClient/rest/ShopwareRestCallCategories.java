package com.shopware.shopwareRestClient.rest;

import javax.ws.rs.core.Response;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.categories.Categories;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ShopwareRestCallCategories extends ShopwareRestCall {

	public ShopwareRestCallCategories(String user, String password) {
		super(user, password);
	}

	public Categories getJsonById(String idParameter) {
		final Response response = client.target(Configuration.getUriToShopware() + "api/categories/" + idParameter).request().get();
		response.bufferEntity();
		String categorieJsonString = response.readEntity(String.class);
		
		return (Categories) new GenericSerializer().deserializer(Categories.class, categorieJsonString);
	}

	public Boolean post() {
		return null;
	}

	public Boolean put() {
		return null;
	}

	public Boolean delete() {
		return null;
	}
}