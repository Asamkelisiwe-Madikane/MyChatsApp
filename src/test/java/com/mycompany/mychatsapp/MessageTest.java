/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.mychatsapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private Message message1;
    private Message message2;

    @BeforeEach
    public void setUp() {

        message1 = new Message(
                1,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        message2 = new Message(
                2,
                "08575975889",
                "Hi Keegan, did you receive the payment?"
        );
    }

    // =========================================================
    // MESSAGE LENGTH TESTS
    // =========================================================

    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {

        String result = message1.checkMessageLength(
                message1.getMessageText()
        );

        assertEquals(
                "Message ready to send.",
                result
        );
    }

    @Test
    public void testCheckMessageLength_over250chars_returnsFailure() {

        String longMessage = "a".repeat(260);

        String result =
                message1.checkMessageLength(longMessage);

        assertTrue(
                result.contains(
                        "Message exceeds 250 characters"
                )
        );
    }

    // =========================================================
    // RECIPIENT CELL TESTS
    // =========================================================

    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {

        String result =
                message1.checkRecipientCell(
                        message1.getRecipient()
                );

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure() {

        String result =
                message2.checkRecipientCell(
                        message2.getRecipient()
                );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code.",
                result
        );
    }

    // =========================================================
    // MESSAGE HASH TESTS
    // =========================================================

    @Test
    public void testCreateMessageHash_correctFormat() {

        message1.setMessageID("1234567890");

        String hash = message1.createMessageHash();

        assertTrue(
                hash.endsWith(":1:HITONIGHT")
        );
    }

    @Test
    public void testCreateMessageHash_isUppercase() {

        message1.setMessageID("1234567890");

        String hash = message1.createMessageHash();

        assertEquals(
                hash.toUpperCase(),
                hash
        );
    }

    // =========================================================
    // MESSAGE ID TESTS
    // =========================================================

    @Test
    public void testMessageID_notNull() {

        assertNotNull(
                message1.getMessageID()
        );
    }

    @Test
    public void testMessageID_lengthIs10() {

        assertEquals(
                10,
                message1.getMessageID().length()
        );
    }

    // =========================================================
    // SENT MESSAGE TESTS
    // =========================================================

    @Test
    public void testSentMessage_send() {

        String result = message1.sentMessage(1);

        assertEquals(
                "Message successfully sent.",
                result
        );
    }

    @Test
    public void testSentMessage_disregard() {

        String result = message1.sentMessage(2);

        assertEquals(
                "Press 0 to delete the message.",
                result
        );
    }

    @Test
    public void testSentMessage_store() {

        String result = message1.sentMessage(3);

        assertEquals(
                "Message successfully stored.",
                result
        );
    }
}