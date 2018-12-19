package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Booking;

@Transactional
public interface BookingDAO extends MongoRepository<Booking, Long>, BookingSpecificDAO {

	public Booking findBookingById(String id);

	public List<Booking> findBookingByBeginDate(Date begindate);

	@Query("{ 'endDate' : { $regex: ?0 } }")
	public List<Booking> findBookingByEndDate(Date endDate);

}
