# microservices_app
General purpose microservice architecture for modern web application.

## Technologies
### Frontend
* Jquery
* Sass
* NPM: Package manager
* Nginx: Serving statics files, reverse proxy for backend, load balancing
### Backend
* Spring Boot: Basic framework
* Mybatis: Persistence framework
* Redis: Caching
* Netflix Eureka: Load balancing
* Netflix Zuul: API gateway
* Flask
### DB
* MySQL
### Devops
* Docker
* Docker compose

![Alt](microservices_architecture.png)

## Set up
* Install docker and docker compose
* Under `/microservices_app` directory, run `sudo docker-compose up` to build all docker images and run containers.