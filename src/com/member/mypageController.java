package com.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.loginuserAct;

public class mypageController implements Initializable {

	// mypage
	@FXML
	private Button cancelBtn;
	@FXML
	private TextField selectID, selectPW, selectName, selectPhone, selectEmail, selectSnum, selectMajor;
	@FXML
	private ListView<String> listView;
	@FXML
	private TextArea textArea;
	@FXML
	private TableView<MemberVO> tableMemberView;
	@FXML
	private TableColumn<MemberVO, Integer> tableMemberList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		getinfo();

	}

	public void getinfo() {
		try {
			MemberVO mVO = getMember(loginuserAct.userup());
	
			selectID.setText(mVO.getMember_id());
			selectPW.setText(mVO.getMember_pw());
			selectName.setText(mVO.getMember_name());
			selectPhone.setText(String.valueOf(mVO.getMember_phone()));
			selectEmail.setText(mVO.getMember_email());
			selectSnum.setText(String.valueOf(mVO.getMember_num()));
			selectMajor.setText(mVO.getMember_major());
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public MemberVO getMember(int mem_code) {
		return MemberDao.MyPage(mem_code);
	}

	// 마이페이지 취소버튼 동작
	public void cancelAction(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage) cancelBtn.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("/com/Main/BorderPaneView.fxml"));
		Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.show();
		stage.close();
	}

}
