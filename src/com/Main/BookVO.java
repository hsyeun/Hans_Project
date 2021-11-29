package com.Main;

import lombok.Data;

@Data
public class BookVO {
	
	int book_code;
	String book_name;
	String book_writer;
	String book_pub;
	int possess_code;
	int possess_holder;
	String possess_cover;
	String status_check;
	String bookinformation;
	
	
	
	void setStatus_check(int sc) {
		if (sc == 0) {
			status_check = "대여가능";
		} else {
			status_check = "대여중";
		}
		bookinformation = book_name + " : " + status_check;
	}



}
