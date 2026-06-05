# MyChatsApp

A Java-based console chat application developed using Java, Maven, and JUnit 5.  
This project allows users to register, log in, and send messages while validating usernames, passwords, phone numbers, and message details.

---

# Features

## User Registration
- Username validation
- Password complexity validation
- South African phone number validation

## User Login
- Login authentication
- Login status messages

## Messaging System
- Send messages
- Store messages
- Display recently sent messages
- Generate unique message IDs
- Create message hashes
- Validate message length
- Validate recipient phone numbers

## Unit Testing
- JUnit 5 testing implemented
- Automated CI testing using GitHub Actions and Maven

---

# Technologies Used

- Java 17
- Maven
- JUnit 5
- GitHub Actions
- Apache NetBeans IDE

---

# Project Structure

```text
MyChatsApp
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── mycompany
    │               └── mychatsapp
    │                   ├── Login.java
    │                   ├── Message.java
    │                   └── MainApp.java
    │
    └── test
        └── java
            └── com
                └── mycompany
                    └── mychatsapp
                        ├── LoginTest.java
                        └── MessageTest.java
