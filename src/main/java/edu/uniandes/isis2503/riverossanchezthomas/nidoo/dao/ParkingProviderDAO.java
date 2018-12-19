package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.ParkingProvider;

@Transactional
public interface ParkingProviderDAO extends MongoRepository<ParkingProvider, String> {

	public ParkingProvider findParkingProviderById(String id);
	
	public ParkingProvider findParkingProviderByEmail(String email);
	
	public List<ParkingProvider> findParkingProviderByName(String name);

	public List<ParkingProvider> findParkingProviderByPassword(String password);

	public List<ParkingProvider> findParkingProviderByNickName(String nickName);

	public ParkingProvider findParkingProviderByAccountNumber(int accountNumber);
}
