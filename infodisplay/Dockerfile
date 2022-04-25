FROM maven:3.6.3-jdk-11 as builder

WORKDIR /app
COPY ./pom.xml ./
RUN mvn dependency:go-offline

COPY ./src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11

RUN mkdir /app
COPY --from=builder ./app/target/infodisplay-0.0.1-SNAPSHOT.jar /app

ENV TZ="Asia/Colombo"

WORKDIR /app

CMD ["java", "-jar", "infodisplay-0.0.1-SNAPSHOT.jar"]
