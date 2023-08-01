FROM openjdk:17-oracle
MAINTAINER "spawn"
COPY build/libs/spawn-0.0.1-SNAPSHOT.jar spawn.jar
ENTRYPOINT ["java","-jar","spawn.jar"]