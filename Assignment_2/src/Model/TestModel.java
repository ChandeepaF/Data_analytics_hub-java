package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Database.Database_Handler;
import Model.Exceptions.Invalid_ID_Exception;
import Model.Exceptions.Invalid_Lastname_Exception;
import Model.Exceptions.Invalid_Likes_Exception;
import Model.Exceptions.Invalid_Password_Exception;
import Model.Exceptions.Invalid_PostNumber_Exception;
import Model.Exceptions.Invalid_Shares_Exception;
import Model.Exceptions.Invalid_Username_Exception;
import Model.Exceptions.Invalid_DateFormat_Exception;
import Model.Exceptions.Invalid_Firstname_Exception;

public class TestModel {

	private static TestModel testModel;
	
	private Operator operator;
	
	private User user;
	
	private Database_Handler dbHandler;
	
	private TestModel() {
		operator = new Operator();
		user = new User();
		dbHandler = new Database_Handler();
	}
	
	
	public static TestModel getInstance() {
		if(testModel == null) {
			return new TestModel();
		}else {
			return testModel;
		}
	}
	
	
	
	public String save_Personal_Data(String usernameData, String passwordData, String firstnameData, String lastnameData) {
		return dbHandler.Save_Personal_Details(usernameData, passwordData, firstnameData, lastnameData);
	}
	
	
	public String update_Personal_Data(String current_username, String new_username, String new_password, String new_first_name, String new_last_name) {
		return dbHandler.updatePersonalDetails(current_username, new_username, new_password, new_first_name, new_last_name);
	}
	
	
	public String save_Post_Data(String Username, String IDData, String contentData, String authorData, String likesData, String sharesData, String date_timeData) {
		return dbHandler.Save_Posts(Username, IDData, contentData, authorData, likesData, sharesData, date_timeData);
	}
	
	
	public String check_Login_Data(String usernameLoginData) {
		return dbHandler.validate_Login_Details(usernameLoginData);
	}
	

	
	
	public String verify_Login_Data(String usernameLoginData, String passwordLoginData) throws Invalid_Username_Exception, Invalid_Password_Exception{
		
		String output = null;
		String savedPassword = null;
		
		try {
			savedPassword =  dbHandler.validate_Login_Details(usernameLoginData);
		}catch (Exception e) {
			throw new Invalid_Username_Exception("Invalid username");
		}
		
		if(savedPassword.equals(passwordLoginData)) {
			output = "Access granted";
			
			if(Store_username.size() == 0) {
				Store_username.add(usernameLoginData);
			}
			
			else {
				Store_username.set(0, usernameLoginData);
			}
		}
		if(savedPassword.equals("Username not found!")) {
			output = "Username is invalid";
		}

		if(!savedPassword.equals(passwordLoginData) && !savedPassword.equals("Username not found!")) {
			output = "Password is invalid";
		}
		
		return output;
	}
	
	
	
	public static ArrayList<String> Store_username = new ArrayList<String>();
	
	
	
