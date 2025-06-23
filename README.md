# JAVA sqlite CLI APP


This is a simple command-line Java application that uses SQLITE to manage users.
It supports basic CRUD operation.



### Features

- Add a new user
- List all the users
- Update a user name by ID 
- Delete a user by ID
- Menu command-line interface
- SQLite as a local database
- Maven for build


### Used Technologies

-Java
-SQLite( via JDBC)
-Maven



### for cloning 

git clone https://github.com/araskara/UserDataCLI.git
cd dataExp

### Building
mvn clean install

### Add SQLite JDBC Dependency

In your `pom.xml` file:

```xml 
<dependencies>
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.45.1.0</version>
    </dependency>
</dependencies>
```

### Compile and Run 
mvn clean compile
mvn exec:java -Dexec.mainClass="com.codeingaras.Main"

