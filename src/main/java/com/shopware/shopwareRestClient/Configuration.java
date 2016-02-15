package com.shopware.shopwareRestClient;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.configuration.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {

	Logger log = LoggerFactory.getLogger(Configuration.class);
	CompositeConfiguration config;
	
	private static String uriToShopware;
	
	public Configuration(){
		config = new CompositeConfiguration();
		config.addConfiguration(new SystemConfiguration());
		try {
			config.addConfiguration(new PropertiesConfiguration("authenticationData.properties"));
		} catch (ConfigurationException e) {
			log.error(e.getMessage());
		}
		
		uriToShopware = config.getString("uriToShopware");
	}
	
	public Map<String, String> getLoginData(){
		Map<String, String> loginData = new HashMap<String, String>();
		loginData.put("user", config.getString("user"));
		loginData.put("password", config.getString("password"));
		
		return loginData;
	}

	public static String getUriToShopware() {
		return uriToShopware;
	}
}
