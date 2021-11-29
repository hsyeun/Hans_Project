package com.member;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;
import com.DBCon.DBConnection;
import login.loginuserAct;

public class MemberDao {
	public static void LoginSelect(MemberVO mVO) {
		
		String run = "SELECT member_code FROM member "
				+ "WHERE MEMBER_SHOW = 'Y' AND MEMBER_ID = ? AND MEMBER_PW = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement prst = conn.prepareCall(run);
			prst.setString(1, mVO.getMember_id());
			prst.setString(2, mVO.getMember_pw());
			
			prst.executeUpdate();	
			System.out.println("로그인 성공");			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sc.close();
		}
	}
	
//	public static int MemberCode(MemberVO mVO) {
//		int mCode = 0;
//		String run = "{ call memberlist(?, ?) }";
//		
//		try {
//			Connection conn = DBConnection.getConnection();
//			CallableStatement callableStatement = conn.prepareCall(run);
//
//			callableStatement.setString(1, mVO.getMember_id());
//			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
//			System.out.println();
//			
//			try {
//				callableStatement.execute();
//				mCode = callableStatement.getInt(mCode);
//				System.out.println(mCode);
//				
//			} catch(SQLException e) {
//				System.out.println("프로시저에서 에러 발생!");
//				// System.err.format("SQL State: %s", e.getSQLState());
//				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} 
//		return mCode;
//	}
	
	public static MemberVO MemberSelect(String mid){
		MemberVO mVO = new MemberVO();
		
		String run = "{ call memberlist(?, ?) }";
		
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, mid);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
				
					mVO.setMember_code(rs.getInt(1));
					mVO.setMember_id(rs.getString(2));
					mVO.setMember_pw(rs.getString(3));
					mVO.setMember_name(rs.getString(4));
					mVO.setMember_phone(rs.getInt(5));
					mVO.setMember_email(rs.getString(6));
					mVO.setMember_num(rs.getInt(7));
					mVO.setMember_major(rs.getString(8));
					mVO.setMember_show(rs.getString(9));

		
				}

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mVO;
	}
		
	public static void JoinInsert(MemberVO mVO) {
						
		String run = "INSERT INTO MEMBER"
				+ "(member_code, member_id, member_pw, member_name, member_phone, member_email, member_num, member_major) "
				+ "VALUES((select nvl(max(member_code)+1, 1001) from member),?,?,?,?,?,?,?)";

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement prst = conn.prepareCall(run);
			prst.setString(1, mVO.getMember_id());
			prst.setString(2, mVO.getMember_pw());
			prst.setString(3, mVO.getMember_name());
			prst.setInt(4, mVO.getMember_phone());
			prst.setString(5, mVO.getMember_email());
			prst.setInt(6, mVO.getMember_num());
			prst.setString(7, mVO.getMember_major());
			prst.executeUpdate();	
			
			System.out.println("성공");			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sc.close();
		}
	}
	
	public static int MyPage(MemberVO mVO) {
		int myInfo = 0;
		String run = "SELECT * FROM MEMBER WHERE member_show = 'Y' and member_id = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement prst = conn.prepareCall(run);
			prst.setString(1, mVO.getMember_id());
			ResultSet rs = prst.executeQuery();	
			
			mVO.setMember_pw(rs.getString("member_pw"));
			mVO.setMember_name(rs.getString("member_name"));
			mVO.setMember_phone(rs.getInt("member_phone"));
			mVO.setMember_email(rs.getString("member_email"));
			mVO.setMember_num(rs.getInt("member_num"));
			mVO.setMember_major(rs.getString("member_major"));

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sc.close();
		}
		return myInfo;
	}
}
