FROM openjdk:14
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]