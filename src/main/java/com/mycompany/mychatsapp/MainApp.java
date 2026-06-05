/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        // =====================================================
        // REGISTRATION
        // =====================================================

        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter your firstname: ");
        String firstname = input.nextLine();

        System.out.print("Enter your lastname: ");
        String lastname = input.nextLine();

        String username;

        while (true) {

            System.out.print("Enter a username: ");
            username = input.nextLine();

            if (login.checkUserName(username)) {

                System.out.println("Username successfully captured.");
                break;

            } else {

                System.out.println(
                        "Invalid username. Username must contain '_' and be no more than 5 characters."
                );
            }
        }

        String password;

        while (true) {

            System.out.print("Enter a password: ");
            password = input.nextLine();

            if (login.checkPasswordComplexity(password)) {

                System.out.println("Password captured successfully.");
                break;

            } else {

                System.out.println(
                        "Password must contain at least 8 characters, a capital letter, a number and a special character."
                );
            }
        }

        String phone;

        while (true) {

            System.out.print("Enter International Cell Number: ");
            phone = input.nextLine();

            if (login.checkCellPhoneNumber(phone)) {

                System.out.println("Cell phone number captured successfully.");
                break;

            } else {

                System.out.println(
                        "Invalid cellphone number. Must contain international code."
                );
            }
        }

        String response = login.registerUser(username, password, phone);

        System.out.println(response);

        // =====================================================
        // LOGIN
        // =====================================================

        System.out.println("\n=== USER LOGIN ===");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        boolean loggedIn =
                login.loginUser(loginUsername, loginPassword);

        System.out.println(
                login.returnLoginStatus(loggedIn)
        );

        // =====================================================
        // CHAT APP
        // =====================================================

        if (loggedIn) {

            System.out.println("\nWelcome to ChatApp");

            boolean running = true;

            // REQUIRED BY FEEDBACK
            ArrayList<Message> messages =
                    new ArrayList<>();

            while (running) {

                System.out.println("\n===== CHAT MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show Recently Sent Messages");
                System.out.println("3. Show Total Messages");
                System.out.println("4. Quit");

                System.out.print("Choose an option: ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    // =========================================
                    // SEND MESSAGES
                    // =========================================

                    case 1:

                        System.out.print(
                                "How many messages would you like to send? "
                        );

                        int numMessages = input.nextInt();
                        input.nextLine();

                        for (int i = 0; i < numMessages; i++) {

                            int messageNumber = i + 1;

                            System.out.println(
                                    "\n========== MESSAGE "
                                            + messageNumber
                                            + " =========="
                            );

                            // ------------------------------
                            // VALIDATE RECIPIENT
                            // ------------------------------

                            String recipient;

                            while (true) {

                                System.out.print(
                                        "Enter recipient number (+27xxxxxxxxx): "
                                );

                                recipient = input.nextLine();

                                Message temp =
                                        new Message(
                                                messageNumber,
                                                recipient,
                                                "temp"
                                        );

                                if (temp.checkRecipientCell()) {

                                    System.out.println(
                                            temp.getRecipientValidationMessage()
                                    );

                                    break;

                                } else {

                                    System.out.println(
                                            temp.getRecipientValidationMessage()
                                    );
                                }
                            }

                            // ------------------------------
                            // VALIDATE MESSAGE LENGTH
                            // ------------------------------

                            String messageText;

                            while (true) {

                                System.out.print(
                                        "Enter your message: "
                                );

                                messageText =
                                        input.nextLine();

                                Message temp =
                                        new Message(
                                                messageNumber,
                                                recipient,
                                                messageText
                                        );

                                if (temp.checkMessageLength()) {

                                    System.out.println(
                                            temp.getMessageLengthValidationMessage()
                                    );

                                    break;

                                } else {

                                    System.out.println(
                                            temp.getMessageLengthValidationMessage()
                                    );
                                }
                            }

                            // ------------------------------
                            // CREATE MESSAGE OBJECT
                            // ------------------------------

                            Message msg =
                                    new Message(
                                            messageNumber,
                                            recipient,
                                            messageText
                                    );

                            messages.add(msg);

                            // ------------------------------
                            // SEND OPTIONS
                            // ------------------------------

                            System.out.println(
                                    "\nChoose Message Option"
                            );

                            System.out.println(
                                    "1. Send Message"
                            );

                            System.out.println(
                                    "2. Disregard Message"
                            );

                            System.out.println(
                                    "3. Store Message"
                            );

                            System.out.print(
                                    "Option: "
                            );

                            int option =
                                    input.nextInt();

                            input.nextLine();

                            System.out.println(
                                    msg.sentMessage(option)
                            );

                            // ------------------------------
                            // DISPLAY DETAILS
                            // ------------------------------

                            msg.printMessages();
                        }

                        break;

                    // =========================================
                    // SHOW RECENT MESSAGES
                    // =========================================

                    case 2:

                        if (messages.isEmpty()) {

                            System.out.println(
                                    "No messages sent yet."
                            );

                        } else {

                            System.out.println(
                                    "\n=== RECENTLY SENT MESSAGES ==="
                            );

                            for (Message msg : messages) {

                                msg.printMessages();
                            }
                        }

                        break;

                    // =========================================
                    // TOTAL MESSAGES
                    // =========================================

                    case 3:

                        System.out.println(
                                "Total Messages: "
                                        + Message.returnTotalMessages()
                        );

                        break;

                    // =========================================
                    // QUIT
                    // =========================================

                    case 4:

                        running = false;

                        System.out.println(
                                "Logging out..."
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid option."
                        );
                }
            }

        } else {

            System.out.println(
                    "Login failed. Exiting ChatApp."
            );
        }

        input.close();
    }
}      

