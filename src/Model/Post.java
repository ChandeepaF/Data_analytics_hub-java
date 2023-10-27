package Model;

import Model.Exceptions.InvalidDateFormatException;
import Model.Exceptions.InvalidFilenameException;
import Model.Exceptions.InvalidFolderException;
import Model.Exceptions.InvalidIdException;
import Model.Exceptions.InvalidLikesException;
import Model.Exceptions.InvalidPostNumberException;
import Model.Exceptions.InvalidSharesException;

public class Post {


	public int validateIdData(String IDData) throws InvalidIdException {
		
		if(IDData == null || IDData.trim().isEmpty()) {
			throw new InvalidIdException("ID is empty");
		}
		
		int intID = 0;
		
		try {
			intID = Integer.parseInt(IDData);
			
		}catch(NumberFormatException e) {
			throw new InvalidIdException("ID is not a number");
		}
		
		if(intID <= 0) {
			throw new InvalidIdException("ID is not positive");
		}
		
		return intID;
	}

	
	
	public String validateContentData(String contentData) throws Exception {
		
		if(contentData == null || contentData.trim().isEmpty()) {
			throw new Exception("Content is empty");
		}
		
		return contentData;
	}
	
	
	
	public String validateAuthorData(String authorData) throws Exception {
		
		if(authorData == null || authorData.trim().isEmpty()) {
			throw new Exception("Author is empty");
		}
		
		return authorData;
	}
	
	
	public int validateLikesData(String likesData) throws InvalidLikesException {
		
		if(likesData == null || likesData.trim().isEmpty()) {
			throw new InvalidLikesException("Number of likes is empty");
		}
		
		int intLikes = 0;
		try {
			intLikes = Integer.parseInt(likesData);
			
		}catch(NumberFormatException e) {
			throw new InvalidLikesException("Number of likes is not a number");
		}
		
		if(intLikes <= 0) {
			throw new InvalidLikesException("Number of likes is not positive");
		}
		
		return intLikes;
		
	}
	
	
	
	public int validateSharesData(String sharesData) throws InvalidSharesException {
		
		if(sharesData == null || sharesData.trim().isEmpty()) {
			throw new InvalidSharesException("Number of shares is empty");
		}
		
		int intShares = 0;
		try {
			intShares = Integer.parseInt(sharesData);
			
		}catch(NumberFormatException e) {
			throw new InvalidSharesException("Number of shares is not a number");
		}
		
		if(intShares <= 0) {
			throw new InvalidSharesException("Number of shares is not positive");
		}
		
		return intShares;
	}
	
	
	
	public String validateDateTimeData(String date_timeData) throws InvalidDateFormatException {
		
		if(date_timeData == null || date_timeData.trim().isEmpty()) {
			throw new InvalidDateFormatException("Date & time is empty");
		}
		
		if(!date_timeData.contains("/")) {
			throw new InvalidDateFormatException("Invalid date format");
		}
		
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
		
		if(date > 31) {
			throw new InvalidDateFormatException("Invalid date");
		}
		
		if(month > 12) {
			throw new InvalidDateFormatException("Invalid month");
		}
		
		if(year > 2023) {
			throw new InvalidDateFormatException("Invalid year");
		}
		
		if(hours > 24) {
			throw new InvalidDateFormatException("Invalid hours");
		}
		
		if(minutes > 59) {
			throw new InvalidDateFormatException("Invalid minutes");
		}	
			

		
		return date_timeData;
	}
	
	
		
	public int validateLikesPost(String postNumberData) throws InvalidPostNumberException {
		
		if(postNumberData == null || postNumberData.trim().isEmpty()) {
			throw new InvalidPostNumberException("Post number is empty");
		}
		
		int intPosts = 0;
		
		try {
			intPosts = Integer.parseInt(postNumberData);
			
		}catch(NumberFormatException e) {
			throw new InvalidPostNumberException("Amount of posts is not a number");
		}
		
		if(intPosts <= 0) {
			throw new InvalidPostNumberException("ID is not positive");
		}
		
		return intPosts;
	}	
	
	
	
	public String validateExportFolder(String folderData) throws InvalidFolderException {
		
		if(folderData == null || folderData.trim().isEmpty()) {
			throw new InvalidFolderException("Folder Invalid!");
		}
		
		return folderData;
	}
	
	
	
	public String validateExportFilename(String filenameData) throws InvalidFilenameException {
		
		if(filenameData == null || filenameData.trim().isEmpty()) {
			throw new InvalidFilenameException("Filename is empty!");
		}
		
		return filenameData;
	}
	
}
