package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import Model.Database.DatabaseHandler;
import Model.Exceptions.InvalidIdException;
import Model.Exceptions.InvalidLastnameException;
import Model.Exceptions.InvalidLikesException;
import Model.Exceptions.InvalidPasswordException;
import Model.Exceptions.InvalidPostNumberException;
import Model.Exceptions.InvalidSharesException;
import Model.Exceptions.InvalidUsernameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import Model.Exceptions.InvalidDateFormatException;
import Model.Exceptions.InvalidFilenameException;
import Model.Exceptions.InvalidFirstnameException;
import Model.Exceptions.InvalidFolderException;

public class HubModel {

	// Instances of the classes are created
	private static HubModel hubModel;
	
	private Post post;
	
	private User user;
	
	private DatabaseHandler dbHandler;
	
	// The "HubModel" method is made public for the unit tests to be able to reach  
	public HubModel() {
		post = new Post();
		user = new User();
		dbHandler = new DatabaseHandler();
	}
	
	
	// A single instance of the "Hubmodel" is created to incorporate the Singleton pattern of coding
	public static HubModel getInstance() {
		if(hubModel == null) {
			return new HubModel();
		}else {
			return hubModel;
		}
	}
	
	
	
	// To transfer the data to the database handler to save the person information
	public String savePersonalData(String usernameData, String passwordData, String firstnameData, String lastnameData) {
		return dbHandler.savePersonalDetails(usernameData, passwordData, firstnameData, lastnameData);
	}
	
	
	// To transfer the data to the update personal details method in the database handler
	public String updatePersonalData(String currentUsername, String newUsername, String newPassword, String newFirstname, String newLastname) {
		return dbHandler.updatePersonalDetails(currentUsername, newUsername, newPassword, newFirstname, newLastname);
	}
	
	
	// To send the post data to the database handler to be saved
	public String savePostData(String Username, String IDData, String contentData, String authorData, String likesData, String sharesData, String date_timeData) {
		return dbHandler.savePosts(Username, IDData, contentData, authorData, likesData, sharesData, date_timeData);
	}
	
	
	// To transfer the login details of the user to verify if the data is correct
	public String checkLoginData(String usernameLoginData) {
		return dbHandler.validateLoginDetails(usernameLoginData);
	}
	
	
	
	// An array list to store the username of the user once logged in. This will be the same until the user sign out
	public static ArrayList<String> Store_username = new ArrayList<String>();
	
	// An array list to store the type of the user,if vip  or normal
	public static ArrayList<String> Store_userType = new ArrayList<String>();
	
	
	
