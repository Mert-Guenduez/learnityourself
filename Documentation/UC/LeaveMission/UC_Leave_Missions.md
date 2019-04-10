# Use-Case Specification: Leave Missions


## 1. Use-Case Name 
### 1.1 Brief Description
This Use Case deals with leaving a mission.

## 2. Flow of Events
### 2.1 Basic Flow 
UML Diagram:

![UML][]

### 2.2 Mock-Up
Mock-Up:

![Mockup_overview][]
![Mockup_main][]
![Mockup_leave][]
![Mockup_confirm][]
![Mockup_newoverview][]

### 2.3 .feature file

[Feature file](https://github.com/Mert-Guenduez/learnityourself/blob/master/app/src/androidTest/assets/res/LeaveMission.feature)

## 3. Special Requirements
### 3.1 Mission Member
The user must be logged in.

## 4. Preconditions
### 4.1 Mission access
The user must be assigned to the mission.

## 5. Postconditions 
### 5.1 New Password
The mission is removed from the list of missions available for the user. Database entries are updated.

## 6. Extension Points
n/a

<!-- picture links -->
[UML]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/UML_LeaveMission.png
 
[Mockup_overview][]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/missionsoverview.png
[Mockup_main][]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/missionmain.png
[Mockup_leave][]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/leave.png
[Mockup_confirm][]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/confirm.png
[Mockup_newoverview][]: https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/LeaveMission/new_missionsoverview.png

