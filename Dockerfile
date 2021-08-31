FROM openjdk:8-alpine

#RUN apk update

#RUN apk add maven

#COPY . .

#RUN mvn package -DskipTests

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]