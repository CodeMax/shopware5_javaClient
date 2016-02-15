package MBMShopware.ShopwareRestClient.Rest;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleDto;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallArticle;
import com.shopware.shopwareRestClient.dto.article.Article;
import com.shopware.shopwareRestClient.dto.article.ArticleList;
import com.shopware.shopwareRestClient.dto.article.Category;
import com.shopware.shopwareRestClient.dto.article.Maindetail;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class ShopwareRestCallArticleTest {

	PostArticleDto postArticle;
	ShopwareRestCallArticle caller;
	final Client client = ClientBuilder.newClient();	
	private Map<String, String> loginData;
	
	@Before
	public void config(){
		Configuration config = null;
		config = new Configuration();
		loginData = config.getLoginData();
		caller = new ShopwareRestCallArticle(loginData.get("user"), loginData.get("password"));
		
		//generiere Price-Dto		
/*		Price price = new Price();
		price.setPrice(15);
		price.setBasePrice(7);
		price.setPseudoPrice(20);
		Price[] prices = new Price[1];
		prices[0] = price;*/
		
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
		
		//generiere Category-Dto
		Category category = new Category();
		category.setId(1);
		category.setName("testcategory");
		Category[] categoryList = new Category[1];
		categoryList[0] = category;

//		Image image = new Image();
//		image.se
		
		postArticle = new PostArticleDto();
//		postArticle.setActive(true);
		postArticle.setName("Testartikel 3");
//		postArticle.setMainDetail(mainDetail);
//		postArticle.setSupplierId(11);
//		postArticle.setTaxId(1);
//		postArticle.setDescriptionLong("long Description");
//
//		postArticle.setMetaTitle("Testtitle");
//		postArticle.setDescription("normal Description");
//		postArticle.setKeywords("keyword1, keyword2, keyword3");
//		
//		postArticle.setCategories(categoryList);
//		postArticle.setLastStock(true);
//		postArticle.setImages(images);
	}

	@Test
	public void getArticleByIdTest(){
		Article article = caller.getArticleById("1", false);
		System.out.println(article.toString());
	}

	@Test
	public void getArticleByArticlenumberTest(){
		Article article = caller.getArticleById("4014366161219", true);
		System.out.println(article.toString());
	}
	
	@Test
	public void getArticleListTest(){
		String language = "";
		ArticleList article = caller.getArticleList(language);
		
		System.out.println(article.toString());
	}
	
	@Test
	public void setArticleTest(){
		Response postResponse = caller.post(postArticle);
		String output = new GenericSerializer().stringifyResponseEntity(postResponse);
		System.out.println(output);
	}

//	@Test
//	public void updateArticleTest(){
//		Response putResponse = caller.put("3", false, postArticle);
//		String output = new GenericSerializer().stringifyResponseEntity(putResponse);
//		System.out.println(output);
//	}
}