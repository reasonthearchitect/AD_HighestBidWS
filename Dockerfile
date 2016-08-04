FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/highestbid-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]
EXPOSE 8230