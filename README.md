# Hotel-Reservation

## Description
The Hotel reservation site is a Spring boot application designed to allow users to find and book hotel rooms. 
We also partnered with a package deals site and have provided an API for them communicate.  The site uses and MVC and Entity frameworks. 

## Whats in the Repo

- `database` Directory: Contains model and recent dump of mysql
- `src` Directory:  Code base
  - `main`: code base
  - `test`: unit tests  
-  `pom.xml`: uses maven for package management

## Deployment
Currently, the application is deployed to heroku and requires a MYSQL database and Java 16. 
The application.properties sets the database connection.  Use `env.sh` to setup the application to point 
to your local mysql instance. 

You can find the application here: `https://cst438-hotel-reservation-3.herokuapp.com/`

Webpage routes: 
- /hotel/search: search for room

API Routes: 
- POST - /api/search: search for available reservations
- POST - /api/reservation: book reservation
- POST - /api/reservation/cancel: cancel existing reservation




