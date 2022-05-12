package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.Vehicles;


public class Menu {
	private dao.vehiclesDao vehiclesDao = new dao.vehiclesDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> selections = Arrays.asList(
			"Display Vehicles", 
			"View a Car", 
			"Add a Car", 
			"Update Car Information", 
			"Delete a Car");
	
	public void start() throws SQLException {
		String selection = " ";
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				displayVehicles();
			} else if (selection.equals("2")) {
				displayCar();
			} else if (selection.equals("3")) {
				addCar();
			} else if (selection.equals("4")) {
				updateCar();
			} else if (selection.equals("5")) {
				deleteCar();
			} System.out.println("Press enter to continue..");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Please make a selection: \n -------------");
		for(int i = 0; i < selections.size(); i++) {
			System.out.println(i + 1 + ") " + selections.get(i));
		}
	}
	
	private void displayVehicles() throws SQLException {
		List<Vehicles> cars = vehiclesDao.displayVehicles();
		for(Vehicles x : cars) {
			System.out.println("Car ID: " + x.getCarId() + "\n" + "Car MAKE: " + x.getMake() + "\n" +
					"Car MODEL: " + x.getModel() + "\n" + "Car YEAR: "+ x.getYear());
			System.out.println("---------------------------");
		}
	}
	
	private void displayCar() throws SQLException {
		System.out.print("Enter Car Id: ");
		int carId = Integer.parseInt(scanner.nextLine());
		Vehicles car = vehiclesDao.getCarById(carId);
		System.out.println("Car ID: " + car.getCarId() + "\n" + "Car MAKE: " + car.getMake()
		+ "\n" + "Car MODEL: " + car.getModel() + "\n" + "Car YEAR: " + car.getYear());
	}
	
	private void addCar() throws SQLException {
		System.out.println("Enter new car make: ");
		String make = scanner.nextLine();
	
		System.out.println("Enter new car model: ");
		String model = scanner.nextLine();
		
		System.out.println("Enter new car year: ");
		int year = Integer.parseInt(scanner.nextLine());
		vehiclesDao.addCar(make, model, year);
	
	}
	
	private void deleteCar() throws SQLException {
		System.out.print("Enter the ID for the car you wish to delete: ");
		int carId = Integer.parseInt(scanner.nextLine());
		vehiclesDao.deleteCarById(carId);
	}
	
	private void updateCar() throws SQLException {
		System.out.print("Enter the ID of the car you wish to update: ");
		int carId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the updated car MAKE: ");
		String make = scanner.nextLine();
		System.out.print("Enter the updated car MODEL: ");
		String model = scanner.nextLine();
		System.out.print("Enter the updated car YEAR: ");
		int year = Integer.parseInt(scanner.nextLine());
		vehiclesDao.updateCarById(carId, make, model, year);
	}

}
