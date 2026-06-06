/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatsapp;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

public class Message {

    static boolean displayStoredMessages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 private String messageID;
private int messageNumber;
private String recipient;
private String messageText;
private String messageHash;
    private static int totalMessages = 0;

    // =========================================================
    // PART 3 ARRAYS
    // =========================================================

    private static List<String> sentMessages = new ArrayList<>();
    private static List<String> disregardedMessages = new ArrayList<>();
    private static List<String> storedMessages = new ArrayList<>();
    private static List<String> messageHashes = new ArrayList<>();
    private static List<String> messageIDs = new ArrayList<>();
    private static List<String> recipientList = new ArrayList<>();

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
    // CHECK RECIPIENT
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

        int excess = messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + excess
                + " characters, please reduce size.";
    }

    // =========================================================
    // CREATE HASH
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

                sentMessages.add(messageText);
                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                recipientList.add(recipient);

                return "Message successfully sent.";

            case 2:

                disregardedMessages.add(messageText);

                return "Message discarded.";

            case 3:

                storeMessage();

                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                recipientList.add(recipient);

                return "Message successfully stored.";

            default:

                return "Invalid option.";
        }
    }

    // =========================================================
    // STORE MESSAGE
    // Attribution:
    // org.json library
    // https://mvnrepository.com/artifact/org.json/json
    // =========================================================

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
    // PART 3
    // LOAD STORED MESSAGES
    // Attribution:
    // org.json library
    // https://mvnrepository.com/artifact/org.json/json
    // =========================================================

    public static void loadStoredMessages() {

        storedMessages.clear();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("messages.json"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                JSONObject obj =
                        new JSONObject(line);

                storedMessages.add(
                        obj.getString("messageText")
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "No stored messages found."
            );
        }
    }

    // =========================================================
    // PART 3
    // DISPLAY LONGEST MESSAGE
    // =========================================================

    public static String displayLongestMessage() {

        String longest = "";

        for (String msg : storedMessages) {

            if (msg.length() > longest.length()) {

                longest = msg;
            }
        }

        return longest;
    }

    // =========================================================
    // PART 3
    // SEARCH BY MESSAGE ID
    // =========================================================

    public static String searchByMessageID(String id) {

        for (int i = 0; i < messageIDs.size(); i++) {

            if (messageIDs.get(i).equals(id)) {

                if (i < sentMessages.size()) {

                    return sentMessages.get(i);
                }
            }
        }

        return "Message not found.";
    }

    // =========================================================
    // PART 3
    // SEARCH BY RECIPIENT
    // =========================================================

    public static String searchByRecipient(String recipient) {

    StringBuilder results = new StringBuilder();

    for (int i = 0; i < recipientList.size(); i++) {

        if (recipientList.get(i).equals(recipient)) {

            if (i < sentMessages.size()) {
                results.append(sentMessages.get(i))
                       .append("\n");
            }
        }
    }

    for (String stored : storedMessages) {
        results.append(stored).append("\n");
    }

    if (results.length() == 0) {
        return "No messages found.";
    }

    return results.toString();
}

    // =========================================================
    // PART 3
    // DELETE BY HASH
    // =========================================================

    public static String deleteByHash(String hash) {

        for (int i = 0;
             i < messageHashes.size();
             i++) {

            if (messageHashes.get(i)
                    .equals(hash)) {

                String deletedMessage =
                        sentMessages.get(i);

                messageHashes.remove(i);
                messageIDs.remove(i);
                recipientList.remove(i);
                sentMessages.remove(i);

                return "Message: "
                        + deletedMessage
                        + " successfully deleted.";
            }
        }

        return "Hash not found.";
    }

    // =========================================================
    // PART 3
    // Message REPORT
    // =========================================================

    public static String printMessagesReport() {

        StringBuilder report =
                new StringBuilder();

        report.append(
                "=== Message Report ===\n"
        );

        for (int i = 0;
             i < sentMessages.size();
             i++) {

            report.append(
                    "Message Hash: "
            ).append(
                    messageHashes.get(i)
            ).append("\n");

            report.append(
                    "Recipient: "
            ).append(
                    recipientList.get(i)
            ).append("\n");

            report.append(
                    "Message: "
            ).append(
                    sentMessages.get(i)
            ).append("\n");

            report.append(
                    "--------------------------------\n"
            );
        }

        return report.toString();
    }

    // =========================================================
    // PRINT SINGLE MESSAGE
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

    // =========================================================
    // PART 3 GETTERS FOR TESTING
    // =========================================================

    public static List<String> getSentMessages() {
        return sentMessages;
    }

    public static List<String> getStoredMessages() {
        return storedMessages;
    }

    public static List<String> getDisregardedMessages() {
        return disregardedMessages;
    }

    public static List<String> getMessageHashes() {
        return messageHashes;
    }

    public static List<String> getMessageIDs() {
        return messageIDs;
    }
}

