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
   String username;
    String password;
    String phoneNumber;
    
    public boolean checkUserName(String username){
        
        // Check if username contains underscore and length <= 5
        if(!username.contains("_")) {
            return false;
        }
        return username.length() <= 5;
    }  
    
    public boolean checkPasswordComplexity(String password){
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
     
        for (int i = 0; i < password.length(); i++) {
            
            char ch = password.charAt(i);
         
            // Correct checks
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } 
            else if (Character.isDigit(ch)) {
                hasNumber = true;
            } 
            else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }
        
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String phone){
        return phone.startsWith("+27") && phone.length() == 12;
    } 
    
    public String registerUser(String username, String password, String phoneNumber){
        
        if (!checkUserName(username)){
            return "Username must contain an underscore and be no more than 5 characters long";
        }
        
        if(!checkPasswordComplexity(password)){
            return "Password must be at least 8 characters, include a capital letter, number, and special character";
        } 
        
        if (!checkCellPhoneNumber(phoneNumber)){
            return "Phone number must start with +27 and be exactly 12 characters long";
        }
        
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        
        return "User registered successfully";
    }

    // Fixed method (removed extra parameter)
    public boolean loginUser(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean success){
        if(success){
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }


    String registerUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

