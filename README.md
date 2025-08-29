LetterBoxD CLI (Java)

A Java-based command-line application for managing movies and users, inspired by LetterBoxD. This project provides both admin and user functionalities to interact with a MySQL database storing movie and user data.

Features
Admin Features

Add, delete, and update movies.

Add, delete, and manage users.

Change user passwords.

View all movies in the database.

Search for users by ID.

User Features

View all available movies.

Search movies by ID.

Create and manage personal watchlists.

Add/remove movies from watchlists.

Mark movies as watched with ratings.

View trending movies.

Change password or username.

Trending Movies

Fetches random movies from the database.

Displays the top 10 trending movies using a stack-based implementation.

Project Structure
LetterBoxD/
│
├─ bin/                # Compiled .class files
├─ database/           
│   ├─ letterboxd.sql  # Database schema
│   ├─ letterboxd.pdf  # Documentation
│   └─ letterboxd.docx # Documentation
├─ lib/                # External libraries
├─ PPT/                # Presentation files
│   └─ LETTERBOXD.pptx
├─ src/
│   └─ P/              # Java source package
│       ├─ Admin.java
│       ├─ Main.java
│       ├─ searchBST.java
│       ├─ sll.java
│       ├─ Trending.java
│       ├─ User.java
│       └─ zcombined.java (legacy/testing code)
└─ README.md

Technologies Used

Java: Core language for CLI application logic.

MySQL: Stores movies, users, watchlists, and ratings.

JDBC: Database connectivity for executing SQL queries.

Setup & Usage

Clone the repository:

git clone https://github.com/theredguy2006/LetterBoxD-CLI.git
cd LetterBoxD-CLI


Set up the database:

Create a MySQL database named letterboxd.

Import letterboxd.sql to create necessary tables and sample data.

Configure database credentials in Main.java:

String driverName = "com.mysql.jdbc.Driver";
String dbURL = "jdbc:mysql://localhost:3306/letterboxd";
String dbUser = "root";       // replace with your DB username
String dbPass = "";           // replace with your DB password


Compile the Java source code:

javac -d bin src/P/*.java


Run the application:

java -cp bin P.Main


Login credentials:

Admin: username: admin, password: admin

New user: username: new, password: new (follow prompts for registration)

Code Highlights

Admin.java: Handles all admin-related tasks like adding/deleting movies and users.

User.java: Manages user operations, watchlists, watched movies, and ratings.

searchBST.java: Binary Search Tree for efficiently managing movie data.

sll.java: Singly Linked List for managing users.

Trending.java: Stack-based trending movies feature.

zcombined.java: Legacy/testing code, mostly commented out.

Potential Improvements

Security: Avoid hardcoding credentials; implement password hashing.

Code organization: Refactor large classes into smaller, modular units.

Error handling: Add robust exception handling for database operations.

Scalability: Optimize SQL queries for performance with large datasets.

UI: Add a graphical or web interface for better user experience.

Notes

CLI-only: No graphical interface.

Fully functional one year old project, designed for learning Java, JDBC, and database management.

The project demonstrates linked lists, BST, and stack data structures in practical applications.
