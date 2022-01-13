echo "Compile and build jar"
call mvn clean install -DskipTests

echo "Run jar"
call java -jar target/RestApiPoc-0.0.1-SNAPSHOT.jar

pause