package com.shopware.shopwareRestClient.services;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.Article;
import com.shopware.shopwareRestClient.dto.article.ArticleVariants;
import com.shopware.shopwareRestClient.dto.transaction.ArticleTransactionInfoDto;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallArticle;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallVariants;

public class ArticleTransactionImpl implements ArticleTransaction {

	ShopwareRestCallArticle articleCaller;
	ShopwareRestCallVariants variantsCaller;
	ArticleTransactionService articleController;
	ArticleTransactionInfoDto dto;
	
	public ArticleTransactionImpl(){
		Configuration config = new Configuration();
		articleController = new ArticleTransactionService();
		articleCaller = new ShopwareRestCallArticle(config.getLoginData().get("user"), config.getLoginData().get("password"));
		variantsCaller = new ShopwareRestCallVariants(config.getLoginData().get("user"), config.getLoginData().get("password"));
	}
	

	public ArticleTransactionInfoDto articleTransaction(String codeInput, boolean verkauf) {
		if(!codeInput.isEmpty()){
			Article article = articleCaller.getArticleById(codeInput, true);
			if(!new QualityGate().articleQualityCheck(article)){
				dto.setStatus(1500);
				dto.setError("Der Artikel ist fehlerhaft angelegt! "
						+ "Bitte Artikelnummer und EAN-Nummer sowie die anderen Daten prüfen");
			}
			if(article.getSuccess()){
				dto = doTransaction(codeInput, verkauf, article);
			}else{
				dto.setStatus(1401);
				dto.setError("Der Arikel konnte leider nicht richtig gelesen werden. Bitte versuchen Sie es erneut");
			}
		}else{
			dto.setStatus(1400);
			dto.setError("Der eingegebene Code ist leider leer oder wurde nicht angenommen.");
		}
		return dto;
	}
	
	
	/**
	 * 
	 * @param codeInput
	 * @param isSell
	 * @param article
	 * @return
	 */
	private ArticleTransactionInfoDto doTransaction(String codeInput, boolean isSell, Article article){
		boolean isVariant = false;
		
		for(ArticleVariants variants : article.getData().getDetails()){
			if(codeInput.equals(variants.getEan())){
				isVariant = true;
				article = articleController.updateVariants(codeInput, article, isSell);
				dto = articleController.sendVariants(codeInput, variants, isVariant, article);
			}
		}
		
		if(!isVariant){
			if(codeInput.equals(article.getData().getMainDetail().getNumber()) || codeInput.equals(article.getData().getMainDetail().getEan())){
				articleController.updateArticles(codeInput, article, isSell);
				dto = articleController.sendArticle(codeInput, article, isVariant);
			}
		}
		return dto;
	}
}