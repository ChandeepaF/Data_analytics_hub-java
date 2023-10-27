package Model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DatabaseHandler {
	
	// Method to save the personal details in the SQLiteStudio
	public String savePersonalDetails(String username, String password, String first_name, String last_name) {
		
		String outputMessage = null;
		
		// The type of user is normal at sign up
		String type = "normal";
		
		// Table name
		final String TABLE_NAME = "User_Details";
		
		// To establish a connection using the DatabaseConnection class defined
		try (Connection con = DatabaseConnection.getConnection()){
			
			// To check if there are any existing usernames with the username of this new user
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE username = ?")){
				checkStatement.setString(1, username);
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				// To retrieve the results of the query. The number of existing users with the same username
				int existingUserCount = resultSet.getInt(1);
				
				// If there are any, the error message will be displayed
				if (existingUserCount > 0){
					outputMessage = "Username already exists!";
				}
				
				// If there are no existing records, the data will be added to the database
				if(existingUserCount == 0){
					try(PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?)")){
						prepareStatement.setString(1, username);
						prepareStatement.setString(2, password);
						prepareStatement.setString(3, first_name);
						prepareStatement.setString(4, last_name);
						prepareStatement.setString(5, type);
						
						int result = prepareStatement.executeUpdate();
						
						// If the execution is successfully, the user will be notified
						if (result == 1) {
							createPostTable(username);
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
		
		// To return the final output
		return outputMessage;
		
	}		

	
	
	// To create a post table along with the successful registration of a new user
	public String createPostTable(String userName) {
		
		String outputMessage = null;
		
		// The username of the user will be used to create a new table for the posts
		final String TABLE_NAME = userName + "_Post_Details";
	
		// Establish a connection to the database
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			// If a table with the above name doesn't exist, a new table will be created, and the column names are passed on
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
		
		// To return the final output of the process
		return outputMessage;
	}
		
	
	
	// Method to update the user details after sign up
	public String updatePersonalDetails(String current_username, String new_username, String new_password, String new_first_name, String new_last_name) {
		
		String outputMessage = null;
		
		// Defining the table name
		final String TABLE_NAME = "User_Details";
		
		// Establish a connection to the database
		try (Connection con = DatabaseConnection.getConnection()){
			
			// To check if there are any existing usernames with the new username of this new user
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE username = ?")){
				checkStatement.setString(1, new_username);
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				// To retrieve the results of the query. The number of existing users with the same new username
				int existingUserCount = resultSet.getInt(1);
				
				// If there are any, the error message will be displayed
				if (existingUserCount > 0){
					outputMessage = "New Username already exists!";
				}
				else{
					// If there are no existing records, the data will be added to the database
					try(PreparedStatement prepareStatement = con.prepareStatement("UPDATE " + TABLE_NAME + " SET username = ?, password = ?, first_name = ?, "
							+ "last_name = ? WHERE username = ?")){
						prepareStatement.setString(1, new_username);
						prepareStatement.setString(2, new_password);
						prepareStatement.setString(3, new_first_name);
						prepareStatement.setString(4, new_last_name);
						prepareStatement.setString(5, current_username);
						
						int result = prepareStatement.executeUpdate();
						
						// If the execution is successfully, the user will be notified
						if (result == 1) {
							outputMessage = "Personal data updated successfully!";
							
						}
						else {
							// If the existing username of the user is invalid
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
				
		// To return the final output of the process
		return outputMessage;
		
	}
	
	
	
	// To change the type of the user from normal to vip
	public String changeVip(String Username) {
		
		final String TABLE_NAME = "User_Details";
			
		String output = null;
		
		// Type to be updated with
		String type = "vip";
		
		
		// Establish a connection to the database
		try (Connection con = DatabaseConnection.getConnection();
								
				// To update the table accordingly with regards to the username of the user
				PreparedStatement prepareStatement = con.prepareStatement("UPDATE " + TABLE_NAME + " SET type = ? WHERE username = ?")){
			prepareStatement.setString(1, type);
			prepareStatement.setString(2, Username);
		
			
			int result = prepareStatement.executeUpdate();
			
			// If the execution is successfully, the user will be notified
			if (result == 1) {
				output = "Type updated successfully!";
				
			}
			else {
				output = "Type not updated!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
			
		// To return the final output of the process
		return output;
	}
	
	
	
	// Method to check the type of user upon login
	public String checkUserType(String Username) {
		
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		// Establish a connection to the database
		try (Connection con = DatabaseConnection.getConnection();
							
				// To select the type of the user relating to the user's username
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, Username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				// A do-while loop is used to loop through the existing records and extract the type of the relevant user
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
			
		// To return the final output of the process
		return output;
		
	}
			
	
	
	// Method to rename the specific post table of a user upon the changing of the username
	public String renamePostTable(String current_username, String new_username) {
		
		String outputMessage = null;
		
		// The current table name of the user relating to the old username
		String CURRENT_TABLE_NAME = current_username + "_Post_Details"; 
		// The new table name of the user relating to the new username
		String NEW_TABLE_NAME = new_username + "_Post_Details";          

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			// To alter the table and rename it to the new username
			String renameTableSQL = "ALTER TABLE " + CURRENT_TABLE_NAME + " RENAME TO " + NEW_TABLE_NAME;
			
			stmt.execute(renameTableSQL);
			
			outputMessage = "Table renamed sucesfully";
			
		} catch (SQLException e) {
			outputMessage = e.getMessage();
		}
		
		// To return the final output of the process
		return outputMessage;
	}
	
	
	
	// To validate the login details that the user has entered upon login  
	public String validateLoginDetails(String Username) {
		
		// The table containing the details of the user
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = DatabaseConnection.getConnection();
								
				// Statement to select the password from the table relating to the specified username the user has enrered
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, Username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				// A do-while loop is used to loop through the existing records and extract the password pertaining to the username of the user
				do {
					output = resultSet.getString("password");
				
				} while (resultSet.next());
				
				
			} else {
				// If there are no existing records with the username the user has entered on login screen 
				output = "Username not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
							
	}
	
	
	
	// Method to retrieve the Full name of the user upon login 
	public String getNameUser(String username) {
		
		// Table to look for
		final String TABLE_NAME = "User_Details";
		
		ResultSet resultSet = null;
		
		String output = null;
		
		// To establish a connection to the database
		try (Connection con = DatabaseConnection.getConnection();
				
				// Statement to select the details from the table relating to the username
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?")){
			prepareStatement.setString(1, username);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					// To extract both the first name and the last name and to output it
					output = String.format("%s %s", resultSet.getString("first_name"), resultSet.getString("last_name"));
				
				} while (resultSet.next());
				
				
			} else {
				output = "Name not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		// To return the final output of the process
		return output;
						
	}

	
	
	// To save the post data to the relevant post details table of the user
	public String savePosts(String username, String ID, String content, String author, String likes, String shares, String date_time) {
		
		String outputMessage = null;
		
		// Specify the table name of the user
		final String TABLE_NAME = username + "_Post_Details";  
		
		try (Connection con = DatabaseConnection.getConnection()){
			
			// To check if there are any existing posts with the same ID of the new post to be added
			try(PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE id = ?")){
				checkStatement.setString(1, ID);
				
				
				ResultSet resultSet = checkStatement.executeQuery();
				
				resultSet.next();
				
				// To get the count of the posts if there are any existing posts in the database already
				int existingPostCount = resultSet.getInt(1);
				
				// If there are any existing posts with the same ID, the post will not be added and the error message will be displayed to the user
				if (existingPostCount > 0) {
					outputMessage = "Invalid post ID. Post with the current ID already exists!";
				}
				
				// If not, the post will be added to the database
				if (existingPostCount == 0) {
				
				    try(PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?, ?)")){
						prepareStatement.setString(1, ID);
						prepareStatement.setString(2, content);
						prepareStatement.setString(3, author);
						prepareStatement.setString(4, likes);
						prepareStatement.setString(5, shares);
						prepareStatement.setString(6, date_time);
				
						int result = prepareStatement.executeUpdate();
				
						// If successful, the user will be notified that the new post has been added
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
					
			// To return the final output of the process
			return outputMessage;
				
	}		
	
	
	
	// Method to remove a post from the database
	public String removePosts(String username, int iD) {
		
		String outputMessage = null;
		
		// The table name containing the username of the user
		final String TABLE_NAME = username + "_Post_Details"; 
		
		
		try (Connection con = DatabaseConnection.getConnection();
				
				// To delete the post containing the specific post id
				PreparedStatement prepareStatement = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			int result = prepareStatement.executeUpdate();
			
			// If the deletion is successful, the message will be displayed to the user
			if (result == 1) {
				outputMessage = "Post deleted successfully!";
			}
			else {
				// If there are no posts related to the specified ID, the user will be notified about it
				outputMessage = "Post not found";
			}
			
		} catch(SQLException e) {
			outputMessage = e.getMessage();
			e.printStackTrace();
		}
				
		return outputMessage;
			
		}
		
		

	// Method to retrieve a post of the user
	public String retrievePosts(String username, int iD) {
		
		// The table name of the user
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = DatabaseConnection.getConnection();
				
				// To select the post containing the specified ID by the user
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					// To output the post with the specified ID in the database
					// The format to output is defined here 
					output = String.format("ID: %d | Content: %s | Author: %s | Likes: %d | Shares: %d | Date/Time: %s\n",
							resultSet.getInt("id"), resultSet.getString("content"), resultSet.getString("author"), resultSet.getInt("likes"),
							resultSet.getInt("shares"), resultSet.getString("date_time"));
				
				} while (resultSet.next());
				
			} else {
				// If there are no exiting posts with the defined ID
				output = "Post not found";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
		}
	
	
	
	// Method to export a post based on the ID
	public String exportPosts(String username, int iD) {
		
		// Table name of the user containing posts
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = DatabaseConnection.getConnection();
				
				// Select a post from the table with the specified ID
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")){
			prepareStatement.setInt(1, iD);
		
			
			resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				
				do {
					// To output the post with the specified ID in the database
					// The format to be exported in the csv file is defined here 
					output = resultSet.getInt("id") + "," + resultSet.getString("content") + "," + resultSet.getString("author") + "," + resultSet.getInt("likes") + 
							"," + resultSet.getInt("shares") + "," + resultSet.getString("date_time");
				
				} while (resultSet.next());
				
			} else {
				// If there are no exiting posts with the defined ID
				output = "Post not found!";
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
		}
	
	
	
	// Method to retrieve the posts with the most likes
	public String retrievePostLikes(String username, int number) {
		
		// Table name of the user containing posts
		final String TABLE_NAME = username + "_Post_Details"; 
		
		ResultSet resultSet = null;
		
		String output = null;
		
		
		try (Connection con = DatabaseConnection.getConnection();
				
				// Select posts from the table and order them by likes in descending order
				PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " ORDER BY likes DESC LIMIT ?")){
			prepareStatement.setInt(1, number);
						
			resultSet = prepareStatement.executeQuery();
			
			
			if (resultSet.next()) {
				
				output = "";
				
				do {
					// To output the post with the specified ID in the database
					// The format to output is defined here 
					output += String.format("ID: %d | Content: %s | Author: %s | Likes: %d | Shares: %d | Date/Time: %s \n",
							resultSet.getInt("id"), resultSet.getString("content"), resultSet.getString("author"), resultSet.getInt("likes"),
							resultSet.getInt("shares"), resultSet.getString("date_time"));
				
				} while (resultSet.next());
				
			} else {
				// If there are no posts in the database
				output = "No posts found!";
			}
			
				
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
				
		return output;
			
	}
	
	
	
	// Method to retrieve the posts and categorize them depending on the number of shares
	public String retrieveSharesPosts(String username) {
		
		String output= null;
		
		// The table name containing the posts of the user
		final String TABLE_NAME = username + "_Post_Details"; 
		
		// The attributes of the three groups of shares are defined 
		int firstGroup = 0;
		int secondGroup = 0;
		int thirdGroup = 0;
		
		
		try (Connection con = DatabaseConnection.getConnection();
				
				// To select shares, to count them, and to group by the number shares in the posts 
				PreparedStatement prepareStatement = con.prepareStatement("SELECT shares, COUNT(*) FROM " + TABLE_NAME + " GROUP BY shares")){
		
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
			
				// Attributes to sore the grouped shares as well as their counts
				int shares = resultSet.getInt("shares");
				int count = resultSet.getInt("COUNT(*)");
				
				// If the shares are in the range of 0 to 99, the count number will be added to the first group
				if (shares >= 0 && shares <= 99) {
					firstGroup += count;
				}
				
				// If the shares are in the range of 100 to 999, the count number will be added to the second group
				if (shares >= 100 && shares <= 999) {
					secondGroup += count;
				}
				
				// If the shares are in the range above 1000, the count number will be added to the third group
				if (shares >= 1000) {
					thirdGroup += count;
				}
			}
			
			
		} catch(SQLException e) {
			output = e.getMessage();
			e.printStackTrace();
		}
		
		// The result values will be converted to Strings before passing over to the next method for further analyzing
		String firstGroup1 = Integer.toString(firstGroup);
		String secondGroup1 = Integer.toString(secondGroup);
		String thirdGroup1 = Integer.toString(thirdGroup);
		
		output = firstGroup1 + "," + secondGroup1 + "," + thirdGroup1;
		
		return output;
	}

}
