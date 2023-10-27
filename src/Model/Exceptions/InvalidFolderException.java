package Model.Exceptions;

public class InvalidFolderException extends Exception{

	// To handle exceptions related to invalid folder selected when exporting a post
	public InvalidFolderException(String message) {
		super(message);
	}
}
