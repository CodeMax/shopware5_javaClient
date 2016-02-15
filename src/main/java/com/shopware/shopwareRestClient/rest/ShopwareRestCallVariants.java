package com.shopware.shopwareRestClient.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.Variants;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleVariantsDto;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ShopwareRestCallVariants extends ShopwareRestCall {

	public ShopwareRestCallVariants(String user, String password) {
		super(user, password);
	}

	/**
	 * GET Article by ID/ArticleNumber
	 * @param idParameter
	 * @param isArticleNumber
	 * @return
	 */
	public Variants getArticlevariantsById(String idParameter, boolean isArticleNumber) {
		WebTarget webTarget = null;
		if (isArticleNumber){
			webTarget = client.target(Configuration.getUriToShopware() + "api/variants/" + idParameter + "?useNumberAsId=true&considerTaxInput=true");
		}else{
			webTarget = client.target(Configuration.getUriToShopware() + "api/variants/" + idParameter + "?considerTaxInput=true");
		}
		final Response response = webTarget.request().get();
		
		response.bufferEntity();
		String articleJsonString = response.readEntity(String.class);
		System.out.println(articleJsonString);
		
		return (Variants) new GenericSerializer().deserializer(Variants.class, articleJsonString);
	}
	
	/**
	 * GET Media for a specific Article
	 * @param mediaId
	 * @return
	 */
	public Response getMediaOfArticle(int mediaId){
		final Response response = client.target(Configuration.getUriToShopware() + "api/media/" + mediaId)
										.request().get();
		return response;
	}
	
	/**
	 * POST an Variant-Article
	 * @param postVariable
	 * @return
	 */
	public Response post(PostArticleVariantsDto postVariable) {
		final Response response = client.target(Configuration.getUriToShopware() + "api/variants")
										.request().post(Entity.entity(new GenericSerializer()
										.serializer(postVariable), MediaType.APPLICATION_JSON));
		return response;
	}

	/**
	 * PUT an Variant-Article
	 * @param idParameter
	 * @param isArticleNumber
	 * @param articleDto
	 * @return
	 */
	public Response put(String idParameter, boolean isArticleNumber, PostArticleVariantsDto variantsDto) {

		System.out.println("PutDto before PUT: " + variantsDto.toString());
		WebTarget webTarget = null;
		if (isArticleNumber){
			webTarget = client.target(Configuration.getUriToShopware() + "api/variants/" + idParameter + "?useNumberAsId=true");
		}else{
			webTarget = client.target(Configuration.getUriToShopware() + "api/variants/" + idParameter);
		}
		final Response response = webTarget.request()
										   .put(Entity
										   .entity(new GenericSerializer().serializer(variantsDto), MediaType.APPLICATION_JSON));

		System.out.println("Response of PUT: " + new GenericSerializer().stringifyResponseEntity(response));
		return response;
	}
}