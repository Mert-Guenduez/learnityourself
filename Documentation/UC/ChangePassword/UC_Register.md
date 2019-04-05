# Use-Case Specification: Change Password


## 1. Use-Case Name 
### 1.1 Brief Description
This Use Case deals with changing a user's password.

## 2. Flow of Events
### 2.1 Basic Flow 
UML Diagram:

![UML][]

### 2.2 Mock-Up
Mock-Up:

![Mockup_start][]
![Mockup_current][]
![Mockup_new][]
![Mockup_toast][]

### 2.3 .feature file

[Feature file](https://github.com/Mert-Guenduez/learnityourself/blob/master/app/src/androidTest/assets/res/ChangePassword.feature)

## 3. Special Requirements
### 3.1 Mission Member
The user must be logged in.

## 4. Preconditions
### 4.1 Current password
The current password is set as the user's password.

## 5. Postconditions 
### 5.1 New Password
The new password is set as the user's password. Database entries are updated. A message is shown to user.

## 6. Extension Points
n/a

<!-- picture links -->
[UML]: 
[Mockup_start]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ChangePassword/Start.png
[Mockup_current]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ChangePassword/current.png
[Mockup_new]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ChangePassword/new.png
[Mockup_toast]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ChangePassword/toast.png

