# Software Architecture Document


## 1. Introduction 

### 1.1 Purpose
This Document ought to depict the architectural structure of the implementation of our project by presenting multiple different views in order to touch on all aspects of the structure. It serves as an overview for the architectural decisions we have made.
### 1.2 Scope
The Software Architecture Document's scope is providing an insight on the architecture of our project. This includes Classes, Use Cases and Data Storage.
  
### 1.3 References
- [Blog](https://learnityourselfdhbw.wordpress.com/)
- [GitHub](https://github.com/Mert-Guenduez/learnityourself)
- [Overall Use case diagram](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/UseCases_Overview.png)
- [Software Requirements Specification](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/SRS/SRS.md)
- [Use Case: CreateMission](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/CreateMission/UC_CreateMission.md)
- [Use Case: EditMissionMember](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/EditMissionMember/UC_EditMissionMember.md)
- [Use Case: Login](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/Login/UC_Login.md)
- [Use Case: ManageTasks](https://github.com/Mert-Guenduez/learnityourself/tree/master/Documentation/UC/ManageTasks)
- [Use Case: Register](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/Register/UC_Register.md)
- [Use Case: ViewMissions](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/ViewMissions/UC_ViewMissions.md)

## 2. Architectural Representation
We use the MVC for our Android App. 

![MVC](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/MVC.png)
  
## 3.Architectural Goals and Constraints 
The frontend and the backend are both developed separted from each other and only communicate over php Post Requests.

### Frontend
The fronted is written in Java and uses the MVC architecture.

### Backend
The backend is an API and belongs to the Model of the MVC architecture. To store the data it communicates with a MySQL database.

### MVC
The main goal of the MVC architecture is to separate the view from the logic. The controller takes care of handling actions by the user and telling View or Model, that there were actions performed that concern them. Models contain the data that is displayed in the views.


## 4. Use-Case View 
The Android App provides the use cases shown in the following diagram.

![UC](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/UC/UseCases_Overview.png)


## 5. Logical View
![Logical View](https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/MVCDiagram.png)

## 6. Process View
n/a

## 7. Deployment View
![Deployment View](https://github.com/Mert-Guenduez/learnityourself/blob/master/Documentation/DeploymentView.png)

## 8. Implementation View
n/a

## 9. Data View
We are using a MySQL Database to store all relevant data, including User Information, Missions and Tasks (and their respective relations).

![DataScheme](https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/dbScheme.png)

## 10. Size and Performance
n/a

## 11. Quality
To ensure a high quality code we write and run tests. For now we just use Feature Tests. More Tests will be added in the future. However, the tests are automatically executed before a new version is deployed to the server.
