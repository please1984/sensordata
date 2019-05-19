package org.beond.controller;

import java.util.List;
import java.util.Optional;

import org.beond.domain.SensorData;
import org.beond.domain.SensorDataFromMongo;
import org.beond.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * sensor 데이터 조회를 위한 rest controller 정의
 * @author beond
 *
 */
@RestController
@RequestMapping("/api")
public class SensorController {
	
	/**
	 * Sensor Data 조회 서비스 
	 */
	@Autowired
	private SensorDataService sensorDataService;
    
	/**
	 * sensordata 전체 조회 api ( with h2database )
	 * @return
	 */
    @RequestMapping(value = "/sensordatas", method = RequestMethod.GET)
    public List<SensorData> getSensorData() {
        return sensorDataService.getSensorData();
    }

	/**
	 * sensordata 단건 조회 api ( with h2database )
	 * @return
	 */
    @RequestMapping(value = "/sensordatas/{id}", method = RequestMethod.GET)
    public Optional<SensorData> getSensorData(@PathVariable(name = "id") Long id) {
        return sensorDataService.getSensorData(id);
    }
    
    /**
	 * sensordata 전체 조회 api ( with mongodb )
	 * @return
	 */
    @RequestMapping(value = "/mongosensordatas", method = RequestMethod.GET)
    public List<SensorDataFromMongo> getSensorDataFromMongo() {
        return sensorDataService.getSensorDataFromMongo();
    }
    
    /**
	 * sensordata 단건 조회 api ( with mongodb )
	 * @return
	 */
    @RequestMapping(value = "/mongosensordatas/{key}", method = RequestMethod.GET)
    public Optional<SensorDataFromMongo> getSensorDataFromMongo(@PathVariable(name = "key") String key) {
        return sensorDataService.getSensorDataFromMongo(key);
    }

}