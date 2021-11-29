package com.Chat;

//import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.Scanner;

public class InsertT1 {

	public static void ChatInsert(ChatVO chat) {

		String runSP = "{ call sp_insert_chat(?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setInt(1, chat.getChat_writer());
			callableStatement.setString(2, chat.getChat_text());
			callableStatement.setInt(3, chat.getPossess_code());
			callableStatement.executeUpdate();	
			System.out.println("성공");			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
