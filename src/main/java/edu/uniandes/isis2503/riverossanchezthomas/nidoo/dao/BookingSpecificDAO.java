package edu.uniandes.isis2503.riverossanchezthomas.nidoo.dao;

import java.util.Date;
import java.util.List;

import edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents.Booking;

public interface BookingSpecificDAO {

	public List<Booking> findBookingByBeginDateAfter(Date beginDate);

	public List<Booking> findBookingByRangeDate(Date beginDate, Date endDate);

	public List<Booking> findBookingByEndDateBefore(Date endDate);
}
