Leyte Progressive High School Registrar System
This is a desktop-based Registrar System developed for Leyte Progressive High School to help streamline student data management, improve administrative efficiency, and securely store student records.

Overview
The system provides a centralized platform for managing student information, enrollment records, and class assignments. Designed with simplicity and maintainability in mind, this application is ideal for small to medium-sized educational institutions looking to digitize their student record processes.

Features
Student registration and information management

Grade level and section assignment

Enrollment tracking across academic years

Optional user login authentication for registrar staff

Modular codebase for future enhancements (e.g., grade reports, printing)

Technologies Used
Java (Core application logic)

Java Swing or JavaFX (User interface)

MySQL or SQLite (Database management)

JDBC (Java Database Connectivity)

Launch4j (Convert .jar to .exe)

Inno Setup (Create Windows installer)

Project Structure
css
Copy
Edit
RegistrarSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Main.java
│   │   │   ├── database/
│   │   │   ├── models/
│   │   │   └── ui/
│   └── resources/
├── database/
│   └── registrar_db.sql
├── README.md
└── LICENSE
Getting Started
Prerequisites
Java Development Kit (JDK 8 or later)

MySQL or SQLite installed and configured

Any IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)
