package org.beond.repository;

import org.beond.domain.SensorData;
import org.springframework.data.repository.CrudRepository;

/**
 * h2 database 내 sensor_data 테이블 조회하는 repository ( JPA )
 * 기본적으로 findAll / findById 등의 기본 method 를 제공
 * @author beond
 *
 */
public interface SensorDataRepository  extends CrudRepository<SensorData, Long> {

}
