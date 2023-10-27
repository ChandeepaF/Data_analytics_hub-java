package Model;

import Model.Exceptions.InvalidDateFormatException;
import Model.Exceptions.InvalidFilenameException;
import Model.Exceptions.InvalidFolderException;
import Model.Exceptions.InvalidIdException;
import Model.Exceptions.InvalidLikesException;
import Model.Exceptions.InvalidPostNumberException;
import Model.Exceptions.InvalidSharesException;

public class Post {


	// This method is defined to validate the post ID that is entered by the user 
	public int validateIdData(String IDData) throws InvalidIdException {
		
		// To check if the ID is empty or null
		if(IDData == null || IDData.trim().isEmpty()) {
			throw new InvalidIdException("ID is empty");
		}
		
		int intID = 0;
		
		// The String value is parsed into an integer 
		try {
			intID = Integer.parseInt(IDData);
			
			// If the value is not a number
		}catch(NumberFormatException e) {
			throw new InvalidIdException("ID is not a number");
		}
		
		// To  check if the value is less than 0
		if(intID <= 0) {
			throw new InvalidIdException("ID is not positive");
		}
		
		return intID;
	}

	
	
	// To check if the content data the user entered for the post is neither empty nor null
	public String validateContentData(String contentData) throws Exception {
		
		if(contentData == null || contentData.trim().isEmpty()) {
			throw new Exception("Content is empty");
		}
		
		return contentData;
	}
	
	
	
	// To check if the author data the user entered for the post is neither empty nor null
	public String validateAuthorData(String authorData) throws Exception {
		
		if(authorData == null || authorData.trim().isEmpty()) {
			throw new Exception("Author is empty");
		}
		
		return authorData;
	}
	
	
	
	// This method is defined to validate the post likes that are entered by the user 
	public int validateLikesData(String likesData) throws InvalidLikesException {
		
		// To check if the ID is empty or null
		if(likesData == null || likesData.trim().isEmpty()) {
			throw new InvalidLikesException("Number of likes is empty");
		}
		
		int intLikes = 0;
		try {
			intLikes = Integer.parseInt(likesData);
			
			// To check if the value is a number
		}catch(NumberFormatException e) {
			throw new InvalidLikesException("Number of likes is not a number");
		}
		
		// To check if the value is less than 0
		if(intLikes <= 0) {
			throw new InvalidLikesException("Number of likes is not positive");
		}
		
		return intLikes;
		
	}
	
	
	
	// This method is defined to validate the post shares that are entered by the user 
	public int validateSharesData(String sharesData) throws InvalidSharesException {
		
		// To check if the ID is empty or null
		if(sharesData == null || sharesData.trim().isEmpty()) {
			throw new InvalidSharesException("Number of shares is empty");
		}
		
		int intShares = 0;
		try {
			intShares = Integer.parseInt(sharesData);
			
			// To check if the value is a number
		}catch(NumberFormatException e) {
			throw new InvalidSharesException("Number of shares is not a number");
		}
		
		// To check if the value is less than 0
		if(intShares <= 0) {
			throw new InvalidSharesException("Number of shares is not positive");
		}
		
		return intShares;
	}
	
	
	
	// This method is defined to validate the  date and time
	public String validateDateTimeData(String date_timeData) throws InvalidDateFormatException {
		
		// To check if its empty or null
		if(date_timeData == null || date_timeData.trim().isEmpty()) {
			throw new InvalidDateFormatException("Date & time is empty");
		}
		
		// To ensure that the date is separated by "/"
		if(!date_timeData.contains("/")) {
			throw new InvalidDateFormatException("Invalid date format");
		}
		
		// To ensure that the time is separated by a ":"
		if(!date_timeData.contains(":")) {
			throw new InvalidDateFormatException("Invalid time format");
		}
		
		
		String[] tokens = date_timeData.split(" ");
		
		String tokens1 = tokens[0];
		String tokens2 = tokens[1];
		
		String[] tokens3 = tokens1.split("/");
		String[] tokens4 = tokens2.split(":");
		
		int date = Integer.parseInt(tokens3[0]);
		int month = Integer.parseInt(tokens3[1]);
		int year = Integer.parseInt(tokens3[2]);
		
		int hours = Integer.parseInt(tokens4[0]);
		int minutes = Integer.parseInt(tokens4[1]);
		
		// To ensure that date is entered before month and year
		if(date > 31) {
			throw new InvalidDateFormatException("Invalid date");
		}
		
		// To ensure that month is entered between date and year
		if(month > 12) {
			throw new InvalidDateFormatException("Invalid month");
		}
		
		// To ensure that year is entered after month and date
		if(year > 2023) {
			throw new InvalidDateFormatException("Invalid year");
		}
		
		// To ensure that hours are entered first
		if(hours > 24) {
			throw new InvalidDateFormatException("Invalid hours");
		}
		
		// To ensure that minutes are entered second
		if(minutes > 59) {
			throw new InvalidDateFormatException("Invalid minutes");
		}	
			
		
		return date_timeData;
	}
	
	
		
	// To validate the number of post/posts that are requested by the user based on the most number of likes
	public int validateLikesPost(String postNumberData) throws InvalidPostNumberException {
		
		// To check if the value is empty or null
		if(postNumberData == null || postNumberData.trim().isEmpty()) {
			throw new InvalidPostNumberException("Post number is empty");
		}
		
		int intPosts = 0;
		
		try {
			intPosts = Integer.parseInt(postNumberData);
			
			// To check if the value is a number
		}catch(NumberFormatException e) {
			throw new InvalidPostNumberException("Amount of posts is not a number");
		}
		
		// To check if the value is less than 0
		if(intPosts <= 0) {
			throw new InvalidPostNumberException("ID is not positive");
		}
		
		return intPosts;
	}	
	
	
	
	// To validate the export folder that the post is saved to
	public String validateExportFolder(String folderData) throws InvalidFolderException {
		
		// To check if the folder path is empty or null
		if(folderData == null || folderData.trim().isEmpty()) {
			throw new InvalidFolderException("Folder Invalid!");
		}
		
		return folderData;
	}
	
	
	
	// To validate the filename of the export csv file
	public String validateExportFilename(String filenameData) throws InvalidFilenameException {
		
		// To check if the filename is empty or null
		if(filenameData == null || filenameData.trim().isEmpty()) {
			throw new InvalidFilenameException("Filename is empty!");
		}
		
		return filenameData;
	}
	
}
