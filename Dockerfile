FROM eclipse-temurin:22
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY target/GolfTournamentMembershipQap2-0.0.1-SNAPSHOT.jar/
GolfTournamentMembershipQap2-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]