package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Bill;

@Transactional
public interface BillDAO extends MongoRepository<Bill, Long> {

	public Bill findBillById(String id);

	public List<Bill> findBillByCreationDate(Date creationDate);

	public List<Bill> findBillByTotalPrice(Double totalPrice);

}
