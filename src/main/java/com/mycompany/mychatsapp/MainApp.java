/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.util.Scanner;

/**
 *
 * @author user 1
 */
public class MainApp {
      public static void main(String[] args) {

        // Scanner allows the user to enter information
        Scanner input = new Scanner(System.in);

        // Create an object of the Login class
        Login login = new Login();

        // --- REGISTRATION SECTION ---
        System.out.println("=== USER REGISTRATION ===");

        // First name
        System.out.println("Enter your firstname:");
        String firstname = input.nextLine();

        // Last name
        System.out.println("Enter your lastname:");
        String lastname = input.nextLine();

        // Username
        String username;

        while (true) {

            System.out.print("Enter a username: ");
            username = input.nextLine();

            if (login.checkUserName(username)) {

                System.out.println("Username successfully captured.");
                break;

            } else {

                System.out.println("Invalid username. Ensure that it contains  <=5 characters and '_'." );

            }
        }

        // Password
        String password;

        while (true) {

            System.out.print("Enter a password: ");
            password = input.nextLine();

            if (login.checkPasswordComplexity(password)) {

                System.out.println("Password captured successfully");
                break;

            } else {

                System.out.println("Password must be eight characters long, including a special character, capital letter, and number.");

            }
        }

        // Phone number
        String phone;

        while (true) {

            System.out.print("Enter International code: ");
            phone = input.nextLine();

            if (login.checkCellPhoneNumber(phone)) {

                System.out.println("CellPhone number captured successfully.");
                break;

            } else {

                System.out.println("Invalid CellPhone number, does not contain international code");

            }
        }

        // Register user
        String response = login.registerUser(username, password, phone);

        // Show registration message
        System.out.println(response);

        // --- LOGIN SECTION ---
        System.out.println("\n=== USER LOGIN ===");

        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();

        // Check login
        boolean loggedIn = login.loginUser(loginUsername, loginPassword);

        // Print login message
        String loginMessage = login.returnLoginStatus(loggedIn);

        System.out.println(loginMessage);
        
      // ===================== PART 2 STARTS HERE =====================

if (loggedIn) {

    System.out.println("\n=== WELCOME TO CHATAPP ===");

    boolean running = true;

    // Array to store messages
    String[] sentMessages = new String[100];
    int messageCount = 0;

    // While loop menu
    while (running) {

        System.out.println("\n===== CHAT MENU =====");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
        System.out.println("3. Quit");

        System.out.print("Choose an option: ");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {

            case 1:

                System.out.print("How many messages: ");
                int numMessages = input.nextInt();
                input.nextLine();

                for (int i = 0; i < numMessages; i++) {

                    int messageNumber = i + 1;

                    System.out.println("\nMessage " + messageNumber);

                    System.out.print("Enter recipient number: ");
                    String recipient = input.nextLine();

                    System.out.print("Enter your message: ");
                    String message = input.nextLine();

                    // Store message
                    sentMessages[messageCount] =
                            "Recipient: " + recipient +
                            " | Message: " + message;

                    messageCount++;

                    System.out.println("Message sent successfully.");
                }

                break;

            case 2:

                // Show recently sent messages
                if (messageCount == 0) {

                    System.out.println("No messages sent yet.");

                } else {

                    System.out.println("\n=== RECENTLY SENT MESSAGES ===");

                    for (int i = 0; i < messageCount; i++) {

                        System.out.println((i + 1) + ". " + sentMessages[i]);
                    }
                }

                break;

            case 3:

                System.out.println("Logging out...");
                running = false;

                break;

            default:

                System.out.println("Invalid option. Try again.");
        }
    }

} else {

    // Print failure and exit
    System.out.println("Login failed. Exiting ChatApp.");
}

input.close();
}
}
      

