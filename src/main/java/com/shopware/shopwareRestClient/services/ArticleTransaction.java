package com.shopware.shopwareRestClient.services;

import com.shopware.shopwareRestClient.dto.transaction.ArticleTransactionInfoDto;

public interface ArticleTransaction {

	public ArticleTransactionInfoDto articleTransaction(String codeInput, boolean verkauf);
}
