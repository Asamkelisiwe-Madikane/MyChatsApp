/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.mychatsapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private Message msg1;
    private Message msg2;
    private Message msg3;
    private Message msg4;
    private Message msg5;

    @BeforeEach
    public void setUp() {

        msg1 = new Message(
                1,
                "+27834557896",
                "Did you get the cake?"
        );

        msg2 = new Message(
                2,
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time."
        );

        msg3 = new Message(
                3,
                "+27834484567",
                "Yohoooo, I am at your gate."
        );

        msg4 = new Message(
                4,
                "0838884567",
                "It is dinner time!"
        );

        msg5 = new Message(
                5,
                "+27838884567",
                "Ok, I am leaving without you."
        );

        // Simulate user choices

        msg1.sentMessage(1); // Sent
        msg2.sentMessage(3); // Stored
        msg3.sentMessage(2); // Disregarded
        msg4.sentMessage(1); // Sent
        msg5.sentMessage(3); // Stored
    }

    // =====================================================
    // PART 2 TESTS
    // =====================================================

    @Test
    public void testCheckMessageLength() {

        assertTrue(msg1.checkMessageLength());
    }

    @Test
    public void testRecipientValidation() {

        assertTrue(msg1.checkRecipientCell());
        assertFalse(msg4.checkRecipientCell());
    }

    @Test
    public void testMessageIDExists() {

        assertNotNull(msg1.getMessageID());
    }

    @Test
    public void testMessageIDLength() {

        assertEquals(10,
                msg1.getMessageID().length());
    }

    @Test
    public void testMessageHashCreated() {

        assertNotNull(msg1.getMessageHash());
    }

    // =====================================================
    // PART 3 TEST 1
    // SENT MESSAGES ARRAY
    // =====================================================

    @Test
    public void testSentMessagesArray_correctlyPopulated() {

        assertTrue(
                Message.getSentMessages()
                        .contains("Did you get the cake?")
        );

        assertTrue(
                Message.getSentMessages()
                        .contains("It is dinner time!")
        );
    }

    // =====================================================
    // PART 3 TEST 2
    // LONGEST MESSAGE
    // =====================================================

    @Test
    public void testDisplayLongestMessage_returnsCorrectMessage() {

        Message.getStoredMessages().clear();

        Message.getStoredMessages().add(
                "Did you get the cake?"
        );

        Message.getStoredMessages().add(
                "Where are you? You are late! I have asked you to be on time."
        );

        Message.getStoredMessages().add(
                "Ok, I am leaving without you."
        );

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                Message.displayLongestMessage()
        );
    }

    // =====================================================
    // PART 3 TEST 3
    // SEARCH BY MESSAGE ID
    // =====================================================

    @Test
    public void testSearchByMessageID_returnsCorrectMessage() {

        String id = msg4.getMessageID();

        assertEquals(
                "It is dinner time!",
                Message.searchByMessageID(id)
        );
    }

    // =====================================================
    // PART 3 TEST 4
    // SEARCH BY RECIPIENT
    // =====================================================

    @Test
    public void testSearchByRecipient_returnsAllMatchingMessages() {

        String result =
                Message.searchByRecipient(
                        "+27838884567"
                );

        assertTrue(
                result.contains(
                        "Where are you? You are late! I have asked you to be on time."
                )
                ||
                result.contains(
                        "Ok, I am leaving without you."
                )
        );
    }

    // =====================================================
    // PART 3 TEST 5
    // DELETE BY HASH
    // =====================================================

    @Test
    public void testDeleteByHash_removesCorrectMessage() {

        String hash = msg1.getMessageHash();

        String result =
                Message.deleteByHash(hash);

        assertEquals(
                "Message: Did you get the cake? successfully deleted.",
                result
        );
    }

    // =====================================================
    // PART 3 TEST 6
    // REPORT
    // =====================================================

    @Test
    public void testDisplayReport_containsRequiredFields() {

        String report =
                Message.printMessagesReport();

        assertTrue(
                report.contains("Message Hash")
        );

        assertTrue(
                report.contains("Recipient")
        );

        assertTrue(
                report.contains("Message")
        );
    }
}