package Model.Exceptions;

public class InvalidFilenameException extends Exception{

	// To handle exceptions related to the Invalid Filename when exporting a post
	public InvalidFilenameException(String message) {
		super(message);
	}
}
