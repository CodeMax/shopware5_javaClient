package com.shopware.shopwareRestClient.services;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.Article;
import com.shopware.shopwareRestClient.dto.article.Data;
import com.shopware.shopwareRestClient.dto.article.ArticleVariants;
import com.shopware.shopwareRestClient.dto.article.Image;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleDto;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleVariantsDto;
import com.shopware.shopwareRestClient.dto.media.Media;
import com.shopware.shopwareRestClient.dto.transaction.ArticleTransactionInfoDto;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallArticle;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallMedia;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallVariants;
import com.shopware.shopwareRestClient.util.ArticleGetToPostMapper;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ArticleTransactionService {
	
	Logger log = LoggerFactory.getLogger(ArticleTransactionService.class);
	
	ShopwareRestCallArticle articleCaller;
	ShopwareRestCallVariants variantsCaller;
	ShopwareRestCallMedia mediaCaller;
	
	public ArticleTransactionService(){
		Configuration config = new Configuration();
		articleCaller = new ShopwareRestCallArticle(config.getLoginData().get("user"), config.getLoginData().get("password"));
		variantsCaller = new ShopwareRestCallVariants(config.getLoginData().get("user"), config.getLoginData().get("password"));
		mediaCaller = new ShopwareRestCallMedia(config.getLoginData().get("user"), config.getLoginData().get("password"));
	}
	
	
	/**
	 * Update stock of an Article by ID/EAN
	 * @param codeInput
	 * @param article
	 * @param isSell
	 * @return Article
	 */
	public Article updateArticles(String codeInput, Article article, boolean isSell){
		if(isSell){
			article.getData().getMainDetail().setInStock(article.getData().getMainDetail().getInStock() - 1);
		}else{
			article.getData().getMainDetail().setInStock(article.getData().getMainDetail().getInStock() + 1);
		}
		return article;
	}
	
	
	/**
	 * Update stock of a Variant by ID/EAN
	 * @param codeInput
	 * @param article
	 * @param isSell
	 * @return Article
	 */
	public Article updateVariants(String codeInput, Article article, boolean isSell){
		ArticleVariants[] detailList = article.getData().getDetails();
		
		for(int counter = 0; counter < detailList.length; counter++){
			if(codeInput.equals(detailList[counter].getEan())){
				if(isSell){
					detailList[counter].setInStock(detailList[counter].getInStock() - 1);
				}else{
					detailList[counter].setInStock(detailList[counter].getInStock() + 1);
				}
				break;
			}
		}
		article.getData().setDetails(detailList);
		return article;
	}
	
	
	/**
	 * 
	 * @param codeInput
	 * @param article
	 * @param isVariants
	 * @return ArticleTransactionInfoDto
	 */
	public ArticleTransactionInfoDto sendArticle(String codeInput, Article article, boolean isVariants){
		PostArticleDto putDto = new ArticleGetToPostMapper().postArticleDtoMapper(article);
		Response response = articleCaller.put(codeInput, true, putDto);
		
		return fillArticleInfoDto(article.getData(), putDto, response.getStatus());
	}
	
	
	/**
	 * 
	 * @param codeInput
	 * @param article
	 * @param variants
	 * @param isVariants
	 * @return ArticleTransactionInfoDto
	 */
	public ArticleTransactionInfoDto sendVariants(String codeInput, ArticleVariants variants, boolean isVariants, Article article){
		PostArticleVariantsDto putDto = new ArticleGetToPostMapper().postArticleVariantsDtoMapper(variants);
		Response response = variantsCaller.put(codeInput, true, putDto);
		
		return fillVariantsToInfoDto(variants, article, response.getStatus());
	}


	/**
	 * Fills InfoDto with newest Article-Data for Mask-Output
	 * @param data
	 * @param minimalPostArticleDto
	 * @param status
	 * @return ArticleTransactionInfoDto
	 */
	private ArticleTransactionInfoDto fillArticleInfoDto(Data data, PostArticleDto minimalPostArticleDto, int status){
		ArticleTransactionInfoDto infoDto = new ArticleTransactionInfoDto();
		//get Image Date
		Image[] imageArray = data.getImages();
		if(imageArray != null && imageArray.length > 0){
			//get First Images
			Integer mediaId = imageArray[0].getMediaId();
			if(mediaId != 0){
				Response response = mediaCaller.getMediaOfArticle(mediaId);
				System.out.println(new GenericSerializer().stringifyResponseEntity(response));
				String url = response.readEntity(Media.class).getData().getPath();
				infoDto.setImageUrl(url);
			}
		}else{
			infoDto.setImageUrl(Configuration.getUriToShopware()+"dummyImage.jpg");
		}
		infoDto.setArticleName(data.getName());
		infoDto.setArticleStock(minimalPostArticleDto.getMainDetail().getInStock());
		infoDto.setEan(data.getMainDetail().getEan());
		infoDto.setLongDescription(data.getDescriptionLong());
		infoDto.setSellingPrice(Math.round(data.getMainDetail().getPrices()[0].getPrice()));
		infoDto.setStatus(status);
		
		return infoDto;
	}
	
	
	/**
	 * Fills InfoDto with newest Variants-Data for Mask-Output
	 * @param variants
	 * @param article
	 * @param status
	 * @return ArticleTransactionInfoDto
	 */
	private ArticleTransactionInfoDto fillVariantsToInfoDto(ArticleVariants variants, Article article, int status) {
		ArticleTransactionInfoDto infoDto = new ArticleTransactionInfoDto();
		Integer mediaId = 0;
		
		for(Image articleImage : article.getData().getImages()){
			if(variants.getEan().equals(articleImage.getPath())){
				mediaId = articleImage.getMediaId();
			}
		}
		
		if(mediaId != 0){
			Response response = mediaCaller.getMediaOfArticle(mediaId);
			System.out.println(new GenericSerializer().stringifyResponseEntity(response));
			String url = response.readEntity(Media.class).getData().getPath();
			infoDto.setImageUrl(url);
		}else{
			infoDto.setImageUrl(Configuration.getUriToShopware()+"dummyImage.jpg");
		}
		
		infoDto.setArticleName(article.getData().getName());
		infoDto.setArticleStock(variants.getInStock());
		infoDto.setEan(variants.getEan());
		infoDto.setLongDescription(variants.getDescriptionLong());
		infoDto.setSellingPrice(Math.round(article.getData().getMainDetail().getPrices()[0].getPrice()));
		infoDto.setStatus(status);
		
		return infoDto;
	}
}