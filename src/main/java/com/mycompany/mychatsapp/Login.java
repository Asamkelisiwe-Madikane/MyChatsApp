/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

public class Login {

    // Store registered user details
    private String storedUsername;
    private String storedPassword;

    // ===================================
    // USERNAME VALIDATION
    // Must contain "_" and be 5 chars or less
    // ===================================

    public boolean checkUserName(String username) {

        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    // ===================================
    // PASSWORD VALIDATION
    // At least 8 chars, capital, number, special char
    // ===================================

    public boolean checkPasswordComplexity(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            }

            if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    // ===================================
    // PHONE NUMBER VALIDATION
    // Must start with +27 and contain 9 digits after
    // Example: +27831234567
    // ===================================

    public boolean checkCellPhoneNumber(String phoneNumber) {

        return phoneNumber != null
                && phoneNumber.matches("\\+27\\d{9}");
    }

    // ===================================
    // REGISTER USER
    // ===================================

    public String registerUser(String username,
                               String password,
                               String phoneNumber) {

        if (!checkUserName(username)) {

            return "Username is not correctly formatted.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {

            return "Cell phone number incorrectly formatted.";
        }

        // Save user details
        storedUsername = username;
        storedPassword = password;

        return "User registered successfully.";
    }

    // ===================================
    // LOGIN USER
    // ===================================

    public boolean loginUser(String username, String password) {

        return storedUsername != null
                && storedPassword != null
                && storedUsername.equals(username)
                && storedPassword.equals(password);
    }

    // ===================================
    // LOGIN STATUS MESSAGE
    // ===================================

    public String returnLoginStatus(boolean status) {

        if (status) {

            return "Login successful.";
        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}