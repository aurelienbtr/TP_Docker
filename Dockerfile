FROM openjdk:8-jdk-alpine as build
#JE CREE UNE IMAGE TEMP
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
#JE COPIE TOUT CE QUIL FAUT
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","uphf.docker.aurelien.TP.TpDockerApplication"]

