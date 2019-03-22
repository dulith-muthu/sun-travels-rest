FROM java:8-jdk-alpine

COPY ./target/sun-travel-rest-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

#RUN sh -c 'sun-travel-rest-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","sun-travel-rest-0.0.1-SNAPSHOT.jar"]