# SpringBoot_MicroService_SpringCloud_Security

# Swagger URL 

host:port/swagger-ui.html#/

Ex: http://localhost:8080/swagger-ui.html#/


# Spring Security Oauth need Roles, Insert below roles Before creating Users

- insert into roles values(1,'ROLE_USER');
- insert into roles values(2,'ROLE_ADMIN');

# User Creation
![token generate/ user login ](https://github.com/HarshaPrimeTrainings/SpringBoot_MicroService_SpringCloud_Security/blob/main/usercreate.PNG)

# Token Generation
![token generate/ user login ](https://github.com/HarshaPrimeTrainings/SpringBoot_MicroService_SpringCloud_Security/blob/main/tokengenerate.PNG)

# Getting get users
![access users ](https://github.com/HarshaPrimeTrainings/SpringBoot_MicroService_SpringCloud_Security/blob/main/accesusers.PNG)


# Docker Image Creation
`docker build -f Dockerfile -t mydemoimage . ("." is current location)`
# Running Docker Image
`docker run -p 7070:7070 mydemoimage`
# Insted of runing commands every time we can use docker-compose
- docker-compose -f docker-compose.yml up
- docker-compose -f docker-compose.yml down