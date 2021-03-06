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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.loginuserAct;

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

	@FXML
	private void showinfo(MouseEvent event) throws IOException {
		if (event.getClickCount() != 2)
			return;

		Stage dialog2 = new Stage(StageStyle.UTILITY);
		dialog2.initModality(Modality.WINDOW_MODAL);
		dialog2.initOwner(tablePossessView.getScene().getWindow());
		dialog2.setTitle("text");
		Parent parent2 = FXMLLoader.load(getClass().getResource("form2.fxml"));

		Button btnFormCancel = (Button) parent2.lookup("#btnFormCancel2");
		Button btnlenderinfo = (Button) parent2.lookup("#openlenderButton");
		Label label = (Label) parent2.lookup("#TenNameLabel");
//			//label con
//			
		PossessInfoVO book = tablePossessView.getSelectionModel().getSelectedItem();
		label.setText("??? ?????? : " + book.getBook_name() + '\n' + "?????? : " + book.getBook_writer() + '\n' 
				+ "????????? : " + book.getBook_pub() + '\n' 
				+ "?????? ?????? : " + book.getStatus_check() + '\n' + "??? ?????? : " + book.getPossess_code() + '\n');
		loginuserAct.pos_code_update(book.possess_code);

		Button btnchat = (Button) parent2.lookup("#openchatButton");
		btnchat.setOnAction(e2 -> openchat());
		btnlenderinfo.setOnAction(e2 -> openlenderinfo(book.getLender()));
		btnFormCancel.setOnAction(e2 -> dialog2.close());
		Scene scene2 = new Scene(parent2);
		dialog2.setScene(scene2);
		dialog2.setResizable(false);
		dialog2.show();
	}

	public void openchat() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/Chat/MyScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openlenderinfo(int lender) {
		if (lender == 0) {return ;}
		
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("lenderinfo.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
