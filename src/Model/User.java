package Model;

import Model.Exceptions.InvalidFirstnameException;
import Model.Exceptions.InvalidIdException;
import Model.Exceptions.InvalidLastnameException;
import Model.Exceptions.InvalidPasswordException;
import Model.Exceptions.InvalidUsernameException;

public class User {

	
	public String validateUsernameData(String usernameData) throws InvalidUsernameException {
			
		if(usernameData == null || usernameData.trim().isEmpty()) {
			throw new InvalidUsernameException("Username is empty");
		}
		
		return usernameData;
	}
			
	
	public String validatePasswordData(String passwordData) throws InvalidPasswordException {
		
		if(passwordData == null || passwordData.trim().isEmpty()) {
			throw new InvalidPasswordException("Password is empty");
		}
		
		return passwordData;
	}
	
	
	public String validateFirstNameData(String firstnameData) throws InvalidFirstnameException {
		
		if(firstnameData == null || firstnameData.trim().isEmpty()) {
			throw new InvalidFirstnameException("First name is empty");
		}
		
		for (int i = 0; i< firstnameData.length(); i++) {
			
			char firstname = firstnameData.charAt(i);
			
			if(!Character.isLetter(firstname)) {
				throw new InvalidFirstnameException("Invalid first name");
			}
			
		}
		
		return firstnameData;
	}
	
	
	public String validateLastNameData(String lastnameData) throws InvalidLastnameException {
		
		if(lastnameData == null || lastnameData.trim().isEmpty()) {
			throw new InvalidLastnameException("Last name is empty");
		}
		
		for (int i=0; i < lastnameData.length(); i++) {
			
			char lastname = lastnameData.charAt(i);
			
			if(!Character.isLetter(lastname)) {
				throw new InvalidLastnameException("Invalid last name");
			}
		}
		
		return lastnameData;
	}
		
}
