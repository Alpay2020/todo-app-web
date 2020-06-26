FROM openjdk:14

ENV ENVIRONMENT=prod

MAINTAINER Alpay Ergindemir <alpay.ergindemir@live.de>

ADD backend/target/todo-app-web.jar app.jar

CMD ["sh", "-c", "java -Dserver.port=$PORT -Dspring.data.mongodb.uri=$MONGODB_URI -jar /app.jar"]