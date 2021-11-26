package com.chat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyController implements Initializable {

	@FXML
	private Button chatButton;

	@FXML
	private TextField textAmu;

	@FXML
	private TableView<Chat> tableView;

	@FXML
	private TableColumn<Chat, String> memo;

	@FXML
	private TableColumn<Chat, String> date;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO (don't really need to do anything here).

		memo.setCellValueFactory(new PropertyValueFactory<>("memo"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableView.setItems(getChat());
//		tableView.getColumns().addAll(user, memo);
	}

	// When user click on myButton
	// this method will be called.

	public void addChat(ActionEvent event) {
		Chat chat = new Chat();
		chat.setUser("이지영");
		chat.setMemo(chat.getUser() + " : " + textAmu.getText());

		tableView.getItems().addAll(chat);
		textAmu.clear();

	}

	// 모든 product
	public ObservableList<Chat> getChat() {
		ObservableList<Chat> chats = FXCollections.observableArrayList();
		return chats;
	}

}