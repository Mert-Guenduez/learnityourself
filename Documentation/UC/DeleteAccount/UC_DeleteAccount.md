# Use-Case Specification: Delete Account

## 1. Use-Case Name 
### 1.1 Brief Description
This Use Case deals with the deletion of a user account

## 2. Flow of Events
### 2.1 Basic Flow 
UML Diagram:

![UML][]

### 2.2 Mock-Up
Mock-Up:

![Mockup_start][]
![Mockup_current][]
![Mockup_delete][]
![Mockup_warning][]
![Mockup_confirmation][]
![Mockup_toast][]

### 2.3 .feature file

[Feature file](https://github.com/Mert-Guenduez/learnityourself/blob/master/app/src/androidTest/assets/res/DeleteAccount.feature)

## 3. Special Requirements
### 3.1 Mission Member
The user must be logged in.

## 4. Preconditions
### 4.1 Current password
The current password is set as the user's password.

## 5. Postconditions 
### 5.1 Account deleted
All relations to the user and the user itself are deleted in the database.
User becomes a guest and the login screen gets displayed with an information message containing "Account was deleted."

## 6. Extension Points
n/a

<!-- picture links -->
[UML]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/UML_DeleteAccount.png

[Mockup_start]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/start.png
[Mockup_current]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/currentPassword.png
[Mockup_delete]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/Delete.png
[Mockup_warning]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/warning.png
[Mockup_confirmation]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/confirm.png
[Mockup_toast]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/DeleteAccount/toast.png

