/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mychatsapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserName_Valid() {

        Login login = new Login();

        assertTrue(login.checkUserName("abc_1"));
    }

    @Test
    public void testCheckUserName_Invalid() {

        Login login = new Login();

        assertFalse(login.checkUserName("abcdef"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {

        Login login = new Login();

        assertTrue(login.checkPasswordComplexity("Password@1"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {

        Login login = new Login();

        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {

        Login login = new Login();

        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {

        Login login = new Login();

        assertFalse(login.checkCellPhoneNumber("0831234567"));
    }

    @Test
    public void testRegisterUser() {

        Login login = new Login();

        String result =
                login.registerUser(
                        "abc_1",
                        "Password@1",
                        "+27831234567"
                );

        assertNotNull(result);
    }

    @Test
    public void testLoginUser() {

        Login login = new Login();

        login.registerUser(
                "abc_1",
                "Password@1",
                "+27831234567"
        );

        boolean result =
                login.loginUser(
                        "abc_1",
                        "Password@1"
                );

        assertTrue(result);
    }

    @Test
    public void testReturnLoginStatus_Success() {

        Login login = new Login();

        String result =
                login.returnLoginStatus(true);

        assertNotNull(result);
    }

    @Test
    public void testReturnLoginStatus_Failure() {

        Login login = new Login();

        String result =
                login.returnLoginStatus(false);

        assertNotNull(result);
    }
}