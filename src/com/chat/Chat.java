package com.chat;

import lombok.Data;

@Data
public class Chat {
	
	String user;
	String memo="";
	String date;
	
	Chat() {
		setDate("sysdate");
	}

}
