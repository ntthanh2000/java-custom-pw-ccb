# A custom testing framework

A test framework project using Playwright and Cucumber on Maven because I'm not sane.
For reporting, Allure and Jacoco are used

## Folders

src.main.java contains files for pages functions, steps definitions, hooks and utils function
src.test.java contains feature files and runner class

## Run
mvn clean test 
mvn clean test allure:report
