# sainsburys-fruits-test

## Description

A test project for Sainsbury's that retrieves a list of fruits, processes that list and outputs the result on the console.

## The application's flow

The flow of the application consists of seven steps:

1. Retrieve an HTML document that contains the list of *Sainsbury's ripe fruits*.
2. Iterate through the list of fruits and extract the links to the pages containing the individual fruits.
3. Process each document containing a single fruit. The processing involves extracting the fruit's title, description and unit price and also calculating the size of the HTML page containing said fruit.
4. Assemble the fruits based on the extracted information
5. Assemble a list containing the assembled fruits which also calculates the sum of each fruit's unit price
6. Convert the fruits list to JSON
7. Write it on the console

## Dependencies

Java 1.8 and Maven 3 is required to package and run the application.

The app also depends on a number of external libraries of which Maven takes care:

1. [Apache HttpClient](https://github.com/apache/httpclient) - for retrieving the HTML documents
2. [JSoup](https://github.com/jhy/jsoup) - for scraping the HTML documents
3. [JSON](https://github.com/stleary/JSON-java) - for JSON serialization
4. [JUnit](https://github.com/junit-team/junit4) - for testing
5. [Mockito](https://github.com/mockito/mockito) - for mocking

## Running the tests

In order to run the unit and integration tests, issue the following command:
```
mvn test
```

## Running the application

In order to run the application, first issue the following command which takes care of creating a runnable .jar:
```
mvn package
```
Then issue the following command which runs the application:
```
java -jar target/fruits-1.0-SNAPSHOT-jar-with-dependencies.jar
```
