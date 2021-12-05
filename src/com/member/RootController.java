package com.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.loginuserAct;

public class RootController implements Initializable {

	// Login
	@FXML
	private Label UserLogin;
	@FXML
	private Button user, UserSignUp, home, login, loginOK;
	@FXML
	private TextField getID, getPhoneNum, getName, inputID;
	@FXML
	private PasswordField getPW, inputPW;

	// Join
	@FXML
	private TextField jid, jname, jphone, jemail, jsnum, jmajor;
	@FXML
	private PasswordField jpw, jpwc;
	@FXML
	private Button submitBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	// first에서 Login 버튼을 눌렀을 때 login페이지로 이동
	public void moveUser() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage) user.getScene().getWindow();

		Parent second = FXMLLoader.load(getClass().getResource("view/login.fxml"));
		Scene sc = new Scene(second);
		primaryStage.setScene(sc);
		primaryStage.show();
		stage.close();
	}

	// user login 버튼 이벤트
	public void UserLogin(ActionEvent event) throws Exception {

		MemberVO mVO = new MemberVO();
		mVO.setMember_id(inputID.getText());
		mVO.setMember_pw(inputPW.getText());

		// 로그인된 상태로 화면전환
		if (inputPW.getText().equals("")) {
			Alert loginFail = new Alert(AlertType.ERROR);
			loginFail.setHeaderText("Empty error");
			loginFail.setContentText("Please input ID or Password");
			loginFail.showAndWait();
		} else {
			loginuserAct.userupdate(mVO.getMember_id());
			Stage primaryStage = new Stage();
			Stage stage = (Stage) loginOK.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("/com/Main/BorderPaneView.fxml"));
			Scene sc = new Scene(second);
			primaryStage.setTitle("AppMain");
			primaryStage.setScene(sc);
			primaryStage.show();
			stage.close();
		}
	}

	// SignUP 버튼을 눌렀을 때 join페이지로 이동
	public void goUserSignUp() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage) UserSignUp.getScene().getWindow();

		Parent second = FXMLLoader.load(getClass().getResource("view/join.fxml"));
		Scene sc = new Scene(second);
		primaryStage.setTitle("Join");
		primaryStage.setScene(sc);
		primaryStage.show();
		stage.close();
	}

	// 가입버튼 이벤트
	@FXML
	public void submitUserSignup(ActionEvent event) throws Exception {
		MemberVO mVO = new MemberVO();

		try {
			mVO.setMember_id(jid.getText());
			mVO.setMember_pw(jpw.getText());
			mVO.setMember_name(jname.getText());
			mVO.setMember_phone(Integer.parseInt(jphone.getText()));
			mVO.setMember_email(jemail.getText());
			mVO.setMember_num(Integer.parseInt(jsnum.getText()));
			mVO.setMember_major(jmajor.getText());

			MemberDao.JoinInsert(mVO);

			Alert joinSuccess = new Alert(AlertType.CONFIRMATION);
			joinSuccess.setHeaderText("환영합니다!");
			joinSuccess.setContentText("가입되셨습니다.");
			joinSuccess.showAndWait();

			try {
				Parent members = FXMLLoader.load(getClass().getResource("view/login.fxml"));
				Scene scene = new Scene(members);
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setTitle("login");
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException caught"); // 예외처리 발생!!

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}