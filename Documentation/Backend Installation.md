# Installation of learnityourself server and database

- [Installation of learnityourself server and database](#installation-plan)
    - [1. Installation Guide](#2-installation-guide)
        - [1.1 Requirements](#21-requirements)
        - [1.2 Cloning implementation](#23-cloning-implementation)
        - [1.3 Configure database](#24-configure-database)
        - [1.4 Configure database authentication](#24-configure-database-authentication)
        - [1.5 Test application](#25-test-application)

## 1. Installation Guide
This guide helps you to setup your own instance of a learnityourself server.

### 1.1 Requirements

Install following components to your local machine or to a dedicated server:
- Webserver (e.g nginx/ apache)
- PHP
- Git
- DBMS (SQL)

You can also use XAMPP https://www.apachefriends.org/index.html to run the Apache Server as well as a MySQL Database
Simply put the php Files in the htdocs Directory and Run Apache as well as MySQL in the XAMPP Console

### 1.2 Cloning implementation

git clone https://github.com/Mert-Guenduez/learnityourself.git
Warning: Make sure that your webserver configuration makes folder "learnityourself/Backend" accessible.

### 1.3 Configure database

Create database tables according to following schema "learnityourself/Documentation/dbSchema/schema.sql".

### 1.4 Configure database authentication

Edit "connectToDatabase.php" in folder "learnityourself/Backend" to use your own database.
You will need to create a user with a password for the database and enter these credentials as follows:

Original:
$db = new mysqli('localhost', 'DB_USER', 'DB_PWD', 'DB_NAME');

Example:
$db = new mysqli('localhost', 'jannik', 'passwort123', 'learnityourself');

Warning: Don't change "localhost" even if you are using a dedicated server.

### 1.5 Test the application
After you have completed all steps above, you should be able to use our application with your own server.

You can change the default learnityourself server to your own in the login screen.
Just hit the pen in the top right corner and enter the host address.
Example: https://www.learnityourself.ml/ or  https://91.205.172.109/
