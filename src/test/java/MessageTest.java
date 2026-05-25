/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mychatsapp.Message;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

public class MessageTest {

    private Message message1;
    private Message message2;

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

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

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    // =========================================================
    // MESSAGE LENGTH TESTS
    // =========================================================

    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {

        String result = message1.checkMessageLength(
                message1.getMessageText()
        );

        assertEquals("Message ready to send.", result);
    }

    @Test
    public void testCheckMessageLength_over250chars_returnsFailure() {

        String longMessage = "a".repeat(260);

        String result = message1.checkMessageLength(longMessage);

        assertTrue(result.contains("Message exceeds 250 characters"));
    }

    // =========================================================
    // RECIPIENT CELL TESTS
    // =========================================================

    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {

        String result = message1.checkRecipientCell(
                message1.getRecipient()
        );

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure() {

        String result = message2.checkRecipientCell(
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

        assertTrue(hash.endsWith(":1:HITONIGHT"));
    }

    @Test
    public void testCreateMessageHash_isUppercase() {

        message1.setMessageID("1234567890");

        String hash = message1.createMessageHash();

        assertEquals(hash.toUpperCase(), hash);
    }

    // =========================================================
    // MESSAGE ID TESTS
    // =========================================================

    @Test
    public void testMessageID_notNull() {

        assertNotNull(message1.getMessageID());
    }

    @Test
    public void testMessageID_lengthIs10() {

        assertEquals(10, message1.getMessageID().length());
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

    /**
     * Test of generateMessageID method, of class Message.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Message instance = null;
        String expResult = "";
        String result = instance.generateMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        String text = "";
        Message instance = null;
        String expResult = "";
        String result = instance.checkMessageLength(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String recipient = "";
        Message instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        int option = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.sentMessage(option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = null;
        instance.storeMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = null;
        instance.printMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = Message.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageNumber method, of class Message.
     */
    @Test
    public void testGetMessageNumber() {
        System.out.println("getMessageNumber");
        Message instance = null;
        int expResult = 0;
        int result = instance.getMessageNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class Message.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = null;
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageText method, of class Message.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageID method, of class Message.
     */
    @Test
    public void testSetMessageID() {
        System.out.println("setMessageID");
        String messageID = "";
        Message instance = null;
        instance.setMessageID(messageID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecipient method, of class Message.
     */
    @Test
    public void testSetRecipient() {
        System.out.println("setRecipient");
        String recipient = "";
        Message instance = null;
        instance.setRecipient(recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageText method, of class Message.
     */
    @Test
    public void testSetMessageText() {
        System.out.println("setMessageText");
        String messageText = "";
        Message instance = null;
        instance.setMessageText(messageText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageHash method, of class Message.
     */
    @Test
    public void testSetMessageHash() {
        System.out.println("setMessageHash");
        String messageHash = "";
        Message instance = null;
        instance.setMessageHash(messageHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}