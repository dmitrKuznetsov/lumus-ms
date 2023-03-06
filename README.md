# Lumus MicroService
This RESTful app provides only one end-point for getting information about LED:\
GET http://localhost:8080/led/barcode/{barcode} \
(For example, barcode = 8680168583151)
```
{
   "image": "https://lamptest.ru/images/photo/00233-vitoone-1510590.jpg",
   "model": "1510590",
   "brand": "Vitoone",
   "rating": 3.0,
   "life": 25000,
   "price": 159.0,
   "voltage": "220-240",
   "temp": {
      "declared": 2700,
      "measured": 2971
   },
   "brightness": {
      "declared": 500,
      "measured": 485
   },
   "power": {
      "declared": 8.0,
      "measured": 6.2
   }
}
```

Features:
* Job for downloading CSV file from [URL](http://lamptest.ru/led.csv) to database
* Classic trio: Thin REST controllers --- Services --- JPA-repositories
* Docker-compose script for easy database starting
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
- Commons CSV
