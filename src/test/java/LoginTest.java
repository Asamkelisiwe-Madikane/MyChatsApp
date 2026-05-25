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

    public LoginTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");

        String username = "";
        Login instance = new Login();

        boolean expResult = false;
        boolean result = instance.checkUserName(username);

        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");

        String password = "";
        Login instance = new Login();

        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);

        assertEquals(expResult, result);
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");

        String phone = "";
        Login instance = new Login();

        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(phone);

        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");

        String username = "";
        String password = "";
        String phoneNumber = "";

        Login instance = new Login();

        String expResult = "";
        String result = instance.registerUser(username, password, phoneNumber);

        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");

        String username = "";
        String password = "";

        Login instance = new Login();

        boolean expResult = false;
        boolean result = instance.loginUser(username, password);

        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");

        boolean success = false;

        Login instance = new Login();

        String expResult = "";
        String result = instance.returnLoginStatus(success);

        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser_3args() {
        System.out.println("registerUser");

        String username = "";
        String password = "";
        String phoneNumber = "";

        Login instance = new Login();

        String expResult = "";
        String result = instance.registerUser(username, password, phoneNumber);

        assertEquals(expResult, result);
    }
}