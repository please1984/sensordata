package org.beond.service;

import java.util.List;
import java.util.Optional;

import org.beond.domain.SensorData;
import org.beond.domain.SensorDataFromMongo;

public interface SensorDataService {
	/**
	 * sensordata 전체 조회 api ( with h2database )
	 */
	public List<SensorData> getSensorData();
	/**
	 * sensordata 단건 조회 api ( with h2database )
	 */
	public Optional<SensorData> getSensorData(Long id);

	/**
	 * sensordata 전체 조회 api ( with mongodb )
	 */
	public List<SensorDataFromMongo> getSensorDataFromMongo();
	/**
	 * sensordata 단건 조회 api ( with mongodb )
	 */
	public Optional<SensorDataFromMongo> getSensorDataFromMongo(String key);
}
