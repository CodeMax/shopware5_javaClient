package com.shopware.shopwareRestClient.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.Article;
import com.shopware.shopwareRestClient.dto.article.ArticleList;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleDto;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ShopwareRestCallArticle extends ShopwareRestCall {

	public ShopwareRestCallArticle(String user, String password) {
		super(user, password);
	}

	/**
	 * GET Article by ID/ArticleNumber
	 * @param idParameter
	 * @param isArticleNumber
	 * @return
	 */
	public Article getArticleById(String idParameter, boolean isArticleNumber) {
		WebTarget webTarget = null;
		if (isArticleNumber){
			webTarget = client.target(Configuration.getUriToShopware() + "api/articles/" + idParameter + "?useNumberAsId=true&considerTaxInput=true");
		}else{
			webTarget = client.target(Configuration.getUriToShopware() + "api/articles/" + idParameter + "?considerTaxInput=true");
		}
		final Response response = webTarget.request().get();
		
		response.bufferEntity();
		String articleJsonString = response.readEntity(String.class);
		System.out.println(articleJsonString);
		
		return (Article) new GenericSerializer().deserializer(Article.class, articleJsonString);
	}
	
	/**
	 * GET List of all Articles
	 * @param language - desides which language is requested. Send empty String, if specific language is not requested.
	 * @return
	 */
	public ArticleList getArticleList(String language) {
		final Response response;
		if(language.equals("")){
			response = client.target(Configuration.getUriToShopware() + "api/articles").request().get();
		}else{
			response = client.target(Configuration.getUriToShopware() + "api/articles/language=" + language).request().get();
		}
		response.bufferEntity();
		String articleJsonString = response.readEntity(String.class);
		return (ArticleList) new GenericSerializer().deserializer(ArticleList.class, articleJsonString);
	}
	
	/**
	 * POST an Article-Entity
	 * @param articleDto
	 * @return
	 */
	public Response post(PostArticleDto articleDto) {
		final Response response = client.target(Configuration.getUriToShopware() + "api/articles")
										.request().post(Entity.entity(new GenericSerializer()
										.serializer(articleDto), MediaType.APPLICATION_JSON));
		return response;
	}

	public Response put(String idParameter, boolean isArticleNumber, PostArticleDto articleDto) {

		System.out.println("PutDto before PUT: " + articleDto.toString());
		WebTarget webTarget = null;
		if (isArticleNumber){
			webTarget = client.target(Configuration.getUriToShopware() + "api/articles/" + idParameter + "?useNumberAsId=true");
		}else{
			webTarget = client.target(Configuration.getUriToShopware() + "api/articles/" + idParameter);
		}
		final Response response = webTarget.request()
										   .put(Entity
										   .entity(new GenericSerializer().serializer(articleDto), MediaType.APPLICATION_JSON));

		System.out.println("Response of PUT: " + new GenericSerializer().stringifyResponseEntity(response));
		return response;
	}
}