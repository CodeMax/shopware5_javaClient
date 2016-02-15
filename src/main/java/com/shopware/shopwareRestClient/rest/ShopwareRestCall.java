package com.shopware.shopwareRestClient.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public abstract class ShopwareRestCall {

	final Client client;
	
	public ShopwareRestCall(String user, String password) {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.digest(user, password);
		client = ClientBuilder.newClient();
		client.register(feature);
	}
	
}
