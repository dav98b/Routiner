# Routiner
Jakarta EE demo - Assistant for your routine 

## TODO
* REST endpoints implementation
* Web client which provides UI and consumes REST APIs
* Finish core domain model

## Build
To compile, package and make artifacts available as dependency execute from root folder:
```mvn install```
## Run REST API server
This application is configured to use OpenLiberty, installation dir is specified in plugin section (liberty-maven-plugin) of parent pom.xml.<br> 
To start the server execute from rest-api folder:
```mvn liberty:run```<br>
It deploys artifacts automatically 

API will then be available on localhost:9080/api/v1/

