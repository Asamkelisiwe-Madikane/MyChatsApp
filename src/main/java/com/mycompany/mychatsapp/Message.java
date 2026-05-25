/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.json.JSONObject;

/**
 *
 * @author user 1
 */
public class Message {
 
 // Fields
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Total messages counter
    private static int totalMessages = 0;

    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {

        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();

        totalMessages++;
    }

    // =========================================================
    // GENERATE MESSAGE ID
    // =========================================================

    public String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // =========================================================
    // CHECK MESSAGE ID
    // =========================================================

    public boolean checkMessageID() {

        return messageID.length() == 10;
    }

    // =========================================================
    // CHECK MESSAGE LENGTH
    // =========================================================

    public String checkMessageLength(String text) {

        if (text.length() <= 250) {

            return "Message ready to send.";

        } else {

            int exceeded = text.length() - 250;

            return "Message exceeds 250 characters by "
                    + exceeded
                    + ", please reduce size.";
        }
    }

    // =========================================================
    // CHECK RECIPIENT CELL
    // =========================================================

    public String checkRecipientCell(String recipient) {

        if (recipient.startsWith("+")
                && recipient.length() <= 13) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

    // =========================================================
    // CREATE MESSAGE HASH
    // =========================================================

    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length - 1]
                .replace("?", "")
                .replace(".", "")
                .toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    // =========================================================
    // SENT MESSAGE
    // =========================================================

    public String sentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // =========================================================
    // STORE MESSAGE
    // =========================================================

    public void storeMessage() {

        try {

            JSONObject messageObject = new JSONObject();

            messageObject.put("MessageID", messageID);
            messageObject.put("MessageHash", messageHash);
            messageObject.put("Recipient", recipient);
            messageObject.put("Message", messageText);

            FileWriter file = new FileWriter("storedMessages.json", true);

            file.write(messageObject.toString());
            file.write(System.lineSeparator());

            file.close();

            System.out.println("Message stored successfully.");

        } catch (IOException e) {

            System.out.println("Error storing message: " + e.getMessage());
        }
    }
    // =========================================================
    // PRINT MESSAGE
    // =========================================================

    public void printMessages() {

        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
    }

    // =========================================================
    // RETURN TOTAL MESSAGES
    // =========================================================

    public static int returnTotalMessages() {

        return totalMessages;
    }

    // =========================================================
    // GETTERS
    // =========================================================

    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    // =========================================================
    // SETTERS
    // =========================================================

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }
} 

