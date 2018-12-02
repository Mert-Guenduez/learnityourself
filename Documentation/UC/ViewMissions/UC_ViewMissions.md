# Use-Case Specification: View Missions


## 1. Use-Case Name 
### 1.1 Brief Description
This Use Case deals with viewing Missions of a User, Tasks of a Mission and Information of a Mission. To access these functions the User must be logged in.

## 2. Flow of Events
### 2.1 Basic Flow 
UML Diagram: 

![UML][]

### 2.2 Mock-Up
Mock-Up:

![Mockup_viewMissions][]
![Mockup_viewMission][]
![Mockup_viewMissionInformation][]


### 2.3 .feature file

[Feature](https://github.com/Mert-Guenduez/learnityourself/blob/master/app/src/androidTest/assets/res/ViewMissions.feature)

## 3. Special Requirements
### 3.1 Mission Member
The user must be part of a Mission.

## 4. Preconditions
### 4.1 Learn IT App
The user has to be logged into the App.

## 5. Postconditions 
### 5.1 Display Missions
The System needs to display the List of Missions of a User.

### 5.1 Display Tasks
The System needs to display the List of Tasks of a Mission.

### 5.1 Display Information of a Mission
The System needs to display the description, the finish date and the List of MissionMembers of a Mission.

## 6. Extension Points
n/a

<!-- picture links -->
[Mockup_viewMissions]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ViewMissions/Mockup_viewMissions.png
[Mockup_viewMission]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ViewMissions/Mockup_viewMission.png
[Mockup_viewMissionInformation]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ViewMissions/Mockup_viewMissionInformation.png
[UML]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ViewMissions/ViewMissions.png "UML Diagram"
