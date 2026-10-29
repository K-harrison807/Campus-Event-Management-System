# Campus-Event-Management-System
# Campus Event Management System (Java Console Application)

## System Functionality Demo

[**Click here to download and watch the system functionality demo video**](https://github.com/K-harrison807/Campus-Event-Management-System/releases/download/v1.0.0/PRO631_Assignment_System.Functonality.mp4)

## Overview

The Campus Event Management System is a Java console-based application developed as part of an academic assignment. It allows staff and students to manage campus events and event registrations through role-based access.

The system simulates real-world event registration by supporting participant limits, waitlists, automatic promotion from waitlists, event searching and sorting, and file-based data storage.

## Screenshots (Check out more in the screenShot folder)

## Create Event
![Staff menu](https://github.com/K-harrison807/Campus-Event-Management-System/blob/main/JavaScreenShots/create%201.png)

### Event Registration
![Event Registration](https://github.com/K-harrison807/Campus-Event-Management-System/blob/main/JavaScreenShots/studentRegisted%205.png)

### Waitlist
![Waitlist](https://github.com/K-harrison807/Campus-Event-Management-System/blob/main/JavaScreenShots/waitlist%2011.png)

### Cancel Events
![View Events](https://github.com/K-harrison807/Campus-Event-Management-System/blob/main/JavaScreenShots/cancel%20event%203.png)


## Features

### Staff Users

- Create new events.
- Update event details.
- Cancel events.
- View registered participants.
- View event waitlists.
- Sort events by name or date.

### Student Users

- View available events.
- Register for events using an Event ID.
- Cancel event registrations.
- Cancel waitlist entries.
- Check registration status.
- Search for events by name or date.

### Event Management

Each event stores the following information:

- Event ID
- Event name
- Date and time
- Location
- Maximum participant capacity
- List of registered participants
- Waitlist queue

### System Behaviour

- Students register for events using an Event ID.
- When an event reaches its maximum capacity, additional students are placed on the waitlist.
- When a registered student cancels, the first student on the waitlist is automatically promoted, if someone is waiting.
- Event data is saved to files and loaded automatically when the application starts.
- Events can be sorted by name or date and searched by name or date.

## Technologies Used

- **Java** – Application development.
- **Object-Oriented Programming (OOP)** – Inheritance and polymorphism.
- **ArrayList** – Managing collections of data.
- **Queue** – Managing event waitlists.
- **File Handling** – Reading and writing data using `BufferedReader` and `FileWriter`.
- **Java Date and Time API** – Using `LocalDate` and `LocalTime`.
- **Collections and Lambda Expressions** – Sorting events.

## How to Run

1. Open the project in Apache NetBeans or IntelliJ IDEA.
2. Locate `Main.java`.
3. Run the application.
4. Select the **Student** or **Staff** role.
5. Follow the console menu options.

## Learning Outcomes

This project demonstrates practical experience in:

- Object-Oriented Programming.
- Role-based system design.
- Event and registration management.
- File persistence.
- Input validation.
- Sorting and searching.
- Queue-based waitlist management.
