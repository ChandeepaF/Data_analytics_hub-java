package Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
	
	private static final String DB_URL = "jdbc:sqlite:data.db";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL);
	}

}
