# interview-challenge
This Spring application was built for an interview


<h2> Challenge Description </h2>
Write Http endpoint API to manage customers and addresses

Business Requirements
- customer contains document id, name, age, registration date, last update info and one or more addresses
- addresses contains zip code, number and it can belong to one or more customers
- We should be able to insert, update, delete and query customers along with their dependencies
- We should be able to query customers by zip code

Assumptions
- document id from customer is unique;
- supports more than one customer by address
- one customer can have more than one address
- zip code must have a mask 99999-999  

Technical Spec
- Write a standalone Java Application exposing either rest or graphql API
    - Use ORM implementation as persistency
    - It must be written in Java8 or higher

<h2> How to run </h2>
First of all, move to the project root path (where the pom.xml archive is) and build the application:

```
$ mvn clean install
```

After building successfully, run:

```
$ mvn spring-boot:run
```

- The application is set to run at port 8083.
- The url to the api-doc is: http://your-localhost:8083/swagger-ui.html
- The url to access h2 database is: http://your-localhost:8083/h2-console
