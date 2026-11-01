# Library Management System (Java RMI)

A Distributed Library Management System developed using Java Remote Method Invocation (RMI).

## Project Description

This project implements a client-server library management system. The client communicates with the remote server using Java RMI to perform library operations.

## Features

- Add new books.
- Search for books by title.
- View all available books.
- Prevent duplicate Book IDs.
- Store book records using HashMap.
- Maintain issued book records and issuing history.

## Project Structure

```text
Dscc_Project/
│
├── Book.java
├── LibraryService.java
├── LibraryServiceImpl.java
├── LibraryServer.java
├── LibraryClient.java
└── README.md
```

## How to Run

### 1. Compile the Project

```bash
javac *.java
```

### 2. Start the RMI Server

```bash
java LibraryServer
```

Keep the server running.

### 3. Start the Client

Open a new terminal in the project directory and run:

```bash
java LibraryClient
```

## Available Operations

1. Add Book
2. Search Book
3. View All Available Books
4. Exit

## Technologies Used

- Java
- Java RMI
- HashMap
- ArrayList
