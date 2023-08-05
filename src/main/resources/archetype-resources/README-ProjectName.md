# Adjust Project Name 

*   Refactor/Rename file `JexxaTemplate.java` into `<ProjektName>.java` within your IDE

*   Refactor/Rename the GroupId (directory) `io.jexxa.jexxatemplate` into `com.github.<your-github-account>` for example within your IDE. Delete the old package if it is not done by your IDE. 

*   Adjust all sections marked with TODO (and remove TODO statement) in : 
    *    [pom.xml](pom.xml) 
    *    [jexxa-application.properties](src/main/resources/jexxa-application.properties) 
    *    [jexxa-test.properties](src/test/resources/jexxa-test.properties)
    *    [docker-compose.yml](deploy/docker-compose.yml)

* In README.md and README-ProjectName.md:
    *   Search/replace (case-sensitive) `jexxa-projects/JexxaTemplate` by `<your-github-account>/<ProjectName>` to adjust the badges

*   In README.md:
    *   Search/replace (case-sensitive) `io/jexxa/jexxatemplate` by `com/github/<your-github-account>` (GroupId with `/` separator)
    *   Search/replace (case-sensitive) `JexxaTemplate` by `<ProjectName>`
    *   Search/replace (case-sensitive) `jexxatemplate` by `<projectname>`

*   Adjust release version
    ```shell
    mvn versions:set -DnewVersion='0.1.0-SNAPSHOT'
    ```

*   Push all changes to GitHub and validate that test build run successfully via ['Maven Test Build' GitHub-Actions](https://github.com/jexxa-projects/JexxaTemplate/actions/workflows/mavenBuild.yml).
    *   Note: As long as you did not execute the steps in [README-CICD.md](README-CICD.md), the `Merge me!` action script might fail.   
