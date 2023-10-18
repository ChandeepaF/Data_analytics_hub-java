package Model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Handler {

	public String Save_Personal_Details(String username, String password, String first_name, String last_name) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = "PersonalDetails";
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO" + TABLE_NAME + " VALUES(?, ?, ?, ?)")){
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, password);
			prepareStatement.setString(3, first_name);
			prepareStatement.setString(4, last_name);
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				outputMessage = "Data saved to file";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
				
	}		
	
	
	public String updatePersonalDetails(String current_username, String new_username, String new_password, String new_first_name, String new_last_name) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = "PersonalDetails";
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("UPDATE" + TABLE_NAME + " SET username = ?, password = ?, first_name = ?, "
						+ "last_name = ? WHERE username = ?")){
			prepareStatement.setString(1, new_username);
			prepareStatement.setString(2, new_password);
			prepareStatement.setString(3, new_first_name);
			prepareStatement.setString(4, new_last_name);
			prepareStatement.setString(5, current_username);
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				outputMessage = "Personal data updated succesfully";
			}
			else {
				outputMessage = "No existing record found";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
				
	}	
		
	
	
	public String Save_Posts(String ID, String content, String author, String likes, String shares, String date_time) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = "PostDetails";
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO" + TABLE_NAME + " VALUES(?, ?, ?, ?, ?, ?)")){
			prepareStatement.setString(1, ID);
			prepareStatement.setString(2, content);
			prepareStatement.setString(3, author);
			prepareStatement.setString(4, likes);
			prepareStatement.setString(5, shares);
			prepareStatement.setString(6, date_time);
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				outputMessage = "Data saved to file";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
				
	}		
	
	
	
	public String Remove_Posts(int iD) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = "PostDetails";
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("DELETE FROM" + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setLong(1, iD);
		
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				outputMessage = "Post deleted succesfully";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
			
		}
		
		
		
	public ResultSet retrieve_Posts(int iD) {
		
		
		final String TABLE_NAME = "PostDetails";
		
		ResultSet resultSet = null;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM" + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setLong(1, iD);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				System.out.printf("ID: %d | Content: %s | Author: %s | Likes: %d | Shares: %d | Date/Time: %s\n",
						resultSet.getInt("id"), resultSet.getString("content"), resultSet.getString("author"), resultSet.getInt("likes"),
						resultSet.getInt("shares"), resultSet.getString("date_time"));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
				
		return resultSet;
			
		}
	
	
	
	
		
}
