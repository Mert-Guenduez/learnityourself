# Software Requirements Specification

### Revision History

| Date        | Version | Description | Author  |
|-------------|---------|-------------|---------|
| 21/Oct/18 | 0.10  | First draft  | Mert Gündüz |
| 22/Oct/18 | 0.20  | More detail to convention part | Mert Gündüz |
| 23/Oct/18 | 0.21  | Added revision history, git commit convention and added content to user interface section | Jannik Adam |
| 28/Oct/18 | 0.30  | Added more detail to several categories  | Mert Gündüz |
## 1. Introduction
### 1.1 Purpose
This Software Requirements Specification ought to give you 
concise information about our learnityourself project. It will provide an overview of
how our App will be structured and which functions will be covered. It defines its requirements and serves as a depiction of
the scope. Not only is the Software Requirements Specification a central document to give our clients an overview of what is realistically expectable,
but it is also useful for us developers to keep track of the direction we want go in.
### 1.2 Scope
This SRS applies to the entire project, which will be realized as an Android App.
This document is for internal use only and shall give directives for the project's development.
### 1.3 Definitions, Acronyms and Abbreviations
* **SRS**	Software Requirements Specification
* **n/a**	not applicable
* **tbd**	to be determined
### 1.4	References
- [GitHub](https://github.com/Mert-Guenduez/learnityourself)
- [Blog](https://learnityourselfdhbw.wordpress.com/)
- [Overall Use case diagram](https://github.com/Mert-Guenduez/learnityourself/blob/master/UseCases.xml)
### 1.5	Overview
The next chapters will be structured as follows:
The second chapter, Overall Description, gives an overview of the functionality of our app and a use case diagram.
The third chapter, the Requirements Specification lists all ressources needed for the project.
 

## 2. Overall Description
Learnityourself is an Android App that helps turn mundane tasks such as studying
into a game, alone or with friends. We will use Java to develop the Frontend, which will
communicate with a backend server using the RESTful API.  
![use-cases.png](https://github.com/Mert-Guenduez/learnityourself/raw/master/UseCases.png)

## 3.	Specific Requirements 
### 3.1	Functionality
#### 3.1.1	Account System
The learnityourself account system is held simple, so the user
does not need to bother with activating his/her account, for example.
##### 3.1.1.1	Register
The user will be able to create an Account by filling in a form to set a username and password.
##### 3.1.1.2	Login
The user can login to the app using his/her respective username and password.
##### 3.1.1.3	Logout 
The user can logout quickly by tapping a logout Button.
##### 3.1.1.4	Change password
The user can change the password in the profile settings. For this, the old password is required.
##### 3.1.1.5 Delete Account
The user can delete the account. In order to do this, the password needs to be re-entered.
##### 3.1.1.6 Reset Password
The user can reset the password by entering the answer for a previously set security question.
#### 3.1.2	General

##### 3.1.2.1	Create Missions
The user can create a mission and set a goal while doing so.
##### 3.1.2.2	View Missions
The user can view all of his missions.
##### 3.1.2.3	Join Missions
The user can search for other missions and request to join.
##### 3.1.2.4 Create custom rewards
The user can create custom rewards for himself. The user may set the reward costs.
##### 3.1.2.5 Spend Points on Rewards
The user can spent his in-game-currency on rewards set up previously.
##### 3.1.2.6	Achievements
The user can view a list of achievements and strive to reach as many as possible. Each achievement has a unique reward such as new user icons or money.

#### 3.1.3	Mission System
##### 3.1.3.1	Edit mission properties
The user can change the group properties even after the group has already been created. Examples of properties are group name, final date, tasks and task duration.
##### 3.1.3.2 Add user
The user can invite other users to join the mission.
##### 3.1.3.3 Manage Tasks
Manage the Missions Tasks by editing or deleting existing tasks as well as creating new ones.
[Manage Tasks](https://github.com/Mert-Guenduez/learnityourself/blob/master/UC_ManageTasks.md)
##### 3.1.3.4 Complete task
The user can set a task as completed. In addition the user can reflect on him-/herself by giving a rating based on how well the task was completed.
##### 3.1.3.5	View statistics
The user can look at dynamically created graphs comparing each user's progress.
##### 3.1.3.6	Highscore
The user receives points upon completing a task. These points are restricted to the group the task was completed in and are used as a way of comparison between users.
##### 3.1.3.7	Get Points
The user receives in-game currency upon completing a task. The amount of money received is based on how long the task takes to complete.
The currency system is independent of the groups and money will be allocated to the accounts. The user can spend the money for rewards.
##### 3.1.3.8 Leave Mission
The user may leave a mission at any time.
#### 3.1.4	Settings
##### 3.1.4.1	Change username
The user may change the username as long as the new one isn't taken already.
##### 3.1.4.2	Show help
The user can view instructions on how to use the app properly and view frequently asked questions.
	
### 3.2	Usability 
#### 3.2.1	Training time
The user can use the app anytime. Creating new user entries is quick and easy. The GUI is designed to have a clear and simple layout.

#### 3.2.2	Language
The Application will be English.

### 3.3	Reliability 
#### 3.3.1	Availability
The service is available 95% of the time. However while the app is in development, the availability may drop below 95%.

#### 3.3.2	Mean Time Between Failures
We plan to keep the MTBF high, a specific estimation is not possible yet.

#### 3.3.3	Mean Time To Repair
We plan to keep the MTTR low, a specific estimation is not possible yet.

### 3.4	Performance
#### 3.4.1	Response time
Is very low and should not take longer than 3-5 seconds. The average response time should be below one second.

#### 3.4.2	Capacity
Three to four digit registered users should be no problem regarding capacity.

### 3.5	Supportability
#### 3.5.1	Conventions
When creating the sourcecode, common Java conventions and best practices will be applied to guarantee simple extensibility.
Furthermore the following GitHub version control conventions are to be applied:
- Each developer will make changes in their own respective branch
- Pulling should be done on a regular basis to avoid massive merge conflicts and pushing is generally only allowed when the sourcecode works (this is especially important when merging the branch into the master)
- A forceful push should be avoided at all cost since it can generally always be avoided and has the risk of destroying others work.

For commits in general:
- The commit should start with the area its relevant to: `[Back]`(Backend), `[Front]`(Frontend), `[Doc]`(Documentation), `[Other]`(affected area should be pointed out in commit message)
- This should be followed by one of the following tags: `[Bug]`(Bug Fix), `[Feat]`(Feature), `[Misc]`(Miscellaneous, more detail in commit description), `[Test]`(Testing)
- After that you should add your actual commit message and fill the description with relevant details

### 3.6	Design Constraints
#### 3.6.1	GitHub
GitHub for version control.

#### 3.6.2	YouTrack
YouTrack as an agile management tool.

#### 3.6.3 	MySQL
MySQL as our single database.

#### 3.6.4 MVC
The App services are implemented using MVC architecture.

### 3.7	Online User Documentation and Help System Requirements
n/a
### 3.8	Purchased Components
n/a

### 3.9	Interfaces
#### 3.9.1	User Interfaces
Our App will have several Interfaces and pages depending on what the user intends to do.

**Login Screen**:
When starting the application the user will see the login screen first. It contains a welcoming message, for example the latest changes
 that were made and can either login or register to our service, which leads to the overview screen.
 
**Overview Screen**: After the user has logged in he is able to view his account settings, an overview of current active missions and has the opportunity to join or create a mission. 
When selecting a mission, the user is redirected to the specific mission overview as a mission member. 
Alternatively a settings button can be pressed, leading to the settings screen.

**Mission Screen**: Here the mission member can see a list of all tasks in this mission and modify the mission settings e.g. add tasks, edit Tasks, add users, leave mission and so on. If the mission member selects a task it displays more detail and can be individually set to be completed for this mission member.

**Settings Screen**: The settings screen is fairly simple so that the desired action is found quickly.
For the functionalities, see **3.1.4 Settings**.
#### 3.9.2	Hardware Interfaces
n/a

#### 3.9.3	Software Interfaces
n/a

#### 3.9.4	Communications Interfaces
n/a

### 3.10	Licensing Requirements
n/a

### 3.11	Legal, Copyright, and Other Notices
n/a

### 3.12	Applicable Standards
n/a

## 4.	Supporting Information
n/a


