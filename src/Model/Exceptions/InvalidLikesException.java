package Model.Exceptions;

public class InvalidLikesException extends Exception{

	// To handle exceptions related to the likes of the posts
	public InvalidLikesException(String message) {
		super(message);
	}
}
