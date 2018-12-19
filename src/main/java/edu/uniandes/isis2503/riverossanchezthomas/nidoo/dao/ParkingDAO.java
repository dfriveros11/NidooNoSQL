package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Parking;

@Transactional
public interface ParkingDAO extends MongoRepository<Parking, Long> {

	public Parking findParkingById(String id);

	public List<Parking> findParkingByName(String name);

	public List<Parking> findParkingByAddress(String address);
}
