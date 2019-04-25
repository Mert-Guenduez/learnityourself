<sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield>

<sdfield type="DOCINFO" subtype="TITLE"><Iteration/ Master> Test Plan</sdfield>

<font face="Arial, sans-serif"><font size="4">**Version <1.0>**</font></font>

<font color="#0000ff">_[Note: The following template is provided for use with the Rational Unified Process. Text enclosed in square brackets and displayed in blue italics (style=InfoBlue) is included to provide guidance to the author and should be deleted before publishing the document. A paragraph entered following this style will automatically be set to normal (style=Body Text).]_</font>

<font color="#0000ff">_[To customize automatic fields in Microsoft Word (which display a gray background when selected), select File>Properties and replace the Title, Subject and Company fields with the appropriate information for this document. After closing the dialog, automatic fields may be updated throughout the document by selecting Edit>Select All (or Ctrl-A) and pressing F9, or simply click on the field and press F9. This must be done separately for Headers and Footers. Alt-F9 will toggle between displaying the field names and the field contents. See Word help for more information on working with fields.]_</font>

<font face="Arial, sans-serif"><font size="5">**Revision History**</font></font>

<table width="635" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="139"> <col width="63"> <col width="236"> <col width="140"></colgroup>

<tbody>

<tr valign="TOP">

<td width="139" bgcolor="#f2f2f2">

**Date**

</td>

<td width="63" bgcolor="#f2f2f2">

**Version**

</td>

<td width="236" bgcolor="#f2f2f2">

**Description**

</td>

<td width="140" bgcolor="#f2f2f2">

**Author**

</td>

</tr>

<tr valign="TOP">

<td width="139">

<dd/mmm/yy>

</td>

<td width="63">

<x.x>

</td>

<td width="236">

<details>

</td>

<td width="140">

<name>

</td>

</tr>

<tr valign="TOP">

<td width="139"></td>

<td width="63"></td>

<td width="236"></td>

<td width="140"></td>

</tr>

<tr valign="TOP">

<td width="139"></td>

<td width="63"></td>

<td width="236"></td>

<td width="140"></td>

</tr>

<tr valign="TOP">

<td width="139"></td>

<td width="63"></td>

<td width="236"></td>

<td width="140"></td>

</tr>

</tbody>

</table>

<font face="Arial, sans-serif"><font size="5">**Table of Contents**</font></font>

<div id="Inhaltsverzeichnis1" dir="LTR">

1\. Introduction 5

1.1 Purpose 5

1.2 Scope 5

1.3 Intended Audience 5

1.4 Document Terminology and Acronyms 5

1.5 References 5

1.6 Document Structure 6

2\. Evaluation Mission and Test Motivation 6

2.1 Background 6

2.2 Evaluation Mission 6

2.3 Test Motivators 6

3\. Target Test Items 6

4\. Outline of Planned Tests 6

4.1 Outline of Test Inclusions 7

4.2 Outline of Other Candidates for Potential Inclusion 7

4.3 Outline of Test Exclusions 7

5\. Test Approach 7

5.1 Initial Test-Idea Catalogs and Other Reference Sources 7

5.2 Testing Techniques and Types 7

5.2.1 Data and Database Integrity Testing 7

5.2.2 Function Testing 8

5.2.3 Business Cycle Testing 10

5.2.4 User Interface Testing 11

5.2.5 Performance Profiling 11

5.2.6 Load Testing 13

5.2.7 Stress Testing 14

5.2.8 Volume Testing 16

5.2.9 Security and Access Control Testing 17

5.2.10 Failover and Recovery Testing 18

5.2.11 Configuration Testing 19

5.2.12 Installation Testing 20

6\. Entry and Exit Criteria 21

6.1 Test Plan 21

6.1.1 Test Plan Entry Criteria 21

6.1.2 Test Plan Exit Criteria 21

6.1.3 Suspension and Resumption Criteria 21

6.2 Test Cycles 21

6.2.1 Test Cycle Entry Criteria 21

6.2.2 Test Cycle Exit Criteria 22

6.2.3 Test Cycle Abnormal Termination 22

7\. Deliverables 22

7.1 Test Evaluation Summaries 22

7.2 Reporting on Test Coverage 22

7.3 Perceived Quality Reports 22

7.4 Incident Logs and Change Requests 22

7.5 Smoke Test Suite and Supporting Test Scripts 22

7.6 Additional Work Products 22

7.6.1 Detailed Test Results 22

7.6.2 Additional Automated Functional Test Scripts 22

7.6.3 Test Guidelines 23

7.6.4 Traceability Matrices 23

8\. Testing Workflow 23

9\. Environmental Needs 23

9.1 Base System Hardware 23

9.2 Base Software Elements in the Test Environment 24

9.3 Productivity and Support Tools 24

9.4 Test Environment Configurations 25

10\. Responsibilities, Staffing, and Training Needs 25

10.1 People and Roles 25

10.2 Staffing and Training Needs 27

11\. Iteration Milestones 27

12\. Risks, Dependencies, Assumptions, and Constraints 28

13\. Management Process and Procedures 29

13.1 Measuring and Assessing the Extent of Testing 29

13.2 Assessing the Deliverables of this Test Plan 29

13.3 Problem Reporting, Escalation, and Issue Resolution 29

13.4 Managing Test Cycles 29

13.5 Traceability Strategies 29

13.6 Approval and Signoff 30

</div>

<sdfield type="DOCINFO" subtype="TITLE"><Iteration/ Master> Test Plan</sdfield>

# 1.Introduction

## 1.1Purpose

The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for a given iteration. It describes the approach to testing the software, and is the top-level plan generated and used by managers to direct the test effort.

This _Test Plan_ for the <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield> supports the following objectives:

<font color="#0000ff">• _[Identifies the items that should be targeted by the tests._</font>

<font color="#0000ff">• _Identifies the motivation for and ideas behind the test areas to be covered._</font>

<font color="#0000ff">• _Outlines the testing approach that will be used._</font>

<font color="#0000ff">• _Identifies the required resources and provides an estimate of the test efforts._</font>

<font color="#0000ff">• _Lists the deliverable elements of the test project.]_</font>

## <a name="_Ref524432427"></a>1.2Scope

<font color="#0000ff">_[Describe the levels of testing<font face="Symbol, serif"></font>for example, Unit, Integration, or System<font face="Symbol, serif"></font>and the types of testing<font face="Symbol, serif"></font>such as Functionality, Usability, Reliability, Performance, and Supportability<font face="Symbol, serif"></font>that will be addressed by this **Test Plan**. It is also important to provide a general indication of significant areas that will be **excluded** from scope, especially where the intended audience might otherwise reasonably assume the inclusion of those areas._</font>

<font color="#0000ff">_**Note**: Avoid placing detail here that you will repeat in sections 3, Target Test Items, and 4,Outline of Planned Tests.]_</font>

## 1.3Intended Audience

<font color="#0000ff">_[Provide a brief description of the audience for whom you are writing the **Test Plan**. This helps readers of your document identify whether it is a document intended for their use, and helps prevent the document from being used inappropriately._</font>

<font color="#0000ff">_**Note**: Document style and content often alters in relation to the intended audience._</font>

<font color="#0000ff">_This section should only be about three to five paragraphs in length.]_</font>

## 1.4Document Terminology and Acronyms

