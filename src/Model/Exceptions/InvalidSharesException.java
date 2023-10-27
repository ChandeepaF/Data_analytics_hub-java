package Model.Exceptions;

public class InvalidSharesException extends Exception{

	// To handle exceptions related to the shares of the posts
	public InvalidSharesException(String message) {
		super(message);
	}
}
