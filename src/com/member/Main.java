package com.member;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	//프로그램 시작화면

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/first.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Textbook");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