<font color="#0000ff">_[This subsection provides the definitions of any terms, acronyms, and abbreviations required to properly interpret the **Test Plan**. Avoid listing items that are generally applicable to the project as a whole and that are already defined in the project’s Glossary. Include a reference to the project’s Glossary in the References section.]_</font>

## 1.5 References

<font color="#0000ff">_[This subsection provides a list of the documents referenced elsewhere within the **Test Plan**. Identify each document by title, version (or report number if applicable), date, and publishing organization or original author. Avoid listing documents that are influential but not directly referenced. Specify the sources from which the “official versions” of the references can be obtained, such as intranet UNC names or document reference codes. This information may be provided by reference to an appendix or to another document.]_</font>

## 1.6Document Structure

<font color="#0000ff">_[This subsection outlines what the rest of the **Test Plan** contains and gives an introduction to how the rest of the document is organized. This section may be eliminated if a Table of Contents is used.]_</font>

# 2.Evaluation Mission and Test Motivation

<font color="#0000ff">_[Provide an overview of the mission and motivation for the testing that will be conducted in this iteration.]_</font>

## 2.1Background

<font color="#0000ff">_[Provide a brief description of the background surrounding why the test effort defined by this **Test Plan** will be undertaken. Include information such as the key problem being solved, the major benefits of the solution, the planned architecture of the solution, and a brief history of the project. Where this information is defined in other documents, you can include references to those other more detailed documents if appropriate. This section should only be about three to five paragraphs in length.]_</font>

## 2.2Evaluation Mission

<font color="#0000ff">_[Provide a brief statement that defines the mission for the evaluation effort in the current iteration. This statement might incorporate one or more concerns including:_</font>

*   <font color="#0000ff">_find as many bugs as possible_</font>

*   <font color="#0000ff">_find important problems, assess perceived quality risks_</font>

*   <font color="#0000ff">_advise about perceived project risks_</font>

*   <font color="#0000ff">_certify to a standard_</font>

*   <font color="#0000ff">_verify a specification (requirements, design or claims)_</font>

*   <font color="#0000ff">_advise about product quality, satisfy stakeholders_</font>

*   <font color="#0000ff">_advise about testing_</font>

*   <font color="#0000ff">_fulfill process mandates_</font>

*   <font color="#0000ff">_and so forth_</font>

<font color="#0000ff">_Each mission provides a different context to the test effort and alters the way in which testing should be approached.]_</font>

## 2.3Test Motivators

<font color="#0000ff">_[Provide an outline of the key elements that will motivate the testing effort in this iteration. Testing will be motivated by many things<font face="Symbol, serif"></font>quality risks, technical risks, project risks, use cases, functional requirements, non-functional requirements, design elements, suspected failures or faults, change requests, and so forth.]_</font>

# <a name="_Ref524432434"></a>3.Target Test Items

The listing below identifies those test items<font face="Symbol, serif"></font>software, hardware, and supporting product elements <font face="Symbol, serif"></font>that have been identified as targets for testing. This list represents what items will be tested.

<font color="#0000ff">_[Provide a high level list of the major target test items. This list should include both items produced directly by the project development team, and items that those products rely on; for example, basic processor hardware, peripheral devices, operating systems, third-party products or components, and so forth. Consider grouping the list by category and assigning relative importance to each motivator.]_</font>

# <a name="_Ref524432393"></a>4.Outline of Planned Tests

<font color="#0000ff">_[This section provides a high-level outline of the testing that will be performed. The outline in this section represents a high level overview of both the tests that will be performed and those that will not.]_</font>

## 4.1Outline of Test Inclusions

<font color="#0000ff">_[Provide a high level outline of the major testing planned for the current iteration. Note what will be included in the plan and record what will explicitly **not** be included in the section titled Outline of Test Exclusions.]_</font>

## 4.2Outline of Other Candidates for Potential Inclusion

<font color="#0000ff">_[Separately outline test areas you suspect might be useful to investigate and evaluate, but that have not been sufficiently researched to know if they are important to pursue.]_</font>

## <a name="_Ref524448019"></a>4.3Outline of Test Exclusions

<font color="#0000ff">_[Provide a high level outline of the potential tests that might have been conducted but that have been_ <span style="font-style: normal">**explicitly excluded** </span>_from this plan. If a type of test will not be implemented and executed, indicate this in a sentence stating the test will not be implemented or executed and stating the justification, such as:_</font>

*   <font color="#0000ff">“_These tests do not help achieve the evaluation mission.”_</font>

*   <font color="#0000ff">“_There are insufficient resources to conduct these tests.”_</font>

*   <font color="#0000ff">“_These tests are unnecessary due to the testing conducted by xxxx.”_</font>

<font color="#0000ff">_As a heuristic, if you think it would be reasonable for one of your audience members to expect a certain aspect of testing to be included that you will not or cannot address, you should note it’s exclusion: If the team agrees the exclusion is obvious, you probably don’t need to list it.]_</font>

# 5.Test Approach

<font color="#0000ff">_[The Test Approach presents the recommended strategy for designing and implementing the required tests. Sections 3, Target Test Items, and 4, Outline of Planned Tests, identified **what** items will be tested and **what** types of tests would be performed. This section describes **how** the tests will be realized._</font>

<font color="#0000ff">_One aspect to consider for the test approach is the techniques to be used. This should include an outline of how each technique can be implemented, both from a manual and/or an automated perspective, and the criterion for knowing that the technique is useful and successful. For each technique, provide a description of the technique and define why it is an important part of the test approach by briefly outlining how it helps achieve the Evaluation Mission or addresses the Test Motivators._</font>

<font color="#0000ff">_Another aspect to discuss in this section is the Fault or Failure models that are applicable and ways to approach evaluating them._</font>

<font color="#0000ff">_As you define each aspect of the approach, you should update Section 10, Responsibilities, Staffing, and Training Needs, to document the test environment configuration and other resources that will be needed to implement each aspect.]_</font>

## 5.1Initial Test-Idea Catalogs and Other Reference Sources

<font color="#0000ff">_[Provide a listing of existing resources that will be referenced to stimulate the identification and selection of specific tests to be conducted. An example Test-Ideas Catalog is provided in the examples section of RUP.]_</font>

## 5.2Testing Techniques and Types

### 5.2.1Data and Database Integrity Testing

<font color="#0000ff">_[The databases and the database processes should be tested as an independent subsystem. This testing should test the subsystems without the target-of-test’s User Interface as the interface to the data. Additional research into the DataBase Management System (DBMS) needs to be performed to identify the tools and techniques that may exist to support the testing identified in the following table.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise database access methods and processes independent of the UI so you can observe and log incorrect functioning target behavior or data corruption.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff"> _[Invoke each database access method and process, seeding each with valid and invalid data or requests for data._</font>

<font color="#0000ff"> _Inspect the database to ensure the data has been populated as intended and all database events have occurred properly, or review the returned data to ensure that the correct data was retrieved for the correct reasons.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_base configuration imager and restorer_</font>

*   <font color="#0000ff">_backup and recovery tools_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so forth)_</font>

*   <font color="#0000ff">_database SQL utilities and tools_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of all key database access methods and processes.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

