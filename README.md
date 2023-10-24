# spring-eureka-rabbitmq-microservices

In this project, I am honing my Java/Spring microservices skills by communicating fraud detection, customer and notification microservices with RabbitMQ, Eureka Service Discovery, Spring Cloud OpenFeign, Web MVC, Postgres and many many more. 

Start date is 20.10.2023. My aims for the next iterations are:

- Enable Kafka or RabbitMQ for async communication with the notifications service - DONE!
- Enable distributed tracing - NEXT TODO // using Zipkin and Micrometer
- Migrate current Eureka architecture to Kubernetes / Linode.

Following N-tier, layered architecture for a clean architecture throughout the repository.

# Updates after each iteration

21.10 -> Switched from RestTemplate to **OpenFeign** for better communication between services.  
22.10 -> Successfully implemented **Spring Cloud Gateway** as an entry point to all microservices. All necessary routing is done from here.  
24.10 -> **Successfully implemented RabbitMQ** exchange, binding and queues. Async communication is obtained between Customer and Notification services.
