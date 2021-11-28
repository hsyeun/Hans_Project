package com.booklist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDAO {
	static Connection conn = DBConnection.getConnection();
	
	static Statement stmt = null;
	
	static PreparedStatement pstm = null;
	
	static ResultSet rstm = null;
	
	public static ObservableList<BookVO> getBookVO(String sel) throws SQLException{
		ObservableList<BookVO> bookvo = FXCollections.observableArrayList();
		
		stmt = conn.createStatement();
		rstm = stmt.executeQuery("Select b.book_name, p.possess_code from book b JOIN possess p ON (b.book_code = p.book_code) where b.book_name like ('%" + sel + "%')");
	
		
		
		while(rstm.next()) {
			
			BookVO books = new BookVO();
			books.setBook_name(rstm.getNString(1));
			//books.setBook_code(rstm.getInt(1));
			//books.setBook_name(rstm.getNString(2));
			//books.setBook_writer(rstm.getNString(3));
			//books.setBook_pub(rstm.getNString(4));
			books.setPossess_code(rstm.getInt(2));
			
			bookvo.add(books);
		}
		
		return(bookvo);
		
	}
	

}
