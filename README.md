# Docker Compose + Kafka + Spring Boot
![banner](./assets/banner.jpg)

## Overview
This project aims to be a reference for those just starting to work with Java and SpringBoot in which there is a need to build an inner communication between microservices through events via Kafka. To speed up the setup of the development environment, a dockercompose is provided to provision the necessary infrastructure, i.e. Kafka and Zookeeper. **Be aware of the proposed infrastructure is suitable for development and not for production operation.**
## Prerequisites

- Maven 3+
- Java 8+
- Docker 19.03+ 


## Preparing Environment

From the project's folder, execute:
to initialize Kafka and Zookeeper
````bash 
docker-compose up -d
````
to build the applications
````bash 
mvn package
````

## Booting Applications

- Initializing the `producer`
````bash
$ cd producer
$ mvn spring-boot:run
````
**Note:** The `producer` will be accepting request at `http://localhost:8080/orders`


- Initializing the `consumer`
````bash
$ cd consumer
$ mvn spring-boot:run
````
**Note:** The `consumer` has no endpoint, it just connects to the Kafka to listen to the stream events.


## Testing 

With both `consumer` and `producer` applications up and running, let's test their integration through Kafka:
````bash
$ curl -d "{'idorder': '1234', 'customer': 'Foo Bar', 'value': 4321}" \
-H "Content-Type: application/json" \
-X POST http://127.0.0.1:8080/orders
````

If the above request works, we should see a log in the `producer` application's console that looks like the following:
````
2021-07-07 06:23:26.433  INFO 2336 --- [ad | producer-1] b.c.d.producer.config.KafkaConfig        : ACK from ProducerListener message: {"idorder": "12345", "customer": "Foo Bar", "value": 54321} offset:  0
````
and something like in the `consumer` application's console:
````
2021-07-07 06:23:26.490  INFO 3996 --- [ntainer#0-0-C-1] b.c.d.consumer.kafka.KafkaConsumer       : Order: {"idorder": "12345", "customer": "Foo Bar", "value": 54321}
````


## Cleaning Up
After playing around, we need to clean up the mess.. So from the project's folder, do:
<ol>
<li>Stop the containers using the following command:</li>
  <code>docker-compose down</code>
<li>Delete all containers using the following command:</li>
  <code>docker rm -f $(docker ps -a -q)</code>
</ol> 
