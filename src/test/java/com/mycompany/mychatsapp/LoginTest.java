/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.mychatsapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Login object
    private Login login;

    // Runs before every test
    @BeforeEach
    public void setUp() {

        login = new Login();
    }

    // ===================================
    // USERNAME TESTS
    // ===================================

    @Test
    public void testValidUsername() {

        assertTrue(
                login.checkUserName("Kyl_1")
        );
    }

    @Test
    public void testInvalidUsername_NoUnderscore() {

        assertFalse(
                login.checkUserName("Kyle1")
        );
    }

    @Test
    public void testInvalidUsername_TooLong() {

        assertFalse(
                login.checkUserName("kyle_123")
        );
    }

    // ===================================
    // PASSWORD TESTS
    // ===================================

    @Test
    public void testValidPasswordComplexity() {

        assertTrue(
                login.checkPasswordComplexity("Ch&&sec@ke99!")
        );
    }

    @Test
    public void testInvalidPassword_NoCapitalLetter() {

        assertFalse(
                login.checkPasswordComplexity("chatapp01")
        );
    }

    @Test
    public void testInvalidPassword_NoSpecialCharacter() {

        assertFalse(
                login.checkPasswordComplexity("ChatApp1")
        );
    }

    // ===================================
    // PHONE NUMBER TESTS
    // ===================================

    @Test
    public void testValidPhoneNumber() {

        assertTrue(
                login.checkCellPhoneNumber("+27123456789")
        );
    }

    @Test
    public void testInvalidPhoneNumber() {

        assertFalse(
                login.checkCellPhoneNumber("0123456789")
        );
    }

    // ===================================
    // LOGIN TESTS
    // ===================================

    @Test
    public void testLoginSuccess() {

        login.registerUser(
                "Kyl_1",
                "Ch&&sec@ke99!",
                "+27123456789"
        );

        assertTrue(
                login.loginUser(
                        "Kyl_1",
                        "Ch&&sec@ke99!"
                )
        );
    }

    @Test
    public void testLoginFailure() {

        login.registerUser(
                "Kyl_1",
                "Ch&&sec@ke99!",
                "+27123456789"
        );

        assertFalse(
                login.loginUser(
                        "Kyl_1",
                        "wrongpassword"
                )
        );
    }
}