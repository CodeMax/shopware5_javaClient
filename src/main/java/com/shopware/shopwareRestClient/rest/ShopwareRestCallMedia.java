package com.shopware.shopwareRestClient.rest;

import javax.ws.rs.core.Response;

import com.shopware.shopwareRestClient.Configuration;

public class ShopwareRestCallMedia extends ShopwareRestCall {

	public ShopwareRestCallMedia(String user, String password) {
		super(user, password);
	}

	/**
	 * GET Media for a specific Article
	 * @param mediaId
	 * @return
	 */
	public Response getMediaOfArticle(int mediaId){
		final Response response = client.target(Configuration.getUriToShopware() + "api/media/" + mediaId).request().get();
		return response;
	}
}
