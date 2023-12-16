# SpringBoot_MicroService_SpringCloud_Security

# Swagger URL 

host:port/swagger-ui.html#/

Ex: http://localhost:8080/swagger-ui.html#/


# Spring Security Oauth need Roles, Insert below roles Before creating Users

- insert into roles values(1,'ROLE_USER');
- insert into roles values(2,'ROLE_ADMIN');
# To Access Resource we need authenticate, So we can generate toke like below

![token generate/ user login ](https://github.com/HarshaPrimeTrainings/SpringBoot_MicroService_SpringCloud_Security/blob/main/tokengenerate.PNG)