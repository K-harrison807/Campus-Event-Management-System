# Campus-Event-Management-System(Java Console App)

Overview

This project is a Java console-based Campus Event Management System developed as part of an academic assignment.
The system allows staff and students to create, manage, register, and track campus events with role-based access control.

The application simulates real-world event registration, including capacity limits, waitlists, automatic promotion, sorting, search, and file persistence.

#Features

#Staff Users
Create events,
Update event details,
Cancel events,
View all participants,
View waitlist,
Sort events by name or date,

#Student Users
View events,
Register for events,
Cancel registration,
Cancel waitlist entry,
View registration status,
Search events by name or date,
Event Management,

#Each event contains:

Event ID,
Name,
Date,
Time,
Location,
Maximum participants,
Registered participants list,
Waitlist queue,
System Behaviour,
Students register using Event ID,
If event is full → added to waitlist,
If registered student cancels → first waitlist student promoted,
Data saved to file,
Data loaded automatically on startup,
Events sortable by name or date,
Search by name or date,

#Technologies Used
Java,
OOP (Inheritance & Polymorphism),
ArrayList,
Queue (Waitlist),
File Handling (BufferedReader / FileWriter),
LocalDate / LocalTime,
Lambda sorting (Collections.sort),

#How to Run
Open project in NetBeans / IntelliJ,
Run Main.java,
Select role:
Student,
Staff,
Follow menu options,


#Learning Outcomes

This project demonstrates:

Object-Oriented Programming,
Role-based system design,
Event state management,
File persistence,
Input validation,
Sorting and searching,
Queue-based waitlist logic,
