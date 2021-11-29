package com.borrow;

import java.sql.Date;

import lombok.Data;

@Data
public class BorrowListVO {

	int borrow_code;
	int possess_code;
	int borrow_lender;
	Date borrow_date;
	int status_check;
	
}

