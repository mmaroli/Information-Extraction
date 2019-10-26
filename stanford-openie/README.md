# Stanford OpenIE

## Build Docker Container
+ `docker build -t stanford .`
+ SSH: `docker run -it --rm -v $(pwd):/usr/src/app -p 127.0.0.1:8080:8080 --name stanford-app stanford bash`

## Instructions for Maven Build
+ `export MAVEN_OPTS="-Xmx14000m"`
+ `mvn compile && mvn package`
+ `mvn exec:java -Dexec.mainClass="leaf.group.openie.App"`

## To Run Spring Boot Application
+ `mvn spring-boot:run` or
+ `mvn clean package && java -jar target/openie-extraction-1.0-SNAPSHOT.jar`
