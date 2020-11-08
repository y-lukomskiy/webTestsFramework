# A basic framework to run selenium tests for Chrome, Firefox and IE(Selenium+TestNG+Maven)


Table of contents
=================

<!--ts-->
* [Tests requirements](#tests-requirements)
* [To run tests from IDE](#to-run-tests-from-ide)
* [To run tests from Maven](#to-run-tests-from-maven)
<!--te-->

 
## Tests requirements
1. Java 8 should be pre-installed. Please check such points:
    * Java 8 is installed
    * JAVA_HOME is added as a system variable ([Instruction](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html))
2. Intellij idea is installed ([Download](https://www.jetbrains.com/ru-ru/idea/))
3. Maven is installed to the system and bin folder is added to Path ([Instruction](https://maven.apache.org/install.html))
    
## To run tests from IDE
1. Clone the project from github
2. Import the project in IDEA and download Maven dependencies
3. To execute the tests, fill launch configuration in one of ways above:
    * With "Build project" configuration:
        * Click the "Add Configuration" button and add new TestNG configuration(via "+" button)
        * Fill such fields: 
            * ``Name - any`` 
            * ``Test kind - Suite`` 
            * ``Class - fill path to /Path_To_Project_In_Your_OS/src/test/resources/testNG.xml``
        * Save launch configuration and click "Play" button near created configuration.
    
    * With direct testNG.xml file execution:
        * navigate to the /src/test/resources/testNG.xml
        * click right button on the testNG.xml file and click the "Run..." button
4. To get an Allure report - execute one by one ``allure:report`` and ``allure:serve`` commands in maven/plugins/allure section 
  
 ## To run tests from Maven
1. Clone the project from github
2. Open the command line and navigate to the project's folder with ``cd`` command
3. To execute tests with maven enter:
    * Windows ``mvn clean test``    
    * Mac ``./mvn clean test``
4. To get an Allure report - execute one by one ``allure:report`` and ``allure:serve`` commands in maven/plugins/allure section
    * Windows ``mvn allureReport && mvn allureServe``    
    * Mac ``./mvn allure:report && ./mvn allure:serve``
 
 5. (Optionally) You can specify a browser and platform in testNG file. To do this, please set ``parallel="tests"`` in testNG.xml 
