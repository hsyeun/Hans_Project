package com.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import com.application.BookVO;

import application.DBConnection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.loginuserAct;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO (don't really need to do anything here).
		BookList.setCellValueFactory(new PropertyValueFactory<>("bookinformation"));

	}

	public void handlebtn3(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
		Stage window = (Stage) btn3.getScene().getWindow();
		window.setScene(new Scene(root, 700, 350));

	}

	@FXML
	public void handlebtn2(ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/Borrow/BorrowScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handlebtn1(ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/Possess/Possessview.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void select(ActionEvent event) throws SQLException {
		String find = "%" + myTextField.getText() + "%";

		tableView.setItems(getbook(find));
	}

	public ObservableList<BookVO> getbook(String find) throws SQLException {
		return BookDAO.getbookVO(find);
	}

	@FXML
	private void showinfo(MouseEvent event) throws IOException {
		if (event.getClickCount() != 2)
			return;
		loginuserAct.pos_code_update(0);

		Stage dialog2 = new Stage(StageStyle.UTILITY);
		dialog2.initModality(Modality.WINDOW_MODAL);
		dialog2.initOwner(btn4.getScene().getWindow());
		dialog2.setTitle("text");
		Parent parent2 = FXMLLoader.load(getClass().getResource("form2.fxml"));

		Button btnFormCancel = (Button) parent2.lookup("#btnFormCancel2");
		Button btnchat = (Button) parent2.lookup("#openchatButton");
		Label label = (Label) parent2.lookup("#TenNameLabel");
//			//label con
//			
		BookVO book = tableView.getSelectionModel().getSelectedItem();
		label.setText("책 이름 : " + book.getBook_name() + '\n' + "저자 : " + book.getBook_writer() + '\n' + "출판사 : "
				+ book.getBook_pub() + '\n' + "소유자 : " + book.getPossess_holder() + '\n' + "대여 상태 : "
				+ book.getStatus_check() + '\n' + "책 코드 : " + book.getPossess_code() + '\n');
		loginuserAct.pos_code_update(book.possess_code);

		btnchat.setOnAction(e2 -> openchat());
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
}
