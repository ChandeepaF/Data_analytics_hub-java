package Model;

import Model.Exceptions.Invalid_Firstname_Exception;
import Model.Exceptions.Invalid_ID_Exception;
import Model.Exceptions.Invalid_Lastname_Exception;
import Model.Exceptions.Invalid_Password_Exception;
import Model.Exceptions.Invalid_Username_Exception;

public class User {

	
	public String validateUsernameData(String usernameData) throws Invalid_Username_Exception {
			
		if(usernameData == null) {
			throw new Invalid_Username_Exception("Username is null");
		}
		
		return usernameData;
	}
			
	
	public String validatePasswordData(String passwordData) throws Invalid_Password_Exception {
		
		if(passwordData == null) {
			throw new Invalid_Password_Exception("Password is null");
		}
		
		return passwordData;
	}
	
	
	public String validateFirstNameData(String firstnameData) throws Invalid_Firstname_Exception {
		
		if(firstnameData == null) {
			throw new Invalid_Firstname_Exception("First name is null");
		}
		
		char firstname = firstnameData.charAt(0);
		if(!Character.isLetter(firstname)) {
			throw new Invalid_Firstname_Exception("Invalid first name");
		}
		
		return firstnameData;
	}
	
	
	public String validateLastNameData(String lastnameData) throws Invalid_Lastname_Exception {
		
		if(lastnameData == null) {
			throw new Invalid_Lastname_Exception("Last name is null");
		}
		
		char lastname = lastnameData.charAt(0);
		if(!Character.isLetter(lastname)) {
			throw new Invalid_Lastname_Exception("Invalid last name");
		}
		
		return lastnameData;
	}
	
	
	
//	public void read_file() {
//		
//		String line = " ";
//		String splitBy = ",";
//		int iteration = 0;
//		
//
//		try {
//			//To load the file
//			// FileReader myreader = new FileReader("C:\\Users\\Chandeepa Fernando\\Desktop\\Advanced Programming\\posts.csv");
//			FileReader myreader = new FileReader("posts.csv");
//			BufferedReader br = new BufferedReader(myreader);
//			
//			while ((line = br.readLine()) != null){
//				//To skip the first line which contains the header
//				if(iteration == 0){
//					iteration++;
//					continue;
//				}
//				{String[] posts = line.split(splitBy);
//				
//				//Defining the values read from the file to its appropriate attributes
//				this.ID = Integer.parseInt(posts[0]);
//				this.content = posts[1];
//				this.author = posts[2];
//				this.likes = Integer.parseInt(posts[3]);
//				this.shares = Integer.parseInt(posts[4]);
//				this.date_time = posts[5];
//				
//				
//				//Calling the method to add the data to the Hashmap
//				Operations.add_file_data(ID, content, author, likes, shares, date_time);
//				
//				
//			}
//			}
//			
//			
//			} catch(IOException e) {
//				System.out.println("File cannot be found!");;
//				e.printStackTrace();
//				
//
//		} 
//		
//	}
		
}
