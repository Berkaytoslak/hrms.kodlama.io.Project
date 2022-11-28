FROM openjdk:17
EXPOSE 8081
ARG JAR_FILE=hrms/target/*.jar
ADD ${JAR_FILE} hrms.jar
ENTRYPOINT ["java","-jar","hrms.jar"]