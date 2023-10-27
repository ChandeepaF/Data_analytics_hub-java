package Model.Exceptions;

public class InvalidDateFormatException extends Exception{

	// To handle exceptions related to the data & time format of the posts
	public InvalidDateFormatException(String message) {
		super(message);
	}
}
