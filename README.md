# hello-maven

A mvn based HelloWorld with JUnit tests

* [javadocs](https://ucsb-cs56-pconrad.github.io/hello-maven/apidocs/)
* [site docs](https://ucsb-cs56-pconrad.github.io/hello-maven/)


# To use

| To do this | Do this |
| -----------|-----------|
| check that edits to the pom.xml file are valid | Type `mvn validate` |
| clean up so you can recompile everything  | Type `mvn clean` |
| edit the source code for the app | edit files in `src/main/java`.<br>Under that the directories for the package are `edu/ucsb/cs56/pconrad`  |
| edit the source code for the app | edit files in `src/test/java`.<br>Under that the directories for the package are `edu/ucsb/cs56/pconrad`  |
| compile    | Type `mvn compile` |
| run junit tests | Type `mvn test` |
| build the website, including javadoc | Type `mvn site` then look in either `target/site/apidocs/index.html` or `docs/apidocs/index.html` |
| make a jar file | Type `mvn package` and look in `target/hello-maven-1.0.jar` |
| run the main in the jar file | Type `java -jar target/hello-maven-1.0.jar` |
| change which main gets run by the jar | Edit the `<mainClass>` element in `pom.xml` |