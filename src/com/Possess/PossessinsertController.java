package com.Possess;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import login.loginuserAct;

public class PossessinsertController implements Initializable {

	@FXML
	private Button insertbutton, exitButton;

	@FXML
	private TextField nametext, writertext, pubtext, covertext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void insertinfo(ActionEvent event) {
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

	public void openfile(MouseEvent event) throws IOException {
		if (event.getClickCount() != 2)
			return;

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Stage primaryStage = new Stage();
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("이미지 불러오기");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
		File file = fileChooser.showOpenDialog(primaryStage);
		if (file != null) {
			covertext.setText(file.getAbsolutePath());
		}
	}

}
