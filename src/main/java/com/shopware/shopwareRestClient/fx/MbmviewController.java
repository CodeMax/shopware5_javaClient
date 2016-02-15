package com.shopware.shopwareRestClient.fx;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shopware.shopwareRestClient.dto.article.BuySell.BuyingTableArticleDto;
import com.shopware.shopwareRestClient.dto.article.BuySell.SellingTableArticleDto;
import com.shopware.shopwareRestClient.dto.transaction.ArticleTransactionInfoDto;
import com.shopware.shopwareRestClient.services.ArticleTransactionImpl;
import com.shopware.shopwareRestClient.services.ArticleTransaction;
import com.shopware.shopwareRestClient.util.SoundNotifier;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MbmviewController	implements Initializable {
	
	Logger log = LoggerFactory.getLogger(MbmviewController.class);
	
    ObservableList<SellingTableArticleDto> sell_data;
    ObservableList<BuyingTableArticleDto> buy_data;
    
	@FXML private ImageView productImageView_sell;
	@FXML private ImageView productImageView_buy;
	
	@FXML private Label statusField_sell;
	@FXML private Label articleNameField_sell;
	@FXML private Label articleStockField_sell;
	@FXML private Label sellingPriceField_sell;
	@FXML private Label eanField_sell;
	@FXML private Label longDescriptionField_sell;
//	@FXML private Label articleShoplinkField_sell;

	@FXML private Label statusField_buy;
	@FXML private Label articleNameField_buy;
	@FXML private Label articleStockField_buy;
	@FXML private Label sellingPriceField_buy;
	@FXML private Label eanField_buy;
	@FXML private Label longDescriptionField_buy;
//	@FXML private Hyperlink articleShoplinkField_buy;
	
	@FXML private TextField codeField_sell;
	@FXML private TextField codeField_buy;
	
	@FXML private TableView<SellingTableArticleDto> sellTable;
	@FXML private TableColumn<SellingTableArticleDto, Integer> sellTableCounterField;
    @FXML private TableColumn<SellingTableArticleDto, String> sellTableEanField;
    
	@FXML private TableView<BuyingTableArticleDto> buyTable;
	@FXML private TableColumn<BuyingTableArticleDto, Integer> buyTableCounterField;
    @FXML private TableColumn<BuyingTableArticleDto, String> buyTableEanField;

    @FXML private VBox contentView_sell;
    @FXML private VBox contentView_buy;
    

	/**
	 * initialize DataTable
	 */
	public void initialize(URL location, ResourceBundle resources) {
		sellTableCounterField.setCellValueFactory(new PropertyValueFactory<SellingTableArticleDto,Integer>("sellCounter"));
		sellTableEanField.setCellValueFactory(new PropertyValueFactory<SellingTableArticleDto,String>("sellEan"));
		
		buyTableCounterField.setCellValueFactory(new PropertyValueFactory<BuyingTableArticleDto,Integer>("buyCounter"));
		buyTableEanField.setCellValueFactory(new PropertyValueFactory<BuyingTableArticleDto,String>("buyEan"));
		
		sell_data = FXCollections.observableArrayList();
		buy_data = FXCollections.observableArrayList();
		
        sellTable.setItems(sell_data);
        buyTable.setItems(buy_data);
	}
	
	@FXML
    public void handleSellInputFocus(){
        codeField_sell.requestFocus();
    }
	
	@FXML
    public void handleBuyInputFocus(){
        codeField_buy.requestFocus();
    }
	
//	@FXML
//	public void browseToArticle(){
//		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
//		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
//			try {
////				desktop.browse(uri);
//		    } catch (Exception e) {
//		    	e.printStackTrace();
//		    }
//		}
//	}
	
	@FXML
	public void handleSellingCodeEnter(KeyEvent event){
	    if (event.getCode() == KeyCode.ENTER) {
	    	final String enteredCode = codeField_sell.getText();
	    	
	    	resetSellMaskCleaner();
	    	
	    	Thread thread = new Thread() {
	    	    public void run() {
	    	    	ArticleTransaction transaction = new ArticleTransactionImpl();
	    	    	final ArticleTransactionInfoDto infoDto = transaction.articleTransaction(enteredCode, true);
	    	    	
	    	    	Platform.runLater(new Runnable(){
						public void run() {
							if(infoDto.getStatus() == 200){
					    		statusField_sell.setText("Erfolgreich verkauft: " + enteredCode);
						    	System.out.println(infoDto.toString());
						    	
						    	articleNameField_sell.setText(infoDto.getArticleName());;
						    	articleStockField_sell.setText(Integer.toString(infoDto.getArticleStock()) + " Stück");
						    	sellingPriceField_sell.setText(Integer.toString(infoDto.getSellingPrice()) + " €");
						    	eanField_sell.setText("EAN: " + infoDto.getEan());
						    	longDescriptionField_sell.setText(infoDto.getLongDescription());;
						    	productImageView_sell.setImage(new Image(infoDto.getImageUrl()));
//						    	articleShoplinkField_sell.setText("zum Artikel im Shop");
						    	
						    	
						    	//START: Fill Data-Table
						    	SellingTableArticleDto sellingTableArticleDto = new SellingTableArticleDto();
						    	
						    	boolean matching = false;
						    	int stadCounter = 1;
						    	for (SellingTableArticleDto stad : sell_data){
						    		if(stad.getSellEan().equals(infoDto.getEan())){
						    			stadCounter = stad.getSellCounter() + 1;
						    			sell_data.remove(stad);
						    			break;
						    		}
						    	}
						    	
						    	if(matching == false){
							    	sellingTableArticleDto.sellCounter.setValue(stadCounter);
							    	sellingTableArticleDto.sellEan.setValue(infoDto.getEan());
						    	}
						        sell_data.add(sellingTableArticleDto);
						    	//END: Fill Data-Table
						        
						        sellTable.getColumns().get(0).setVisible(false);
						        sellTable.getColumns().get(0).setVisible(true);
					    	}else{
						    	contentView_sell.setStyle("-fx-background-color:#FF0000;");
						    	productImageView_sell.setImage(null);
						    	
						    	if(infoDto.getStatus() == 400){
						    		statusField_sell.setText("Etwas ist schief gelaufen! Es wurde kein Artikel zu dem Barcode gefunden! Bitte Anleitung befolgen..");
						    		statusField_sell.setTextFill(Color.web("#ffffff"));
						    		statusField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
						    		articleNameField_sell.setText("1. Noch einmal probieren.");
						    		articleNameField_sell.setTextFill(Color.web("#ffffff"));
						    		articleNameField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		articleStockField_sell.setText("2. Bitte prüfen, ob der Artikel im Shop die richtige EAN-Nummer besitzt.");
						    		articleStockField_sell.setTextFill(Color.web("#ffffff"));
						    		articleStockField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		sellingPriceField_sell.setText("3. Bitte prüfen, ob die Artikelnummer ebenfalls die identische EAN-Nummer enthält.");
						    		sellingPriceField_sell.setTextFill(Color.web("#ffffff"));
						    		sellingPriceField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		eanField_sell.setText("4. Prüfen ob die Internetverbindung steht.");
						    		eanField_sell.setTextFill(Color.web("#ffffff"));
						    		eanField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		longDescriptionField_sell.setText("5. Den Systemadministrator kontaktieren!");
						    		longDescriptionField_sell.setTextFill(Color.web("#ffffff"));
						    		longDescriptionField_sell.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		
						    		//Output sound as Warning
						    		try {
										new SoundNotifier().beepAlarm();
									} catch (InterruptedException e) {
										log.error(e.getMessage());
									}
						    	}
					    	}
						}
	    	    	});
	    	    }  
	    	};
	    	thread.start();
	    }
	}
	
	@FXML
	public void handleBuyingCodeEnter(KeyEvent event){
	    if (event.getCode() == KeyCode.ENTER) {
	    	final String enteredCode = codeField_buy.getText();
	    	
	    	resetBuyMaskCleaner();
	    	
	    	Thread thread = new Thread() {
	    	    public void run() {
	    	    	ArticleTransaction transaction = new ArticleTransactionImpl();
	    	    	final ArticleTransactionInfoDto infoDto = transaction.articleTransaction(enteredCode, false);

	    	    	Platform.runLater(new Runnable(){
						public void run() {
							if(infoDto.getStatus() == 200){
					    		statusField_buy.setText("Erfolgreicher Zugang: " + enteredCode);
						    	System.out.println(infoDto.toString());
						    	
						    	articleNameField_buy.setText(infoDto.getArticleName());;
						    	articleStockField_buy.setText(Integer.toString(infoDto.getArticleStock()) + " Stück");
						    	sellingPriceField_buy.setText(Integer.toString(infoDto.getSellingPrice()) +" €");
						    	eanField_buy.setText("EAN: " + infoDto.getEan());
						    	longDescriptionField_buy.setText(infoDto.getLongDescription());;
						    	productImageView_buy.setImage(new Image(infoDto.getImageUrl()));
//						    	articleShoplinkField_buy.setText("zum Artikel im Shop");
						    	
						    	
						    	//START: Fill Data-Table
						    	BuyingTableArticleDto buyingTableArticleDto = new BuyingTableArticleDto();
						    	
						    	boolean matching = false;
						    	int stadCounter = 1;
						    	for (BuyingTableArticleDto stad : buy_data){
						    		if(stad.getBuyEan().equals(infoDto.getEan())){
						    			stadCounter = stad.getBuyCounter() + 1;
						    			buy_data.remove(stad);
						    			break;
						    		}
						    	}
						    	
						    	if(matching == false){
							    	buyingTableArticleDto.buyCounter.setValue(stadCounter);
							    	buyingTableArticleDto.buyEan.setValue(infoDto.getEan());
						    	}
						        buy_data.add(buyingTableArticleDto);
						    	//END: Fill Data-Table
						        
						        buyTable.getColumns().get(0).setVisible(false);
						        buyTable.getColumns().get(0).setVisible(true);
					    	}else{
						    	contentView_buy.setStyle("-fx-background-color:#FF0000;");
						    	productImageView_buy.setImage(null);
						    	
						    	if(infoDto.getStatus() == 400){
						    		statusField_buy.setText("Etwas ist schief gelaufen! Es wurde kein Artikel zu dem Barcode gefunden! Bitte Anleitung befolgen..");
						    		statusField_buy.setTextFill(Color.web("#ffffff"));
						    		statusField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
						    		articleNameField_buy.setText("1. Noch einmal probieren.");
						    		articleNameField_buy.setTextFill(Color.web("#ffffff"));
						    		articleNameField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		articleStockField_buy.setText("2. Bitte prüfen, ob der Artikel im Shop die richtige EAN-Nummer besitzt.");
						    		articleStockField_buy.setTextFill(Color.web("#ffffff"));
						    		articleStockField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		sellingPriceField_buy.setText("3. Bitte prüfen, ob die Artikelnummer ebenfalls die identische EAN-Nummer enthält.");
						    		sellingPriceField_buy.setTextFill(Color.web("#ffffff"));
						    		sellingPriceField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		eanField_buy.setText("4. Prüfen ob die Internetverbindung steht.");
						    		eanField_buy.setTextFill(Color.web("#ffffff"));
						    		eanField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		longDescriptionField_buy.setText("5. Den Systemadministrator kontaktieren!");
						    		longDescriptionField_buy.setTextFill(Color.web("#ffffff"));
						    		longDescriptionField_buy.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
						    		
						    		//Output sound as Warning
						    		try {
										new SoundNotifier().beepAlarm();
									} catch (InterruptedException e) {
										log.error(e.getMessage());
									}
						    	}
					    	}
						}
	    	    	});
	    	    }  
	    	};
	    	thread.start();
	    }
	}
	
	public void resetSellMaskCleaner(){
    	//Clear Text/Image/Styling
		codeField_sell.setText("");
    	productImageView_sell.setImage(null);
    	statusField_sell.setText("");
		articleNameField_sell.setText("");
		articleStockField_sell.setText("");
		sellingPriceField_sell.setText("");
		eanField_sell.setText("");
		longDescriptionField_sell.setText("");
		
    	//Text-styling
    	statusField_sell.setTextFill(Color.web("#000"));
		articleNameField_sell.setTextFill(Color.web("#000"));
		articleStockField_sell.setTextFill(Color.web("#000"));
		sellingPriceField_sell.setTextFill(Color.web("#000"));
		eanField_sell.setTextFill(Color.web("#000"));
		longDescriptionField_sell.setTextFill(Color.web("#000"));

    	articleNameField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		statusField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		articleStockField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		sellingPriceField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		eanField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		longDescriptionField_sell.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		
		contentView_sell.setStyle("");
	}
	
	public void resetBuyMaskCleaner(){
    	//Clear Text/Image/Styling
		codeField_buy.setText("");
    	productImageView_buy.setImage(null);
    	statusField_buy.setText("");
		articleNameField_buy.setText("");
		articleStockField_buy.setText("");
		sellingPriceField_buy.setText("");
		eanField_buy.setText("");
		longDescriptionField_buy.setText("");
		
    	//Text-styling
    	statusField_buy.setTextFill(Color.web("#000"));
		articleNameField_buy.setTextFill(Color.web("#000"));
		articleStockField_buy.setTextFill(Color.web("#000"));
		sellingPriceField_buy.setTextFill(Color.web("#000"));
		eanField_buy.setTextFill(Color.web("#000"));
		longDescriptionField_buy.setTextFill(Color.web("#000"));

    	articleNameField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		statusField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		articleStockField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		sellingPriceField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		eanField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		longDescriptionField_buy.setFont(Font.font("Verdana", FontWeight.NORMAL, 11));
		
		contentView_buy.setStyle("");
	}
}