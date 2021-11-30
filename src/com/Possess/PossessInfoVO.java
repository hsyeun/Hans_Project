package com.Possess;

import login.loginuserAct;
import lombok.Data;

@Data
public class PossessInfoVO {
	
	int book_code;
	String book_name;
	String book_writer;
	String book_pub;
	int possess_code;
	int possess_holder;
	String possess_cover;
	String status_check;
	int lender;
	
	
	void setStatus_check(int sc) {
		if (sc == 0) {
			status_check = "대여가능";
		} else {
			status_check = "대여중";
			lender = loginuserAct.lenderinfo();
		}
	}

}