	// Method to verify the login data of the user at sign in
	public String verifyLoginData(String usernameLoginData, String passwordLoginData) throws InvalidUsernameException, InvalidPasswordException {
		
		// Initializing the variables
		String output = null;
		String savedPassword = null;
		String loginUsername = null;
		String loginPassword = null;

		
		// To validate if the username is empty
		try {
			loginUsername = user.validateUsernameData(usernameLoginData);
		}catch (InvalidUsernameException e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		// To validate if the password is empty
		try {
			loginPassword = user.validatePasswordData(passwordLoginData);
		}catch (InvalidPasswordException e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		// To transfer the username to the database to retrieve the corresponding password if present
		try {
			savedPassword =  dbHandler.validateLoginDetails(loginUsername);
		}catch (Exception e) {
			throw new InvalidUsernameException("Invalid username");
		}
		
		// If the password saved in the database is similar to what the user entered, access will be granted
		if(savedPassword.equals(loginPassword)) {
			output = "Access granted";
			
			// To add the username to the array list to save for future use until the user logs out
			if(Store_username.size() == 0) {
				Store_username.add(loginUsername);
			}
			
			else {
				Store_username.set(0, loginUsername);
			}
		}
		// If the username the user entered is not found in the database, an error message will be displayed
		if(savedPassword.equals("Username not found!")) {
			output = "Username is invalid";
		}

		// If the username is found, but password is wrong, the error will be displayed to the user
		if(!savedPassword.equals(loginPassword) && !savedPassword.equals("Username not found!")) {
			output = "Password is invalid";
		}
		
		return output;
	}
	
	
	
	// To retrieve the full name of the user from the database
	public String getName(String username) {
		
		String output = null;

		try {
			output = dbHandler.getNameUser(username);
			
		}catch (Exception e) {
			output = e.getMessage();
			return output;
		}
		
		return output;
	}
	
	

	// Method to add the person data to the database upon first sign up
	public String addPersonalData(String usernameData, String passwordData, String firstnameData, String lastnameData) {
		
		String output = null;
		
		String Username = null;
		String Password = null;
		String FirstName = null;
		String LastName = null;
		
		// To check if the username the user entered is valid
		try {
			Username = user.validateUsernameData(usernameData);
		}catch (InvalidUsernameException e7) {
			output = e7.getMessage();
			return output;
		}
		
		// To check if the password the user entered is valid
		try {
			Password = user.validatePasswordData(passwordData);
		}catch (InvalidPasswordException e8) {
			output = e8.getMessage();
			return output;
		}
		
		// To check if the First name the user entered is valid
		try {
			FirstName = user.validateFirstNameData(firstnameData);
		}catch (InvalidFirstnameException e9) {
			output = e9.getMessage();
			return output;
		}
		
		// To check if the Last name the user entered is valid
		try {
			LastName = user.validateLastNameData(lastnameData);
		}catch (InvalidLastnameException e10) {
			output = e10.getMessage();
			return output;
		}
		
		// If the data is valid, it will be transfered to the database handler 
		output = savePersonalData(Username, Password, FirstName, LastName);
		
		if(output.equals("Data saved successfully")) {
			
			// If the data is saved successfully, a post table containing the username of the user will be created
			dbHandler.createPostTable(Username);
		}
		
		
		return output;

	}
	

	
	// Method to edit the profile of the already existing user
	public String editProfile(String currentUsernameData, String newUsernameData, String newPasswordData, String newFirstnameData, String newLastnameData) throws InvalidUsernameException {
		
		String output = null;
		
		String current_username = null;
		String new_username = null;
		String new_password = null;
		String new_first_name = null;
		String new_last_name = null;
		
		
		// If the current username and the new username the user entered are both the same, the error message will be displayed to the user
		if (currentUsernameData.equals(newUsernameData)) {
			return "Current username & New username are the same! Enter again.";
		}
		
		// If they are different, the data will be validated
		else {
				
			// To validate the current username the user entered, if it is empty or not
			try {
				current_username = user.validateUsernameData(currentUsernameData);
			}catch (InvalidUsernameException e7) {
				output = e7.getMessage();
				return output;
			}
			
			// To validate the new username the user entered, if it is empty or not
			try {
				new_username = user.validateUsernameData(newUsernameData);
			}catch (InvalidUsernameException e7) {
				output = e7.getMessage();
				return output;
			}
			
			// To validate the password the user entered, if it is empty or not
			try {
				new_password = user.validatePasswordData(newPasswordData);
			}catch (InvalidPasswordException e8) {
				output = e8.getMessage();
				return output;
			}
			
			// To validate the First name the user entered, if it is empty or doesn't contain digits
			try {
				new_first_name = user.validateFirstNameData(newFirstnameData);
			}catch (InvalidFirstnameException e9) {
				output = e9.getMessage();
				return output;
			}
			
			// To validate the Last name the user entered, if it is empty or doesn't contain digits
			try {
				new_last_name = user.validateLastNameData(newLastnameData);
			}catch (InvalidLastnameException e10) {
				output = e10.getMessage();
				return output;
			}
			
			// To send the data to the database handler to update the existing records
			output = updatePersonalData(current_username, new_username, new_password, new_first_name, new_last_name);
			
			// If the data is updated successfully
			if (output.equals("Personal data updated successfully!")) {
				// The existing username in the array list will be changed to the new username 
				Store_username.set(0, newUsernameData);
				
				// The already existing Post table of the user with the old username will be changed to the new username
				dbHandler.renamePostTable(current_username, new_username);
			}
		}
		
		return output;
	}
	
	
	
	// To get the type of the user from the database
	public String getUserType() {
		
		String Username = null;
		String type = null;
		
		// The username of the user is retrieved from the array list first
		Username = Store_username.get(0);
		
		// The username of the user is transfered to the database handler to validate the type
		type = dbHandler.checkUserType(Username);
		

		if(type.equals("vip")) {
			
			// If the user is vip, the array list for the type of the user will be set or updated to vip
			type = "vip";
			
			if(Store_userType.size() == 0) {
				Store_userType.add(type);
			}
			
			else {
				Store_userType.set(0, type);
			}
		}
		
		
		if(type.equals("normal")) {
			
			// If the user is normal, the array list for the type of the user will be set or updated to normal
			type = "normal";
			
			if(Store_userType.size() == 0) {
				Store_userType.add(type);
			}
			
			else {
				Store_userType.set(0, type);
			}
		}
		
		return type;
		
	}
	

	
	// This method will be called to upgrade a normal user to a vip user
	public String upgradeVip() {
		
		String Username = null;
		String output = null;
		
		// To retrieve the existing username from the array list
		Username = Store_username.get(0); 
		
		// to transfer to username to the database handler to change the type of the user in the database from normal to vip
		output = dbHandler.changeVip(Username);
		
		return output;
	}


	
	// This method is called to add the post data to the table in the database under the user's username
	public String addpostData(String IDData, String contentData, String authorData, String likesData, String sharesData, String dateTimeData) {
		
		String output = null;
		
		int ID = 0;
		String Content = null;
		String Author = null;
		int Likes = 0;
		int Shares = 0;
		String Date_time = null;
		String Username = null;

		
		// To validate the ID that the user entered, if doesn't contain only digits or is empty
		try {
			ID = post.validateIdData(IDData);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		// To validate the content that the user entered, if it is empty
		try {
			Content = post.validateContentData(contentData);
		}catch (Exception e2) {
			output = e2.getMessage();
			return output;
		}
		
		// To validate the author that the user entered, if it is empty
		try {
			Author = post.validateAuthorData(authorData);
		}catch (Exception e3) {
			output = e3.getMessage();
			return output;
		}
		
		// To validate the likes that the user entered, if doesn't contain only digits or is empty
		try {
			Likes = post.validateLikesData(likesData);
		}catch (InvalidLikesException e4) {
			output = e4.getMessage();
			return output;
		}
		
		// To validate the shares that the user entered, if doesn't contain only digits or is empty
		try {
			Shares = post.validateSharesData(sharesData);
		}catch (InvalidSharesException e5) {
			output = e5.getMessage();
			return output;
		}
		
		// To validate the date and time that the user entered, if it is empty
		try {
			Date_time = post.validateDateTimeData(dateTimeData);
		}catch (InvalidDateFormatException e6) {
			output = e6.getMessage();
			return output;
		}
		
		// Convereted to a string before being transfered to the database handler
		String ID1 = Integer.toString(ID);
		String Likes1 = Integer.toString(Likes);
		String Shares1 = Integer.toString(Shares);
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);
		
		// Data is transfered to the database handler
		output = savePostData(Username, ID1, Content, Author, Likes1, Shares1, Date_time);
		
		return output;
		
		
	}



	// Method to retrieve an existing post from the database under the user's own table 
	public String retrieveExistingPost(String retrieveID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		
		// To validate the ID that the user entered, if doesn't contain only digits or is empty
		try {
			ID = post.validateIdData(retrieveID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);
		
		// The ID of the requested post and the user's username are both transfered to the database handler to retrieve the post
		output = dbHandler.retrievePosts(Username, ID);
				
		return output;
		
	}
	
	
	
	// Method to retrieve the posts with the most likes
	public String retrieveTopLikes(String postNumber) {
		
		String output = null;
		int Number = 0;
		String Username = null;
		
		
		// To validate the number of posts that the user entered, if doesn't contain only digits or is empty
		try {
			Number = post.validateLikesPost(postNumber);
		}catch (InvalidPostNumberException e11) {
			output = e11.getMessage();
			return output;
		}
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);
		
		// The number of the requested post/posts and the user's username are both transfered to the database handler to retrieve the post/posts
		output = dbHandler.retrievePostLikes(Username, Number);
		
		return output;
	}
	
	
	
	// This method is defined to delete an existing post from the database under the user's name
	public String deleteExistingPost(String deleteID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		
		// To validate the ID that the user entered, if doesn't contain only digits or is empty
		try {
			ID = post.validateIdData(deleteID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);

		// The ID of the post to be deleted and the user's username are both transfered to the database handler to delete the post
		output = dbHandler.removePosts(Username, ID);
		
		return output;
	}
	
	

	// Method to export a post to a csv file
	public String exportCsvPost(String exportID, String exportFolder, String exportFilename) {
		
		String output = null;
		int expID = 0;
		String expFoldername = null;
		String expFilename = null;
		String Username = null;
		String Post = null;
		
		
		// To validate the ID that the user entered, if doesn't contain only digits or is empty
		try {
			expID = post.validateIdData(exportID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		// To check if the folder selected is empty
		try {
			expFoldername = post.validateExportFolder(exportFolder);
		}catch (InvalidFolderException e20) {
			output = e20.getMessage();
			return output;
		}
		
		// To validate if the user has not entered a file name 
		try {
			expFilename = post.validateExportFilename(exportFilename);
		}catch (InvalidFilenameException e21) {
			output = e21.getMessage();
			return output;
		}
		
		
		// Defining the filename of the file, as a csv file
		String fileName = expFilename + ".csv";
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);
		
		// The ID of the requested post and the user's username are both transfered to the database handler to retrieve the post
		Post = dbHandler.exportPosts(Username,expID);
		
		
		// If there is no post with the entered post ID, an error message will be displayed to the user
		if(Post.equals("Post not found!")) {
			
			output = "Post not found. Invalid ID!";
			return output;
		}
		
		// If the post is found, the post will be exported
		else {
		
			try {
				// File is called and the folder path and the file name are both defined
				File folder = new File(expFoldername);
				File file = new File(folder, fileName);
				
				if(!folder.exists()) {
					folder.mkdirs();
					output = "Unable to locate folder";
				}
				
				// FileWriter is called to write the data to the csv file
				FileWriter writer = new FileWriter(file);
				
				
				// The data is written to the csv file
				if (Post != null) {
					
					// The first row containing the heading
					writer.write("ID, Content, Author, Likes, Shares, Date/Time \n");
					
					// Next, the post is written
					writer.write(Post);
					
					writer.close();
					
					// Message to let the user know if the exporting was successfull or not
					output = "Post saved to file!";
				}
				
			}
			catch (IOException e) {
				e.printStackTrace();
				output = "Unable to save posts!";
			}
		}
		
		return output;
		
	}
	
	
	
	// Method to import posts from a csv file to the database
	public String importCsvPosts(String path) {
		
		String output = null;
		
		int ID = 0;
		String Content = null;
		String Author = null;
		int Likes = 0;
		int Shares = 0;
		String Date_time = null;
		String Username = null;
		
		String line = " ";
		String splitBy = ",";
		int iteration = 0;
		

		try {
			//To load the file
			FileReader myreader = new FileReader(path);
			BufferedReader br = new BufferedReader(myreader);
			
			while ((line = br.readLine()) != null){
				//To skip the first line which contains the header
				if(iteration == 0){
					iteration++;
					continue;
				}
				
				{String[] posts = line.split(splitBy);
				
				
				// To validate the ID that the user entered, if doesn't contain only digits or is empty				
				try {
					ID = post.validateIdData(posts[0]);
				}catch (InvalidIdException e1) {
					output = e1.getMessage();
					return output;
				}
				
				// To validate the content that the user entered, if it is empty
				try {
					Content = post.validateContentData(posts[1]);
				}catch (Exception e2) {
					output = e2.getMessage();
					return output;
				}
				
				// To validate the author that the user entered, if it is empty
				try {
					Author = post.validateAuthorData(posts[2]);
				}catch (Exception e3) {
					output = e3.getMessage();
					return output;
				}
				
				// To validate the likes that the user entered, if doesn't contain only digits or is empty
				try {
					Likes = post.validateLikesData(posts[3]);
				}catch (InvalidLikesException e4) {
					output = e4.getMessage();
					return output;
				}
				
				// To validate the shares that the user entered, if doesn't contain only digits or is empty
				try {
					Shares = post.validateSharesData(posts[4]);
				}catch (InvalidSharesException e5) {
					output = e5.getMessage();
					return output;
				}
				
				// To validate the date and time that the user entered, if it is empty
				try {
					Date_time = post.validateDateTimeData(posts[5]);
				}catch (InvalidDateFormatException e6) {
					output = e6.getMessage();
					return output;
				}
				
				// Convereted to a string before being transfered to the database handler
				String ID1 = Integer.toString(ID);
				String Likes1 = Integer.toString(Likes);
				String Shares1 = Integer.toString(Shares);
				
				// The username is retrieved from the array list containing the username
				Username = Store_username.get(0);
				
				// Data is transfered to the database handler
				output = savePostData(Username, ID1, Content, Author, Likes1, Shares1, Date_time);
				
				
				}
			}
			
			
		} catch(IOException e) {
			output = "File cannot be found!";
			e.printStackTrace();
				
		}
		
	return output; 
	
	}
	
	
	
	// Method to retrieve the data for the Pie chart
	public ObservableList<Data> dataVisualization() {
		
		String output = null;
		
		String Username = null;
		String shareValues = null;
		
		// The username is retrieved from the array list containing the username
		Username = Store_username.get(0);
		
		// The username is transfered to the database handler to retrieve the shares in its corresponding groups
		shareValues = dbHandler.retrieveSharesPosts(Username);
		
		
		// The retrieved values are split by "," and added to a list
		String [] token_shares = shareValues.split(",");
		
		int firstGroup = Integer.parseInt(token_shares[0]);
		int secondGroup = Integer.parseInt(token_shares[1]);
		int thirdGroup = Integer.parseInt(token_shares[2]);

		
		// All the data is then added to an Observable List for the Pie chart to retrieve the data from 
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("0 - 99 Shares", firstGroup),
						new PieChart.Data("100 - 999 Shares", secondGroup),
						new PieChart.Data("Above 1000 Shares", thirdGroup));
		
		
		return pieChartData;
		
	}

}

