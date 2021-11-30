package com.member;

import java.net.URL;
import java.util.ResourceBundle;

import com.Main.BookDAO;
import com.Main.BookVO;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import login.loginuserAct;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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
//		else if(inputID.getText().equals(mVO.getMember_id()) && inputPW.getText().equals(mVO.getMember_pw())){
//			UserLogin.setText("Login Success");
//			
//		
			loginuserAct.userupdate(mVO.getMember_id());
			Stage primaryStage = new Stage();
			Stage stage = (Stage) loginOK.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("/com/Main/BorderPaneView.fxml"));
			Scene sc = new Scene(second);
			primaryStage.setTitle("Join");
			primaryStage.setScene(sc);
			primaryStage.show();
			stage.close();
		}

//		} else {
//        	UserLogin.setText("Login Failed");
//        }
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

	/*
	 * //ID 중복 확인
	 * 
	 * @FXML public void checkExistID(){ // socket = MemberVO.socket;
	 * 
	 * if(getID.getText().equals("")) { Alert noCheckID = new
	 * Alert(AlertType.ERROR); noCheckID.setHeaderText("ID input error");
	 * noCheckID.setContentText("Please input ID"); noCheckID.showAndWait(); return;
	 * }
	 * 
	 * try { String m = "checkID:" + getID.getText(); BufferedReader br = new
	 * BufferedReader(new InputStreamReader(socket.getInputStream(),
	 * StandardCharsets.UTF_8)); PrintWriter pw = new PrintWriter(new
	 * OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
	 * 
	 * pw.println(m); pw.flush();
	 * 
	 * checkNum = Integer.parseInt(br.readLine());
	 * 
	 * 
	 * } catch (IOException e1) { e1.printStackTrace(); }
	 * 
	 * switch(checkNum) { case 0: Alert exist = new Alert(AlertType.INFORMATION);
	 * exist.setHeaderText("ID is available");
	 * exist.setContentText("ID is available"); exist.showAndWait(); break; case 1:
	 * Alert noExist = new Alert(AlertType.WARNING);
	 * noExist.setHeaderText("ID is exist");
	 * noExist.setContentText("id cneck again"); noExist.showAndWait(); break; } }
	 */

	/*
	 * @FXML public void goHome() throws Exception{ Stage primaryStage = new
	 * Stage(); Parent signUp =
	 * FXMLLoader.load(getClass().getResource("view/first.fxml")); //
	 * signUp.getStylesheets().add(getClass().getResource("css/first.css").
	 * toExternalForm()); primaryStage.setScene(new Scene(signUp));
	 * primaryStage.show(); // primaryStage.setResizable(false);
	 * 
	 * Stage stage = (Stage)home.getScene().getWindow(); stage.close(); }
	 */

//	@FXML public void toHome() throws Exception {
//		Stage primaryStage = new Stage();
//		Stage stage = (Stage)UserLogin.getScene().getWindow();
//
//			Parent ob = FXMLLoader.load(getClass().getResource("view/first.fxml"));
//			ob.getStylesheets().add(getClass().getResource("css/first.css").toExternalForm());
//			Scene sc = new Scene(ob);
//			primaryStage.setScene(sc);
//	        primaryStage.show();
//	        primaryStage.setResizable(false);
//			stage.close();
//	}

//	@FXML public void toHome2() throws Exception {
//		Stage primaryStage = new Stage();
//		Stage stage = (Stage)ManagerLogin.getScene().getWindow();
//
//			Parent ob = FXMLLoader.load(getClass().getResource("view/first.fxml"));
//			ob.getStylesheets().add(getClass().getResource("css/first.css").toExternalForm());
//			Scene sc = new Scene(ob);
//			primaryStage.setScene(sc);
//	        primaryStage.show();
//	        primaryStage.setResizable(false);
//			stage.close();
//	}

//	@FXML public void toHome3() throws Exception {
//		Stage primaryStage = new Stage();
//		Stage stage = (Stage)UserSignupLabel.getScene().getWindow();
//
//			Parent ob = FXMLLoader.load(getClass().getResource("view/first.fxml"));
//			ob.getStylesheets().add(getClass().getResource("css/first.css").toExternalForm());
//			Scene sc = new Scene(ob);
//			primaryStage.setScene(sc);
//	        primaryStage.show();
//	        primaryStage.setResizable(false);
//			stage.close();
//	}

}