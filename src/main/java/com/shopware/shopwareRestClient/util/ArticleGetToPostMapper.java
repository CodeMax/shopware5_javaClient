package com.shopware.shopwareRestClient.util;

import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleDto;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleVariantsDto;
import com.shopware.shopwareRestClient.dto.article.BuySell.SellMaindetail;
import com.shopware.shopwareRestClient.dto.article.Article;
import com.shopware.shopwareRestClient.dto.article.ArticleVariants;
import com.shopware.shopwareRestClient.dto.article.Data;

public class ArticleGetToPostMapper {

	/**
	 * Map GET-Article-Dto auf POST-Article-Dto
	 * @param article
	 * @return
	 */
	public PostArticleDto postArticleDtoMapper(Article article){
		PostArticleDto putDto = new PostArticleDto();
		
		Data articleData = article.getData();
		
//		putDto.setActive(articleData.getActive());
//		putDto.setAdded(articleData.getAdded());
//		putDto.setAvailableFrom(articleData.getAvailableFrom());
//		putDto.setAvailableTo(articleData.getAvailableTo());
		
		//TODO: STIMMT NICHT ÜBEREIN! IN API-BESCHREIBUNG PRÜFEN!
//		putDto.setCategories(articleData.getCategories());
		
//		putDto.setChanged(articleData.getChanged());
//		putDto.setConfiguratorSet(articleData.getConfiguratorSet());
		
		//TODO: STIMMT NICHT ÜBEREIN! IN API-BESCHREIBUNG PRÜFEN!
//		putDto.setCrossBundleLook(articleData.getCrossBundleLook());
		
//		putDto.setCustomerGroups(articleData.getCustomerGroups());
//		putDto.setDescription(articleData.getDescription());
//		putDto.setDescriptionLong(articleData.getDescriptionLong());
//		putDto.setDownloads(articleData.getDownloads());
//		putDto.setFilterGroupId(articleData.getFilterGroupId());
//		putDto.setHighlight(articleData.getHighlight());
//		putDto.setImages(articleData.getImages());
//		putDto.setKeywords(articleData.getKeywords());
//		putDto.setLastStock(articleData.getLastStock());
		
		SellMaindetail mpmd = new SellMaindetail();
		mpmd.setId(articleData.getMainDetail().getId());
		mpmd.setNumber(articleData.getMainDetail().getNumber());
		mpmd.setInStock(articleData.getMainDetail().getInStock());
		mpmd.setEan(articleData.getMainDetail().getEan());
		putDto.setMainDetail(mpmd);
		
		//Set Prices to null to avoid error!
//		putDto.getMainDetail().setPrices(null);
		
//		putDto.setMetaTitle(articleData.getMetaTitle());
//		putDto.setMode(articleData.getMode());
		putDto.setName(articleData.getName());
//		putDto.setNotification(articleData.getNotification());
//		putDto.setPriceGroupActive(articleData.getPriceGroupActive());
//		putDto.setPriceGroupId(articleData.getPriceGroupId());
//		putDto.setPropertyValues(articleData.getPropertyValues());
//		putDto.setPseudoSales(articleData.getPseudoSales());
		
		//TODO: STIMMT NICHT ÜBEREIN! IN API-BESCHREIBUNG PRÜFEN!
//		putDto.setRelated(articleData.getRelated());
//		putDto.setSimilar(articleData.getSimilar());

//		putDto.setSupplier(articleData.getSupplier());
//		putDto.setSupplierId(articleData.getSupplierId());
//		putDto.setTaxId(articleData.getTaxId());
//		putDto.setTemplate(articleData.getTemplate());

//		putDto.setVariants(articleData.getDetails());
		
		return putDto;
	}

	public PostArticleVariantsDto postArticleVariantsDtoMapper(ArticleVariants variants) {
		PostArticleVariantsDto variantsPostDto = new PostArticleVariantsDto();
		
		variantsPostDto.setId(variants.getId());
		variantsPostDto.setArticleId(variants.getArticleId());
		variantsPostDto.setUnitId(variants.getUnitId());
		variantsPostDto.setInStock(variants.getInStock());
		variantsPostDto.setEan(variants.getEan());
		variantsPostDto.setNumber(variants.getNumber());
		
		return variantsPostDto;
	}
}