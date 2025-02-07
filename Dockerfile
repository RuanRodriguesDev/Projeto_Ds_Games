# Etapa de Build (instalar Maven manualmente)
FROM maven:3.9.8-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar todos os arquivos para o container
COPY . .

# Compilar o projeto e gerar o JAR
RUN mvn clean package -DskipTests


# Etapa de Execução (OpenJDK 21)
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar o JAR gerado da etapa de build para o container
COPY --from=build /app/target/*.jar dslist.jar

# Expor a porta da aplicação
EXPOSE 8080

# Executar o JAR
ENTRYPOINT ["java", "-jar", "dslist.jar"]
