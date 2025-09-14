#set($hash = '#')

[![Maven Test Build](${vcsRepository}/actions/workflows/mavenBuild.yml/badge.svg)](${vcsRepository}/actions/workflows/mavenBuild.yml)
[![New Release](${vcsRepository}/actions/workflows/newRelease.yml/badge.svg)](${vcsRepository}/actions/workflows/newRelease.yml)

${hash} ${projectName}
This template can be used to start your own JLegMed application
 
${hash}${hash}  Requirements

*   Java ${javaVersion}+ installed
*   IDE with maven support 
*   [Optional] Docker or Kubernetes if you want to run your application in a container. See [here](README-GitHub.md) for more information.   
*   [Optional] A locally running [developer stack](deploy/developerStack.yml) providing a Postgres database, ActiveMQ broker, and Swagger-UI 

${hash}${hash} Build the Project

*   Check out the new project in your favorite IDE

*   [Optional] **With** running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install
    
    java -jar "-Djlegmed.config.import=src/test/resources/jlegmed-test.properties" target/${artifactId.toLowerCase()}-jar-with-dependencies.jar
    ```


${hash}${hash} Start Developing your Project

${hash}${hash}${hash} Set up your project on GitHub  

To continuously build and deploy your application, we recommend using GitHub as described [here](README-GitHub.md).

${hash}${hash}${hash} Package Structure
To organize our code, we recommend the following package structure. Since messages are treated as first-class objects, we strongly recommend a fine-grained packages structure:

``` 
(${package})
    flowgraph // Provides app specific flow graphs 
    plugins   // Provides app specific filter 
    |    <technology 1>
    |    ...
    |    <technology n>
    dto
        |    consumedmessage  // Messages received by the app
        |    publishedmessage // Messages published by the app
        |    domainevent      // Domain events published by the app
        |    telemetrydata    // Telemetry data published by the app
        |    flowdata         // Data structures used only within the app
        |    flowerror        // Exceptions occurred during processing
 
```

${hash}${hash}${hash} Cleanup Readme

After successfully setting up your new project, you should clean up the text of README as described [here](https://www.makeareadme.com)    
