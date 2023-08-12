[![Maven Central](https://img.shields.io/maven-central/v/io.jexxa/jexxa-archetype)](https://maven-badges.herokuapp.com/maven-central/io.jexxa/jexxa-archetype/) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# JexxaArchetype

## Features

*   Build your first Jexxa-project as self-contained jar and/or docker image

*   Template for [Unit-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/domain/book/BookTest.java), [Stub-](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/applicationservice/BookStoreServiceTest.java) and [Integration tests](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/integration/BookstoreIT.java)

*   Predefined architectural tests for:
    *   [Pattern Language](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate the correct annotation of your application using project [Addend](http://addend.jexxa.io/)
    *   [Ports&Adapters Architecture](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate dependencies between packages of your application
    *   [Usage of Aggregates](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/src/test/java/io/jexxa/tutorials/bookstore/architecture/ArchitectureTest.java) to validate that your business logic is not exposed

*   Predefined CI/CD pipeline for GitHub including automatic dependency updates 

## Usage
* Checkout archetype
* Build archetype 
```
mvn clean install
```
* Build Project Template 
```bash
mvn -B archetype:generate \
  -DarchetypeGroupId=io.jexxa \
  -DarchetypeArtifactId=jexxa-archetype \
  -DarchetypeVersion=0.1.3 \
  -DprojectName=JexxaProject \
  -DgroupId=com.github.jexxaproject \
  -DgithubAccount=jexxa-projects
```