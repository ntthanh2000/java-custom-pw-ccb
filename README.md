# A custom testing framework

A test framework project using Playwright and Cucumber on Maven because I'm not sane.

For reporting, Allure and Jacoco are used

## Folders

src.main.java contains files for pages functions, steps definitions, hooks and utils function

src.test.java contains feature files and runner class



## Run

```bash
# run all tests in features folder
mvn test 

# run with cucumber filter to tags, feature path
mvn test -Dcucumber.filter.tags="@tagname"

# run with cucumber filter to feature path
mvn test -Dcucumber.features=src/test/java/features/Test1.feature

# run all tests in features folder AND generate report as html file
mvn test allure:report

# run all tests in features folder AND compile report to html in temp and open report in local server
mvn test allure:serve
```

## Reports

Reports are stored in `target/allure-results` as json files

When run cmd with allure:report, report index.html is saved at `target/site/allure-maven-plugin`