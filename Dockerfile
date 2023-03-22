FROM amazoncorretto:17
EXPOSE 8080
ADD target/demo-k8s.jar demo-k8s.jar
ENTRYPOINT ["java", "-jar", "/demo-k8s.jar"]
