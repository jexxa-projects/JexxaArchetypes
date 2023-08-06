#set($hash = '#')
[![Maven Test Build](https://github.com/jexxa-projects/JexxaTemplate/actions/workflows/mavenBuild.yml/badge.svg)](https://github.com/jexxa-projects/JexxaTemplate/actions/workflows/mavenBuild.yml)
[![New Release](https://github.com/jexxa-projects/JexxaTemplate/actions/workflows/newRelease.yml/badge.svg)](https://github.com/jexxa-projects/JexxaTemplate/actions/workflows/newRelease.yml)

${hash} ${name}
This template can be used to start your own Jexxa application 

${hash}${hash}  Requirements

*   Java 17+ installed
*   IDE with maven support 
*   [Optional] Docker or Kubernetes if you want to run your application in a container. See [here](README-CICD.md) for more information.   
*   [Optional] A locally running [developer stack](deploy/developerStack.yml) providing a Postgres database, ActiveMQ broker, and Swagger-UI 

${hash}${hash}  Features

*   Build your first Jexxa-project as self-contained jar and/or docker image
    
*   Template for [Unit-](src/test/java/${groupId.replace('.', '/')}/domain/book/BookTest.java), [Stub-](src/test/java/${groupId.replace('.', '/')}/applicationservice/BookStoreServiceTest.java) and [Integration tests](src/test/java/${groupId.replace('.', '/')}/integration/${name}IT.java)

*   Predefined architectural tests for: 
    *   [Pattern Language](src/test/java/${groupId.replace('.', '/')}/architecture/ArchitectureTest.java) to validate the correct annotation of your application using project [Addend](http://addend.jexxa.io/) 
    *   [Ports&Adapters Architecture](src/test/java/${groupId.replace('.', '/')}/architecture/ArchitectureTest.java) to validate dependencies between packages of your application
    *   [Usage of Aggregates](src/test/java/${groupId.replace('.', '/')}/architecture/ArchitectureTest.java) to validate that your business logic is not exposed

*   Predefined CI/CD pipeline for GitHub including automatic dependency updates 

${hash}${hash} Build the Project

*   Checkout the new project in your favorite IDE

*   Without running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install -P '!integrationTests'

    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-local.properties" target/${artifactId}-jar-with-dependencies.jar
    ```

*   [Optional] **With** running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install
    
    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-test.properties" target/${artifactId}-jar-with-dependencies.jar
    ```

*   Now you can use `curl` to access your application, or open this [http://localhost:7503/BookStoreService/getBooks](http://localhost:7503/BookStoreService/getBooks) in your browser:
    ```Console
    curl -X GET  http://localhost:7503/BookStoreService/getBooks
    ```
    Response should look as follows 
    ```Console
    [
      {"isbn13":"978-1-60309-322-4"},{"isbn13":"978-1-891830-85-3"},
      {"isbn13":"978-1-60309-047-6"},{"isbn13":"978-1-60309-025-4"},
      {"isbn13":"978-1-60309-016-2"},{"isbn13":"978-1-60309-265-4"}
    ]
    ```
*   [Optional] See [here](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/README-OPENAPI.md#explore-openapi) how to use the application with Swagger-UI

${hash}${hash} Start Developing your Project

${hash}${hash}${hash} Set up the CI/CD Pipeline  

In order to continuously build and deploy your application, configure your CI/CD pipeline as described [here](README-CICD.md).

${hash}${hash}${hash} Cleanup Readme

After successfully set up your new project, you should clean up the text of README as described [here](https://www.makeareadme.com)    
