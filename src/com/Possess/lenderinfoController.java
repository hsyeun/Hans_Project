package com.Possess;

import java.net.URL;
import java.util.ResourceBundle;

import com.member.MemberDao;
import com.member.MemberVO;

import javafx.application.Platform;
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

public class lenderinfoController implements Initializable {

	// mypage
	@FXML
	private Button cancelBtn;
	@FXML
	private TextField selectID,  selectPhone, selectEmail;
	@FXML
	private ListView<String> listView;
	@FXML
	private TextArea textArea;
	@FXML
	private TableView<PossessInfoVO> tableMemberView;
	@FXML
	private TableColumn<PossessInfoVO, Integer> tableMemberList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		getinfo();

	}

	public void getinfo() {
		try {
			
			MemberVO mVO = getMember(loginuserAct.lenderinfo());
	
			selectID.setText(mVO.getMember_id());
			selectPhone.setText(String.valueOf(mVO.getMember_phone()));
			selectEmail.setText(mVO.getMember_email());

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
		Stage stage11 = (Stage) cancelBtn.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});

	}

}
