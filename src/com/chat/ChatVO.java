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
	private String member_id;
	private int possess_code;
	private String memo;

	ChatVO () {
		member_id = "나";
		chat_date = "지금"; 
	}
	
	void setPossess_code(int code) {
		possess_code = code;
		memo = member_id + " : " + chat_text;			
	}


}