package dao;

import java.util.List;

import model.Parking;

public class TestConnection {
	public static void main(String[] args) {
		ParkingDAOImpl parkingDAOImpl = new ParkingDAOImpl();
		parkingDAOImpl.createParking(new Parking(6L, "Estacionamiento",50,"Santana"));
		
		List<Parking> parkings = parkingDAOImpl.readAllParkings();
		for (Parking parking : parkings) {
			System.out.println(parking);
			
		}
	}

}