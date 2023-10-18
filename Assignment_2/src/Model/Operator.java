package Model;

import Model.Exceptions.Invalid_DateFormat_Exception;
import Model.Exceptions.Invalid_ID_Exception;
import Model.Exceptions.Invalid_Likes_Exception;
import Model.Exceptions.Invalid_Shares_Exception;

public class Operator {


	public int validateIdData(String IDData) throws Invalid_ID_Exception {
		
		if(IDData == null) {
			throw new Invalid_ID_Exception("ID is null");
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
		
		if(contentData == null) {
			throw new Exception("ID is null");
		}
		
		return contentData;
	}
	
	
	
	public String validateAuthorData(String authorData) throws Exception {
		
		if(authorData == null) {
			throw new Exception("ID is null");
		}
		
		return authorData;
	}
	
	
	public int validateLikesData(String likesData) throws Invalid_Likes_Exception {
		
		if(likesData == null) {
			throw new Invalid_Likes_Exception("Number of likes is null");
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
		
		if(sharesData == null) {
			throw new Invalid_Shares_Exception("Number of shares is null");
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
		
		if(date_timeData == null) {
			throw new Invalid_DateFormat_Exception("Date & time is null");
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
		String[] tokens4 = tokens1.split(":");
		
		// 17/07/2023 10:00
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
		
		if(year > 12) {
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
	
	
	
	public String getPost(int retrieveID) throws Invalid_ID_Exception {
		
	}
	
	
	public String deletePost(int deleteID) throws Invalid_ID_Exception {
		
	}
	
	
	public String likesPost(int postNumber) throws Invalid_PostNumber_Exception {
		
	}
	
	
	
	public String exportPost(int exportID) throws Invalid_ID_Exception {
		
	}




	
	
	
//	public double validateWidthValue(String widthValue) throws InvalidDimensionException {
//		return validateDimensionValue("width", widthValue);
//	}
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
