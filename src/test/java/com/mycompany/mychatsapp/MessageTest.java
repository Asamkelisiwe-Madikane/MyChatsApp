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

@Test
public void testCheckMessageLength_validMessage_returnsTrue() {

    assertTrue(message1.checkMessageLength());

    assertEquals(
            "Message ready to send.",
            message1.getMessageLengthValidationMessage()
    );
}

@Test
public void testCheckMessageLength_over250chars_returnsFalse() {

    Message longMessage = new Message(
            3,
            "+27718693002",
            "a".repeat(260)
    );

    assertFalse(longMessage.checkMessageLength());

    assertTrue(
            longMessage.getMessageLengthValidationMessage()
                    .contains("Message exceeds 250 characters")
    );
}

@Test
public void testCheckRecipientCell_validNumber_returnsTrue() {

    assertTrue(message1.checkRecipientCell());

    assertEquals(
            "Cell phone number successfully captured.",
            message1.getRecipientValidationMessage()
    );
}

@Test
public void testCheckRecipientCell_invalidNumber_returnsFalse() {

    assertFalse(message2.checkRecipientCell());

    assertEquals(
            "Cell phone number is incorrectly formatted or does not contain an international code.",
            message2.getRecipientValidationMessage()
    );
}

@Test
public void testCreateMessageHash_correctFormat() {

    message1.setMessageID("1234567890");

    String hash = message1.createMessageHash();

    assertTrue(hash.contains(":1:"));
}

@Test
public void testCreateMessageHash_isUpperCase() {

    message1.setMessageID("1234567890");

    String hash = message1.createMessageHash();

    assertEquals(hash.toUpperCase(), hash);
}

@Test
public void testMessageID_notNull() {

    assertNotNull(message1.getMessageID());
}

@Test
public void testMessageID_lengthIs10() {

    assertEquals(
            10,
            message1.getMessageID().length()
    );
}

@Test
public void testCheckMessageID_returnsTrue() {

    assertTrue(message1.checkMessageID());
}

@Test
public void testSentMessage_send() {

    assertEquals(
            "Message successfully sent.",
            message1.sentMessage(1)
    );
}

@Test
public void testSentMessage_discard() {

    assertEquals(
            "Message discarded.",
            message1.sentMessage(2)
    );
}

@Test
public void testSentMessage_store() {

    assertEquals(
            "Message successfully stored.",
            message1.sentMessage(3)
    );
}

@Test
public void testSentMessage_invalidOption() {

    assertEquals(
            "Invalid option.",
            message1.sentMessage(99)
    );
}

@Test
public void testReturnTotalMessages() {

    assertTrue(
            Message.returnTotalMessages() >= 2
    );
}

}
