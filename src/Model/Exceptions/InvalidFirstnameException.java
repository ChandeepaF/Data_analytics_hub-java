package Model.Exceptions;

public class InvalidFirstnameException extends Exception{
	
	// To handle exceptions related to the First name of the user
	public InvalidFirstnameException(String message) {
		super(message);
	}
}
