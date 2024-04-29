FROM openjdk:17-slim
EXPOSE 8081
ADD build/libs/hw1_SpringBootPurposeInternalStructure-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]