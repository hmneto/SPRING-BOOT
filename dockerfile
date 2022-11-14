FROM openjdk:17-alpine

WORKDIR "/home"

COPY . .

RUN apk add maven

WORKDIR "/home"

RUN mvn clean package

# EXPOSE 8081

# CMD [ "java", "-jar",  "/home/target/app-0.0.1-SNAPSHOT.jar"]

# CMD ["mvn","spring-boot:run"]

CMD ["mvn","test"]