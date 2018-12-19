package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao.BookingSpecificDAO;
import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Booking;

public class BookingSpecificDAOImpl implements BookingSpecificDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Booking> findBookingByBeginDateAfter(Date beginDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("beginDate").gt(beginDate)).with(new Sort(Sort.Direction.ASC));
		return mongoTemplate.find(query, Booking.class);
	}

	@Override
	public List<Booking> findBookingByRangeDate(Date beginDate, Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("beginDate").gt(beginDate).and("endDate").lt(endDate));
		return mongoTemplate.find(query, Booking.class);
	}

	@Override
	public List<Booking> findBookingByEndDateBefore(Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("endDate").lt(endDate)).with(new Sort(Sort.Direction.ASC));
		return mongoTemplate.find(query, Booking.class);
	}

}
