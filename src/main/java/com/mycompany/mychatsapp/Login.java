/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

/**
 *
 * @author user 1
 */
public class Login {

    private String username;
    private String password;
    private String phoneNumber;

    // =====================================================
    // USERNAME VALIDATION
    // =====================================================

    public boolean checkUserName(String username) {

        if (username == null) {
            return false;
        }

        return username.contains("_") && username.length() <= 5;
    }

    // =====================================================
    // PASSWORD VALIDATION
    // =====================================================

    public boolean checkPasswordComplexity(String password) {

        if (password == null) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8
                && hasCapital
                && hasNumber
                && hasSpecial;
    }

    // =====================================================
    // PHONE NUMBER VALIDATION
    // =====================================================

    public boolean checkCellPhoneNumber(String phone) {

        if (phone == null) {
            return false;
        }

        return phone.matches("\\+27\\d{9}");
    }

    // =====================================================
    // USER REGISTRATION
    // =====================================================

    public String registerUser(
            String username,
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

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        return "User registered successfully";
    }

    // =====================================================
    // LOGIN
    // =====================================================

    public boolean loginUser(String username, String password) {

        if (this.username == null || this.password == null) {
            return false;
        }

        return this.username.equals(username)
                && this.password.equals(password);
    }

    // =====================================================
    // LOGIN STATUS MESSAGE
    // =====================================================

    public String returnLoginStatus(boolean success) {

        if (success) {
            return "Welcome " + username + ", it is great to see you again.";
        }

        return "Username or password incorrect, please try again";
    }

    // =====================================================
    // GETTERS
    // =====================================================

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

