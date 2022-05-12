package entity;

public class Vehicles {
private int carId;
private String make;
private String model;
private int year;

public Vehicles() {
	
}
public Vehicles (int carId, String make, String model, int year) {
	this.setCarId(carId);
	this.setMake(make);
	this.setModel(model);
	this.setYear(year);
	}

public int getCarId() {
	return carId;
}

public void setCarId(int carId) {
	this.carId = carId;
}

public String getMake() {
	return make;
}

public void setMake(String make) {
	this.make = make;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public void addCar(String make, String model, int year) {
	this.make = make;
	this.model = model;
	this.year = year;
}

}
