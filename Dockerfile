FROM openjdk:8
VOLUME /tmp
EXPOSE 8802
ADD ./target/Movement-0.0.1-SNAPSHOT.jar movement-server.jar
ENTRYPOINT ["java","-jar","/movement-server.jar"]