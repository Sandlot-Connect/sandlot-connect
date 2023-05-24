# Sandlot Connect
Sandlot Connect is a social media platform inspired by the grassroots resurgence of sandlot baseball across Texas and beyond. 
Within this web application, users can create a new baseball team or request to join an existing team. 
When a user creates a new team they have access to requests and can approve or dismiss requests to join the team. 
Once on a team, members have a private space where they can make a post and communicate with group members. 
The application is built using Java and Spring Boot on the back-end, with Thymeleaf for the front-end.

Visit our project at https://sandlotconnect.xyz:8080/

![Sandlot connect video](assets/sandlot-connect-video.gif)

## Getting Started

To get started with Sandlot Connect, you will need to:
1. Clone the repository to your local machine. Import the project to your preferred IDE. 
2. Set up a local MySQL database. 
3. Create an application.properties file and store the below lines. Fill in the database name, username, and password with your credentials: 
```
  spring.datasource.url=jdbc:mysql://localhost/'EXAMPLE_DB'?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
  spring.datasource.username='YOUR_DB_USERNAME_HERE'
  spring.datasource.password='YOUR_DB_PASSWORD_HERE'
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
4. Build and run the project
5. Access the project at http://localhost:8080/

## Features
- Register as a user
- Create a team
- Make a post
- Register another user
- Request to join a team
- Team Captain can see pending requests in the admin page and approve or dismiss
- Users added to a team can see the team posts page and make a post or a comment
- Team Captain can remove players from the team on the posts page

## Technologies Used
- Java
- Javascript
- Spring Boot
- Thymeleaf
- CSS
- HTML
- MYSQL
- Bootstrap
