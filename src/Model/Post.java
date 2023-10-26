package Model;

import Model.Exceptions.Invalid_DateFormat_Exception;
import Model.Exceptions.Invalid_Filename_Exception;
import Model.Exceptions.Invalid_Folder_Exception;
import Model.Exceptions.Invalid_ID_Exception;
import Model.Exceptions.Invalid_Likes_Exception;
import Model.Exceptions.Invalid_PostNumber_Exception;
import Model.Exceptions.Invalid_Shares_Exception;

public class Post {


	public int validateIdData(String IDData) throws Invalid_ID_Exception {
		
		if(IDData == null || IDData.trim().isEmpty()) {
			throw new Invalid_ID_Exception("ID is empty");
		}
		
		int intID = 0;
		
		try {
			intID = Integer.parseInt(IDData);
			
		}catch(NumberFormatException e) {
			throw new Invalid_ID_Exception("ID is not a number");
		}
		
		if(intID <= 0) {
			throw new Invalid_ID_Exception("ID is not positive");
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
	
	
	public int validateLikesData(String likesData) throws Invalid_Likes_Exception {
		
		if(likesData == null || likesData.trim().isEmpty()) {
			throw new Invalid_Likes_Exception("Number of likes is empty");
		}
		
		int intLikes = 0;
		try {
			intLikes = Integer.parseInt(likesData);
			
		}catch(NumberFormatException e) {
			throw new Invalid_Likes_Exception("Number of likes is not a number");
		}
		
		if(intLikes <= 0) {
			throw new Invalid_Likes_Exception("Number of likes is not positive");
		}
		
		return intLikes;
		
	}
	
	
	
	public int validateSharesData(String sharesData) throws Invalid_Shares_Exception {
		
		if(sharesData == null || sharesData.trim().isEmpty()) {
			throw new Invalid_Shares_Exception("Number of shares is empty");
		}
		
		int intShares = 0;
		try {
			intShares = Integer.parseInt(sharesData);
			
		}catch(NumberFormatException e) {
			throw new Invalid_Shares_Exception("Number of shares is not a number");
		}
		
		if(intShares <= 0) {
			throw new Invalid_Shares_Exception("Number of shares is not positive");
		}
		
		return intShares;
	}
	
	
	
	public String validateDateTimeData(String date_timeData) throws Invalid_DateFormat_Exception {
		
		if(date_timeData == null || date_timeData.trim().isEmpty()) {
			throw new Invalid_DateFormat_Exception("Date & time is empty");
		}
		
		if(!date_timeData.contains("/")) {
			throw new Invalid_DateFormat_Exception("Invalid date format");
		}
		
		if(!date_timeData.contains(":")) {
			throw new Invalid_DateFormat_Exception("Invalid time format");
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
			throw new Invalid_DateFormat_Exception("Invalid date");
		}
		
		if(month > 12) {
			throw new Invalid_DateFormat_Exception("Invalid month");
		}
		
		if(year > 2023) {
			throw new Invalid_DateFormat_Exception("Invalid year");
		}
		
		if(hours > 24) {
			throw new Invalid_DateFormat_Exception("Invalid hours");
		}
		
		if(minutes > 59) {
			throw new Invalid_DateFormat_Exception("Invalid minutes");
		}
		
		return date_timeData;
	}
	
	
		
	public int validateLikesPost(String postNumberData) throws Invalid_PostNumber_Exception {
		
		if(postNumberData == null || postNumberData.trim().isEmpty()) {
			throw new Invalid_PostNumber_Exception("Post number is empty");
		}
		
		int intPosts = 0;
		
		try {
			intPosts = Integer.parseInt(postNumberData);
			
		}catch(NumberFormatException e) {
			throw new Invalid_PostNumber_Exception("Amount of posts is not a number");
		}
		
		if(intPosts <= 0) {
			throw new Invalid_PostNumber_Exception("ID is not positive");
		}
		
		return intPosts;
	}	
	
	
	
	public String validateExportFolder(String folderData) throws Invalid_Folder_Exception {
		
		if(folderData == null || folderData.trim().isEmpty()) {
			throw new Invalid_Folder_Exception("Folder not selected!");
		}
		
		return folderData;
	}
	
	
	
	public String validateExportFilename(String filenameData) throws Invalid_Filename_Exception {
		
		if(filenameData == null || filenameData.trim().isEmpty()) {
			throw new Invalid_Filename_Exception("Filename is empty!");
		}
		
		return filenameData;
	}
	
}
