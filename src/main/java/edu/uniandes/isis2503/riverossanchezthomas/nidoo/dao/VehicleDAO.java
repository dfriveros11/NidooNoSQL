package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Vehicle;

@Transactional
public interface VehicleDAO extends MongoRepository<Vehicle, Long> {

	public Vehicle findVehicleById(String id);

	public Vehicle findVehicleByLincensePlate(String lincensePlate);

	public List<Vehicle> findVehicleByCarModel(String carModel);

	public List<Vehicle> findVehicleByCarBrand(String carBrand);
}
