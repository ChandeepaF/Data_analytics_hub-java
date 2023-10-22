package Model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
//	public static void main(String[] args) {
//		final String TABLE_NAME = "User_Details";
//
//		try (Connection con = Database_Connection.getConnection();
//				Statement stmt = con.createStatement();) {
//			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME 
//										+ "(username VARCHAR(15) NOT NULL,"
//										+ "password VARCHAR(15) NOT NULL,"
//										+ "first_name VARCHAR(15) NOT NULL,"
//										+ "last_name VARCHAR(15) NOT NULL,"
//										+ "PRIMARY KEY (username))");
//			System.out.println("Table created sucesfully");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
	public static void main(String[] args) {
		final String TABLE_NAME = "Post_Details";

		try (Connection con = Database_Connection.getConnection();
				Statement stmt = con.createStatement();) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME 
										+ "(id INT NOT NULL,"
										+ "content VARCHAR(15) NOT NULL,"
										+ "author VARCHAR(15) NOT NULL,"
										+ "likes INT NOT NULL,"
										+ "shares INT NOT NULL,"
										+ "date_time VARCHAR(15) NOT NULL,"
										+ "PRIMARY KEY (id))");
			System.out.println("Table created sucesfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


}
