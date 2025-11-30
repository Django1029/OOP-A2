YunyangJiang-A2
PROG2004 – Object Oriented Programming
Assignment 2: Park Rides Visitor Management System (PRVMS)

This project is my implementation of Assignment 2 for PROG2004.
The goal of this assignment is to develop a Theme Park Ride Visitor Management System (PRVMS) using Java.
The project demonstrates the use of object-oriented programming principles, advanced collections, abstract classes, interfaces, sorting mechanisms, queue structures, linked lists, and file input/output operations.
All required parts from Part 1 to Part 7 have been fully implemented.

Project Structure

The project contains the following Java source files:

AssignmentTwo.java
Person.java
Employee.java
Visitor.java
Ride.java
RideInterface.java
RideVisitorComparator.java

Features Implemented (Based on Assignment Requirements)

Part 1 – Classes and Inheritance

Person class (abstract) with id, name, age

Employee extends Person

Visitor extends Person

Ride class with ride name, operator, max riders, counters, queue, and history

Part 2 – Abstract Class and Interface

Person is abstract

RideInterface created containing all required methods

Ride implements all interface methods

Part 3 – Waiting Line Using Queue

Implemented a FIFO queue using Queue<Visitor>

Methods: addVisitorToQueue, removeVisitorFromQueue, printQueue

Demonstrated in partThree()

Part 4A – Ride History Using LinkedList

Ride history stored in LinkedList<Visitor>

Methods: addVisitorToHistory, checkVisitorFromHistory, numberOfVisitors, printRideHistory (uses Iterator)

Demonstrated in partFourA()

Part 4B – Sorting Ride History

Custom comparator class RideVisitorComparator

Sorting uses ticketType then age

Demonstrated in partFourB()

Part 5 – Running One Ride Cycle

Checks for ride operator

Checks that queue is not empty

Moves up to maxRider visitors from queue into history

Cycle counter increases

Demonstrated in partFive()

Part 6 – Export Ride History to CSV

Method exportRideHistory(String filename)

Writes visitor details as CSV lines

Includes exception handling

Demonstrated in partSix()

Part 7 – Import Ride History from CSV

Method importRideHistory(String filename)

Reads CSV lines and recreates Visitor objects

Adds them into LinkedList

Includes exception handling

Demonstrated in partSeven()

How to Compile and Run

Compile inside the src folder using:

javac *.java

Run the program using:

java AssignmentTwo

The program automatically executes all demonstrations for Parts 3 to 7.

A CSV file named ride_history_export.csv will be created during Part 6.

Example Output (Short Preview)

The program displays outputs such as:

PART 3: Waiting Line Demo
Visitors added to queue
A visitor removed from queue
Queue printed

PART 4A: Ride History Demo
Visitors added to history
Visitor found or not found
Number of visitors printed

PART 5: Run One Cycle Demo
Operator displayed
Visitors moved from queue to history

PART 6: Export Demo
ride_history_export.csv created

PART 7: Import Demo
Visitors successfully imported and printed

Technologies Used

Java
Abstract classes
Interfaces
Queue
LinkedList
Iterator
Comparator
CSV file I/O

Unit Learning Outcomes (ULO) Addressed

ULO2 – Applied OOP principles including inheritance, abstraction, and encapsulation
ULO3 – Used advanced Java collections such as Queue, LinkedList, and Comparator
ULO4 – Implemented file input/output for exporting and importing visitor data

GenAI Use Declaration
(Choose ONE statement only)

A. If GenAI was used:
I acknowledge that I have used GenAI tools to complete this assessment.
I used ChatGPT to assist with structure and debugging within the parameters outlined in the Assessment Brief and by the Unit Assessor.

B. If GenAI was not used:
I acknowledge that I have not knowingly used GenAI to complete this assessment.

Video Demonstration Guide

The video should briefly explain:

Person, Employee, Visitor inheritance

Why Person is abstract

How RideInterface enforces required methods

Queue operations for waiting line

LinkedList ride history and Iterator

Sorting using Comparator

Running a ride cycle process

CSV export and import

Demonstration of program output

Author

Yunyang Jiang
Southern Cross University
PROG2004 – Object Oriented Programming
Assignment 2 – PRVMS
