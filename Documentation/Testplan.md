# Test plan

- [Test plan](#test-plan)
    - [1. Introduction](#1-introduction)
        - [1.1 Purpose](#11-purpose)
        - [1.2 Scope](#12-scope)
        - [1.3 Intended Audience](#13-intended-audience)
        - [1.4 Document Terminology and Acronyms](#14-document-terminology-and-acronyms)
        - [1.5  References](#15--references)
        - [1.6 Document Structure](#16-document-structure)
    - [2. Evaluation Mission and Test Motivation](#2-evaluation-mission-and-test-motivation)
        - [2.1 Background](#21-background)
        - [2.2 Evaluation Mission](#22-evaluation-mission)
        - [2.3 Test Motivators](#23-test-motivators)
    - [3. Target Test Items](#3-target-test-items)
    - [4. Outline of Planned Tests](#4-outline-of-planned-tests)
        - [4.1 Outline of Test Inclusions](#41-outline-of-test-inclusions)
        - [4.2 Outline of Other Candidates for Potential Inclusion](#42-outline-of-other-candidates-for-potential-inclusion)
        - [4.3 Outline of Test Exclusions](#43-outline-of-test-exclusions)
    - [5. Test Approach](#5-test-approach)
        - [5.1 Testing Techniques and Types](#51-testing-techniques-and-types)
            - [5.1.1 Unit Testing](#511-unit-testing)
            - [5.1.2 User Interface Testing](#512-user-interface-testing)
            - [5.1.3 User Testing](#514-user-testing)
    - [6. Entry and Exit Criteria](#6-entry-and-exit-criteria)
        - [6.1 Test Plan](#61-test-plan)
            - [6.1.1 Test Plan Entry Criteria](#611-test-plan-entry-criteria)
            - [6.1.2 Test Plan Exit Criteria](#612-test-plan-exit-criteria)
    - [7. Deliverables](#7-deliverables)
        - [7.1 Test Evaluation Summaries](#71-test-evaluation-summaries)
        - [7.2 Reporting on Test Coverage](#72-reporting-on-test-coverage)
        - [7.3 Perceived Quality Reports](#73-perceived-quality-reports)
        - [7.4 Incident Logs and Change Requests](#74-incident-logs-and-change-requests)
        - [7.5 Smoke Test Suite and Supporting Test Scripts](#75-smoke-test-suite-and-supporting-test-scripts)
    - [8. Testing Workflow](#8-testing-workflow)
    - [9. Environmental Needs](#9-environmental-needs)
        - [9.1 Base System Hardware](#91-base-system-hardware)
        - [9.2 Base Software Elements in the Test Environment](#92-base-software-elements-in-the-test-environment)
        - [9.3 Productivity and Support Tools](#93-productivity-and-support-tools)
    - [10. Responsibilities, Staffing, and Training Needs](#10-responsibilities-staffing-and-training-needs)
        - [10.1 People and Roles](#101-people-and-roles)
        - [10.2 Staffing and Training Needs](#102-staffing-and-training-needs)
    - [11. Iteration Milestones](#11-iteration-milestones)
    - [12. Risks, Dependencies, Assumptions, and Constraints](#12-risks-dependencies-assumptions-and-constraints)
    - [13. Management Process and Procedures](#13-management-process-and-procedures)
    - [14. Metrics](#14-Metrics)

## 1. Introduction

### 1.1 Purpose

The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for a given iteration. It describes the approach to testing the software.
This Test Plan for LearnItYourself supports the following objectives:

- Identifies the items that should be targeted by the tests.
- Identifies the motivation for and ideas behind the test areas to be covered.
- Outlines the testing approach that will be used.
- Identifies the required resources and provides an estimate of the test efforts.

### 1.2 Scope

This test plan will cover tests assuring the functionality of the application's front end, back end and the communication between the two.
This document shows the following types of testing:

- Unit Testing
- Integration Testing
- User Interface Testing
- API Testing

 Not covered are any tests related to performance and scale or usability.

### 1.3 Intended Audience

This test plan is written primarily for internal documentation reasons. It is meant to provide orientation to the developers to work from and as a documentation to measure the fullfillment of quality requirements against.

### 1.4 Document Terminology and Acronyms

| Abbr | Abbreviation                        |
|------|-------------------------------------|
| API  | Application Programmable Interface  |
| CI   | Continuous Integration              |
| CD   | Continuous Delivery/Deployment      |
| n/a  | not applicable                      |
| SRS  | Software Requirements Specification |
| tbd  | to be determined                    |
| UI   | User Interface                      |
| VC   | Version Control                     |

### 1.5  References

| Title                                                                        | Date       | Publishing organization   |
| -----------------------------------------------------------------------------|:----------:| ------------------------- |
| [Blog](https://learnityourselfdhbw.wordpress.com)                            | Oct. 2018  | LearnItYourself Team      |
| [GitHub Repository](https://github.com/Mert-Guenduez/learnityourself)        | Oct. 2018  | LearnItYourself Team      |
| [UC_Add User](./UC/AddUser/UC_AddUser.md)                                    | Oct. 2018  | LearnItYourself Team      |
| [UC_CreateMission](./UC/CreateMission/UC_CreateMission.md)                   | Nov. 2018  | LearnItYourself Team      |
| [UC_ManageTasks](./UC/ManageTasks/UC_ManageTasks.md)                         | Nov. 2018  | LearnItYourself Team      |
| [UC_Register](./UC/Register/UC_Register.md)                                  | Nov. 2018  | LearnItYourself Team      |
| [UC_EditMissionMember](./UC/EditMissionMember/UC_EditMissionMember.md)       | Dez. 2018  | LearnItYourself Team      |
| [UC_Login](./UC/Login/UC_Login.md)                                           | Dez. 2018  | LearnItYourself Team      |
| [UC_ViewMissions](./UC/ViewMissions/UC_ViewMissions.md)                      | Dez. 2018  | LearnItYourself Team      |
| [UC_ChangePassword](./UC/ChangePassword/UC_ChangePassword.md)                | Apr. 2019  | LearnItYourself Team      |
| [UC_CompleteTask](./UC/CompleteTask/UC_CompleteTask.md)                      | Apr. 2019  | LearnItYourself Team      |
| [UC_DeleteAccount](./UC/DeleteAccount/UC_DeleteAccount.md)                   | Apr. 2019  | LearnItYourself Team      |
| [UC_EditMission](./UC/EditMission/UC_EditMission.md)                         | Apr. 2019  | LearnItYourself Team      |
| [UC_LeaveMission](./UC/LeaveMission/UC_LeaveMission.md)                      | Apr. 2019  | LearnItYourself Team      |
| [UC_Logout](./UC/Logout/UC_Logout.md)                                        | Apr. 2019  | LearnItYourself Team      |
| [UC_ManageCustomRewards](./UC/ManageCustomRewards/UC_ManageCustomRewards.md) | Apr. 2019  | LearnItYourself Team      |
| [UC_ReceiveAchievements](./UC/ReceiveAchievements/UC_ReceiveAchievements.md) | Apr. 2019  | LearnItYourself Team      |
| [UC_SpendPointsOnRewards](./UC/SpendPointsOnRewards/UC_SpendPointsOnRewards.md) | Apr. 2019  | LearnItYourself Team      |
| [UC_ViewMissionStatistic](./UC/ViewMissionStatistic/UC_ViewMissionStatistic.md) | Apr. 2019  | LearnItYourself Team      |
| [UC_ViewStatistic](./UC/ViewStatistic/UC_ViewStatistic.md)                   | Apr. 2019       | LearnItYourself Team |
| [ScoreSheet](../UserTesting/ScoreSheet.xlsm)                                 | May. 2019       | LearnItYourself Team |
| [ScoreCollection](../UserTesting/ScoreCollection.csv)                        | May. 2019       | LearnItYourself Team |
| [Test Plan](./Testplan.md)                                                   | Apr. 2019  | LearnItYourself Team      |
| [SRS](./SRS/SRS.md                                     )                      | Oct. 2018  | LearnItYourself Team      |
| [SAD](./SRA.md)                                                             | Oct. 2018  | LearnItYourself Team      |

### 1.6 Document Structure

n/a

## 2. Evaluation Mission and Test Motivation

### 2.1 Background

Testing makes sure that our Code works as intended. It also prevents code changes to break existing functionality unnoticed. In the context of integration it can also prevent broken software states to be merged into our master branch.

### 2.2 Evaluation Mission

Testing is a crucial phase in the development cycle. It is necessary in order to fix technical bugs and important functional problems.

### 2.3 Test Motivators

The tests are done to ensure quality and mitigate risks and fulfill functional requirements. Their purpose is to provide stability for our application. And to make sure bugs don't go unnoticed.

## 3. Target Test Items

- Android frontend
- Server backend (and APIs)

## 4. Outline of Planned Tests

### 4.1 Outline of Test Inclusions

*Frontend: Android Client*:
- UI / Integration testing
- User Testing

*Backend: PhP Application*:
- Unit testing


![Testing overview](./testing_overview.png)  

The tests themself will not be tested and will not account into code coverage.

### 4.2 Outline of Other Candidates for Potential Inclusion

n/a

### 4.3 Outline of Test Exclusions

Because of time and resource constraints we will not do:

- Stress test
- Load/performance tests
- any further tests

## 5. Test Approach

### 5.1 Testing Techniques and Types

#### 5.1.1 Unit Testing

Unit testing ensures, that the tested sourcecode works as expected. Therefore small parts of the sourcecode are tested independently.

|                       | Description                                                         |
|-----------------------|---------------------------------------------------------------------|
|Technique Objective    | Ensure that the implemented code works as expected                  |
|Technique              | Implement test methods using phpUnit Framework                      |
|Oracles                | Test execution logs t command line                                  |
|Required Tools         | phpUnit                                                             |
|Success Criteria       | All tests pass. Coverage is above  40%                               |
|Special Considerations | -                                                                   |

#### 5.1.2 User Interface Testing

By UI testing the application is tested from the perspective of the user. The goal of UI testing is to ensure that the UI behaves as expected.

|                       | Description                                                          |
|-----------------------|----------------------------------------------------------------------|
|Technique Objective    | Test application automated from the perspective of the user through UI Test |
|Technique              | Writing Gherkin `.feature` files with clearly defined steps. The test implementation of the steps use the Android Espresso library to serve the emulator. |
|Oracles                |  Test execution logs t command line                                  |
|Required Tools         | Dependencies of Cucumber and Espresso and an Implementation of a test runner based on JUnit 4 to execute UI tests |
|Success Criteria       | All UI tests pass.  Coverage is above  40%  |
|Special Considerations | - |

#### 5.1.3 User Testing

User Testing makes sure our Application, especially the UI makes sense to the average user. To ensure this we will use a [ScoreSheet](../UserTesting/ScoreSheet.xlsm) and calculate the average results from around 10 Users. The results will be saved to a [ScoreCollection](../UserTesting/ScoreCollection.csv)

|                       | Description                                                          |
|-----------------------|----------------------------------------------------------------------|
|Technique Objective    | Test App with an actual human                                        |
|Technique              | Human interaction with the App                                       |         
|Oracles                | Fileld out Score Sheet                                               |
|Required Tools         | User, ScoreSheet, Excel                                              |
|Success Criteria       | Average result of at least 7.0                                       |
|Special Considerations | Different aspects tested should have different weights               |

## 6. Entry and Exit Criteria

### 6.1 Test Plan

#### 6.1.1 Test Plan Entry Criteria

n/a

#### 6.1.2 Test Plan Exit Criteria

n/a

## 7. Deliverables

## 7.1 Test Evaluation Summaries

The project contains a certain amount of tests in the Frontend and Backend. Each pushed commit to the master triggers our CI/CD Pipeline, which builds the application and executes the Backend tests.

Continuous Integration/Delivery/Deployment Pipeline based on Jenkins: [Jenkins](http://91.205.172.109:8080) [![Build Status](http://91.205.172.109:8080)](http://91.205.172.109:8080)

[comment]: #Code Analysis

CI/CD Pipeline stages: Build, Test, Deploy(only on the master branch):  
![CI/CD Pipeline stages: Build, Test, Deploy(only on the master branch) ](./CICD_stages.png)  
Integration of CI/CD Pipeline pipeline with github:  
![Integration of CI/CD Pipeline pipeline with github](./CICD_github_commits.png)  
Frontend IDE test execution:  
![Frontend IDE test execution](./frontend_test_execution.png)  
Backend IDE test execution:  
![Backend IDE test execution](./backend_test_execution.png)

## 7.2 Reporting on Test Coverage

TODO

## 7.3 Perceived Quality Reports

TODO

## 7.4 Incident Logs and Change Requests

TODO

## 7.5 Smoke Test Suite and Supporting Test Scripts

The automated test execution in our CI/CD Pipeline enables regression testing. With this approach it is clearly visible when changes break existing functions and affect the correct behaviour of the application.

## 8. Testing Workflow

1) Local testing in the IDE when developing
4) Before the automated deployment the build and test stages are executed

## 9. Environmental Needs

### 9.1 Base System Hardware

The following table sets forth the system resources for the test effort presented in this Test Plan.

| Resource              | Quantity | Name and Type                |
|-----------------------|:--------:|------------------------------|
| CI/CD server          |    1     | Jenkins CI                   |
| local test machine    |    1     | Notebooks (Angelika, Jannik, Jonas, Mert)  |
| Android test device   |    1     | Mobile Phones (Jannik, Jonas, Mert)    |

### 9.2 Base Software Elements in the Test Environment

The following base software elements are required in the test environment for this Test Plan.

| Software Element Name |  Type and Other Notes                        |
|-----------------------|----------------------------------------------|
| Android Studio        | Test Runner / IDE                            |
| JUnit 4 & 5           | Unit testing library                         |
| Espresso              | UI testing library                           |
| Cucumber              | human readable test definitions              |

### 9.3 Productivity and Support Tools

The following tools will be employed to support the test process for this Test Plan.

| Tool Category or Type | Tool Brand Name                              |
|-----------------------|----------------------------------------------|
| Repository            | [github.com](http://github.com/)             |
| CI/CD Service         | [Jenkins CI](https://jenkins.io)             |

## 10. Responsibilities, Staffing, and Training Needs

### 10.1 People and Roles

| Role          | Person Assigned |  Specific Responsibilities or Comments |
|---------------|:---------------:|----------------------------------------|
| Test Manager  | Angelika        |  Test management oversight. |
| Test Designer | Angelika, Jannik, Mert |  Implementation of the tests. |

### 10.2 Staffing and Training Needs

n/a

## 11. Iteration Milestones

We want to keep over 20% code coverage.

## 12. Risks, Dependencies, Assumptions, and Constraints

| Risk | Mitigation Strategy | Contingency (Risk is realized) |
|------|---------------------|--------------------------------|
| Test Runner does not work | Use other libraries which includ Test Runner | fix test  configuration |
| UI tests fail | Refactor test | Create and commit refactored test |
| Unit Tests Fail | Refactor Tests | Create and commit refactored test|

## 13. Management Process and Procedures

n/a

## 14. Metrics

Further than making sure the code works, we want to ensure that it meets certain quality requirements. To meassure this we're using metrics. The tool for meassuring will be integrated in our build process.

| Tool | Description | Integration |
|------|---------------------|--------------------------------|
| SonarCloud | Tool static code analysis | We integrated the tool in our Jenkins Build Process |
