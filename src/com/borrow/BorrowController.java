package com.borrow;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

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
		
		tableBorrowList.setCellValueFactory(new PropertyValueFactory<>("possess_code"));
		BorrowCode.setCellValueFactory(new PropertyValueFactory<>("borrow_code"));
		
		tableBorrowView.setItems(getBorrowList());

	}

	public void BorrowAction(ActionEvent event) {
		BorrowListVO boli = new BorrowListVO();
		boli.setBorrow_lender(10109);
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
		return BorrowAct.BorrowSelect(10109);
	}

}
