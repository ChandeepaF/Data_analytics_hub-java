package Model.Exceptions;

public class InvalidPasswordException extends Exception{
	
	// To handle exceptions related to the password of the user
	public InvalidPasswordException(String message) {
		super(message);
	}
}
