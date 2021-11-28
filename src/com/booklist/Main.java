package com.booklist;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {
	

	//@FXML
	//Button btn1, btn2, btn3, btn4;
	
	//@FXML
	//private TextArea myTextField;
	
	@Override
	public void start(Stage primaryStage) {
		try {
        // Read file fxml and draw interface.
        
        Parent root= FXMLLoader.load(getClass().getResource("BorderPaneView.fxml")); 
        //Parent root1= FXMLLoader.load(getClass().getResource("scene3.fxml")); 
        //Parent root2= FXMLLoader.load(getClass().getResource("scene2.fxml"));
        //Parent root3= FXMLLoader.load(getClass().getResource("scene1.fxml"));
        
        Scene scene = new Scene(root);
        
        
        primaryStage.setTitle("AppMain");
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
