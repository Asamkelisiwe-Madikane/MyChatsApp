/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

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

private String generateMessageID() {

    Random random = new Random();

    long number =
            1000000000L +
            (long) (random.nextDouble() * 9000000000L);

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
// CHECK RECIPIENT NUMBER
// =========================================================

public boolean checkRecipientCell() {

    return recipient != null
            && recipient.matches("\\+27\\d{9}");
}

public String getRecipientValidationMessage() {

    if (checkRecipientCell()) {

        return "Cell phone number successfully captured.";
    }

    return "Cell phone number is incorrectly formatted or does not contain an international code.";
}

// =========================================================
// CHECK MESSAGE LENGTH
// =========================================================

public boolean checkMessageLength() {

    return messageText != null
            && messageText.length() <= 250;
}

public String getMessageLengthValidationMessage() {

    if (checkMessageLength()) {

        return "Message ready to send.";
    }

    int excess =
            messageText.length() - 250;

    return "Message exceeds 250 characters by "
            + excess
            + " characters, please reduce size.";
}

// =========================================================
// CREATE MESSAGE HASH
// =========================================================

public String createMessageHash() {

    if (messageText == null ||
        messageText.trim().isEmpty()) {

        return "INVALID_HASH";
    }

    String[] words =
            messageText.trim().split("\\s+");

   String firstWord =
        words[0]
                .replaceAll("[^a-zA-Z0-9]", "");

String lastWord =
        words[words.length - 1]
                .replaceAll("[^a-zA-Z0-9]", "");

    String hash =
            messageID.substring(0, 2)
                    + ":"
                    + messageNumber
                    + ":"
                    + firstWord
                    + lastWord;

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
            return "Message discarded.";

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

/**
 * Uses org.json library to store messages in JSON format.
 */
public void storeMessage() {

    JSONObject jsonMessage = new JSONObject();

    jsonMessage.put("messageID", messageID);
    jsonMessage.put("messageNumber", messageNumber);
    jsonMessage.put("recipient", recipient);
    jsonMessage.put("messageText", messageText);
    jsonMessage.put("messageHash", messageHash);

    try (FileWriter writer =
                 new FileWriter("messages.json", true)) {

        writer.write(jsonMessage.toString());
        writer.write(System.lineSeparator());

    } catch (IOException e) {

        System.out.println(
                "Error storing message: "
                        + e.getMessage()
        );
    }
}

// =========================================================
// PRINT MESSAGE DETAILS
// =========================================================

public String printMessages() {
   

    return
            "Message ID: " + messageID +
            "\nMessage Hash: " + messageHash +
            "\nRecipient: " + recipient +
            "\nMessage: " + messageText;
}

// =========================================================
// TOTAL MESSAGES
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
    this.messageHash = createMessageHash();
}

public void setMessageHash(String messageHash) {
    this.messageHash = messageHash;
}
}


