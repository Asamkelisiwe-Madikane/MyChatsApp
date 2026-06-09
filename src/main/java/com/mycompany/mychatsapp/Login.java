/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

public class Login {

    private String storedUsername;
    private String storedPassword;

    // ===================================
    // CONSTRUCTOR
    // ===================================

    public Login() {

        System.out.println("=================================");
        System.out.println("      WELCOME TO MY CHATSAPP");
        System.out.println("=================================");
        System.out.println();
    }

    // ===================================
    // USERNAME VALIDATION
    // ===================================

    public boolean checkUserName(String username) {

        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    // ===================================
    // PASSWORD VALIDATION
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
    // CELL PHONE VALIDATION
    // ===================================

    public boolean checkCellPhoneNumber(String phoneNumber) {

        return phoneNumber != null
                && phoneNumber.matches("\\+27\\d{9}");
    }

    // ===================================
    // REGISTER USER
    // ===================================

    public String registerUser(
            String username,
            String password,
            String phoneNumber) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain an international code.";
        }

        storedUsername = username;
        storedPassword = password;

        return "User registered successfully.";
    }

    // ===================================
    // LOGIN USER
    // ===================================

    public boolean loginUser(
            String username,
            String password) {

        return storedUsername != null
                && storedPassword != null
                && storedUsername.equals(username)
                && storedPassword.equals(password);
    }

    // ===================================
    // LOGIN STATUS
    // ===================================

    public String returnLoginStatus(
            boolean loginStatus) {

        if (loginStatus) {

            return "Welcome "
                    + storedUsername
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }

    // ===================================
    // GETTERS
    // ===================================

    public String getStoredUsername() {
        return storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }
}