package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Parking;

public class ParkingDAOImpl implements ParkingDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ParkingDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/parking", "postgres", "lobomalo7");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createParking(Parking parking) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO parking (type, num_cars, company)values (?,?,?);");
			preparedStatement.setString(1,parking.getType());
			preparedStatement.setInt(2,parking.getNum_cars());
			preparedStatement.setString(3,parking.getCompany());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Parking readParking(Long id) {
		Parking parking = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM parking WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					parking = new Parking(resultSet.getLong(1), resultSet.getString(2).trim(), resultSet.getInt(3),
											resultSet.getString(4).trim());
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return parking;
	}

	@Override
	public List<Parking> readAllParkings() {
		List<Parking> parkings = new ArrayList<Parking>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT * FROM parking");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Parking parking = new Parking(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getInt(3),
									resultSet.getString(4));
					parkings.add(parking);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return parkings;
	}

	@Override
	public void updateParking(Parking parking) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE parking SET type=?," + "num_cars=?," + "company=? WHERE id=?;");
				preparedStatement.setString(1,parking.getType() );
				preparedStatement.setInt(2,parking.getNum_cars() );
				preparedStatement.setString(3,parking.getCompany());
				preparedStatement.setLong(4, parking.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteParking(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM parking WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}

}
