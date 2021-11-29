package com.borrow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import application.DBConnection;

public class ReturnAct {

	public static void Returning(int borrow_code) {

		String runSP = "{ call sp_insert_return(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setInt(1, borrow_code);

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
