# Используйте официальный образ Java 17
FROM openjdk:17

# Установите рабочую директорию внутри контейнера
WORKDIR /app

# Копируйте jar файл вашего приложения в рабочую директорию
COPY ./jars/links-redirect-1.0.0.jar /app/links-redirect-1.0.0.jar

# Укажите команду для запуска вашего приложения
CMD ["java", "-jar", "links-redirect-1.0.0.jar"]
