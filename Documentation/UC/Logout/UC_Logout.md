# Use-Case Specification: Logout


## 1. Use-Case Name 
### 1.1 Brief Description
This Use Case deals with a logged-in user logging out of the application

## 2. Flow of Events
### 2.1 Basic Flow 
UML Diagram: 

![UML][]

### 2.2 Mock-Up
Mock-Up:

![Mock][]

### 2.3 .feature file

[Feature](https://github.com/Mert-Guenduez/learnityourself/blob/master/app/src/androidTest/assets/res/Logout.feature)

## 3. Special Requirements
### 3.1 Existing account
The Guest must have an existing account and be logged into the app.

## 4. Preconditions
### 4.1 Logged in
The user is logged into the app and is seeing the main Activity
### 4.2 Existing Session Key
The user has an existing and valid session key

## 5. Postconditions
### 5.1 Logged out
The user is seeing the login screen
### 5.2 Session key
The user will no longer have a session key

## 6. Extension Points
n/a

<!-- picture links -->
[UML]: https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/UC/Logout/UML_Logout.png "UML Diagram"
[Mock]: https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/UC/Logout/Logout_Mock.png "Mockup"
