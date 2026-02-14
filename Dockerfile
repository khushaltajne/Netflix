# use a base image with java
FROM eclipse-temurin:21-jdk

# Expose the port your app runs on 
EXPOSE 8080

# Set the working Directory inside the container and Copy the jar file
ADD target/Netflix.jar Netflix.jar

#Run the jar file
ENTRYPOINT [ "java" , "-jar", "/Netflix.jar" ]

