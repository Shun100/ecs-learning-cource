# Stage1: Build
FROM eclipse-temurin:21 AS build

WORKDIR /app
COPY . /app

# Gradle Wrapperに実行権限を付与してJARをビルド
RUN chmod +x ./gradlew && ./gradlew build

# Stage2: Runtime
FROM eclipse-temurin:21

WORKDIR /app

# ビルドステージで生成したJARをコピー
COPY --from=build /app/build/libs/my-app-0.0.1-SNAPSHOT.jar ./my-app.jar

# JARを実行
CMD ["java", "-jar", "my-app.jar"]