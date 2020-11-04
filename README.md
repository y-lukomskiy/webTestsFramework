# A basic framework to run selenium tests for Chrome, Firefox and IE(Selenium+TestNG+Maven)

## Table of contents
  * [Pre test requirements](#Pre test requirements)
  * [To run tests from IDE](#To run tests from IDE)
  * [To run tests from maven](#To run tests from Maven)
 
## Pre test requirements
1. Java 8 should be pre-installed. Please check such points:
    * Java 8 is installed
    * JAVA_HOME is added as a system variable ([Instruction](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html))
2. Intellij idea is installed ([Download](https://www.jetbrains.com/ru-ru/idea/))
3. Maven is installed to the system and bin folder is added to Path ([Instruction](https://maven.apache.org/install.html))
    
## To run tests from IDE
1. Clone the project from github
2. Import the project in IDEA and download Maven dependencies
3. Click the "Add Configuration" button and add new TestNG configuration(via "+" button)
4. Fill such fields:
    * Name - any;
    * Test kind - Suite
    * Class - fill path to /Path_To_Project_In_Your_OS/src/test/resources/testNG.xml
    * VM options - ``-Dtestng.dtd.http=true``
4. Save launch configuration and click "Play" button near created configuration.
    * Note: you can specify a browser and platform in testNG file
  
 ## To run tests from Maven
 1. Clone the project from github
 2. Open the command line and navigate to the project's folder
 3. To execute maven test enter:
    * Windows ``mvn clean test -Dtestng.dtd.http=true``    
    * Mac ``./mvn clean test -Dtestng.dtd.http=true``
