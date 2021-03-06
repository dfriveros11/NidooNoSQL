package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Guard;

@Transactional
public interface GuardDAO extends MongoRepository<Guard, Long> {
	
	public Guard findGuardById(String id);

	public Guard findGuardByEmail(String email);

	public List<Guard> findGuardByPhone(int phone);
}
