package org.beond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot application 으로 기동
 * 
 * 센서 데이터가 nosql db 나 rdb 에 저장되어 있다고 감안하여 
 * rest api call 을 통해서 각 db 에 있는 데이터를 조회하는 코드를 작성 
 *  
 *  - application.properties 를 참조
 *  
 *  - 내부적으로 아래의 database 를 함께 기동하여 테스트가 용이하도록 설정
 *   . h2database ( rdbms 에서 센서데이터 조회 ) 
 *   . embedded mongodb ( no-sql 에서 센서데이터 조회 )
 *   
 *  - swagger ui 를 사용가능하도록 함
 *   . swagger ( api 관련 테스트  )
 *   
 * @author beond
 *
 */
@SpringBootApplication
public class SensorDataApplication {

    public static void main(String[] args) {
    	SpringApplication.run(SensorDataApplication.class, args);
    }

}
