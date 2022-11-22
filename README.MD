## Startup

This project has a _vanilla_ JavaScript frontend and Spring Boot service for company project and employee management.

The correct way to start the application is to start the Postgres database with pgAdmin4, start "baigiamasisApplication",
(on init it will create a database with  three entities **"Companies"**, **"Employees"** and **"Projcts"**; will configurate JPA repositories and REST controllers ) and finally the frontend

`docker-compose up db`

Run or build spring boot project with your IDE `src/main/java/com/liaudanskyte/baigiamasis/BaigiamasisApplication.java`

`npm install` and `npm start` in `frontend` directory


## Tests

Spring boot is not covered with unit tests **_YET_**

Will happen shortly

This project was created with love, sweat and tears. Figma, Maven, StackOverflow and Google in general did contribute too 