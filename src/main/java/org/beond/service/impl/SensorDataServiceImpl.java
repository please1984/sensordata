package org.beond.service.impl;

import java.util.List;
import java.util.Optional;

import org.beond.domain.SensorData;
import org.beond.domain.SensorDataFromMongo;
import org.beond.repository.SensorDataMongoRepository;
import org.beond.repository.SensorDataRepository;
import org.beond.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SensorDataServiceImpl implements SensorDataService {

	/*
	 * h2 database 조회용 jpa repository
	 */
	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	/*
	 * mongodb 조회용 repository
	 */
	@Autowired
	private SensorDataMongoRepository sensorDataMongoRepository;

	/**
	 * sensordata 전체 조회 api ( with h2database )
	 */
	@Override
	public List<SensorData> getSensorData() {
		return (List<SensorData>) sensorDataRepository.findAll();
	}

	/**
	 * sensordata 전체 조회 api ( with mongodb )
	 */
	@Override
	public List<SensorDataFromMongo> getSensorDataFromMongo() {
		return sensorDataMongoRepository.findAll();
	}

	/**
	 * sensordata 단건 조회 api ( with h2database )
	 */
	@Override
	public Optional<SensorData> getSensorData(Long id) {
		return (Optional<SensorData>) sensorDataRepository.findById(id);
	}

	/**
	 * sensordata 단건 조회 api ( with mongodb )
	 */
	@Override
	public Optional<SensorDataFromMongo> getSensorDataFromMongo(String key) {
		return sensorDataMongoRepository.findByKey(key);
	}
}
