FROM amazoncorretto:17
EXPOSE 8080
ADD target/demo-k8s-0.0.1-SNAPSHOT.jar demo-k8s-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demo-k8s-0.0.1-SNAPSHOT.jar"]
