package com.Borrow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class BorrowController implements Initializable {

	@FXML
	private Button BorrowButton, ReturnButton;

	@FXML
	private TableView<BorrowListVO> tableBorrowView;

	@FXML
	private TableColumn<BorrowListVO, Integer> tableBorrowList;

	@FXML
	private TableColumn<BorrowListVO, Integer> BorrowCode;
	
	@FXML
	private TextField inputPossess;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		tableBorrowList.setCellValueFactory(new PropertyValueFactory<>("book_name"));
		BorrowCode.setCellValueFactory(new PropertyValueFactory<>("borrow_code"));
		
		tableBorrowView.setItems(getBorrowList());
		inputPossess.setText(String.valueOf(loginuserAct.pos_code_up()));

	}

	public void BorrowAction(ActionEvent event) {
		BorrowListVO boli = new BorrowListVO();
		boli.setBorrow_lender(loginuserAct.userup());
		boli.setPossess_code(Integer.parseInt(inputPossess.getText()));
		
		int pos_status = BorrowAct.BorrowUniqueInsert(boli);
		if (pos_status == 0) {
		BorrowAct.BorrowInsert(boli);
		}
		tableBorrowView.setItems(getBorrowList());
		inputPossess.clear();
	}

	public void ReturnAction(ActionEvent event) {
		int bor_code = (Integer.parseInt(inputPossess.getText()));
		
		ReturnAct.Returning(bor_code);
		tableBorrowView.setItems(getBorrowList());

		inputPossess.clear();
	}
	
	public ObservableList<BorrowListVO> getBorrowList() {
		return BorrowAct.BorrowSelect(loginuserAct.userup());
	}

	
	@FXML
	private void showinfo(MouseEvent event) throws IOException {
		if (event.getClickCount() != 2)
			return;

		Stage dialog2 = new Stage(StageStyle.UTILITY);
		dialog2.initModality(Modality.WINDOW_MODAL);
		dialog2.initOwner(tableBorrowView.getScene().getWindow());
		dialog2.setTitle("text");
		Parent parent2 = FXMLLoader.load(getClass().getResource("form2.fxml"));

		Button btnFormCancel = (Button) parent2.lookup("#btnFormCancel2");
		Label label = (Label) parent2.lookup("#TenNameLabel");
//			//label con
//			
		BorrowListVO book = tableBorrowView.getSelectionModel().getSelectedItem();
		label.setText("책 이름 : " + book.getBook_name() + '\n' + "저자 : " + book.getBook_writer() + '\n' + "출판사 : "
				+ book.getBook_pub() + '\n' + "소유자 : " + book.getPossess_holder() + '\n' +
				"책 코드 : " + book.getPossess_code() + '\n' +
				"빌린 날짜 : " + book.getBorrow_date());
		loginuserAct.pos_code_update(book.possess_code);

		Button btnchat = (Button) parent2.lookup("#openchatButton");
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
