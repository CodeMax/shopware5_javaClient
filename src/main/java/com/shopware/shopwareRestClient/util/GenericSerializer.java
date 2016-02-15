package com.shopware.shopwareRestClient.util;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GenericSerializer {

	Logger log = LoggerFactory.getLogger(GenericSerializer.class);
	
	/**
	 * Mapping a Json-String on an object
	 * @param dtoClass
	 * @param jsonString
	 * @return
	 */
	public  Object deserializer(Class<?> dtoClass, String jsonString){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Object object = null;
		try {
			object = mapper.readValue(jsonString, dtoClass);
		} catch (JsonParseException e) {
			log.error(e.getMessage());
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return object;
	}
	
	/**
	 * Generates a Json-String out of an Object 
	 * @param dtoObject
	 * @return
	 */
	public  String serializer(Object dtoObject){
		String jsonString = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonString = mapper.writeValueAsString(dtoObject) ;
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		
		return jsonString;
	}
	
	/**
	 * Generates a String from a HTTP-Response
	 * @param response
	 * @return
	 */
	public String stringifyResponseEntity(Response response){
		response.bufferEntity();
		String responseString = response.readEntity(String.class);
		return responseString;
	}
}
