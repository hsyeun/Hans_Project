package com.Possess;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import login.loginuserAct;
import javafx.scene.control.TableColumn;

public class PossessController implements Initializable {

	@FXML
	private Button addBookButton;

	@FXML
	private TableView<PossessInfoVO> tablePossessView;

	@FXML
	private TableColumn<PossessInfoVO, String> possess_name;

	@FXML
	private TableColumn<PossessInfoVO, String> possess_status;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		possess_name.setCellValueFactory(new PropertyValueFactory<>("book_name"));
		possess_status.setCellValueFactory(new PropertyValueFactory<>("status_check"));

		tablePossessView.setItems(getPossessList());

	}

	public void changeview(ActionEvent event) throws Exception {
		Stage stage11 = (Stage) addBookButton.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
		
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Possessinsertview.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<PossessInfoVO> getPossessList() {
		return PossessAct.PossessSelect(loginuserAct.userup());
	}

}
