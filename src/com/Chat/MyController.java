package com.Chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
//import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.loginuserAct;

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
		chat.setChat_writer(loginuserAct.userup());
		chat.setChat_text(textAmu.getText());
		chat.setPossess_code(loginuserAct.pos_code_up());

		InsertT1.ChatInsert(chat);
		tableView.getItems().addAll(chat);

		textAmu.clear();

	}

	public ObservableList<ChatVO> getChat() {
		return SelectT1.ChatSelct(loginuserAct.pos_code_up());
	}

	@FXML
	private void showinfo(MouseEvent event) throws IOException {
		if (event.getClickCount() != 2)
			return;

		Stage dialog2 = new Stage(StageStyle.UTILITY);
		dialog2.initModality(Modality.WINDOW_MODAL);
		dialog2.initOwner(chatButton.getScene().getWindow());
		dialog2.setTitle("text");
		Parent parent2 = FXMLLoader.load(getClass().getResource("form2.fxml"));

		Button btnFormCancel = (Button) parent2.lookup("#btnFormCancel2");
		Label label = (Label) parent2.lookup("#TenNameLabel");
//			//label con
//			
		ChatVO chat = tableView.getSelectionModel().getSelectedItem();
		label.setText(chat.getMemo() + " " + chat.getChat_date());

		btnFormCancel.setOnAction(e2 -> dialog2.close());
		Scene scene2 = new Scene(parent2);
		dialog2.setScene(scene2);
		dialog2.setResizable(false);
		dialog2.show();
	}

}