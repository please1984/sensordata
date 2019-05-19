=========

## Sensor Data 조회 프로젝트 
Sensor Data 가 RDB 나 No-SQL database 에 저장이 되어 있다는 가정하에 해당 데이터를 조회해 오는 샘플 프로젝트

## 사용 Opensource
- Springboot
- Springboot JPA
- Springboot Mongodb
- h2 database
- embedded mongodb
- Swagger

## Database 설정 관련 참조
- h2database 같은 경우 in-memory 로 springBoot Application 기동시 같이 기동이 되며 관련 설정은 application.properties 설정을 따른다.
-- SensorData 소스 Entity 설정을 참조하여 기동시에 table schema 를 생성
-- resource 폴더 내에 data.sql 을 통해 springboot Application 기동시 초기 데이터를 적재 
- embedded mongodb 의 경우 Springboot Application 기동시 별도의 프로세스로 기동되며 관련 설정은 MongoConfig 를 참조한다.
-- MongoConfig 소스 내에  관련 MongoClient 생성 및 초기 데이터 적재 로직을 통해 초기 데이터 적재