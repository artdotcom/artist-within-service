FROM openjdk:11.0.2-slim
RUN ln -fs /usr/share/zoneinfo/US/Pacific-New /etc/localtime
WORKDIR /opt
COPY target/artist-within-service.jar .
COPY target/newrelic.jar .
COPY newrelic.yml .
ENV NEW_RELIC_ENABLED=false
ENV NEW_RELIC_DISTRIBUTED_TRACING=true
ENV JAVA_OPTS="-Xmx2g -Xms2g -XX:NewSize=750m"
ENTRYPOINT exec java -Dnewrelic.config.agent_enabled=${NEW_RELIC_ENABLED} -Dnewrelic.config.distributed_tracing.enabled=${NEW_RELIC_DISTRIBUTED_TRACING} ${JAVA_OPTS} -javaagent:newrelic.jar -jar artist-within-service.jar
