import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Model.Post;
import Model.TestModel;
import Model.User;
import Model.Database.Database_Handler;
import Model.Exceptions.Invalid_Password_Exception;
import Model.Exceptions.Invalid_Username_Exception;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataAnalyticsHubTest {

	TestModel testModel;
	Database_Handler dbHandler;

	

	@BeforeEach
	void setUp() throws Invalid_Username_Exception, Invalid_Password_Exception {
	    testModel = new TestModel(); // Initialize your test model here
	    dbHandler = new Database_Handler();

	    testModel.verify_Login_Data("Chan123", "Hello%456");
	}
	
	
//	
//	@Order(1)
//	@Test
//	void test_addPersonaldata(){
//		
//		String expectedOutput1 = "Data saved successfully";
//		
//		String actualOutput1 = testModel.addPersonalData("Chan123", "Hello%456", "Chandeepa", "Fernando");
//		
//		assertEquals(actualOutput1, expectedOutput1);
//	
//		
//
//		String expectedOutput2 = "Invalid first name";
//		
//		String actualOutput2 = testModel.addPersonalData("John", "Melbourne12", "Chan456", "Kane");
//		
//		assertEquals(actualOutput2, expectedOutput2);
//		
//		
//		
//		String expectedOutput3 = "Invalid last name";
//		
//		String actualOutput3 = testModel.addPersonalData("Cameron", "Andrews34%", "Shane", "Andy12");
//		
//		assertEquals(actualOutput3, expectedOutput3);
//		
//	}
//	
//	
//	@Order(2)
//	@Test
//	void test_verifyLogin() throws Invalid_Username_Exception, Invalid_Password_Exception{
//		
//		String expectedOutput1 = "Access granted";
//		
//		String actualOutput1 = testModel.verify_Login_Data("Chan123", "Hello%456");
//		
//		assertEquals(actualOutput1, expectedOutput1);
//		
//		
//		
//		String expectedOutput2 = "Username is invalid";
//		
//		String actualOutput2 = testModel.verify_Login_Data("John123", "Hello%456");
//		
//		assertEquals(actualOutput2, expectedOutput2);
//		
//		
//		
//		String expectedOutput3 = "Password is invalid";
//		
//		String actualOutput3 = testModel.verify_Login_Data("Chan123", "anu33f?");
//		
//		assertEquals(actualOutput3, expectedOutput3);
//		
//		
//		
//		String expectedOutput4 = "Username is empty";
//		
//		String actualOutput4 = testModel.verify_Login_Data("", "anu33f?");
//		
//		assertEquals(actualOutput4, expectedOutput4);
//		
//		
//		
//		String expectedOutput5 = "Password is empty";
//		
//		String actualOutput5 = testModel.verify_Login_Data("Katy", "");
//		
//		assertEquals(actualOutput5, expectedOutput5);
//		
//	}
//	
//
//	
//	@Order(3)
//	@Test
//	void test_getName() {
//		
//		String expectedOutput1 = "Chandeepa Fernando";
//		
//		String actualOutput1 = testModel.getName("Chan123");
//		
//		assertEquals(actualOutput1, expectedOutput1);
//		
//		
//		
//		String expectedOutput2 = "Name not found!";
//		
//		String actualOutput2 = testModel.getName("Shane76d");
//		
//		assertEquals(actualOutput2, expectedOutput2);
//		
//	}
	
	
//	@Order(4)
//	@Test
//	void test_editProfile() throws Invalid_Username_Exception {
//		
//		String expectedOutput1 = "Current username & New username are the same! Enter again.";
//		
//		String actualOutput1 = testModel.editProfile("Chan123", "Chan123", "KdfK5k32", "Anthony", "Edwards");
//		
//		assertEquals(actualOutput1, expectedOutput1);
//		
//		
//		
//		String expectedOutput2 = "Invalid first name";
//		
//		String actualOutput2 = testModel.editProfile("Chan123", "Kirsten", "KdfK5k32", "Anthon23", "Edwards");
//		
//		assertEquals(actualOutput2, expectedOutput2);
//		
//		
//		
//		String expectedOutput3 = "Personal data updated successfully!";
//		
//		String actualOutput3 = testModel.editProfile("Chan123", "Andyk34", "KdfK5k32", "Anthony", "Edwards");
//		
//		assertEquals(actualOutput3, expectedOutput3);
//		
//		
//		
//		String expectedOutput4 = "Personal data updated successfully!";
//		
//		String actualOutput4 = testModel.editProfile("Andyk34", "Chan123", "Hello%456", "Chandeepa", "Fernando");
//		
//		assertEquals(actualOutput4, expectedOutput4);
//		
//	}
	
	
	
	@Order(5)
	@Test
	void test_upgradeVip() {
//		
//		String expectedOutput1 = "Type updated succesfully!";
//		
//		String actualOutput1 = dbHandler.changeVip("Chan123");
//		
//		assertEquals(actualOutput1, expectedOutput1);
		
		
		
		String expectedOutput2 = "Type not updated!";
		
		String actualOutput2 = dbHandler.changeVip("Jason98");
		
		assertEquals(actualOutput2, expectedOutput2);
	}
	
	
	
	
	
	
	
	
	
	

}
