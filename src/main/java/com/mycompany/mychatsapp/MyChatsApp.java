/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mychatsapp;

import java.util.Scanner;

/**
 *
 * @author user 1
 */


public class MyChatsApp {

    public static void main(String[] args) {

        Login login = new Login();

        // Register user
        String registrationMessage = login.registerUser(
                "ab_cd",
                "Password1!",
                "+27831234567"
        );

        System.out.println(registrationMessage);

        // Login user
        boolean loginStatus = login.loginUser(
                "ab_cd",
                "Password1!"
        );

        // Display login result
        System.out.println(
                login.returnLoginStatus(loginStatus)
        );
    }
}

   
    

