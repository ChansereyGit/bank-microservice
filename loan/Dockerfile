#Start with base image containing java runtime
FROM openjdk:17-ea as build

# Information of owner or maintainer of image
MAINTAINER serey

# Add the application's jar to the container
COPY target/loan-0.0.1-SNAPSHOT.jar loan-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/loan-0.0.1-SNAPSHOT.jar"]