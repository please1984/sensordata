package org.beond.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

/**
 * MongoRepository 를 사용하기 위한 mongoClient 및 db name 설정 부분
 * @author beond
 *
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	// EMBEDDED MONGO DB host 명 
    private static final String MONGO_DB_URL = "localhost";

    // EMBEDDED MONGO DB db 명
    private static final String MONGO_DB_NAME = "embeded_db";
    
    // MONGODB Client  
    private MongoClient mongoClient;
    
    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
    	
    	// spring boot application 이 기동될 떄 
    	// embedded mongo db 가 자동으로 같이 기동 되며
    	// 해당 mongo db 의 client 를 생성하는 코드 
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        MongoClient mongoClient = mongo.getObject();                
        this.mongoClient = mongoClient;
        
        // mongo db 로 접근하기 위하여 mongoTemplate 을 생성 
        // ( 참고 ) 현재 프로젝트 내에선 mongoTemplate 를 직접 사용 하는 부분은 없음 -> MongoRepository 사용
        // ( 예제 ) mongoTemplate 사용 예제
        //         xxx xxx = mongoTemplate.findAll(xxx.class, "collectionName"); 
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
        
        
        // mongo db 내 테스트 데이터 적재 로직 
        // 테스트 데이터 양식 
        // ex ) { "key" : "key-0", "data" : "data-0" }
        DB db = mongoClient.getDB(MONGO_DB_NAME);        
        DBCollection collection = db.createCollection("sensor_data", new BasicDBObject());
        for(int i = 0; i < 4 ; i++ ) {
        	collection.save(new BasicDBObject("key", "key-" + i).append("data", "data-" + i));
        }
        
        return mongoTemplate;
    }
    
    // MongoRepository 용 mongoClient
    @Override
    public MongoClient mongoClient() {
        return this.mongoClient;
    }

    // MongoRepository 용 mongo db database name
    @Override
    protected String getDatabaseName() {
        return MONGO_DB_NAME;
    }
}
