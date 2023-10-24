package Model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		final String TABLE_NAME = "User_Details";

		try (Connection con = Database_Connection.getConnection();
				Statement stmt = con.createStatement();) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME 
										+ "(username VARCHAR(15) NOT NULL,"
										+ "password VARCHAR(15) NOT NULL,"
										+ "first_name VARCHAR(15) NOT NULL,"
										+ "last_name VARCHAR(15) NOT NULL,"
										+ "type VARCHAR(15) NOT NULL,"
										+ "PRIMARY KEY (username))");
			System.out.println("Table created sucesfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
