package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Refund;

@Transactional
public interface RefundDAO extends MongoRepository<Refund, Long> {

	public Refund findRefundById(String id);

	public List<Refund> findRefundByDescription(String description);

	public List<Refund> findRefundByCreationDate(Date creationDate);
}
