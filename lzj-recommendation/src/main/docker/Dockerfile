# 基础镜像
FROM openjdk:latest
# 作者信息
LABEL maintainer="wjc.com"
# 将 maven 目录的 jar 包拷贝到 docker 中，并命名为 for_docker.jar
ADD maven/livegoods-recommendation-1.0-SNAPSHOT.jar livegoods-recommendation.jar
# 容器启动执行命令
ENTRYPOINT ["java", "-jar", "livegoods-recommendation.jar"]