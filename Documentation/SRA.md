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
Angelika (Das Diagramm macht Jonas. Er macht auch den Blogeintrag, du musst basically nur hinschreiben was er hinschreibt)
Nimm dir für dieses Dokument am besten einfach das als beispiel https://github.com/WMerk/vnvDoc/blob/master/doc/SAD.MD
  
## 3.Architectural Goals and Constraints 
Angelika (Das Diagramm macht auch Jonas)

## 4. Use-Case View 
n/a

## 5. Logical View
![Logical View](https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/MVCDiagram.png)
## 6. Process View
n/a

## 7. Deployment View
Angelika (wenn es geht. Ich weiß nicht genau was hier hinkommt, du kannst ja mal bei den anderen Gruppen gucken)
http://dhbwse201819.pbworks.com/w/page/130434462/GC8_MVC unter "imperfect examples". Kann dir hierbei auch helfen.
## 8. Implementation View
n/a

## 9. Data View
We are using a MySQL Database to store all relevant data, including User Information, Missions and Tasks (and their respective relations).
![DataScheme](https://raw.githubusercontent.com/Mert-Guenduez/learnityourself/master/Documentation/dbScheme.png)

## 10. Size and Performance
n/a

## 11. Quality
Angelika (Hier einfach n bissl über Tests schreiben)
