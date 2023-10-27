package Model.Exceptions;

public class InvalidLastnameException extends Exception{
	
	// To handle exceptions related to the Last name of the user
	public InvalidLastnameException(String message) {
		super(message);
	}
}
