# 指定 base 镜像
FROM java:8-jre-alpine
# 镜像作者
MAINTAINER  wangjie5633@163.com

# add timezone and default it to Shanghai
RUN apk --update add --no-cache tzdata
# 环境变量
ENV TZ=Asia/Shanghai


# 为后面的 RUN, CMD, ENTRYPOINT, ADD 或 COPY 指令设置镜像中的当前工作目录
WORKDIR /app/
# build 镜像时，在容器中运行指定的命令
RUN mkdir -p /app/log
# 复制文件到镜像
COPY  ./target/pms-0.0.1-SNAPSHOT.jar  /app/pms.jar

# 容器中的进程会监听某个端口
EXPOSE 8080
# 将文件或目录声明为 volume
VOLUME ["/app/log"]

# 设置容器启动时运行的命令
ENTRYPOINT ["java","-Xms2048m", "-Xmx2048m", "-Xss512k", "-jar", "pms.jar"]

# 当做参数传递给 ENTRYPOINT，会被 docker run 之后的参数覆盖
CMD []
