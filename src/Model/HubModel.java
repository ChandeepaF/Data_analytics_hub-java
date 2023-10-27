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

	private static HubModel hubModel;
	
	private Post post;
	
	private User user;
	
	private DatabaseHandler dbHandler;
	
	public HubModel() {
		post = new Post();
		user = new User();
		dbHandler = new DatabaseHandler();
	}
	
	
	public static HubModel getInstance() {
		if(hubModel == null) {
			return new HubModel();
		}else {
			return hubModel;
		}
	}
	
	
	
	public String savePersonalData(String usernameData, String passwordData, String firstnameData, String lastnameData) {
		return dbHandler.savePersonalDetails(usernameData, passwordData, firstnameData, lastnameData);
	}
	
	
	public String updatePersonalData(String currentUsername, String newUsername, String newPassword, String newFirstname, String newLastname) {
		return dbHandler.updatePersonalDetails(currentUsername, newUsername, newPassword, newFirstname, newLastname);
	}
	
	
	public String savePostData(String Username, String IDData, String contentData, String authorData, String likesData, String sharesData, String date_timeData) {
		return dbHandler.savePosts(Username, IDData, contentData, authorData, likesData, sharesData, date_timeData);
	}
	
	
	public String checkLoginData(String usernameLoginData) {
		return dbHandler.validateLoginDetails(usernameLoginData);
	}
	
	
	
	public static ArrayList<String> Store_username = new ArrayList<String>();
	
	public static ArrayList<String> Store_userType = new ArrayList<String>();
	
	
	
	public String verifyLoginData(String usernameLoginData, String passwordLoginData) throws InvalidUsernameException, InvalidPasswordException {
		
		String output = null;
		String savedPassword = null;
		String loginUsername = null;
		String loginPassword = null;

		
		try {
			loginUsername = user.validateUsernameData(usernameLoginData);
		}catch (InvalidUsernameException e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			loginPassword = user.validatePasswordData(passwordLoginData);
		}catch (InvalidPasswordException e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		try {
			savedPassword =  dbHandler.validateLoginDetails(loginUsername);
		}catch (Exception e) {
			throw new InvalidUsernameException("Invalid username");
		}
		
		if(savedPassword.equals(loginPassword)) {
			output = "Access granted";
			
			if(Store_username.size() == 0) {
				Store_username.add(loginUsername);
			}
			
			else {
				Store_username.set(0, loginUsername);
			}
		}
		if(savedPassword.equals("Username not found!")) {
			output = "Username is invalid";
		}

		if(!savedPassword.equals(loginPassword) && !savedPassword.equals("Username not found!")) {
			output = "Password is invalid";
		}
		
		return output;
	}
	
	
	
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
	
	

	public String addPersonalData(String usernameData, String passwordData, String firstnameData, String lastnameData) {
		
		String output = null;
		
		String Username = null;
		String Password = null;
		String FirstName = null;
		String LastName = null;
		
		try {
			Username = user.validateUsernameData(usernameData);
		}catch (InvalidUsernameException e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			Password = user.validatePasswordData(passwordData);
		}catch (InvalidPasswordException e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		try {
			FirstName = user.validateFirstNameData(firstnameData);
		}catch (InvalidFirstnameException e9) {
			output = e9.getMessage();
			return output;
		}
		
		
		try {
			LastName = user.validateLastNameData(lastnameData);
		}catch (InvalidLastnameException e10) {
			output = e10.getMessage();
			return output;
		}
		
		output = savePersonalData(Username, Password, FirstName, LastName);
		
		if(output.equals("Data saved successfully")) {
			
			dbHandler.createPostTable(Username);
		}
		
		
		return output;

	}
	

	
	public String editProfile(String currentUsernameData, String newUsernameData, String newPasswordData, String newFirstnameData, String newLastnameData) throws InvalidUsernameException {
		
		String output = null;
		
		String current_username = null;
		String new_username = null;
		String new_password = null;
		String new_first_name = null;
		String new_last_name = null;
		
		if (currentUsernameData.equals(newUsernameData)) {
			return "Current username & New username are the same! Enter again.";
		}
		
		else {
						
			try {
				current_username = user.validateUsernameData(currentUsernameData);
			}catch (InvalidUsernameException e7) {
				output = e7.getMessage();
				return output;
			}
			
			
			try {
				new_username = user.validateUsernameData(newUsernameData);
			}catch (InvalidUsernameException e7) {
				output = e7.getMessage();
				return output;
			}
			
			try {
				new_password = user.validatePasswordData(newPasswordData);
			}catch (InvalidPasswordException e8) {
				output = e8.getMessage();
				return output;
			}
			
			
			try {
				new_first_name = user.validateFirstNameData(newFirstnameData);
			}catch (InvalidFirstnameException e9) {
				output = e9.getMessage();
				return output;
			}
			
			
			try {
				new_last_name = user.validateLastNameData(newLastnameData);
			}catch (InvalidLastnameException e10) {
				output = e10.getMessage();
				return output;
			}
			
			output = updatePersonalData(current_username, new_username, new_password, new_first_name, new_last_name);
			
			if (output.equals("Personal data updated successfully!")) {
				Store_username.set(0, newUsernameData);
				dbHandler.renamePostTable(current_username, new_username);
			}
		}
		
		return output;
	}
	
	
	
	public String getUserType() {
		
		String Username = null;
		String type = null;
		
		Username = Store_username.get(0);
		
		type = dbHandler.checkUserType(Username);
		

		if(type.equals("vip")) {
			
			type = "vip";
			
			if(Store_userType.size() == 0) {
				Store_userType.add(type);
			}
			
			else {
				Store_userType.set(0, type);
			}
		}
		
		
		if(type.equals("normal")) {
			
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
	

	
	public String upgradeVip() {
		
		String Username = null;
		String output = null;
		
		Username = Store_username.get(0); 
		
		output = dbHandler.changeVip(Username);
		
		return output;
	}


	
	public String addpostData(String IDData, String contentData, String authorData, String likesData, String sharesData, String dateTimeData) {
		
		String output = null;
		
		int ID = 0;
		String Content = null;
		String Author = null;
		int Likes = 0;
		int Shares = 0;
		String Date_time = null;
		String Username = null;

		
		try {
			ID = post.validateIdData(IDData);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		
		try {
			Content = post.validateContentData(contentData);
		}catch (Exception e2) {
			output = e2.getMessage();
			return output;
		}
		
		
		try {
			Author = post.validateAuthorData(authorData);
		}catch (Exception e3) {
			output = e3.getMessage();
			return output;
		}
		
		
		try {
			Likes = post.validateLikesData(likesData);
		}catch (InvalidLikesException e4) {
			output = e4.getMessage();
			return output;
		}
		
		
		try {
			Shares = post.validateSharesData(sharesData);
		}catch (InvalidSharesException e5) {
			output = e5.getMessage();
			return output;
		}
		
		
		try {
			Date_time = post.validateDateTimeData(dateTimeData);
		}catch (InvalidDateFormatException e6) {
			output = e6.getMessage();
			return output;
		}
		
		String ID1 = Integer.toString(ID);
		String Likes1 = Integer.toString(Likes);
		String Shares1 = Integer.toString(Shares);
		
		Username = Store_username.get(0);
		
		output = savePostData(Username, ID1, Content, Author, Likes1, Shares1, Date_time);
		
		return output;
		
		
	}



	public String retrieveExistingPost(String retrieveID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		
		try {
			ID = post.validateIdData(retrieveID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);
		
		output = dbHandler.retrievePosts(Username, ID);
				
		return output;
		
	}
	
	
	
	public String retrieveTopLikes(String postNumber) {
		
		String output = null;
		int Number = 0;
		String Username = null;
		
		try {
			Number = post.validateLikesPost(postNumber);
		}catch (InvalidPostNumberException e11) {
			output = e11.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);
		
		output = dbHandler.retrievePostLikes(Username, Number);
		
		return output;
	}
	
	
	
	public String deleteExistingPost(String deleteID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		try {
			ID = post.validateIdData(deleteID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);

		output = dbHandler.removePosts(Username, ID);
		
		return output;
	}
	
	

	public String exportCsvPost(String exportID, String exportFolder, String exportFilename) {
		
		String output = null;
		int expID = 0;
		String expFoldername = null;
		String expFilename = null;
		String Username = null;
		String Post = null;
		
		
		try {
			expID = post.validateIdData(exportID);
		}catch (InvalidIdException e1) {
			output = e1.getMessage();
			return output;
		}
		
		
		try {
			expFoldername = post.validateExportFolder(exportFolder);
		}catch (InvalidFolderException e20) {
			output = e20.getMessage();
			return output;
		}
		
		
		try {
			expFilename = post.validateExportFilename(exportFilename);
		}catch (InvalidFilenameException e21) {
			output = e21.getMessage();
			return output;
		}
		
		
		String fileName = expFilename + ".csv";
		
		Username = Store_username.get(0);
		
		Post = dbHandler.exportPosts(Username,expID);
		
		
		if(Post.equals("Post not found!")) {
			
			output = "Post not found. Invalid ID!";
			return output;
		}
		
		else {
		
			try {
				
				File folder = new File(expFoldername);
				File file = new File(folder, fileName);
				
				if(!folder.exists()) {
					folder.mkdirs();
					output = "Unable to locate folder";
				}
				
				FileWriter writer = new FileWriter(file);
				
				
				if (Post != null) {
					
					writer.write("ID, Content, Author, Likes, Shares, Date/Time \n");
					
					writer.write(Post);
					
					writer.close();
					
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
				
								
				try {
					ID = post.validateIdData(posts[0]);
				}catch (InvalidIdException e1) {
					output = e1.getMessage();
					return output;
				}
				
				
				try {
					Content = post.validateContentData(posts[1]);
				}catch (Exception e2) {
					output = e2.getMessage();
					return output;
				}
				
				
				try {
					Author = post.validateAuthorData(posts[2]);
				}catch (Exception e3) {
					output = e3.getMessage();
					return output;
				}
				
				
				try {
					Likes = post.validateLikesData(posts[3]);
				}catch (InvalidLikesException e4) {
					output = e4.getMessage();
					return output;
				}
				
				
				try {
					Shares = post.validateSharesData(posts[4]);
				}catch (InvalidSharesException e5) {
					output = e5.getMessage();
					return output;
				}
				
				
				try {
					Date_time = post.validateDateTimeData(posts[5]);
				}catch (InvalidDateFormatException e6) {
					output = e6.getMessage();
					return output;
				}
				
				String ID1 = Integer.toString(ID);
				String Likes1 = Integer.toString(Likes);
				String Shares1 = Integer.toString(Shares);
				
				Username = Store_username.get(0);
				
				output = savePostData(Username, ID1, Content, Author, Likes1, Shares1, Date_time);
				
				
				}
			}
			
			
		} catch(IOException e) {
			output = "File cannot be found!";
			e.printStackTrace();
				
		}
		
	return output; 
	
	}
	
	
	
	public ObservableList<Data> dataVisualization() {
		
		String output = null;
		
		String Username = null;
		String shareValues = null;
		
		
		Username = Store_username.get(0);
		
		shareValues = dbHandler.retrieveSharesPosts(Username);
		
		
		String [] token_shares = shareValues.split(",");
		
		int firstGroup = Integer.parseInt(token_shares[0]);
		int secondGroup = Integer.parseInt(token_shares[1]);
		int thirdGroup = Integer.parseInt(token_shares[2]);

		
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("0 - 99 Shares", firstGroup),
						new PieChart.Data("100 - 999 Shares", secondGroup),
						new PieChart.Data("Above 1000 Shares", thirdGroup));
		
		
		return pieChartData;
		
	}

}

