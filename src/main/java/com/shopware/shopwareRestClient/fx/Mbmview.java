package com.shopware.shopwareRestClient.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mbmview extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Mbmview.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.alwaysOnTopProperty();
		primaryStage.minHeightProperty().setValue(640);
		primaryStage.minWidthProperty().setValue(930);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
