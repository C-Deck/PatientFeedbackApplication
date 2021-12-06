#  PatientFeedbackApplication

Basic program to collect patient feedback after an appointment.

## Backend

The backend was built using Sprint Boot. It leverages the spring-boot-starter-data-jpa and spring-boot-starter-web packages to create a REST backend with low configuration. The database is a simple Postgres DB.

Run command: mvn spring-boot:run

## Frontend

This is a simple webapp using React and Typescript to get feedback on a patient's appointment. It uses Axios to make requests to the backend.

Run command: yarn start


### Going forward

Package the frontend up with the backend in Spring boot. This would make it only have to run the "mvn spring-boot:run" command to run both apps.

Add the other Model classes into the database as tables.