package com.booklist;

import lombok.Data;

@Data
public class BookVO {
	
	
	private int book_code;
	private String book_name; 
	private String book_writer;
	private String book_pub;
	private String bookinformation;
	private int possess_code;
	

	void setBook_pub(String st) {
		book_pub = st;
		bookinformation = book_name + " " + possess_code;
	}

	
	

}
