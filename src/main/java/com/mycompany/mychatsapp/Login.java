/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

public class Login {

    // Variables to store registered user details
    private String storedUsername;
    private String storedPassword;

    //===================================
    // USERNAME VALIDATION
    // Username must:
    // - contain "_"
    // - be 5 characters or less
    //===================================

    public boolean checkUserName(String username) {

        return username != null
                && !username.isEmpty()
                && username.contains("_")
                && username.length() <= 5;
    }

    //===================================
    // PASSWORD VALIDATION
    // Password must:
    // - be at least 8 characters
    // - contain a capital letter
    // - contain a number
    // - contain a special character
    //===================================

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

    //===================================
    // PHONE NUMBER VALIDATION
    // Must:
    // - start with +27
    // - be exactly 12 characters
    //===================================

    public boolean checkCellPhoneNumber(String phoneNumber) {

        return phoneNumber != null
                && phoneNumber.startsWith("+27")
                && phoneNumber.length() == 12
                && phoneNumber.matches("\\+27\\d{9}");
    }

    //===================================
    // REGISTER USER
    //===================================

    public String registerUser(String username,
                               String password,
                               String phoneNumber) {

        if (!checkUserName(username)) {

            return "Username must contain an underscore and be no more than 5 characters long";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password must be at least 8 characters, include a capital letter, number, and special character";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {

            return "Phone number must start with +27 and be exactly 12 characters long";
        }

        // Store user details
        storedUsername = username;
        storedPassword = password;

        return "User registered successfully";
    }

    //===================================
    // LOGIN USER
    //===================================

    public boolean loginUser(String username, String password) {

        return storedUsername != null
                && storedPassword != null
                && storedUsername.equals(username)
                && storedPassword.equals(password);
    }

    //===================================
    // RETURN LOGIN STATUS
    //===================================

    public String returnLoginStatus(boolean status) {

        if (status) {
            return "Login successful";
        }

        return "Username or password incorrect, please try again";
    }
}