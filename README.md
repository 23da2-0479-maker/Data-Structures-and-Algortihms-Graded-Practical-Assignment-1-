# University Student Record and Campus Route Management System

CIT300 – Data Structures and Algorithms
Graded Practical Assignment 1 (Group Project, 10% of module grade)

## Project Overview
A Java console application that manages university student records and models
campus locations/connections as a graph. Demonstrates linked lists, stacks,
queues, a BST/AVL tree, hashing, and graph traversal (BFS/DFS).

## Group Members

| Name | Student ID | Responsibility | Individual Contribution |
|------|-----------|-----------------|--------------------------|
| M.K.Umar Mohamed | 23DA2-0501 | Linked list – student record management | [Implemented the custom singly linked list (Node, StudentLinkedList) and Student record class from scratch. Built add, update, delete, search, and display operations with input validation (duplicate ID checks, marks range, empty fields). Tested independently before integration.|
| [Name] | [ID] | Stack & queue implementation | [describe] |
| [Name] | [ID] | BST/AVL tree & hashing/search | [describe] |
| [Name] | [ID] | Graph, campus locations/connections, BFS/DFS | [describe] |

*(All members: integration, validation, testing, debugging, documentation, GitHub collaboration.)*

## Features
- Add / update / delete / search / display student records (Linked List)
- Undo / recent-actions history (Stack)
- Student service request queue (Queue)
- Student records organized/searched by ID (BST or AVL Tree)
- Fast student ID lookup (Hashing)
- Campus locations and connections modeled as a Graph (adjacency list/matrix)
- Add/remove locations and connections; display campus network
- Graph traversal via BFS or DFS
- Menu-driven console interface with input validation

## Menu
1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records (Linked List)
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions (Stack)
8. Display Students (BST/AVL)
9. Search Student (Hashing)
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations (BFS/DFS)
16. Exit

## Tech Stack
- Java (console-based application)

## How to Run
```
javac -d bin src/**/*.java
java -cp bin Main
```
*(Adjust paths/main class name to match the actual project structure.)*

## Project Structure
```
src/
  ├── model/          # Student, Location, etc.
  ├── linkedlist/      
  ├── stack/
  ├── queue/
  ├── tree/            # BST/AVL
  ├── hashing/
  ├── graph/
  └── Main.java
README.md
```

## GitHub Collaboration
- Branches, commits, and pull requests used across all components.
- Commit history reflects each member's individual contribution.

## Demo Video
One merged demo video (< 15 minutes) with all members' faces visible,
showing each member's contribution.

## Deadline
29th September (via designated LMS submission link).
