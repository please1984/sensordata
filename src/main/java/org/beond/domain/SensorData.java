package org.beond.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * h2 database 내 sensor_data 테이블 과 매핑됨
 */
@Entity(name="sensor_data")
public class SensorData {
	/*
	 * id 컬럼으로 정의 
	 */
	@Id
	@Column(nullable = false, unique=true)
    private Long id;
	@Column(nullable = false)
	private String key;
	@Column(nullable = false)
	private String type;
	@Column(nullable = true)
	private String data;
	
	public SensorData() {
		
	}
	
	public SensorData(Long id, String key, String type, String data) {
		this.id = id;
		this.key = key;
		this.type = type;
		this.data = data;
    }
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
