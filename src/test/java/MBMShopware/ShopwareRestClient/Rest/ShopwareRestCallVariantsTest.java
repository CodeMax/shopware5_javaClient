package MBMShopware.ShopwareRestClient.Rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.Maindetail;
import com.shopware.shopwareRestClient.dto.article.Variants;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleVariantsDto;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallVariants;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ShopwareRestCallVariantsTest {

	private PostArticleVariantsDto postVariants;
	ShopwareRestCallVariants variantsCaller;
	final Client client = ClientBuilder.newClient();
	
	@Before
	public void config(){
		Configuration config = new Configuration();
		variantsCaller = new ShopwareRestCallVariants(config.getLoginData().get("user"), config.getLoginData().get("password"));
		postVariants = new PostArticleVariantsDto();
		
		//generiere MainDetail-Dto
		Maindetail mainDetail = new Maindetail();
		mainDetail.setActive(true);
		mainDetail.setEan("12345678912345");
		mainDetail.setInStock(100);
		mainDetail.setPackUnit("Gramm");
//		mainDetail.setPrices(prices);
		mainDetail.setShippingFree(false);
		mainDetail.setShippingTime("3");
		mainDetail.setSupplierNumber("supplierNumberTest");
		mainDetail.setWeight("5000");
		mainDetail.setNumber("12345678912345");
		mainDetail.setAdditionalText("additionalText");

		postVariants.setId(11);
	    postVariants.setArticleId(8);
	    postVariants.setUnitId(0);
//	    postVariants.setKind(2);
	    postVariants.setInStock(34);
//	    postVariants.setPosition(0);
//	    postVariants.setMinPurchase(1);
//	    postVariants.setPurchaseSteps(0);
//	    postVariants.setMaxPurchase(0);
//	    postVariants.setReleaseDate(0);
//	    postVariants.setActive(true);
//	    postVariants.setShippingFree(false);
	    postVariants.setStockMin(0);
		
//		postArticle.setActive(true);
//		postVariable.setName("Testartikel 3");
//		postArticle.setMainDetail(mainDetail);
//		postArticle.setSupplierId(11);
//		postArticle.setTaxId(1);
//		postArticle.setDescriptionLong("long Description");
//		postArticle.setMetaTitle("Testtitle");
	}

	@Test
	public void getVariantsByArticlenumberTest(){
		Variants variants = variantsCaller.getArticlevariantsById("4014366152514", true);
		System.out.println(variants.toString());
	}
	
	
	@Test
	public void setArticleTest(){
		Response postResponse = variantsCaller.post(postVariants);
		String output = new GenericSerializer().stringifyResponseEntity(postResponse);
		System.out.println(output);
	}
}