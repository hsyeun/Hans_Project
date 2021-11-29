package com.Possess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class PossessAct {

	public static void PossessInsert(PossessInfoVO pos) {

		String runSP = "{ call sp_insert_possess(?, ?, ?, ? ,?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, pos.getBook_name());
			callableStatement.setString(2, pos.getBook_writer());
			callableStatement.setString(3, pos.getBook_pub());
			callableStatement.setInt(4, pos.getPossess_holder());
			callableStatement.setString(5, pos.getPossess_cover());
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

	public static ObservableList<PossessInfoVO> PossessSelect(int holder) {
		ObservableList<PossessInfoVO> poss = FXCollections.observableArrayList();

		String runSP = "{ call sp_select_possess_holder(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, holder);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					PossessInfoVO posinfo = new PossessInfoVO();
					posinfo.setBook_code(resultSet.getInt(1));
					posinfo.setBook_name(resultSet.getString(2));
					posinfo.setBook_writer(resultSet.getString(3));
					posinfo.setBook_pub(resultSet.getString(4));
					posinfo.setPossess_code(resultSet.getInt(5));
					posinfo.setPossess_holder(resultSet.getInt(6));
					posinfo.setPossess_cover(resultSet.getString(7));
					posinfo.setStatus_check(resultSet.getInt(8));

					poss.add(posinfo);

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
		}
		return poss;
	}

}
