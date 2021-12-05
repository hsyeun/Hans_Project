package com.Borrow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class BorrowAct {
	
	//대여정보를 테이블에 저장
	public static void BorrowInsert(BorrowListVO boli) {

		String runSP = "{ call sp_insert_borrow(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setInt(1, boli.getPossess_code());
			callableStatement.setInt(2, boli.getBorrow_lender());

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
	
	//대여행동을 할 때 책의 상태가 대여 가능인 것만 기능할 수 있도록 설정
	public static int BorrowUniqueInsert(BorrowListVO boli) {
		int pos_status = 0;
		String runSP = "{ call sp_select_borrowStatus(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, boli.getPossess_code());
			callableStatement.registerOutParameter(2, OracleTypes.NUMBER);
			System.out.println();

			try {
				callableStatement.execute();
				pos_status = callableStatement.getInt(2);
				System.out.println(pos_status);
				
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
		return pos_status;
	}

	
	//로그인한 계정이 대여한 책 목록을 조회
	public static ObservableList<BorrowListVO> BorrowSelect(int lender) {
		ObservableList<BorrowListVO> bolis = FXCollections.observableArrayList();

		String runSP = "{ call sp_select_borrowlist(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, lender);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					BorrowListVO boli = new BorrowListVO();
					boli.setBook_name(resultSet.getString(1));
					boli.setBook_writer(resultSet.getString(2));
					boli.setBook_pub(resultSet.getString(3));
					boli.setPossess_holder(resultSet.getInt(4));
					boli.setBorrow_date(resultSet.getDate(5));
					boli.setBorrow_code(resultSet.getInt(6));
					boli.setPossess_code(resultSet.getInt(7));
					boli.setBorrow_lender(resultSet.getInt(8));
					boli.setStatus_check(resultSet.getInt(9));

					bolis.add(boli);

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
		return bolis;
	}

}
