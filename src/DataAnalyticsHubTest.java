import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Model.Post;
import Model.HubModel;
import Model.User;
import Model.Database.DatabaseHandler;
import Model.Exceptions.InvalidPasswordException;
import Model.Exceptions.InvalidUsernameException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataAnalyticsHubTest {

	HubModel hubModel;
	DatabaseHandler dbHandler;

	

	@BeforeEach
	void setUp() throws InvalidUsernameException, InvalidPasswordException {
		
	    hubModel = new HubModel(); 
	    dbHandler = new DatabaseHandler();

	    hubModel.verifyLoginData("Chan123", "Hello%456");
	}
	
	
	
	@Order(1)
	@Test
	void test_addPersonaldata(){
		
		String expectedOutput1 = "Data saved successfully";
		
		String actualOutput1 = hubModel.addPersonalData("Chan123", "Hello%456", "Chandeepa", "Fernando");
		
		assertEquals(actualOutput1, expectedOutput1);
	
	

		String expectedOutput2 = "Invalid first name";
		
		String actualOutput2 = hubModel.addPersonalData("John", "Melbourne12", "Chan456", "Kane");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Invalid last name";
		
		String actualOutput3 = hubModel.addPersonalData("Cameron", "Andrews34%", "Shane", "Andy12");
		
		assertEquals(actualOutput3, expectedOutput3);
		
	}
	
	
	@Order(2)
	@Test
	void test_verifyLogin() throws InvalidUsernameException, InvalidPasswordException{
		
		String expectedOutput1 = "Access granted";
		
		String actualOutput1 = hubModel.verifyLoginData("Chan123", "Hello%456");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Username is invalid";
		
		String actualOutput2 = hubModel.verifyLoginData("John123", "Hello%456");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Password is invalid";
		
		String actualOutput3 = hubModel.verifyLoginData("Chan123", "anu33f?");
		
		assertEquals(actualOutput3, expectedOutput3);
		
		
		
		String expectedOutput4 = "Username is empty";
		
		String actualOutput4 = hubModel.verifyLoginData("", "anu33f?");
		
		assertEquals(actualOutput4, expectedOutput4);
		
		
		
		String expectedOutput5 = "Password is empty";
		
		String actualOutput5 = hubModel.verifyLoginData("Katy", "");
		
		assertEquals(actualOutput5, expectedOutput5);
		
	}
	

	
	@Order(3)
	@Test
	void test_getName() {
		
		String expectedOutput1 = "Chandeepa Fernando";
		
		String actualOutput1 = hubModel.getName("Chan123");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Name not found!";
		
		String actualOutput2 = hubModel.getName("Shane76d");
		
		assertEquals(actualOutput2, expectedOutput2);
		
	}
	
	
	@Order(4)
	@Test
	void test_editProfile() throws InvalidUsernameException {
		
		String expectedOutput1 = "Current username & New username are the same! Enter again.";
		
		String actualOutput1 = hubModel.editProfile("Chan123", "Chan123", "KdfK5k32", "Anthony", "Edwards");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Invalid first name";
		
		String actualOutput2 = hubModel.editProfile("Chan123", "Kirsten", "KdfK5k32", "Anthon23", "Edwards");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Personal data updated successfully!";
		
		String actualOutput3 = hubModel.editProfile("Chan123", "Andyk34", "KdfK5k32", "Anthony", "Edwards");
		
		assertEquals(actualOutput3, expectedOutput3);
		
		
		
		String expectedOutput4 = "Personal data updated successfully!";
		
		String actualOutput4 = hubModel.editProfile("Andyk34", "Chan123", "Hello%456", "Chandeepa", "Fernando");
		
		assertEquals(actualOutput4, expectedOutput4);
		
	}
	
	
	
	@Order(5)
	@Test
	void test_upgradeVip() {
		
		String expectedOutput1 = "Type updated succesfully!";
		
		String actualOutput1 = dbHandler.changeVip("Chan123");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Type not updated!";
		
		String actualOutput2 = dbHandler.changeVip("Jason98");
		
		assertEquals(actualOutput2, expectedOutput2);
		
	}
	
	
	
	@Order(6)
	@Test
	void test_checkUserType() {
		
		String expectedOutput1 = "vip";
		
		String actualOutput1 = dbHandler.checkUserType("Chan123");
		
		assertEquals(actualOutput1, expectedOutput1);
		
	}
	
	
	
	@Order(7)
	@Test
	void test_addPosts() {
		
		String expectedOutput1 = "Post saved successfully!";
		
		String actualOutput1 = hubModel.addpostData("44", "This is test content", "Jonathan", "7", "36", "1/12/2023 1:59");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Post saved successfully!";
		
		String actualOutput2 = hubModel.addpostData("136", "I study at RMIT University", "Michael", "100", "231", "31/01/2019 24:01");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Invalid post ID. Post with the current ID already exists!";
		
		String actualOutput3 = hubModel.addpostData("136", "Melbourne whether is unpredictable!", "Kate", "45", "43", "15/11/2020 13:26");
		
		assertEquals(actualOutput3, expectedOutput3);
		
		
		
		String expectedOutput4 = "ID is not a number";
		
		String actualOutput4 = hubModel.addpostData("ab", "I study at RMIT University", "Michael", "100", "231", "31/01/2019 24:01");
		
		assertEquals(actualOutput4, expectedOutput4);
		
		
		
		String expectedOutput5 = "Number of likes is not positive";
		
		String actualOutput5 = hubModel.addpostData("54", "I study at RMIT University", "Michael", "-21", "231", "31/01/2019 24:01");
		
		assertEquals(actualOutput5, expectedOutput5);
		
		
		
		String expectedOutput6 = "Number of shares is not a number";
		
		String actualOutput6 = hubModel.addpostData("167", "I study at RMIT University", "Michael", "100", "h", "31/01/2019 24:01");
		
		assertEquals(actualOutput6, expectedOutput6);
		
		
		
		String expectedOutput7 = "Invalid month";
		
		String actualOutput7 = hubModel.addpostData("876", "I study at RMIT University", "Michael", "100", "231", "31/13/2019 24:01");
		
		assertEquals(actualOutput7, expectedOutput7);
	
	}
	


	
	@Order(8)
	@Test
	void test_retrievePost() {
		
		String expectedOutput1 = "ID: 44 | Content: This is test content | Author: Jonathan | Likes: 7 | Shares: 36 | Date/Time: 1/12/2023 1:59";
		
		String actualOutput1 = hubModel.retrieveExistingPost("44");
		
		assertEquals(actualOutput1.trim(), expectedOutput1.trim());
		
		
		
		String expectedOutput2 = "ID is not a number";
		
		String actualOutput2 = hubModel.retrieveExistingPost("c");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Post not found";
		
		String actualOutput3 = hubModel.retrieveExistingPost("12");
		
		assertEquals(actualOutput3, expectedOutput3);
		
	}
	
	
	
	@Order(9)
	@Test
	void test_retrieveTopLikes() {
		
		String expectedOutput1 = "ID: 136 | Content: I study at RMIT University | Author: Michael | Likes: 100 | Shares: 231 | Date/Time: 31/01/2019 24:01 \n" +
                "ID: 44 | Content: This is test content | Author: Jonathan | Likes: 7 | Shares: 36 | Date/Time: 1/12/2023 1:59";
		
		String actualOutput1 = hubModel.retrieveTopLikes("2");
		
		assertEquals(actualOutput1.trim(), expectedOutput1.trim());
		
		
		
		String expectedOutput2 = "ID: 136 | Content: I study at RMIT University | Author: Michael | Likes: 100 | Shares: 231 | Date/Time: 31/01/2019 24:01";

		String actualOutput2 = hubModel.retrieveTopLikes("1");
		
		assertEquals(actualOutput2.trim(), expectedOutput2.trim());
		
		
		
		String expectedOutput3 = "Amount of posts is not a number";

		String actualOutput3 = hubModel.retrieveTopLikes("k");
		
		assertEquals(actualOutput3, expectedOutput3);
	}
	
	

	
	@Order(10)
	@Test
	void test_deletePost() {
	
		String expectedOutput1 = "Post deleted successfully!";
		
		String actualOutput1 = hubModel.deleteExistingPost("136");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "ID is not a number";
		
		String actualOutput2 = hubModel.deleteExistingPost("n");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Post not found";
		
		String actualOutput3 = hubModel.deleteExistingPost("47");
		
		assertEquals(actualOutput3, expectedOutput3);
		
	}
	
	
	
	@Order(11)
	@Test
	void test_exportPost() {
		
		String expectedOutput1 = "Post not found. Invalid ID!";
		
		String actualOutput1 = hubModel.exportCsvPost("71", "C:\\Users\\Chandeepa Fernando\\Downloads\\Documents", "New post file");
		
		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Folder Invalid!";
		
		String actualOutput2 = hubModel.exportCsvPost("44", "", "New post file");
		
		assertEquals(actualOutput2, expectedOutput2);
		
		
		
		String expectedOutput3 = "Filename is empty!";
		
		String actualOutput3 = hubModel.exportCsvPost("44", "C:\\Users\\Chandeepa Fernando\\Downloads\\Documents", "");
		
		assertEquals(actualOutput3, expectedOutput3);
		
	}
	
		
}
