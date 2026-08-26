package com.mainapp;

public class Car {
	
	int carNo;
	String carName;
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int carNo,String carName){
		this.carNo=carNo;
		this.carName=carName;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carName=" + carName + "]";
	}
	
	
}
