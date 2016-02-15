package com.shopware.shopwareRestClient.services;

import com.shopware.shopwareRestClient.dto.article.Article;

public class QualityGate {

	public boolean articleQualityCheck(Article article){
		
		boolean isOk = false;
		
		isOk = checkArticlenumberEqualsEAN(article);
		isOk = checkLengthEAN(article);
		
		
		return isOk;
	}

	/**
	 * Check if Length of EAN-Number equals 8 or 13
	 * @param article
	 * @return
	 */
	private boolean checkLengthEAN(Article article) {
		int eanLenght = article.getData().getMainDetail().getEan().length();
		return eanLenght == 8 || eanLenght == 13;
	}

	/**
	 * Check if Articlenumber equal to EAN-Number
	 * @param article
	 * @param isOk
	 * @return
	 */
	private boolean checkArticlenumberEqualsEAN(Article article) {
		return article.getData().getMainDetail().getNumber().equals(article.getData().getMainDetail().getEan());
	}
	
	
}
