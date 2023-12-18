# Scheduler Quartz

## Presentation link
https://docs.google.com/presentation/d/1geYipCfb-h5YofHUuaas55X-bpK-O54m/edit?usp=sharing&ouid=107454404973637699122&rtpof=true&sd=true

## Prerequisites:
- Java 17
- Docker
- Git

## How to:
1. Clone code sources  
```git clone https://github.com/dmitrypintusov/scheduler-quartz.git```
2. Start project database  
```docker-compose up -d```
3. Run Spring Boot Application with environment variables (requires SMTP configs)  
```mvn clean spring-boot:run -Drun.jvmArguments=--spring.mail.username=<SMTP user>,spring.mail.password=<SMTP password>```
