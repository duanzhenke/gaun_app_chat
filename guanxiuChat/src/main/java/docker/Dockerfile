FROM java:8

MAINTAINER duanzhenke <1830123756@qq.com>

# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp

COPY ./guanxiuChat-1.0-SNAPSHOT.jar  app_chat.jar

EXPOSE 9097

ENTRYPOINT ["java","-jar","/app_chat.jar"]