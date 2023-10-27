package Model.Exceptions;

public class InvalidPostNumberException extends Exception{
	
	// To handle exceptions related to the number of posts to be displayed 
	// To retrieve the posts with the most number of likes
	public InvalidPostNumberException(String message) {
		super(message);
	}
}
