FROM java:8
LABEL maintainer="sarishbiswas@gmail.com"
VOLUME /tmp
EXPOSE 8081
ADD target/movie-service-0.0.1-SNAPSHOT.jar movie-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movie-service-0.0.1-SNAPSHOT.jar"]
