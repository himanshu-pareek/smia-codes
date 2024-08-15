FROM eclipse-temurin:21 as build

LABEL maintainer="JavaRush <code@javarush.dev>"

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

#unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

#stage 2
#Same Java runtime
FROM eclipse-temurin:21

#Add volume pointing to/ tmp
VOLUME /tmp

#Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#execute the application
ENTRYPOINT ["java", "-cp","app:app/lib/*", "dev.javarush.smia.smia_chapter4.SmiaChapter4Application"]
