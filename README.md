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

Below you find an example how to use the archetype to create a project: 
 
```bash
mvn -B archetype:generate \
  -DarchetypeGroupId=io.jexxa \
  -DarchetypeArtifactId=jexxa-archetype \
  -DarchetypeVersion=0.1.3 \
  -DprojectName=JexxaProject \
  -DgroupId=com.github.jexxaproject \
  -DgithubAccount=jexxa-projects
```

For your own project please adjust at least parameters `projectName`, `groupId`, and `githubAccount`. 

### Description of available Parameters
| Parameter           | Description                                                                                                      | Example                                   | Default Value                                           |
|---------------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------|---------------------------------------------------------|
| `projectName`       | Specifies the name of the project in the desired upper/lower case and the directory that will be created for it. | `JexxaProject`                            | None. It must be defined.                               |
| `groupId`           | Defines the `groupID` for the project.                                                                           | `com.github.jexxaproject`                 | None. It must be defined.                               |
| `artifactId`        | Defines the `artifactId` of the project.                                                                         | `jexxaproject`                            | `projectName` in lower cases.                           | 
| `package`           | Defines the base pacakge name of the project.                                                                    | `com.github.jexxaproject`                 | `groupId`                                               | 
| `githubAccount`     | Defines your GitHub-Account, or one of your GitHub-Organizations that should be used                             | `jexxa-projects`                          | None. It must be defined to use included GitHub-Actions | 
| `vcsRepository`     | Defines the URL of used VCS repository.                                                                          | `https://github.com/jexxa-projects/jexxa` | `https://github.com/<githubAccount>/<projectName>`      | 
| `containerRegistry` | Defines the URL of used container registry.                                                                      | `ghcr.io/jexxa-projects`                  | `ghcr.io/<githubAccount>`                               | 

## Run the Project 

Please follow the README.md in created project directory how to run the project 