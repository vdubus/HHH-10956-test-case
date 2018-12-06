# HHH-10956-test-case

A simple project to show case the Hibernate [HHH-10956](https://hibernate.atlassian.net/browse/HHH-10956) bug.

## Prerequisites

- Java 8
- Maven

## Run the test

```cmd
mvn clean test
```

## Test with different ID generation

In the class `Mission`, update the ID part like:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

Or

```java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
```
