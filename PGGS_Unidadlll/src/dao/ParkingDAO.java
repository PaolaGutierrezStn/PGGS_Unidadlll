package dao;

import java.util.List;

import model.Parking;

public interface ParkingDAO {
	void createParking(Parking parking);
	Parking readParking(Long id);
	List<Parking>readAllParkings();
	void updateParking(Parking parking);
	void deleteParking(Long id);

}
