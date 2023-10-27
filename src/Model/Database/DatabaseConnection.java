package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	// To set up the connection to the database named "data"
	private static final String DB_URL = "jdbc:sqlite:data.db";
	
	// To handle any exceptions that might be thrown during the process
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL);
	}

}
