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
	private TableView<ChatVO> tableView;

	@FXML
	private TableColumn<ChatVO, String> memo;

	@FXML
	private TableColumn<ChatVO, String> date;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO (don't really need to do anything here).

		memo.setCellValueFactory(new PropertyValueFactory<>("memo"));
		date.setCellValueFactory(new PropertyValueFactory<>("chat_date"));
		tableView.setItems(getChat());
	}

	// When user click on myButton
	// this method will be called.

	public void addChat(ActionEvent event) {
		ChatVO chat = new ChatVO();
		chat.setChat_writer(10109);
		chat.setChat_text(textAmu.getText());
		chat.setPossess_code(205);
		
		InsertT1.ChatInsert(chat);
		tableView.getItems().addAll(chat);

		textAmu.clear();

	}

	// 모든 product
	public ObservableList<ChatVO> getChat() {
		return SelectT1.ChatSelct(205);
	}

}