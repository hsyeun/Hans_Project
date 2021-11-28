package com.chat;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class SelectT1 {

	public static ObservableList<ChatVO> ChatSelct(int p_code) {
		ObservableList<ChatVO> chatvos = FXCollections.observableArrayList();



		String runSP = "{ call sp_select_t1(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, p_code);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				
				while (resultSet.next()) {
					ChatVO chat = new ChatVO();
					chat.setChat_code(resultSet.getInt(1));
					chat.setChat_writer(resultSet.getInt(2));
					chat.setChat_text(resultSet.getString(3));
					chat.setChat_date(String.valueOf(resultSet.getDate(4)));
					chat.setChat_show(resultSet.getString(5));
					chat.setPossess_code(resultSet.getInt(6));
					
					chatvos.add(chat);
					
				}
			
				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sc.close();
		}
		return chatvos;
	}

}