*   <font color="#0000ff">_[Testing may require a DBMS development environment or drivers to enter or modify data directly in the databases._</font>

*   <font color="#0000ff">_Processes should be invoked manually._</font>

*   <font color="#0000ff">_Small or minimally sized databases (limited number of records) should be used to increase the visibility of any non-acceptable events.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.2Function Testing

<font color="#0000ff">_[Function testing of the target-of-test should focus on any requirements for test that can be traced directly to use cases or business functions and business rules. The goals of these tests are to verify proper data acceptance, processing, and retrieval, and the appropriate implementation of the business rules. This type of testing is based upon black box techniques; that is verifying the application and its internal processes by interacting with the application via the Graphical User Interface (GUI) and analyzing the output or results. The following table identifies an outline of the testing recommended for each application.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise target-of-test functionality, including navigation, data entry, processing, and retrieval to observe and log target behavior.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff">_[Execute each use-case scenario’s individual use-case flows or functions and features, using valid and invalid data, to verify that:_</font>

<font color="#0000ff"> _the expected results occur when valid data is used_</font>

<font color="#0000ff"> _the appropriate error or warning messages are displayed when invalid data is used_</font>

<font color="#0000ff"> _each business rule is properly applied]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_base configuration imager and restorer_</font>

*   <font color="#0000ff">_backup and recovery tools_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so forth)_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of:_</font>

<font color="#0000ff"> _all key use-case scenarios_</font>

<font color="#0000ff"> _all key features]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[Identify or describe those items or issues (internal or external) that impact the implementation and execution of function test.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.3Business Cycle Testing

<font color="#0000ff">_[Business Cycle Testing should emulate the activities performed on the <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield> over time. A period should be identified, such as one year, and transactions and activities that would occur during a year’s period should be executed. This includes all daily, weekly, and monthly cycles, and events that are date-sensitive, such as ticklers.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise target-of-test and background processes according to required business models and schedules to observe and log target behavior.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff">_[Testing will simulate several business cycles by performing the following:_</font>

*   <font color="#0000ff">_The tests used for target-of-test’s function testing will be modified or enhanced to increase the number of times each function is executed to simulate several different users over a specified period._</font>

*   <font color="#0000ff">_All time or date-sensitive functions will be executed using valid and invalid dates or time periods._</font>

*   <font color="#0000ff">_All functions that occur on a periodic schedule will be executed or launched at the appropriate time._</font>

*   <font color="#0000ff">_Testing will include using valid and invalid data to verify the following:_</font>

    *   <font color="#0000ff">_The expected results occur when valid data is used._</font>

    *   <font color="#0000ff">_The appropriate error or warning messages are displayed when invalid data is used._</font>

    *   <font color="#0000ff">_Each business rule is properly applied.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_base configuration imager and restorer_</font>

*   <font color="#0000ff">_backup and recovery tools_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of all critical business cycles.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff"> _[System dates and events may require special support activities._</font>

<font color="#0000ff"> _A business model is required to identify appropriate test requirements and procedures.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.4User Interface Testing

<font color="#0000ff">_[User Interface (UI) testing verifies a user’s interaction with the software. The goal of UI testing is to ensure that the UI provides the user with the appropriate access and navigation through the functions of the target-of-test. In addition, UI testing ensures that the objects within the UI function as expected and conform to corporate or industry standards.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the following to observe and log standards conformance and target behavior:_</font>

*   <font color="#0000ff">_Navigation through the target-of-test reflecting business functions and requirements, including window-to-window, field-to- field, and use of access methods (tab keys, mouse movements, accelerator keys)._</font>

*   <font color="#0000ff">_Window objects and characteristics can be exercised–such as menus, size, position, state, and focus.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff">_[Create or modify tests for each window to verify proper navigation and object states for each application window and object.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the Test Script Automation Tool.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of each major screen or window that will be used extensively by the end user.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[Not all properties for custom and third-party objects can be accessed.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.5Performance Profiling

<font color="#0000ff">_[Performance profiling is a performance test in which response times, transaction rates, and other time-sensitive requirements are measured and evaluated. The goal of Performance Profiling is to verify performance requirements have been achieved. Performance profiling is implemented and executed to profile and tune a target-of-test's performance behaviors as a function of conditions such as workload or hardware configurations._</font>

<font color="#0000ff">_**Note**: Transactions in the following table refer to “logical business transactions”. These transactions are defined as specific use cases that an actor of the system is expected to perform using the target-of-test, such as add or modify a given contract.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise behaviors for designated functional transactions or business functions under the following conditions to observe and log target behavior and application performance data:_</font>

<font color="#0000ff"> _normal anticipated workload_</font>

<font color="#0000ff"> _anticipated worst-case workload]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff"> _[Use Test Procedures developed for Function or Business Cycle Testing._</font>

<font color="#0000ff"> _Modify data files to increase the number of transactions or the scripts to increase the number of iterations that occur in each transaction._</font>

<font color="#0000ff"> _Scripts should be run on one machine (best case to benchmark single user, single transaction) and should be repeated with multiple clients (virtual or actual, see Special Considerations below).]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_an application performance profiling tool, such as Rational Quantify_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so on_</font>

*   <font color="#0000ff">_resource-constraining tools; for example, Canned Heat]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_The technique supports testing:_</font>

<font color="#0000ff"> _Single Transaction or single user: Successful emulation of the transaction scripts without any failures due to test implementation problems.]_</font>

<font color="#0000ff"> _Multiple transactions or multiple users: Successful emulation of the workload without any failures due to test implementation problems.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[Comprehensive performance testing includes having a background workload on the server._</font>

<font color="#0000ff">_There are several methods that can be used to perform this, including:_</font>

<font color="#0000ff"> _“Drive transactions” directly to the server, usually in the form of Structured Query Language (SQL) calls._</font>

<font color="#0000ff"> _Create “virtual” user load to simulate many clients, usually several hundred. Remote Terminal Emulation tools are used to accomplish this load. This technique can also be used to load the network with “traffic”._</font>

<font color="#0000ff"> _Use multiple physical clients, each running test scripts, to place a load on the system._</font>

<font color="#0000ff">_Performance testing should be performed on a dedicated machine or at a dedicated time. This permits full control and accurate measurement._</font>

<font color="#0000ff">_The databases used for Performance Testing should be either actual size or scaled equally.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.6Load Testing

<font color="#0000ff">_[Load testing is a performance test that subjects the target-of-test to varying workloads to measure and evaluate the performance behaviors and abilities of the target-of-test to continue to function properly under these different workloads. The goal of load testing is to determine and ensure that the system functions properly beyond the expected maximum workload. Additionally, load testing evaluates the performance characteristics, such as response times, transaction rates, and other time-sensitive issues).]_</font>

<font color="#0000ff">_[**Note**: Transactions in the following table refer to “logical business transactions”. These transactions are defined as specific functions that an end user of the system is expected to perform using the application, such as add or modify a given contract.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise designated transactions or business cases under varying workload conditions to observe and log target behavior and system performance data.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff"> _[Use Transaction Test Scripts developed for Function or Business Cycle Testing as a basis, but remember to remove unnecessary interactions and delays._</font>

<font color="#0000ff"> _Modify data files to increase the number of transactions or the tests to increase the number of times each transaction occurs._</font>

<font color="#0000ff"> _Workloads should include (for example, Daily, Weekly, Monthly and so forth) Peak loads._</font>

<font color="#0000ff"> _Workloads should represent both Average as well as Peak loads._</font>

<font color="#0000ff"> _Workloads should represent both Instantaneous and Sustained Peaks._</font>

<font color="#0000ff"> _The Workloads should be executed under different Test Environment Configurations.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_Transaction Load Scheduling and control tool_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so on)_</font>

