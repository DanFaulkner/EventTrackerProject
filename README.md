# EventTrackerProject

## Overview

This project will track a users weight lifting progress. In the future it will display graphs of progress made.

### REST API

### HTML/Javascript Front End

### Angular Front End

### REST API Reference
| Return Type | HTTP Method | URI | Request Body |
|-------------|-------------|-----|--------------|
|List<Exercise> | GET  | /api/exercises      | |
|Exercise       | GET  | /api/exercises/{id} | |
|Exercise       | POST | /api/exercises      | | Exercise JSON |
|Exercise       | PUT  | /api/exercises{id}  | | Exercise JSON |
|Void      | DELETE | /api/exercises{id} | | |
|List<User> | GET  | /api/users      | |
|User       | GET  | /api/users/{id} | |
|User       | POST | /api/users      | | User JSON |
|User       | PUT  | /api/users{id}  | | User JSON |
|Void      | DELETE | /api/users{id} | | |
|List<Weight> | GET  | /api/weights      | |
|Weight       | GET  | /api/weights/{id} | |
|Weight       | POST | /api/weights      | | Weight JSON |
|Weight       | PUT  | /api/weights{id}  | | Weight JSON |
|Void      | DELETE | /api/weights{id} | | |

for some reason when adding a weight lifted the user and exercise details return null.
However, if you get the weight with the id of the recently created weight it will return the details.
I'm planning on fixing them in the front end.



## Technologies Used
Java 1.8, JUnit 5, SpringMVC, Spring Boot, Spring Tool Suite, GitHub, Gradle,
Git terminal, MAC OS, JPava Persistence API & Hibernate.


## Lessons Learned
