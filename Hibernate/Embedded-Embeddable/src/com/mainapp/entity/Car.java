package com.mainapp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Car {
	
	@Column(unique = true)
	private String carNo;
	private String carModel;
	
	public Car() {
		
	}

	public Car(String carNo, String carModel) {
		super();
		this.carNo = carNo;
		this.carModel = carModel;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carModel=" + carModel + "]";
	}
	
	
}
