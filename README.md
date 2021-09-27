Documentation
-------------

This project contains a Selenium WebDriver test application using Junit5 and Maven.

It contains three tests: the first and the third tests pass and the second test fails.

Requirements
-------------
- Requirements : Java 8 or higher, Maven
- Browser: tests are runnable in Chrome and Firefox. The default browser is Chrome.
Add -Dbrowser=firefox to the command in order to run it in Firefox.

Execution
-------------
First test:
```
mvn test -Dtest=DemoqaTest#firstTest
```
Second test:
```
mvn test -Dtest=GoogleCheeseTest#secondTest  
```
Third test:
```
mvn test -Dtest=OrangeHRMTest#thirdTest 
```
Run all tests:
```
mvn clean test 
```