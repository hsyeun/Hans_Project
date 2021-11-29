package com.Possess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.loginuserAct;

public class PossessinsertController implements Initializable{

	
	@FXML
	private Button insertbutton, exitButton;
	
	@FXML
	private TextField nametext, writertext, pubtext, covertext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void insertinfo(ActionEvent event)  {
		PossessInfoVO posinfo = new PossessInfoVO();
		posinfo.setPossess_holder(loginuserAct.userup());
		posinfo.setBook_name(nametext.getText());
		posinfo.setBook_writer(writertext.getText());
		posinfo.setBook_pub(pubtext.getText());
		posinfo.setPossess_cover(covertext.getText());

		PossessAct.PossessInsert(posinfo);

		nametext.clear();
		writertext.clear();
		pubtext.clear();
		covertext.clear();
	}

	public void exitinsertview(ActionEvent event) {
		Stage stage11 = (Stage) exitButton.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
		
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("possessview.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
