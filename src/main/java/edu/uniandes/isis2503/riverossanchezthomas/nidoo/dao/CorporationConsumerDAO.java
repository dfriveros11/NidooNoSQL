package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.CorporationConsumer;

@Transactional
public interface CorporationConsumerDAO extends MongoRepository<CorporationConsumer, String> {
	
	public CorporationConsumer findCorporationConsumerById(String id);

	public CorporationConsumer findCorporationConsumerByEmail(String email);
	
	public List<CorporationConsumer> findCorporationConsumerByName(String name);

	public List<CorporationConsumer> findCorporationConsumerByPassword(String password);

	public List<CorporationConsumer> findCorporationConsumerByNickName(String nickName);
	
	public List<CorporationConsumer> findCorporationConsumerByRepresentant(String representant);
}
