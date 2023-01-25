FROM openjdk:11

EXPOSE 8080

WORKDIR /applications

COPY target/io-project-jsontools-1.0.jar /applications/json-tools.jar

ENTRYPOINT ["java","-jar", "json-tools.jar"]