# API-Monitoring-Dashboard

This is a small full-stack API monitoring and incident tracking dashboard built using Java, Spring Boot, Angular, Typescript, Spring Data JPA and H2.
I built this project to create an enterprise style application. The dashboard stimulates how a team could monitor API Heath, view service status, create incidents and resolve them.  

## Features 
-View API services and health  
-Create new incidents  
-Resolve existing incidents  
-Store data with Spring Data and H2  
-Angular fronted and Spring boot REST APIs  

## Tech Stack
**Backend:** Java 17, Spring Boot, Spring Data JPA, h2, Maven  
**Frontend:** Angular, Typescript, HTML, CSS  

## Backend Structure
Controller -> Service -> Repository -> Database 

## Run Backend
cd backend  
./mvnw spring-boot:run   

Runs at http://localhost:8080  

H2 Console: http://localhost:8080/h2-console  

jdbc:h2:mem:apimonitoringdb  
Username: sa  
Password:  

## Run Frontend 
cd frontend   
npm install   
npm exec ng server or npm start

Runs at http://localhost:4200  

## Future Improvements
-Add PostgreSQL or Supabase  
-Add authenticaiton (In Progress) 
-Add charts for API metrics  
-Add search and filtering  
-Add test  