*   <font color="#0000ff">_resource-constraining tools (for example, Canned Heat)_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of Workload Emulation, which is the successful emulation of the workload without any failures due to test implementation problems.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff"> _[Load testing should be performed on a dedicated machine or at a dedicated time. This permits full control and accurate measurement._</font>

<font color="#0000ff"> _The databases used for load testing should be either actual size or scaled equally.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.7Stress Testing

<font color="#0000ff">_[Stress testing is a type of performance test implemented and executed to understand how a system fails due to conditions at the boundary, or outside of, the expected tolerances. This typically involves low resources or competition for resources. Low resource conditions reveal how the target-of-test fails that is not apparent under normal conditions. Other defects might result from competition for shared resources, like database locks or network bandwidth, although some of these tests are usually addressed under functional and load testing.]_</font>

<font color="#0000ff">_[**Note**: References to transactions in the following table refer to logical business transactions.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the target-of-test functions under the following stress conditions to observe and log target behavior that identifies and documents the conditions under which the system **fails** to continue functioning properly_</font>

<font color="#0000ff"> _little or no memory available on the server (RAM and persistent storage space)_</font>

<font color="#0000ff"> _maximum actual or physically capable number of clients connected or simulated_</font>

<font color="#0000ff"> _multiple users performing the same transactions against the same data or accounts_</font>

<font color="#0000ff"> _“overload” transaction volume or mix (see Performance Profiling above)]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff"> _[Use tests developed for Performance Profiling or Load Testing._</font>

<font color="#0000ff"> _To test limited resources, tests should be run on a single machine, and RAM and persistent storage space on the server should be reduced or limited._</font>

<font color="#0000ff"> _For remaining stress tests, multiple clients should be used, either running the same tests or complementary tests to produce the worst-case transaction volume or mix._</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_Transaction Load Scheduling and control tool_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so on)_</font>

*   <font color="#0000ff">_resource-constraining tools (for example, Canned Heat)_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_The technique supports the testing of Stress Emulation. The system can be emulated successfully in one or more conditions defined as stress conditions and an observation of the resulting system state during and after the condition has been emulated can be captured.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff"> _[Stressing the network may require network tools to load the network with messages or packets._</font>

<font color="#0000ff"> _The persistent storage used for the system should temporarily be reduced to restrict the available space for the database to grow._</font>

<font color="#0000ff"> _Synchronize the simultaneous clients accessing of the same records or data accounts.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.8Volume Testing

