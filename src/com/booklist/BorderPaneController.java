package com.booklist;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class BorderPaneController implements Initializable {
	
	@FXML
	private Button btn1, btn2, btn3, btn4;
	@FXML
	private TextArea myTextField; 
	
	@FXML
	private TableView<BookVO> tableView;
	
	@FXML
	private TableColumn<BookVO, String> BookList;
	
	public void initialize(URL location, ResourceBundle resources) {

	       // TODO (don't really need to do anything here).
		BookList.setCellValueFactory(new PropertyValueFactory<>("bookinformation"));
	    
	   }

	public void handlebtn3(ActionEvent event) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("scene3.fxml"));
		Stage window = (Stage)btn3.getScene().getWindow();
		window.setScene(new Scene(root,700,350));
		
	}
	public void handlebtn2(ActionEvent event) throws Exception {
		Parent root1= FXMLLoader.load(getClass().getResource("scene2.fxml"));
		Stage window = (Stage)btn2.getScene().getWindow();
		window.setScene(new Scene(root1,700,350));
		
	}
    public void handlebtn1(ActionEvent event) throws Exception {
		Parent root2= FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Stage window = (Stage)btn1.getScene().getWindow();
		window.setScene(new Scene(root2,700,350));
		
	}
    
    public ObservableList<BookVO> getbook() throws Exception{
    	return BookDAO.getBookVO(myTextField.getText());
    }
    
    public void select() throws Exception {
    	tableView.setItems(getbook());
    }
   
}
