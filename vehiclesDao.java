package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Vehicles;

public class vehiclesDao {
	private Connection connection;
	private final String GET_VEHICLES_QUERY = "SELECT * FROM cars";
	private final String GET_CARS_BY_ID_QUERY = "SELECT * FROM cars WHERE carId = ?";
	private final String ADD_NEW_CAR_QUERY = "INSERT INTO cars(make, model, year) VALUES (?, ?, ?)";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM cars WHERE carId = ?";
	private final String UPDATE_CAR_BY_ID_QUERY = "UPDATE cars SET make = ?,  model = ?,  year = ? WHERE carID = ?";
	
	public vehiclesDao() {
		connection = dbConnection.getConnection();
	}
		public List<Vehicles> displayVehicles() throws SQLException {
			ResultSet rs = connection.prepareStatement(GET_VEHICLES_QUERY).executeQuery();
			List<Vehicles> cars = new ArrayList<Vehicles>();
			
			while (rs.next()) {
				cars.add(populateVehicles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			} return cars;
		}
		
		private Vehicles populateVehicles(int carId, String make, String model, int year) throws SQLException {
			return new Vehicles(carId, make, model, year);
		}
		
		public Vehicles getCarById(int carId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(GET_CARS_BY_ID_QUERY);
			ps.setInt(1,  carId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return populateVehicles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		public void addCar(String make, String model, int year) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(ADD_NEW_CAR_QUERY);
			ps.setString(1,  make);
			ps.setString(2,  model);
			ps.setInt(3,  year);
			ps.executeUpdate();
		}
		public void deleteCarById(int carId)  throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
			ps.setInt(1, carId);
			ps.executeUpdate();
		}
		public void updateCarById(int carId, String make, String model, int year) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_BY_ID_QUERY);
			ps.setString(1,  make);
			ps.setString(2, model);
			ps.setInt(3, year);
			ps.setInt(4, carId);
			ps.executeUpdate();
		}
	}


