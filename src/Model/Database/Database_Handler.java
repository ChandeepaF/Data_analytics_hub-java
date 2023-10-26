package Model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Database_Handler {
	

	public String Save_Personal_Details(String username, String password, String first_name, String last_name) {
		
		String outputMessage = null;
		
		String type = "normal";
		
		final String TABLE_NAME = "User_Details";
		
		try (Connection con = Database_Connection.getConnection()){
			
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE username = ?")){
				checkStatement.setString(1, username);
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				int existingUserCount = resultSet.getInt(1);
				
				if (existingUserCount > 0){
					outputMessage = "Username already exists!";
				}
				if(existingUserCount == 0){
					try(PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?)")){
						prepareStatement.setString(1, username);
						prepareStatement.setString(2, password);
						prepareStatement.setString(3, first_name);
						prepareStatement.setString(4, last_name);
						prepareStatement.setString(5, type);
						
						int result = prepareStatement.executeUpdate();
						
						if (result == 1) {
							create_Post_Table(username);
							outputMessage = "Data saved successfully";
							
						}
					}
				}
			} catch(SQLException e) {
				outputMessage = e.getMessage();
				e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		return outputMessage;
		
	}		

	
	
	public String create_Post_Table(String userName) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = userName + "_Post_Details";
	
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
			
			outputMessage = "Table created sucesfully";
			
		} catch (SQLException e) {
			outputMessage = e.getMessage();
		}
		
		return outputMessage;
	}
		
	
	
	public String updatePersonalDetails(String current_username, String new_username, String new_password, String new_first_name, String new_last_name) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = "User_Details";
		
		try (Connection con = Database_Connection.getConnection()){
			
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE username = ?")){
				checkStatement.setString(1, new_username);
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				int existingUserCount = resultSet.getInt(1);
				
				if (existingUserCount > 0){
					outputMessage = "Username already exists!";
				}
				else{
					try(PreparedStatement prepareStatement = con.prepareStatement("UPDATE " + TABLE_NAME + " SET username = ?, password = ?, first_name = ?, "
							+ "last_name = ? WHERE username = ?")){
						prepareStatement.setString(1, new_username);
						prepareStatement.setString(2, new_password);
						prepareStatement.setString(3, new_first_name);
						prepareStatement.setString(4, new_last_name);
						prepareStatement.setString(5, current_username);
						
						int result = prepareStatement.executeUpdate();
						
						if (result == 1) {
							outputMessage = "Personal data updated successfully!";
							
						}
						else {
							outputMessage = "Invalid current username!";
						}
					}
				}
			} catch(SQLException e) {
				outputMessage = e.getMessage();
				e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		return outputMessage;
		
	}
	
	
	
	public String changeVip(String Username) {
		
		final String TABLE_NAME = "User_Details";
			
		String output = null;
		
		String type = "vip";
		
		
		try (Connection con = Database_Connection.getConnection();
								
				PreparedStatement prepareStatement = con.prepareStatement("UPDATE " + TABLE_NAME + " SET type = ? WHERE username = ?")){
			prepareStatement.setString(1, type);
			prepareStatement.setString(2, Username);
		
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				output = "Type updated succesfully!";
				
			}
			else {
				output = "Type not updated!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
	}
	
	
	
	public String checkUserType(String Username) {
		
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
								
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, Username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					output = resultSet.getString("type");
				
				} while (resultSet.next());
				
				
			} else {
				output = "Type not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
		
	}
			
	
	
	public String rename_Post_Table(String current_username, String new_username) {
		
		String outputMessage = null;
		
		String CURRENT_TABLE_NAME = current_username + "_Post_Details";   
		String NEW_TABLE_NAME = new_username + "_Post_Details";          

		try (Connection con = Database_Connection.getConnection();
				Statement stmt = con.createStatement();) {
			
			String renameTableSQL = "ALTER TABLE " + CURRENT_TABLE_NAME + " RENAME TO " + NEW_TABLE_NAME;
			
			stmt.execute(renameTableSQL);
			
			outputMessage = "Table renamed sucesfully";
			
		} catch (SQLException e) {
			outputMessage = e.getMessage();
		}
		
		return outputMessage;
	}
	
	
	
	public String validate_Login_Details(String Username) {
		
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
								
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, Username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					output = resultSet.getString("password");
				
				} while (resultSet.next());
				
				
			} else {
				output = "Username not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
							
	}
	
	
	
	public String getNameUser(String username) {
		
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					output = String.format("%s %s", resultSet.getString("first_name"), resultSet.getString("last_name"));
				
				} while (resultSet.next());
				
				
			} else {
				output = "Name not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
						
	}

	
	
	public String Save_Posts(String username, String ID, String content, String author, String likes, String shares, String date_time) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = username + "_Post_Details";  
		
		try (Connection con = Database_Connection.getConnection()){
			
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE id = ?")){
				checkStatement.setString(1, ID);
				
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				int existingPostCount = resultSet.getInt(1);
				
				if (existingPostCount > 0) {
					outputMessage = "Invalid post ID. Post with the current ID already exists!";
				}
				
				if (existingPostCount == 0) {
				
				    try(PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?, ?)")){
						prepareStatement.setString(1, ID);
						prepareStatement.setString(2, content);
						prepareStatement.setString(3, author);
						prepareStatement.setString(4, likes);
						prepareStatement.setString(5, shares);
						prepareStatement.setString(6, date_time);
				
						int result = prepareStatement.executeUpdate();
				
						if (result == 1) {
							outputMessage = "Post saved successfully!";
						}
				    }
				    }
			
				} catch(SQLException e) {
					outputMessage = e.getMessage();
					e.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			return outputMessage;
				
	}		
	
	
	
	public String Remove_Posts(String username, int iD) {
		
		String outputMessage = null;
		
		final String TABLE_NAME = username + "_Post_Details"; 
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {
				outputMessage = "Post deleted succesfully";
			}
			else {
				outputMessage = "Post not found";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
			
		}
		
		
		
	public String retrieve_Posts(String username, int iD) {
		
		
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					output = String.format("ID: %d | Content: %s | Author: %s | Likes: %d | Shares: %d | Date/Time: %s\n",
							resultSet.getInt("id"), resultSet.getString("content"), resultSet.getString("author"), resultSet.getInt("likes"),
							resultSet.getInt("shares"), resultSet.getString("date_time"));
				
				} while (resultSet.next());
				
			} else {
				output = "Post not found";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
		}
	
	
	
	public String export_Posts(String username, int iD) {
		
		
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					output = resultSet.getInt("id") + "," + resultSet.getString("content") + "," + resultSet.getString("author") + "," + resultSet.getInt("likes") + 
							"," + resultSet.getInt("shares") + "," + resultSet.getString("date_time");
				
				} while (resultSet.next());
				
			} else {
				output = "Post not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
		}
	
	
	
	public String retrieve_LikesPosts(String username, int number) {
		
		
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " ORDER BY likes DESC LIMIT ?")){
			prepareStatement.setInt(1, number);
						
			resultSet = prepareStatement.executeQuery();
			
			
			if (resultSet.next()) {
				
				output = "";
				
				do {
					output += String.format("ID: %d | Content: %s | Author: %s | Likes: %d | Shares: %d | Date/Time: %s \n",
							resultSet.getInt("id"), resultSet.getString("content"), resultSet.getString("author"), resultSet.getInt("likes"),
							resultSet.getInt("shares"), resultSet.getString("date_time"));
				
				} while (resultSet.next());
				
			} else {
				output = "No posts found!";
			}
			
				
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
	}
	
	
	
	public String retrieve_SharesPosts(String username) {
		
		String output= null;
		
		final String TABLE_NAME = username + "_Post_Details"; 
		
		int firstGroup = 0;
		int secondGroup = 0;
		int thirdGroup = 0;
		
		
		try (Connection con = Database_Connection.getConnection();
				
				PreparedStatement prepareStatement = con.prepareStatement("SELECT shares, COUNT(*) FROM " + TABLE_NAME + " GROUP BY shares")){
		
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
			
				int shares = resultSet.getInt("shares");
				int count = resultSet.getInt("COUNT(*)");
				
				if (shares >= 0 && shares <= 99) {
					firstGroup += count;
				}
				
				if (shares >= 100 && shares <= 999) {
					secondGroup += count;
				}
				
				if (shares >= 1000) {
					thirdGroup += count;
				}
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
		
		String firstGroup1 = Integer.toString(firstGroup);
		String secondGroup1 = Integer.toString(secondGroup);
		String thirdGroup1 = Integer.toString(thirdGroup);
		
		output = firstGroup1 + "," + secondGroup1 + "," + thirdGroup1;
		
		return output;
	}

}
