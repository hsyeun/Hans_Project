package login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import application.DBConnection;
import oracle.jdbc.OracleTypes;

public class loginuserAct {
	
	static int member_code;
	int possess_code;
	
public static void userupdate(String user) {
				
		String runSP = "{ call sp_update_user(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, user);
			
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

public static int userup() {

	String runSP = "{ call sp_select_user(?) }";

	try {
		Connection conn = DBConnection.getConnection();
		CallableStatement callableStatement = conn.prepareCall(runSP);

		callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
		System.out.println();

		try {
			callableStatement.execute();
			member_code = callableStatement.getInt(1);
			System.out.println(member_code);
			
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
	return member_code;
}



public static void pos_code_update(int pos_code) {
	
	String runSP = "{ call sp_update_book(?) }";

	try {
		Connection conn = DBConnection.getConnection();
		CallableStatement callableStatement = conn.prepareCall(runSP);
		callableStatement.setInt(1, pos_code);
		
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

public static int pos_code_up() {

String runSP = "{ call sp_select_book(?) }";

try {
	Connection conn = DBConnection.getConnection();
	CallableStatement callableStatement = conn.prepareCall(runSP);

	callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
	System.out.println();

	try {
		callableStatement.execute();
		member_code = callableStatement.getInt(1);
		System.out.println(member_code);
		
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
return member_code;
}





public static int lenderinfo() {

	String runSP = "{ call sp_lenderinfo(?) }";

	try {
		Connection conn = DBConnection.getConnection();
		CallableStatement callableStatement = conn.prepareCall(runSP);

		callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
		System.out.println();

		try {
			callableStatement.execute();
			member_code = callableStatement.getInt(1);
			System.out.println(member_code);
			
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
	return member_code;
}

}