	public String getName(String username) {
		
		String output = null;

		try {
			output = dbHandler.getFirstName(username);
			
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
		}catch (Invalid_Username_Exception e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			Password = user.validatePasswordData(passwordData);
		}catch (Invalid_Password_Exception e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		try {
			FirstName = user.validateFirstNameData(firstnameData);
		}catch (Invalid_Firstname_Exception e9) {
			output = e9.getMessage();
			return output;
		}
		
		
		try {
			LastName = user.validateLastNameData(lastnameData);
		}catch (Invalid_Lastname_Exception e10) {
			output = e10.getMessage();
			return output;
		}
		
		output = save_Personal_Data(Username, Password, FirstName, LastName);
		
		return output;

	}
	

	
	public String editProfile(String currentUsernameData, String newUsernameData, String newPasswordData, String newFirstnameData, String newLastnameData) {
		
		String output = null;
		
		String current_username = null;
		String new_username = null;
		String new_password = null;
		String new_first_name = null;
		String new_last_name = null;
		
		try {
			current_username = user.validateUsernameData(currentUsernameData);
		}catch (Invalid_Username_Exception e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			new_username = user.validateUsernameData(newUsernameData);
		}catch (Invalid_Username_Exception e7) {
			output = e7.getMessage();
			return output;
		}
		
		try {
			new_password = user.validatePasswordData(newPasswordData);
		}catch (Invalid_Password_Exception e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		try {
			new_first_name = user.validateFirstNameData(newFirstnameData);
		}catch (Invalid_Firstname_Exception e9) {
			output = e9.getMessage();
			return output;
		}
		
		
		try {
			new_last_name = user.validateLastNameData(newLastnameData);
		}catch (Invalid_Lastname_Exception e10) {
			output = e10.getMessage();
			return output;
		}
		
		output = update_Personal_Data(current_username, new_username, new_password, new_first_name, new_last_name);
		
		if (output.equals("Personal data updated succesfully!")) {
			Store_username.set(0, newUsernameData);
		}
		
		return output;
	}


	
	public String addpostData(String IDData, String contentData, String authorData, String likesData, String sharesData, String date_timeData) {
		
		String output = null;
		
		int ID = 0;
		String Content = null;
		String Author = null;
		int Likes = 0;
		int Shares = 0;
		String Date_time = null;
		String Username = null;

		
		try {
			ID = operator.validateIdData(IDData);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}
		
		
		try {
			Content = operator.validateContentData(contentData);
		}catch (Exception e2) {
			output = e2.getMessage();
			return output;
		}
		
		
		try {
			Author = operator.validateAuthorData(authorData);
		}catch (Exception e3) {
			output = e3.getMessage();
			return output;
		}
		
		
		try {
			Likes = operator.validateLikesData(likesData);
		}catch (Invalid_Likes_Exception e4) {
			output = e4.getMessage();
			return output;
		}
		
		
		try {
			Shares = operator.validateSharesData(sharesData);
		}catch (Invalid_Shares_Exception e5) {
			output = e5.getMessage();
			return output;
		}
		
		
		try {
			Date_time = operator.validateDateTimeData(date_timeData);
		}catch (Invalid_DateFormat_Exception e6) {
			output = e6.getMessage();
			return output;
		}
		
		String ID1 = Integer.toString(ID);
		String Likes1 = Integer.toString(Likes);
		String Shares1 = Integer.toString(Shares);
		
		Username = Store_username.get(0);
		
		output = save_Post_Data(Username, ID1, Content, Author, Likes1, Shares1, Date_time);
		
		return output;
		
		
	}



	public String retrieveExistingPost(String retrieveID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		
		try {
			ID = operator.validateIdData(retrieveID);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);
		
		output = dbHandler.retrieve_Posts(Username, ID);
				
		return output;
		
	}
	
	
	
	public String deleteExistingPost(String deleteID) {
		
		String output = null;
		int ID = 0;
		String Username = null;
		
		try {
			ID = operator.validateIdData(deleteID);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);

		output = dbHandler.Remove_Posts(Username, ID);
		
		return output;
	}
	
	
	
	public String retrieveTopLikes(String postNumber) {
		
		String output = null;
		int Number = 0;
		String Username = null;
		
		try {
			Number = operator.validateLikesPost(postNumber);
		}catch (Invalid_PostNumber_Exception e11) {
			output = e11.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);
		
		output = dbHandler.retrieve_LikesPosts(Username, Number);
		
		return output;
	}
	
	
	
	public String exportCsvPost(String exportID, String exportFolder, String exportFilename) {
		
		String output = null;
		int retID = 0;
		String Username = null;
		
		try {
			retID = operator.validateIdData(exportID);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}
		
		Username = Store_username.get(0);
		
		output = dbHandler.retrieve_Posts(Username,retID);
				
		return output;
	}
	
}

