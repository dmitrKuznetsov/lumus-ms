# Lumus MicroService
This pet-project 

Features:
* Classic trio: Thin REST controllers --- Services --- JPA-repositories
* Docker-compose script for easy database starting
* Flyway migrations for creating tables and seeding initial data
* Validation of requests and informative exception description
* AOP for exception handling
* Bare OpenApi: http://localhost:8080/swagger-ui.html
* Unit and integration testing for services and repositories


## Local development

Start PostgreSQl database using docker-compose script:
```bash
docker-compose -f docker-compose-postgres.yml -p lumus-ms-postgres up -d
```


### Access to pgAdmin (to observe PostgreSQL database state)
1. Visit: http://localhost:5050/browser/
2. Login: admin@admin.com  
   Password: root
3. Register server\
   Host name: "PostgreSQL container IP"\
   Username: admin\
   Password: admin

You can get "PostgreSQL container IP" using:
```bash
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' pg_container
```

# Technological stack
- SpringBoot as a skeleton framework
- SpringBoot Web starter
- PostgreSQL database
- Flyway database migration tool
- Spring Validation
- Springdoc OpenApi
