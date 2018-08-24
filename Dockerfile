FROM java:8-jre-alpine

#add timezone and default it to Shanghai
RUN apk --update add --no-cache tzdata
ENV TZ=Asia/Shanghai

RUN mkdir -p /app/log
COPY  ./target/pms-0.0.1-SNAPSHOT.jar  /app/pms.jar

EXPOSE 9999
VOLUME ["/app/log"]
WORKDIR /app/

ENTRYPOINT ["java","-Xms2048m", "-Xmx2048m", "-Xss512k", "-jar", "pms.jar"]
CMD []
