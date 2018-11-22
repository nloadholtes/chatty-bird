FROM clojure:latest
RUN mkdir -p /usr/src/app
RUN mkdir -p /data/
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
ENTRYPOINT ["java", "-jar", "app-standalone.jar"]
