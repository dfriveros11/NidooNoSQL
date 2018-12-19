package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.ParkingSpot;

@Transactional
public interface ParkingSpotDAO extends MongoRepository<ParkingSpot, String>, ParkingSpotSpecificDAO {

	public ParkingSpot findParkingSpotById(String id);

	public List<ParkingSpot> findParkingSpotByNumber(int number);
}
