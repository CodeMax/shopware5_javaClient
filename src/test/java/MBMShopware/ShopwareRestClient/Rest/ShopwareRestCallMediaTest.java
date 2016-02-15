package MBMShopware.ShopwareRestClient.Rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.junit.Before;
import org.junit.Test;

import com.shopware.shopwareRestClient.Configuration;
import com.shopware.shopwareRestClient.rest.ShopwareRestCallMedia;

public class ShopwareRestCallMediaTest {

	ShopwareRestCallMedia mediaCaller;
	final Client client = ClientBuilder.newClient();
	
	@Before
	public void config(){
		Configuration config = new Configuration();
		mediaCaller = new ShopwareRestCallMedia(config.getLoginData().get("user"), config.getLoginData().get("password"));
	}
	
	@Test
	public void getMediaOfArticleTest(){
		mediaCaller.getMediaOfArticle(18); //TODO
	}
	
	@Test
	public void getMediaOfVariantsTest(){
		
	}
}
