package org.beond.repository;

import java.util.Optional;

import org.beond.domain.SensorDataFromMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * mongodb 내 sensor_data collection 조회하는 repository
 * 기본적으로 findAll / findById 등의 기본 method 를 제공
 * @author beond
 *
 */
public interface SensorDataMongoRepository  extends MongoRepository<SensorDataFromMongo, String> {

	/**
	 * key 값을 이용한 단건 조회 ( findBy + 컬럼네임 )
	 * @param key
	 * @return
	 */
	Optional<SensorDataFromMongo> findByKey(String key);

}
