package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao.implementation;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao.ParkingSpotSpecificDAO;
import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Booking;

public class ParkingSpotSpecificDAOImpl implements ParkingSpotSpecificDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Booking> findParkingSpotWithBookingInDate(Date date) {
		Query query = new Query();
		query.addCriteria(
				Criteria.where("bookings.beginDate").gt(date).andOperator(Criteria.where("bookings.endDate").lt(date)));
		return mongoTemplate.find(query, Booking.class);
	}
}
