FROM openjdk:17 as build
WORKDIR /opt

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

COPY target/*.jar app.jar


FROM openjdk:17
COPY --from=build /opt/app.jar /opt/app.jar
ENTRYPOINT ["java","${JAVA_OPTS}","-jar","app.jar"]