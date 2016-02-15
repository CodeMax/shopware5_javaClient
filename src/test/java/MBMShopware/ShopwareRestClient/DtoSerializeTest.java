package MBMShopware.ShopwareRestClient;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.shopware.shopwareRestClient.dto.article.BuySell.PostArticleDto;
import com.shopware.shopwareRestClient.dto.categories.Categories;
import com.shopware.shopwareRestClient.dto.article.ArticleList;
import com.shopware.shopwareRestClient.dto.article.Maindetail;
import com.shopware.shopwareRestClient.dto.article.Price;
import com.shopware.shopwareRestClient.util.GenericSerializer;

public class DtoSerializeTest {

	String jsonTestArticle;
	String jsonTestCategories;
	PostArticleDto postArticle;
	
	@Before
	public void preparation(){
		
		jsonTestArticle 	= "{'data':{'id':1,'mainDetailId':1,'supplierId':5,'taxId':1,'priceGroupId':1,'filterGroupId':null,'configuratorSetId':null,'name':'Testartikel','description':'','descriptionLong':'','added':'2015-09-29T00:00:00+0200','active':false,'pseudoSales':0,'highlight':false,'keywords':'','metaTitle':'TestArtikel','changed':'2015-09-29T11:59:23+0200','priceGroupActive':false,'lastStock':false,'crossBundleLook':0,'notification':false,'template':'','mode':0,'availableFrom':null,'availableTo':null,'mainDetail':{'id':1,'articleId':1,'unitId':2,'number':'SW10002','supplierNumber':'','kind':1,'additionalText':'','active':0,'inStock':0,'stockMin':0,'weight':'0.000','width':null,'len':null,'height':null,'ean':'0123456789123','position':0,'minPurchase':1,'purchaseSteps':null,'maxPurchase':null,'purchaseUnit':'100.0000','referenceUnit':null,'packUnit':'','shippingFree':false,'releaseDate':null,'shippingTime':'','prices':[{'id':1,'articleId':1,'articleDetailsId':1,'customerGroupKey':'EK','from':1,'to':'beliebig','price':4.20168067227,'pseudoPrice':0,'basePrice':2.5,'percent':0,'customerGroup':{'id':1,'key':'EK','name':'Shopkunden','tax':true,'taxInput':true,'mode':false,'discount':0,'minimumOrder':10,'minimumOrderSurcharge':5}}],'attribute':{'id':1,'articleId':1,'articleDetailId':1,'attr1':'','attr2':'','attr3':'','attr4':'','attr5':'','attr6':'','attr7':'','attr8':'','attr9':'','attr10':'','attr11':'','attr12':'','attr13':'','attr14':'','attr15':'','attr16':'','attr17':null,'attr18':'','attr19':'','attr20':''},'configuratorOptions':[]},'tax':{'id':1,'tax':'19.00','name':'19%'},'propertyValues':[],'supplier':{'id':5,'name':'Austermann','image':'','link':'','description':'','metaTitle':'','metaDescription':'','metaKeywords':'','changed':'2015-08-20T18:07:03+0200'},'propertyGroup':null,'customerGroups':[],'images':[],'configuratorSet':null,'links':[],'downloads':[],'categories':[],'similar':null,'related':null,'details':[],'seoCategories':[]},'success':true}";
		jsonTestCategories 	= "{'data':{'id':1,'active':true,'name':'Root','position':0,'parentId':null,'childrenCount':'3','articleCount':'0'},'success':true}";
	
		Price price = new Price();
		price.setPrice(15);
		price.setBasePrice(7);
		price.setPseudoPrice(20);
		
		Price[] prices = new Price[15];
		
		Maindetail mainDetail = new Maindetail();
		mainDetail.setActive(true);
		mainDetail.setEan("12345678912345");
		mainDetail.setInStock(100);
		mainDetail.setPackUnit("gram");
		mainDetail.setPrices(prices);
		mainDetail.setShippingFree(false);
		mainDetail.setShippingTime("3");
		mainDetail.setSupplierNumber("supplierNumberTest");
		mainDetail.setWeight("5000");
		
		postArticle = new PostArticleDto();
		postArticle.setName("Testartikel 3");
	}
	
	@Test
	public void testDeserializeArticleString(){
		ArticleList articleObject = (ArticleList) new GenericSerializer().deserializer(ArticleList.class, jsonTestArticle);
		System.out.println(articleObject.toString());
		assertNotNull(articleObject.toString());
	}
	
	@Test
	public void testDeserializeCategoriesString(){
		Categories categoriesObject = (Categories) new GenericSerializer().deserializer(Categories.class, jsonTestCategories);
		System.out.println(categoriesObject.toString());
		assertNotNull(categoriesObject.toString());
	}
	
	@Test
	public void testSerializeArticleObject(){
		String articleString = new GenericSerializer().serializer(postArticle);
		System.out.println(articleString);
	}
}