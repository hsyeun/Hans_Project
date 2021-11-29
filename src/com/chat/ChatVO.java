package com.chat;

//import java.sql.Date;

import lombok.Data;

@Data
public class ChatVO {
	private int chat_code;
	private int chat_writer;
	private String chat_text;
	private String chat_date;
	private String chat_show;
	private int possess_code;
	private String memo;

	ChatVO () {
		chat_date = "지금"; 
	}
	
	void setChat_text(String text) {
		chat_text=text;
		memo = chat_writer + " : " + chat_text;			
	}

}