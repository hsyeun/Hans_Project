package com.member;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class CommonData {    // Singleton으로 동작한다.
	private static CommonData instance = new CommonData();
	private CommonData() {
		MemberVO = new HashMap<String, Member>();
	}
	public static CommonData getInstance() {
		return instance;
	}

	private Map<String, Member> MemberVO;    // 회원정보를 저장
	
	public void put(String id, Member member) {    // 회원정보를 저장
		if(id != null && member != null)
			MemberVO.put(id, member);
	}
	
	public Member get(String id) {    // 회원정보를 가져온다.
		return MemberVO.get(id);
	}
	
	public boolean exists(String id) {    // 회원정보가 존재하는지 검사한다.
		return MemberVO.get(id) != null;
	}
	
	// 로그인 여부 저장
	private boolean onLogin = false;
	
	public boolean isOnLogin() {
		return onLogin;
	}
	
	public void setOnLogin(boolean onLogin) {
		this.onLogin = onLogin;
	}
	
}