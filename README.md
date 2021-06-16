# Hotel-Reservation

## Description
The Hotel reservation site is a Spring boot application designed to allow users to find and book hotel rooms. 
We also partnered with a package deals site and have provided an API for them to communicate too.  The site uses an MVC and Entity frameworks. 

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

## Database Design

Database consists of 4 tables: 
- hotel: Hotel consists of the information of every hotel in the system including address.
- reservations: Reservations are records of actual reservations and have foreign key reference to both rooms and users. 
- users: users consists of all users for both api and enduser.  
- rooms: consists of the number available rooms per hotel per date.  It has a foreign key reference to the hotels. 

The database is designed to enhance functionality while normalizing the data.  We designed the main tables based on search, book, login and cancel functionality. 
Foreign key references were used to reference second level information. 




