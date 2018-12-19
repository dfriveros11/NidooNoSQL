package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.ParkingConsumer;

@Transactional
public interface ParkingConsumerDAO extends MongoRepository<ParkingConsumer, String> {
	
	public ParkingConsumer findParkingConsumerById(String id);

	public ParkingConsumer findParkingConsumerByEmail(String email);
	
	public List<ParkingConsumer> findParkingConsumerByName(String name);

	public List<ParkingConsumer> findParkingConsumerByPassword(String password);

	public List<ParkingConsumer> findParkingConsumerByNickName(String nickName);

	public ParkingConsumer findParkingConsumerByCreditCard(int creditcard);
}
