package com.Main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class BookDAO {
	static Connection conn = DBConnection.getConnection();
	static Statement stmt = null;
	static PreparedStatement pstm = null;	
	static ResultSet rstm = null;
	
	public static ObservableList<BookVO> getbookVO(String find) {
		ObservableList<BookVO> poss = FXCollections.observableArrayList();

		String runSP = "{ call sp_select_bookinfo(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, find);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					BookVO boinfo = new BookVO();
					boinfo.setBook_code(resultSet.getInt(1));
					boinfo.setBook_name(resultSet.getString(2));
					boinfo.setBook_writer(resultSet.getString(3));
					boinfo.setBook_pub(resultSet.getString(4));
					boinfo.setPossess_code(resultSet.getInt(5));
					boinfo.setPossess_holder(resultSet.getInt(6));
					boinfo.setPossess_cover(resultSet.getString(7));
					boinfo.setStatus_check(resultSet.getInt(8));

					poss.add(boinfo);

				}

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return poss;
	}
	

}
