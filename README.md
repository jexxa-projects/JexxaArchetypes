[![Maven Central](https://img.shields.io/maven-central/v/io.jexxa/jexxa-archetype)](https://maven-badges.herokuapp.com/maven-central/io.jexxa/jexxa-archetype/) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# JexxaArchetypes
## Summary
This project provides the following Maven archetypes for a Jexxa application: 
* `jexxa-blank-archetype`: Generates a project including only source code that is part of all projects (such as a main-class).  
* `jexxa-archetype`: Generates a project including source code of [BookStore tutorial](https://github.com/jexxa-projects/JexxaTutorials/tree/main/BookStore). It is recommended if you want to play around with existing source code to get familiar with Jexxa and/or ports and adapter architecture. 

## Features

*   Build your first Jexxa-project as self-contained jar and/or docker image

*   Template for [Unit-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/domain/book/BookTest.java), [Stub-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/applicationservice/BookStoreServiceTest.java) and [Integration tests](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/integration/BookstoreIT.java)

*   [Architectural tests](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) for _pattern language_, _ports & adapters architecture_, and _usage of aggregates_. 

*   Predefined CI/CD pipeline for GitHub including automatic dependency updates 

## Create your Project

### Create a new Project using maven  

For your own project please adjust at least parameters `projectName`, `groupId`, and `githubAccount`.

For `jexxa-blank-archetype` use:
```bash 
mvn -B archetype:generate \
  -DarchetypeGroupId=io.jexxa \
  -DarchetypeArtifactId=jexxa-blank-archetype \
  -DprojectName=JexxaProject \
  -DgroupId=com.github.jexxaproject \
  -DgithubAccount=jexxa-projects
```

For `jexxa-archetype` use: 
```bash 
mvn -B archetype:generate \
  -DarchetypeGroupId=io.jexxa \
  -DarchetypeArtifactId=jexxa-archetype \
  -DprojectName=JexxaProject \
  -DgroupId=com.github.jexxaproject \
  -DgithubAccount=jexxa-projects
```

### Create a new project in IntelliJ

* Create new project `File > New > Project`
* Click Maven on the left-hand side of the new project dialog
* Check `Create from archetype`
* Select Catalog `Central Maven` 
* Select Archetype `io.jexxa:jexxa-archetype` or `io.jexxa:jexxa-blank-archetype`
* Select latest available version
* Enter your project-specific settings in `Additional Properties` and `Advanced Settings`. Available parameters are described [below](#Description-of-available-Parameters).

Special Note: 
* __Windows__: `artifactId` must be written with the same upper/lower case as the `projectName`, such as `JexxaProejct`. 
* __Linux/macOS__: `artifactId`must be written in lower cases, such as `jexxaproject`.

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
