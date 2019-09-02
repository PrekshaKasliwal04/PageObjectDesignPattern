# TestAutomationGurukul
This automation framework is for Gurukul test application
Pre-requisite to execute test framework is the Gurukul application should be up and running.

> Framework details:

It is Maven based project written in Selenium with Java following test drivern development.
Below is explanation of various aspetcs of project directory 

1. pom.xml - It is an XML file that contains information about the Gurukul App test assignment project and configuration details used by Maven to build the project.
   Various parameters are mentioned in pom.xml such as which browser to execute test on, which test suite file to execute like testng.xml.

2. testng.xml- This XML file is used to invoke TestNG, suite name is specified along with testname. It will execute class files mentioned in class tags.
   This Xml file is in suites folder.

3. properties: Object repository using properties file,locators are stored in key-value pairs.

4. credentials:Login credentials are stored in key-value pairs.

5. RetryFailedTestCases: When testcases gets failed, it will retry failed testcase twice.

6. src - Contains Projects source files 

> Test Covered:
Following test classes cover below features of the application:
1. LoginTest - Login with valid and invalid credentials, logout
2. RegisterAccountTest - Register account with a new user
3. DashboardTest - Branch and Staff create,view,edit,delete and query functions
4. PaginationTest - Pagination enabled for Staff Entity.
5. AccountTest - View and edit account information of logged in user

> To execute test from eclipse there are two ways:
1. Run pom.xml - There are three parameters - browserName, environment, suiteXmlFile which are used to select browser, URL, testng file respectively. 

2. Run testng.xml - All class files are mentioned which covers above mentioned functions.


> Notes: 

1. Framework is designed to retry failed test cases twice.
2. Browser, environment and testng parameters can be changed from pom.xml (This will help user to perform cross browser testing and to support various test environments )
3. Properties file used to maintain object repository. (All locator values are mentioned in properties folder along with environment.properties file from where URL can be changed) 
4. Reusable Methods are written to optimize code, common operational methods are wrriten in com.basesource.actions all pages use methods mentioned at one place.


