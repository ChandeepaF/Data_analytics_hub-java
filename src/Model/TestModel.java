package Model;

import java.sql.ResultSet;

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
	
	
	public String save_Post_Data(String IDData, String contentData, String authorData, String likesData, String sharesData, String date_timeData) {
		return dbHandler.Save_Posts(IDData, contentData, authorData, likesData, sharesData, date_timeData);
	}
	
	
//	public String remove_Post_Data(String IDData) {
//		return dbHandler.Remove_Posts(IDData);
//	}
	
	
//	public ResultSet retrieve_Post_Data(String IDData) {
//		return dbHandler.retrieve_Posts(IDData);
//	}
	
	
	
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
			Username = user.validateLastNameData(lastnameData);
		}catch (Invalid_Lastname_Exception e10) {
			output = e10.getMessage();
			return output;
		}
		
		output = "User succesfully registered!";
		
		return output;
	}
	
	
	
	public String login(String usernameLogin, String passwordLogin) {
		
		String output = null;
		
		String Username = null;
		String Password = null;
		
		try {
			Username = user.checkLoginUsername(usernameLogin);
		}catch (Invalid_Username_Exception e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			Password = user.checkLoginPassword(passwordLogin);
		}catch (Invalid_Password_Exception e8) {
			output = e8.getMessage();
			return output;
		}
		
		output = "Login succesfull!";
		
		return output;
	}

	
	
	public String editProfile(String newUsernameData, String newPasswordData, String newFirstnameData, String newLastnameData) {
		
		String output = null;
		
		String Username = null;
		String Password = null;
		String FirstName = null;
		String LastName = null;
		
		try {
			Username = user.validateUsernameData(newUsernameData);
		}catch (Invalid_Username_Exception e7) {
			output = e7.getMessage();
			return output;
		}
		
		
		try {
			Password = user.validatePasswordData(newPasswordData);
		}catch (Invalid_Password_Exception e8) {
			output = e8.getMessage();
			return output;
		}
		
		
		try {
			FirstName = user.validateFirstNameData(newFirstnameData);
		}catch (Invalid_Firstname_Exception e9) {
			output = e9.getMessage();
			return output;
		}
		
		
		try {
			Username = user.validateLastNameData(newLastnameData);
		}catch (Invalid_Lastname_Exception e10) {
			output = e10.getMessage();
			return output;
		}
		
		output = "User data succesfully changed!";
		
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
		
		output = "Post succesfully added!";
		
		return output;
	}



	public ResultSet retrieveExistingPost(String retrieveID) {
		
		ResultSet output = null;
		int ID = 0;
		
		try {
			ID = operator.validateIdData(retrieveID);
		}catch (Invalid_ID_Exception e1) {
//			output = e1.getMessage();
			return output;
		}
		
		output = dbHandler.retrieve_Posts(ID);
				
		return output;
		
	}
	
	
	
	public String deleteExistingPost(String deleteID) {
		
		String output = null;
		int ID = 0;
		
		try {
			ID = operator.validateIdData(deleteID);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}

		output = dbHandler.Remove_Posts(ID);
		
		return output;
	}
	
	
	
	public ResultSet retrieveTopLikes(String postNumber) {
		
		ResultSet output = null;
		int Number = 0;
		
		try {
			Number = operator.validateLikesPost(postNumber);
		}catch (Invalid_PostNumber_Exception e11) {
//			output = e11.getMessage();
			return output;
		}
		
		output = dbHandler.retrieve_LikesPosts(Number);
		
		return output;
	}
	
	
	
	public String exportCsvPost(int exportID) {
		
		String output = null;
		int ID = 0;
		
		try {
			ID = operator.exportPost(exportID);
		}catch (Invalid_ID_Exception e1) {
			output = e1.getMessage();
			return output;
		}
		
	////	output = ;
		
		return output;
	}
	
}

