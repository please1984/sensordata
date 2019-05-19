package org.beond.domain;

import org.springframework.data.mongodb.core.mapping.Document;
/*
 * mongodb 내 sensor_data 컬렉션 과 매핑됨
 */
@Document(collection="sensor_data")
public class SensorDataFromMongo {
	private String key;
	private String data;
	
	public SensorDataFromMongo() {
		
	}


	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
