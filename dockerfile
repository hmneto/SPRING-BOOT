FROM openjdk:17-alpine

WORKDIR "/home"

COPY . .

RUN apk add maven

WORKDIR "/home"

RUN mvn clean package

EXPOSE 8084

CMD [ "java", "-jar",  "/home/demo/target/demo-0.0.1-SNAPSHOT.jar"]