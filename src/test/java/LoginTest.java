/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mychatsapp.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user 1
 */
public class LoginTest {
        // Login object that will test its method
    Login login = new Login();
    
    //===================================
    // USERNAME 
    //===================================  
    
    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("Kyl_1"));
    }

    @Test 
    public void testInvalidUsername_NoUnderscore() {
        assertFalse(login.checkUserName("Kyle1"));
    }
 
    @Test
    public void testInvalidUserName_TooLong(){
        assertFalse(login.checkUserName("kyle_123"));
    }

    //====================================
    // PASSWORD TESTS
    //====================================
 
    @Test
    public void testValidPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
 
    @Test
    public void testInvalidPasswordComplexity_NoCapitalLetter() {
        assertFalse(login.checkPasswordComplexity("chatapp01"));
    }
 
    @Test
    public void testInvalidPasswordComplexity_NoSpecial() {
        assertFalse(login.checkPasswordComplexity("ChatApp1"));
    }

    //====================================
    // PHONE NUMBER TEST
    //====================================
    @Test
    public void testValidPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27123456789"));
    }
    
    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(login.checkCellPhoneNumber("0123456789"));
    }
    
    //===================================
    // LOGIN TEST
    //===================================
    @Test
    public void testLoginSuccess() {
        login.registerUser("Kyl_1", "Ch&&sec@ke99!", "+27123456789");
        assertTrue(login.loginUser("Kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailure(){
        login.registerUser("Kyl_1", "Ch&&sec@ke99!", "+27123456789");
        assertFalse(login.loginUser("Kyl_1", "wrongpassword")); 
    }  
}