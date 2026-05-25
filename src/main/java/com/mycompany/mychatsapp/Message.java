/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessages = 0;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Message(int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();

        totalMessages++;
    }

    // =========================================================
    // GENERATE MESSAGE ID
    // =========================================================

    public String generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // =========================================================
    // CHECK MESSAGE ID
    // =========================================================

    public boolean checkMessageID() {

        return messageID != null
                && messageID.length() == 10;
    }

    // =========================================================
    // CHECK MESSAGE LENGTH
    // =========================================================

    public String checkMessageLength(String text) {

        if (text.length() <= 250) {

            return "Message ready to send.";
        }

        int excess = text.length() - 250;

        return "Message exceeds 250 characters by "
                + excess
                + ", please reduce size.";
    }

    // =========================================================
    // CHECK RECIPIENT CELL
    // =========================================================

    public String checkRecipientCell(String recipient) {

        if (recipient.matches("\\+27\\d{9}")) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    // =========================================================
    // CREATE MESSAGE HASH
    // =========================================================

    public String createMessageHash() {

        // Split message into words
        String[] words = messageText.split(" ");

        // First word
        String firstWord = words[0];

        // Last word
        String lastWord = words[words.length - 1];

        // Remove punctuation
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");

        // Create hash
        String hash =
                messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord + lastWord;

        return hash.toUpperCase();
    }

    // =========================================================
    // SEND MESSAGE
    // =========================================================

    public String sentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // =========================================================
    // STORE MESSAGE
    // =========================================================

    public void storeMessage() {

        System.out.println("Message stored.");
    }

    // =========================================================
    // PRINT MESSAGE
    // =========================================================

    public void printMessages() {

        System.out.println(messageText);
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
