package Model.Exceptions;

public class InvalidUsernameException extends Exception{
	
	// To handle exceptions related to the Username of the user
	public InvalidUsernameException(String message) {
		super(message);
	}
}