[![Maven Central](https://img.shields.io/maven-central/v/io.jexxa/jexxa-archetype)](https://maven-badges.herokuapp.com/maven-central/io.jexxa/jexxa-archetype/) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# JexxaArchetype
## Summary
The project is a Maven archetype for a Jexxa application.

## Features

*   Build your first Jexxa-project as self-contained jar and/or docker image

*   Template for [Unit-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/domain/book/BookTest.java), [Stub-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/applicationservice/BookStoreServiceTest.java) and [Integration tests](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/integration/BookstoreIT.java)

*   Predefined architectural tests for:
    *   [Pattern Language](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate the correct annotation of your application using project [Addend](http://addend.jexxa.io/)
    *   [Ports&Adapters Architecture](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate dependencies between packages of your application
    *   [Usage of Aggregates](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate that your business logic is not exposed

*   Predefined CI/CD pipeline for GitHub including automatic dependency updates 

## Create a Project

### Create new Project using maven  
 
```bash
mvn -B archetype:generate \
  -DarchetypeGroupId=io.jexxa \
  -DarchetypeArtifactId=jexxa-archetype \
  -DprojectName=JexxaProject \
  -DgroupId=com.github.jexxaproject \
  -DgithubAccount=jexxa-projects
```

For your own project please adjust at least parameters `projectName`, `groupId`, and `githubAccount`. 

### Create a new project in IntelliJ

* Create new project `File > New > Project`
* Click Maven on the left hand side of the new project dialog
* Check `Create from archetype`
* Select Catalog `Central Maven` 
* Select Archetype `io.jexxa:jexxa-archetype`
* Select latest available version
* Enter your project specific settings in `Additional Properties` and `Advanced Settings`. Available parameters are described [below](#Description-of-available-Parameters).

Note: In IntelliJ `artifactId` should be identical to project name. So please do not adjust upper/lower case. The archetype internally converts the `artifactId` to lower cases.  

### Description of available Parameters
| Parameter           | Description                                                                                                      | Example                                   | Default Value                                                                                       |
|---------------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `projectName`       | Specifies the name of the project in the desired upper/lower case and the directory that will be created for it. | `JexxaProject`                            | None. It must be defined.                                                                           |
| `groupId`           | Defines the `groupID` for the project.                                                                           | `com.github.jexxaproject`                 | None. It must be defined.                                                                           |
| `artifactId`        | Defines the `artifactId` of the project.                                                                         | `jexxaproject`                            | `projectName` in lower cases. Due to java recommendations, it is always converted into lower cases. | 
| `package`           | Defines the base package name of the project.                                                                    | `com.github.jexxaproject`                 | `groupId`                                                                                           | 
| `githubAccount`     | Defines your GitHub-Account, or one of your GitHub-Organizations that should be used                             | `jexxa-projects`                          | None. It must be defined <br />to use included GitHub-Actions                                       | 
| `vcsRepository`     | Defines the URL of used VCS repository.                                                                          | `https://github.com/jexxa-projects/jexxa` | `https://github.com /<githubAccount>/<projectName>`                                                 | 
| `containerRegistry` | Defines the URL of used container registry.                                                                      | `ghcr.io/jexxa-projects`                  | `ghcr.io/<githubAccount>`                                                                           | 

## Run the Project 

Please follow the README.md in created project directory how to run the project 
