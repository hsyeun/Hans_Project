package com.Borrow;

import java.sql.Date;

import lombok.Data;

@Data
public class BorrowListVO {

	String book_name;
	String book_writer;
	String book_pub;
	int possess_holder;
	Date borrow_date;
	int borrow_code;
	int possess_code;
	int borrow_lender;
	int status_check;
	
}

