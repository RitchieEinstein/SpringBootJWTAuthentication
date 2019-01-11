package com.ritchieeinstein.spring.jwtdemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mobile {
	
	private int mobileId;
	private String modelName;
	private String manufacturer;
	
	public Mobile(int mobileId, String modelName, String manufacturer) {
		this.mobileId = mobileId;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
	}
	
	public Mobile() {
		
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	

}
