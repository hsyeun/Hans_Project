package com.DBCon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DBCon.DBConnection;


public class Test {
	
	public static void main(String args[]) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		conn = DBConnection.getConnection();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT * FROM member");

			while (rset.next()) {
				System.out.print(rset.getInt(1) + " ");
				System.out.println(rset.getString(2));
			}
		}

		finally {
			if (rset != null)
				rset.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

}
