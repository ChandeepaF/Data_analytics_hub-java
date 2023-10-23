package Model;

import Model.Exceptions.Invalid_Firstname_Exception;
import Model.Exceptions.Invalid_ID_Exception;
import Model.Exceptions.Invalid_Lastname_Exception;
import Model.Exceptions.Invalid_Password_Exception;
import Model.Exceptions.Invalid_Username_Exception;

public class User {

	
	public String validateUsernameData(String usernameData) throws Invalid_Username_Exception {
			
		if(usernameData == null) {
			throw new Invalid_Username_Exception("Username is null");
		}
		
		return usernameData;
	}
			
	
	public String validatePasswordData(String passwordData) throws Invalid_Password_Exception {
		
		if(passwordData == null) {
			throw new Invalid_Password_Exception("Password is null");
		}
		
		return passwordData;
	}
	
	
	public String validateFirstNameData(String firstnameData) throws Invalid_Firstname_Exception {
		
		if(firstnameData == null) {
			throw new Invalid_Firstname_Exception("First name is null");
		}
		
		char firstname = firstnameData.charAt(0);
		if(!Character.isLetter(firstname)) {
			throw new Invalid_Firstname_Exception("Invalid first name");
		}
		
		return firstnameData;
	}
	
	
	public String validateLastNameData(String lastnameData) throws Invalid_Lastname_Exception {
		
		if(lastnameData == null) {
			throw new Invalid_Lastname_Exception("Last name is null");
		}
		
		char lastname = lastnameData.charAt(0);
		if(!Character.isLetter(lastname)) {
			throw new Invalid_Lastname_Exception("Invalid last name");
		}
		
		return lastnameData;
	}
	
		
}