<font color="#0000ff">_[Volume testing subjects the target-of-test to large amounts of data to determine if limits are reached that cause the software to fail. Volume testing also identifies the continuous maximum load or volume the target-of-test can handle for a given period. For example, if the target-of-test is processing a set of database records to generate a report, a Volume Test would use a large test database, and would check that the software behaved normally and produced the correct report.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the target-of-test under the following high volume scenarios to observe and log target behavior:_</font>

<font color="#0000ff"> _Maximum (actual or physically-capable) number of clients connected, or simulated, all performing the same, worst case (performance) business function for an extended period._</font>

<font color="#0000ff"> _Maximum database size has been reached (actual or scaled) and multiple queries or report transactions are executed simultaneously.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff"> _[Use tests developed for Performance Profiling or Load Testing._</font>

<font color="#0000ff"> _Multiple clients should be used, either running the same tests or complementary tests to produce the worst-case transaction volume or mix (see Stress Testing) for an extended period._</font>

<font color="#0000ff"> _Maximum database size is created (actual, scaled, or filled with representative data) and multiple clients are used to run queries and report transactions simultaneously for extended periods.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">_Transaction Load Scheduling and control tool_</font>

*   <font color="#0000ff">_installation-monitoring tools (registry, hard disk, CPU, memory, and so on)_</font>

*   <font color="#0000ff">_resource-constraining tools (for example, Canned Heat)_</font>

*   <font color="#0000ff">_Data-generation tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of Volume Emulation. Large quantities of users, data, transactions, or other aspects of the system use under volume can be successfully emulated and an observation of the system state changes over the duration of the volume test can be captured.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[What period of time would be considered an acceptable time for high volume conditions, as noted above?]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.9Security and Access Control Testing

<font color="#0000ff">_[Security and Access Control Testing focuses on two key areas of security:_</font>

<font color="#0000ff"> _Application-level security, including access to the Data or Business Functions_</font>

<font color="#0000ff"> _System-level Security, including logging into or remotely accessing to the system._</font>

<font color="#0000ff">_Based on the security you want, application-level security ensures that actors are restricted to specific functions or use cases, or they are limited in the data that is available to them. For example, everyone may be permitted to enter data and create new accounts, but only managers can delete them. If there is security at the data level, testing ensures that “user type one” can see all customer information, including financial data, however, “user two” only sees the demographic data for the same client._</font>

<font color="#0000ff">_System-level security ensures that only those users granted access to the system are capable of accessing the applications and only through the appropriate gateways.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the target-of-test under the following conditions to observe and log target behavior:_</font>

*   <font color="#0000ff">_Application-level Security: an actor can access only those functions or data for which their user type is provided permissions._</font>

*   <font color="#0000ff">_System-level Security: only those actors with access to the system and applications are permitted to access them._</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

*   <font color="#0000ff">_[Application-level Security: Identify and list each user type and the functions or data each type has permissions for.]_</font>

    *   <font color="#0000ff">_Create tests for each user type and verify each permission by creating transactions specific to each user type._</font>

    *   <font color="#0000ff">_Modify user type and re-run tests for same users. In each case, verify those additional functions or data are correctly available or denied._</font>

*   <font color="#0000ff">_System-level Access: [See Special Considerations below]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_Test Script Automation Tool_</font>

*   <font color="#0000ff">“_Hacker” security breach and probing tools_</font>

*   <font color="#0000ff">_OS Security Admin Tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of for each known actor type the appropriate functions or data affected by security settings can be tested.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[Access to the system must be reviewed or discussed with the appropriate network or systems administrator. This testing may not be required as it may be a function of network or systems administration.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.10Failover and Recovery Testing

<font color="#0000ff">_[Failover and recovery testing ensures that the target-of-test can successfully failover and recover from a variety of hardware, software or network malfunctions with undue loss of data or data integrity._</font>

<font color="#0000ff">_For those systems that must be kept running failover testing ensures that, when a failover condition occurs, the alternate or backup systems properly “take over” for the failed system without any loss of data or transactions._</font>

<font color="#0000ff">_Recovery testing is an antagonistic test process in which the application or system is exposed to extreme conditions, or simulated conditions, to cause a failure, such as device Input/Output (I/O) failures, or invalid database pointers and keys. Recovery processes are invoked, and the application or system is monitored and inspected to verify proper application, or system, and data recovery has been achieved.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Simulate the failure conditions and exercise the recovery processes (manual and automated) to restore the database, applications, and system to a desired, known, state. The following types of conditions are included in the testing to observe and log target behavior after recovery:_</font>

<font color="#0000ff"> _power interruption to the client_</font>

<font color="#0000ff"> _power interruption to the server_</font>

<font color="#0000ff"> _communication interruption via network servers_</font>

<font color="#0000ff"> _interruption, communication, or power loss to DASD (Dynamic Access Storage Devices) and DASD controllers_</font>

<font color="#0000ff"> _incomplete cycles (data filter processes interrupted, data synchronization processes interrupted)_</font>

<font color="#0000ff"> _invalid database pointers or keys_</font>

<font color="#0000ff"> _invalid or corrupted data elements in database]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

<font color="#0000ff">_[The tests already created for Function and Business Cycle testing can be used as a basis for creating a series of transactions to support failover and recovery testing, primarily to define the tests to be run to test that recovery was successful._</font>

<font color="#0000ff"> _Power interruption to the client: power the PC down._</font>

<font color="#0000ff"> _Power interruption to the server: simulate or initiate power down procedures for the server._</font>

<font color="#0000ff"> _Interruption via network servers: simulate or initiate communication loss with the network (physically disconnect communication wires or power down network servers or routers)._</font>

<font color="#0000ff"> _Interruption, communication, or power loss to DASD and DASD controllers: simulate or physically eliminate communication with one or more DASDs or controllers._</font>

<font color="#0000ff">_Once the above conditions or simulated conditions are achieved, additional transactions should be executed and, upon reaching this second test point state, recovery procedures should be invoked._</font>

<font color="#0000ff">_Testing for incomplete cycles uses the same technique as described above except that the database processes themselves should be aborted or prematurely terminated._</font>

<font color="#0000ff">_Testing for the following conditions requires that a known database state be achieved._</font>

<font color="#0000ff">_Several database fields, pointers, and keys should be corrupted manually and directly within the database (via database tools). Additional transactions should be executed using the tests from Application Function and Business Cycle Testing and full cycles executed.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_base configuration imager and restorer_</font>

*   <font color="#0000ff">_installation monitoring tools (registry, hard disk, CPU, memory, and so on)_</font>

*   <font color="#0000ff">_backup and recovery tools]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_The technique supports the testing of:_</font>

*   <font color="#0000ff">_One or more simulated disasters involving one or more combinations of the application, database, and system._</font>

*   <font color="#0000ff">_One or more simulated recoveries involving one or more combinations of the application, database, and system to a known desired state.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

*   <font color="#0000ff">_[Recovery testing is highly intrusive. Procedures to disconnect cabling (simulating power or communication loss) may not be desirable or feasible. Alternative methods, such as diagnostic software tools may be required._</font>

*   <font color="#0000ff">_Resources from the Systems (or Computer Operations), Database, and Networking groups are required._</font>

*   <font color="#0000ff">_These tests should be run after hours or on an isolated machine.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.11Configuration Testing

<font color="#0000ff">_[Configuration testing verifies the operation of the target-of-test on different software and hardware configurations. In most production environments, the particular hardware specifications for the client workstations, network connections, and database servers vary. Client workstations may have different software loaded<font face="Symbol, serif"></font>for example, applications, drivers, and so on<font face="Symbol, serif"></font>and, at any one time, many different combinations may be active using different resources.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the target-of-test on the required hardware and software configurations to observe and log target behavior under different configurations and identify changes in configuration state.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

*   <font color="#0000ff">_[Use Function Test scripts._</font>

*   <font color="#0000ff">_Open and close various non-target-of-test related software, such as Microsoft Excel and Word applications, either as part of the test or prior to the start of the test._</font>

*   <font color="#0000ff">_Execute selected transactions to simulate actors interacting with the target-of-test and the non-target-of-test software._</font>

*   <font color="#0000ff">_Repeat the above process, minimizing the available conventional memory on the client workstation.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_base configuration imager and restore_</font>

*   <font color="#0000ff">_installation monitoring tools (registry, hard disk, CPU, memory, and so on)]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of one or more combinations of the target test items running in expected, supported deployment environments.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

*   <font color="#0000ff">_[What non-target-of-test software is needed, is available, and what is accessible on the desktop?_</font>

*   <font color="#0000ff">_What applications are typically used?_</font>

*   <font color="#0000ff">_What data are the applications running; for example, a large spreadsheet opened in Excel or a 100-page document in Word?_</font>

*   <font color="#0000ff">_The entire system’s netware, network servers, databases, and so on, also needs to be documented as part of this test.]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

### 5.2.12Installation Testing

<font color="#0000ff">_[Installation testing has two purposes. The first is to ensure that the software can be installed under different conditions<font face="Symbol, serif"></font>such as a new installation, an upgrade, and a complete or custom installation<font face="Symbol, serif"></font>under normal and abnormal conditions. Abnormal conditions include insufficient disk space, lack of privilege to create directories, and so on. The second purpose is to verify that, once installed, the software operates correctly. This usually means running a number of the tests that were developed for Function Testing.]_</font>

<dl>

<dd>

<table width="591" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="129"> <col width="432"></colgroup>

<tbody>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique Objective:

</td>

<td width="432">

<font color="#0000ff">_[Exercise the installation of the target-of-test onto each required hardware configuration under the following conditions to observe and log installation behavior and configuration state changes:_</font>

*   <font color="#0000ff">_new installation: a new machine, never installed previously with <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield>_</font>

*   <font color="#0000ff">_update: a machine previously installed <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield>, same version_</font>

*   <font color="#0000ff">_update: a machine previously installed <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield>, older version]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Technique:

</td>

<td width="432">

*   <font color="#0000ff">_[Develop automated or manual scripts to validate the condition of the target machine._</font>

    *   <font color="#0000ff">_new: never installed_</font>

    *   <font color="#0000ff">_same or older version already installed_</font>

*   <font color="#0000ff">_Launch or perform installation._</font>

*   <font color="#0000ff">_Using a predetermined subset of Function Test scripts, run the transactions.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Oracles:

</td>

<td width="432">

<font color="#0000ff">_[Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Required Tools:

</td>

<td width="432">

<font color="#0000ff">_[The technique requires the following tools:_</font>

*   <font color="#0000ff">_base configuration imager and restorer_</font>

*   <font color="#0000ff">_installation monitoring tools (registry, hard disk, CPU, memory, and so on)]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Success Criteria:

</td>

<td width="432">

<font color="#0000ff">_[The technique supports the testing of the installation of the developed product in one or more installation configurations.]_</font>

</td>

</tr>

<tr valign="TOP">

<td width="129" bgcolor="#f2f2f2">

Special Considerations:

</td>

<td width="432">

<font color="#0000ff">_[What <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield> transactions should be selected to comprise a confidence test that <sdfield type="DOCINFO" subtype="THEME"><Project Name></sdfield> application has been successfully installed and no major software components are missing?]_</font>

</td>

</tr>

</tbody>

</table>

</dd>

</dl>

# 6.Entry and Exit Criteria

## 6.1Test Plan

### 6.1.1Test Plan Entry Criteria

<font color="#0000ff">_[Specify the criteria that will be used to determine whether the execution of the **Test Plan** can begin.]_</font>

### 6.1.2Test Plan Exit Criteria

<font color="#0000ff">_[Specify the criteria that will be used to determine whether the execution of the **Test Plan** is complete or that continued execution provides no further benefit.]_</font>

### 6.1.3 Suspension and Resumption Criteria

<font color="#0000ff">_[Specify the criteria that will be used to determine whether testing should be prematurely suspended or ended before the plan has been completely executed, and under what criteria testing can be resumed.]_</font>

## 6.2Test Cycles

### 6.2.1Test Cycle Entry Criteria

<font color="#0000ff">_[Specify the criteria to be used to determine whether the test effort for the next Test Cycle of this **Test Plan** can begin.]_</font>

### 6.2.2Test Cycle Exit Criteria

<font color="#0000ff">_[Specify the criteria that will be used to determine whether the test effort for the current Test Cycle of this **Test Plan** is deemed sufficient.]_</font>

### 6.2.3Test Cycle Abnormal Termination

<font color="#0000ff">_[Specify the criteria that will be used to determine whether testing should be prematurely suspended or ended for the current test cycle, or whether the intended build candidate to be tested must be altered.]_</font>

# 7.Deliverables

<font color="#0000ff">_[In this section, list the various artifacts that will be created by the test effort that are useful deliverables to the various stakeholders of the test effort. Don’t list all work products; only list those that give direct, tangible benefit to a stakeholder and those by which you want the success of the test effort to be measured.]_</font>

## 7.1Test Evaluation Summaries

<font color="#0000ff">_[Provide a brief outline of both the form and content of the test evaluation summaries, and indicate how frequently they will be produced.]_</font>

## 7.2Reporting on Test Coverage

<font color="#0000ff">_[Provide a brief outline of both the form and content of the reports used to measure the extent of testing, and indicate how frequently they will be produced. Give an indication as to the method and tools used to record, measure, and report on the extent of testing.]_</font>

## 7.3Perceived Quality Reports

<font color="#0000ff">_[Provide a brief outline of both the form and content of the reports used to measure the perceived quality of the product, and indicate how frequently they will be produced. Give an indication about to the method and tools used to record, measure, and report on the perceived product quality. You might include some analysis of Incidents and Change Request over Test Coverage.]_</font>

## 7.4Incident Logs and Change Requests

<font color="#0000ff">_[Provide a brief outline of both the method and tools used to record, track, and manage test incidents, associated change requests, and their status.]_</font>

## 7.5Smoke Test Suite and Supporting Test Scripts

<font color="#0000ff">_[Provide a brief outline of the test assets that will be delivered to allow ongoing regression testing of subsequent product builds to help detect regressions in the product quality.]_</font>

## 7.6Additional Work Products

<font color="#0000ff">_[In this section, identify the work products that are optional deliverables or those that should not be used to measure or assess the successful execution of the **Test Plan**.]_</font>

### 7.6.1Detailed Test Results

<font color="#0000ff">_[This denotes either a collection of Microsoft Excel spreadsheets listing the results determined for each test case, or the repository of both test logs and determined results maintained by a specialized test product.]_</font>

### 7.6.2Additional Automated Functional Test Scripts

<font color="#0000ff">_[These will be either a collection of the source code files for automated test scripts, or the repository of both source code and compiled executables for test scripts maintained by the test automation product.]_</font>

### 7.6.3Test Guidelines

<font color="#0000ff">_[Test Guidelines cover a broad set of categories, including Test-Idea catalogs, Good Practice Guidance, Test patterns, Fault and Failure Models, Automation Design Standards, and so forth.]_</font>

### 7.6.4Traceability Matrices

<font color="#0000ff">_[Using a tool such as Rational RequisistePro or MS Excel, provide one or more matrices of traceability relationships between traced items.]_</font>

# 8.Testing Workflow

<font color="#0000ff">_[Provide an outline of the workflow to be followed by the Test team in the development and execution of this **Test Plan**.]_</font>

<font color="#0000ff">_The specific testing workflow that you will use should be documented separately in the project's Development Case. It should explain how the project has customized the base RUP test workflow (typically on a phase-by-phase basis). In most cases, we recommend you place a reference in this section of the **Test Plan** to the relevant section of the Development Case. It might be both useful and sufficient to simply include a diagram or image depicting your test workflow._</font>

<font color="#0000ff">_More specific details of the individual testing tasks are defined in a number of different ways, depending on project culture; for example:_</font>

*   <font color="#0000ff">_defined as a list of tasks in this section of the **Test Plan**, or in an accompanying appendix_</font>

*   <font color="#0000ff">_defined in a central project schedule (often in a scheduling tool such as Microsoft Project)_</font>

*   <font color="#0000ff">_documented in individual, "dynamic" to-do lists for each team member, which are usually too detailed to be placed in the **Test Plan**_</font>

*   <font color="#0000ff">_documented on a centrally located whiteboard and updated dynamically_</font>

*   <font color="#0000ff">_not formally documented at all_</font>

<font color="#0000ff">_Based on your project culture, you should either list your specific testing tasks here or provide some descriptive text explaining the process your team uses to handle detailed task planning and provide a reference to where the details are stored, if appropriate._</font>

<font color="#0000ff">_For Master Test Plans, we recommend avoiding detailed task planning, which is often an unproductive effort if done as a front-loaded activity at the beginning of the project. A Master Test Plan might usefully describe the phases and the number of iterations, and give an indication of what types of testing are generally planned for each Phase or Iteration._</font>

<font color="#0000ff">_**Note**: Where process and detailed planning information is recorded centrally and separately from this Test Plan, you will have to manage the issues that will arise from having duplicate copies of the same information. To avoid team members referencing out-of-date information, we suggest that in this situation you place the minimum amount of process and planning information within the Test Plan to make ongoing maintenance easier and simply reference the "Master" source material.]_</font>

# 9.Environmental Needs

<font color="#0000ff">_[This section presents the non-human resources required for the **Test Plan**.]_</font>

## 9.1Base System Hardware

The following table sets forth the system resources for the test effort presented in this _Test Plan_.

<font color="#0000ff">_[The specific elements of the test system may not be fully understood in early iterations, so expect this section to be completed over time. We recommend that the system simulates the production environment, scaling down the concurrent access and database size, and so forth, if and where appropriate.]_</font>

<font color="#0000ff">_[**Note**: Add or delete items as appropriate.]_</font>

<table width="619" bordercolor="#000000" border="1" rules="COLS" cellspacing="0" cellpadding="7"><colgroup><col width="219"> <col width="106"> <col width="250"></colgroup>

<thead>

<tr>

<td width="603" valign="TOP" bgcolor="#f2f2f2" colspan="3">

<font face="Arial, sans-serif">**System Resources**</font>

</td>

</tr>

</thead>

<thead>

<tr valign="TOP">

<td width="219" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Resource**</font>

</td>

<td width="106" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Quantity**</font>

</td>

<td width="250" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Name and Type**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="219">

Database Server

</td>

<td width="106"></td>

<td width="250"></td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Network or Subnet

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Server Name

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Database Name

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

</tbody>

<tbody>

<tr valign="TOP">

<td width="219">

Client Test PCs

</td>

<td width="106"></td>

<td width="250"></td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Include special configuration requirements

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

</tbody>

<tbody>

<tr valign="TOP">

<td width="219">

Test Repository

</td>

<td width="106"></td>

<td width="250"></td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Network or Subnet

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

<tr valign="TOP">

<td width="219">

<font color="#ffffff">—</font>Server Name

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

</tbody>

<tbody>

<tr valign="TOP">

<td width="219">

Test Development PCs

</td>

<td width="106"></td>

<td width="250">

TBD

</td>

</tr>

</tbody>

</table>

## 9.2Base Software Elements in the Test Environment

The following base software elements are required in the test environment for this _Test Plan_.

<font color="#0000ff">_[Note: Add or delete items as appropriate.]_</font>

<table width="632" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="256"> <col width="124"> <col width="208"></colgroup>

<thead>

<tr valign="TOP">

<td width="256" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Software Element Name**</font>

</td>

<td width="124" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Version**</font>

</td>

<td width="208" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Type and Other Notes**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="256">

NT Workstation

</td>

<td width="124"></td>

<td width="208">

Operating System

</td>

</tr>

<tr valign="TOP">

<td width="256">

Windows 2000

</td>

<td width="124"></td>

<td width="208">

Operating System

</td>

</tr>

<tr valign="TOP">

<td width="256">

Internet Explorer

</td>

<td width="124"></td>

<td width="208">

Internet Browser

</td>

</tr>

<tr valign="TOP">

<td width="256">

Netscape Navigator

</td>

<td width="124"></td>

<td width="208">

Internet Browser

</td>

</tr>

<tr valign="TOP">

<td width="256">

MS Outlook

</td>

<td width="124"></td>

<td width="208">

eMail Client software

</td>

</tr>

<tr valign="TOP">

<td width="256">

Network Associates McAfee Virus Checker

</td>

<td width="124"></td>

<td width="208">

Virus Detection and Recovery Software

</td>

</tr>

</tbody>

</table>

## 9.3Productivity and Support Tools

The following tools will be employed to support the test process for this _Test Plan_.

<font color="#0000ff">_[Note: Add or delete items as appropriate.]_</font>

<table width="632" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="189"> <col width="143"> <col width="172"> <col width="70"></colgroup>

<thead>

<tr valign="TOP">

<td width="189" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Tool Category or Type**</font>

</td>

<td width="143" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Tool Brand Name**</font>

</td>

<td width="172" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Vendor or In-house**</font>

</td>

<td width="70" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Version**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="189">

Test Management

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

Defect Tracking

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

ASQ Tool for functional testing

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

ASQ Tool for performance testing

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

Test Coverage Monitor or Profiler

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

Project Management

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

<tr valign="TOP">

<td width="189">

DBMS tools

</td>

<td width="143"></td>

<td width="172"></td>

<td width="70"></td>

</tr>

</tbody>

</table>

## 9.4Test Environment Configurations

The following Test Environment Configurations needs to be provided and supported for this project.

<table width="632" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="189"> <col width="215"> <col width="184"></colgroup>

<thead>

<tr valign="TOP">

<td width="189" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Configuration Name**</font>

</td>

<td width="215" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Description**</font>

</td>

<td width="184" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Implemented in Physical Configuration**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="189">

Average user configuration

</td>

<td width="215"></td>

<td width="184"></td>

</tr>

<tr valign="TOP">

<td width="189">

Minimal configuration supported

</td>

<td width="215"></td>

<td width="184"></td>

</tr>

<tr valign="TOP">

<td width="189">

Visually and mobility challenged

</td>

<td width="215"></td>

<td width="184"></td>

</tr>

<tr valign="TOP">

<td width="189">

International Double Byte OS

</td>

<td width="215"></td>

<td width="184"></td>

</tr>

<tr valign="TOP">

<td width="189">

Network installation (not client)

</td>

<td width="215"></td>

<td width="184"></td>

</tr>

</tbody>

</table>

# <a name="_Ref524433573"></a><a name="_Ref524434117"></a>10.Responsibilities, Staffing, and Training Needs

<font color="#0000ff">_[This section presents the required resources to address the test effort outlined in the **Test Plan**—the main responsibilities, and the knowledge or skill sets required of those resources.]_</font>

## 10.1People and Roles

This table shows the staffing assumptions for the test effort.

<font color="#0000ff">_[**Note**: Add or delete items as appropriate.]_</font>

<table width="620" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="148"> <col width="166"> <col width="262"></colgroup>

<thead>

<tr>

<td width="604" valign="TOP" bgcolor="#f2f2f2" colspan="3">

<font face="Arial, sans-serif">**Human Resources**</font>

</td>

</tr>

<tr valign="TOP">

<td width="148" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Role**</font>

</td>

<td width="166" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Minimum Resources Recommended**</font>

<font size="1" style="font-size: 8pt">**(number of full-time roles allocated)**</font>

</td>

<td width="262" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Specific Responsibilities or Comments**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="148">

Test Manager

</td>

<td width="166"></td>

<td width="262">

Provides management oversight.

Responsibilities include:

*   planning and logistics

*   agree mission

*   identify motivators

*   acquire appropriate resources

*   present management reporting

*   advocate the interests of test

*   evaluate effectiveness of test effort

</td>

</tr>

<tr valign="TOP">

<td width="148">

Test Analyst

</td>

<td width="166"></td>

<td width="262">

Identifies and defines the specific tests to be conducted.

Responsibilities include:

*   identify test ideas

*   define test details

*   determine test results

*   document change requests

*   evaluate product quality

</td>

</tr>

<tr valign="TOP">

<td width="148">

Test Designer

</td>

<td width="166"></td>

<td width="262">

Defines the technical approach to the implementation of the test effort.

Responsibilities include:

*   define test approach

*   define test automation architecture

*   verify test techniques

*   define testability elements

*   structure test implementation

</td>

</tr>

<tr valign="TOP">

<td width="148">

Tester

</td>

<td width="166"></td>

<td width="262">

Implements and executes the tests.

Responsibilities include:

*   implement tests and test suites

*   execute test suites

*   log results

*   analyze and recover from test failures

*   document incidents

</td>

</tr>

<tr valign="TOP">

<td width="148">

Test System Administrator

</td>

<td width="166"></td>

<td width="262">

Ensures test environment and assets are managed and maintained.

Responsibilities include:

*   administer test management system

*   install and support access to, and recovery of, test environment configurations and test labs

</td>

</tr>

<tr valign="TOP">

<td width="148">

Database Administrator, Database Manager

</td>

<td width="166"></td>

<td width="262">

Ensures test data (database) environment and assets are managed and maintained.

Responsibilities include:

*   support the administration of test data and test beds (database).

</td>

</tr>

<tr valign="TOP">

<td width="148">

Designer

</td>

<td width="166"></td>

<td width="262">

Identifies and defines the operations, attributes, and associations of the test classes.

Responsibilities include:

*   defines the test classes required to support testability requirements as defined by the test team

</td>

</tr>

<tr valign="TOP">

<td width="148">

Implementer

</td>

<td width="166"></td>

<td width="262">

Implements and unit tests the test classes and test packages.

Responsibilities include:

*   creates the test components required to support testability requirements as defined by the designer

</td>

</tr>

</tbody>

</table>

## 10.2Staffing and Training Needs

This section outlines how to approach staffing and training the test roles for the project.

<font color="#0000ff">_[The way to approach staffing and training will vary from project to project. If this section is part of a Master Test Plan, you should indicate at what points in the project lifecycle different skills and numbers of staff are needed. If this is an Iteration Test Plan, you should focus mainly on where and what training might occur during the Iteration._</font>

<font color="#0000ff">_Give thought to your training needs, and plan to schedule this based on a Just-In-Time (JIT) approach—there is often a temptation to attend training too far in advance of its usage when the test team has apparent slack. Doing this introduces the risk of the training being forgotten by the time it's needed._</font>

<font color="#0000ff">_Look for opportunities to combine the purchase of productivity tools with training on those tools, and arrange with the vendor to delay delivery of the training until just before you need it. If you have enough headcount, consider having training delivered in a customized manner for you, possibly at your own site._</font>

<font color="#0000ff">_The test team often requires the support and skills of other team members not directly part of the test team. Make sure you arrange in your plan for appropriate availability of System Administrators, Database Administrators, and Developers who are required to enable the test effort.]_</font>

# 11.Iteration Milestones

<font color="#0000ff">_[Identify the key schedule milestones that set the context for the Testing effort. Avoid repeating too much detail that is documented elsewhere in plans that address the entire project.]_</font>

<table width="614" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="178"> <col width="91"> <col width="91"> <col width="91"> <col width="91"></colgroup>

<thead>

<tr valign="TOP">

<td width="178" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Milestone**</font>

</td>

<td width="91" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Planned Start Date**</font>

</td>

<td width="91" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Actual Start Date**</font>

</td>

<td width="91" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Planned End Date**</font>

</td>

<td width="91" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Actual End Date**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="178">

Iteration Plan agreed

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Iteration starts

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Requirements baselined

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Architecture baselined

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

User Interface baselined

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

First Build delivered to test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

First Build accepted into test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

First Build test cycle finishes

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

[Build Two will not be tested]

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Third Build delivered to test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Third Build accepted into test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Third Build test cycle finishes

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Fourth Build delivered to test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Fourth Build accepted into test

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Iteration Assessment review

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

<tr valign="TOP">

<td width="178">

Iteration ends

</td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

<td width="91"></td>

</tr>

</tbody>

</table>

# 12.Risks, Dependencies, Assumptions, and Constraints

<font color="#0000ff">_[List any risks that may affect the successful execution of this **Test Plan**, and identify mitigation and contingency strategies for each risk. Also indicate a relative ranking for both the likelihood of occurrence and the impact if the risk is realized.]_</font>

<table width="607" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="105"> <col width="250"> <col width="208"></colgroup>

<thead>

<tr valign="BOTTOM">

<td width="105" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Risk**</font>

</td>

<td width="250" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Mitigation Strategy**</font>

</td>

<td width="208" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Contingency (Risk is realized)**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="105">

<font size="2" style="font-size: 9pt">Prerequisite entry criteria is not met.</font>

</td>

<td width="250">

<font size="2" style="font-size: 9pt"><Tester> will define the prerequisites that must be met before Load Testing can start.</font>

<font size="2" style="font-size: 9pt"><Customer> will endeavor to meet prerequisites indicated by <Tester>.</font>

</td>

<td width="208">

*   <font size="2" style="font-size: 9pt">Meet outstanding prerequisites</font>

*   <font size="2" style="font-size: 9pt">Consider Load Test Failure</font>

</td>

</tr>

<tr valign="TOP">

<td width="105">

<font size="2" style="font-size: 9pt">Test data proves to be inadequate.</font>

</td>

<td width="250">

<font size="2" style="font-size: 9pt"><Customer> will ensure a full set of suitable and protected test data is available.</font>

<font size="2" style="font-size: 9pt"><Tester> will indicate what is required and will verify the suitability of test data.</font>

</td>

<td width="208">

*   <font size="2" style="font-size: 9pt">Redefine test data</font>

*   <font size="2" style="font-size: 9pt">Review Test Plan and modify</font>

*   <font size="2" style="font-size: 9pt">components (that is, scripts)</font>

*   <font size="2" style="font-size: 9pt">Consider Load Test Failure</font>

</td>

</tr>

<tr valign="TOP">

<td width="105">

<font size="2" style="font-size: 9pt">Database requires refresh.</font>

</td>

<td width="250">

<font size="2" style="font-size: 9pt"><System Admin> will endeavor to ensure the Database is regularly refreshed as required by <Tester>.</font>

</td>

<td width="208">

*   <font size="2" style="font-size: 9pt">Restore data and restart</font>

*   <font size="2" style="font-size: 9pt">Clear Database</font>

</td>

</tr>

</tbody>

</table>

<font color="#0000ff">_[List any dependencies identified during the development of this **Test Plan** that may affect its successful execution if those dependencies are not honored. <span lang="en-NZ">Typically these dependencies relate to activities on the critical path that are prerequisites or post-requisites to one or more preceding (or subsequent) activities</span> You should consider responsibilities you are relying on other teams or staff members external to the test effort completing, timing and dependencies of other planned tasks, the reliance on certain work products being produced.]_</font>

<table width="607" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="189"> <col width="238"> <col width="136"></colgroup>

<thead>

<tr valign="BOTTOM">

<td width="189" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Dependency between**</font>

</td>

<td width="238" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Potential Impact of Dependency**</font>

</td>

<td width="136" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Owners**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

</tbody>

</table>

<font color="#0000ff">_[List any assumptions made during the development of this **Test Plan** that may affect its successful execution if those assumptions are proven incorrect. Assumptions might relate to work you assume other teams are doing, expectations that certain aspects of the product or environment are stable, and so forth]._</font>

<table width="607" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="189"> <col width="238"> <col width="136"></colgroup>

<thead>

<tr valign="BOTTOM">

<td width="189" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Assumption to be proven**</font>

</td>

<td width="238" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Impact of Assumption being incorrect**</font>

</td>

<td width="136" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Owners**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

</tbody>

</table>

<font color="#0000ff">_[List any constraints placed on the test effort that have had a negative effect on the way in which this **Test Plan** has been approached.]_</font>

<table width="607" bordercolor="#000000" border="1" cellspacing="0" cellpadding="7"><colgroup><col width="189"> <col width="238"> <col width="136"></colgroup>

<thead>

<tr valign="BOTTOM">

<td width="189" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Constraint on**</font>

</td>

<td width="238" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Impact Constraint has on test effort**</font>

</td>

<td width="136" bgcolor="#f2f2f2">

<font face="Arial, sans-serif">**Owners**</font>

</td>

</tr>

</thead>

<tbody>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

<tr valign="TOP">

<td width="189"></td>

<td width="238"></td>

<td width="136"></td>

</tr>

</tbody>

</table>

# 13.Management Process and Procedures

<font color="#0000ff">_[Outline what processes and procedures are to be used when issues arise with the **Test Plan** and its enactment.]_</font>

## 13.1Measuring and Assessing the Extent of Testing

<font color="#0000ff">_[Outline the measurement and assessment process to be used to track the extent of testing.]_</font>

## 13.2Assessing the Deliverables of this Test Plan

<font color="#0000ff">_[Outline the assessment process for reviewing and accepting the deliverables of this **Test Plan**]_</font>

## 13.3Problem Reporting, Escalation, and Issue Resolution

<font color="#0000ff">_[Define how process problems will be reported and escalated, and the process to be followed to achieve resolution.]_</font>

## 13.4Managing Test Cycles

<font color="#0000ff">_[Outline the management control process for a test cycle.]_</font>

## 13.5Traceability Strategies

<font color="#0000ff">_[Consider appropriate traceability strategies for:_</font>

*   <font color="#0000ff">_Coverage of Testing against Specifications — enables measurement the extent of testing_</font>

*   <font color="#0000ff">_Motivations for Testing — enables assessment of relevance of tests to help determine whether to maintain or retire tests_</font>

*   <font color="#0000ff">_Software Design Elements — enables tracking of subsequent design changes that would necessitate rerunning tests or retiring them_</font>

*   <font color="#0000ff">_Resulting Change Requests — enables the tests that discovered the need for the change to be identified and re-run to verify the change request has been completed successfully]_</font>

## 13.6Approval and Signoff

<font color="#0000ff">_[Outline the approval process and list the job titles (and names of current incumbents) that initially must approve the plan, and sign off on the plans satisfactory execution.]_</font>
