package Model;

import Model.Exceptions.InvalidFirstnameException;
import Model.Exceptions.InvalidIdException;
import Model.Exceptions.InvalidLastnameException;
import Model.Exceptions.InvalidPasswordException;
import Model.Exceptions.InvalidUsernameException;

public class User {

	
	// To validate the entered username of the user
	public String validateUsernameData(String usernameData) throws InvalidUsernameException {
			
		// To check if the username is empty or null
		if(usernameData == null || usernameData.trim().isEmpty()) {
			throw new InvalidUsernameException("Username is empty");
		}
		
		return usernameData;
	}
			
	
	
	// To validate the entered password of the user
	public String validatePasswordData(String passwordData) throws InvalidPasswordException {
		
		// To check if the password is empty or null
		if(passwordData == null || passwordData.trim().isEmpty()) {
			throw new InvalidPasswordException("Password is empty");
		}
		
		return passwordData;
	}
	
	
	
	// To validate the First name of the user
	public String validateFirstNameData(String firstnameData) throws InvalidFirstnameException {
		
		// To check if the First name is empty or null
		if(firstnameData == null || firstnameData.trim().isEmpty()) {
			throw new InvalidFirstnameException("First name is empty");
		}
		
		// To check if the First name contains any characters other than letters
		for (int i = 0; i< firstnameData.length(); i++) {
			
			char firstname = firstnameData.charAt(i);
			
			if(!Character.isLetter(firstname)) {
				throw new InvalidFirstnameException("Invalid first name");
			}
			
		}
		
		return firstnameData;
	}
	
	
	
	// To validate the Last name of the user
	public String validateLastNameData(String lastnameData) throws InvalidLastnameException {
		
		// To check if the Last name is empty or null
		if(lastnameData == null || lastnameData.trim().isEmpty()) {
			throw new InvalidLastnameException("Last name is empty");
		}
		
		// To check if the Last name contains any characters other than letters
		for (int i=0; i < lastnameData.length(); i++) {
			
			char lastname = lastnameData.charAt(i);
			
			if(!Character.isLetter(lastname)) {
				throw new InvalidLastnameException("Invalid last name");
			}
		}
		
		return lastnameData;
	}
		
}
