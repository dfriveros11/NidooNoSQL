package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Booking;

public interface ParkingSpotSpecificDAO {

	public List<Booking> findParkingSpotWithBookingInDate(@Param("date") Date date);

}
