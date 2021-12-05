package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DBConnection;

public class MemberDao {
	
	//로그인 정보 조회
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
	
	//회원가입 페이지에 입력된 데이터 저장	
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
	
	
	//계정정보 조회
	public static MemberVO MyPage(int mem_code) {
		MemberVO mVO = new MemberVO();
		String run = "SELECT * FROM MEMBER WHERE member_show = 'Y' and member_code = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement prst = conn.prepareCall(run);
			prst.setInt(1, mem_code);
			ResultSet rs = prst.executeQuery();	
			
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
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return mVO;
	}
}
