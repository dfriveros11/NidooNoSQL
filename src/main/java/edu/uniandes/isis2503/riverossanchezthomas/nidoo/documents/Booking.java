package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of the booking
	 */
	@Id
	private String id;

	/**
	 * Beginning date of the boking
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Indexed(direction = IndexDirection.ASCENDING)
	private Date beginDate;

	/**
	 * End dato of the booking
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Indexed(direction = IndexDirection.ASCENDING)
	private Date endDate;

	/**
	 * The parking spot of the booking
	 */
	@JsonBackReference(value = "parkingSpotsBooking")
	@DBRef(lazy = false)
	private ParkingSpot parkingSpot;

	/**
	 * The guard responsible of the booking
	 */
	@JsonBackReference(value = "guardBooking")
	@DBRef(lazy = false)
	private Guard guard;

	/**
	 * The parking provider responsible of the booking
	 */
	@JsonBackReference(value = "ParkningProviderbookings")
	@DBRef(lazy = false)
	private ParkingProvider parkingProvider;

	/**
	 * The bill of the booking
	 */
	@JsonManagedReference(value = "bookingBill")
	@DBRef(lazy = true)
	private List<Bill> bills;

	@JsonIgnoreProperties("bookings")
	@DBRef(lazy = true)
	private List<Vehicle> vehicles;

	public Booking() {
	}

	public Booking(String id) {
		this.id = id;
	}

	@PersistenceConstructor
	public Booking(Date endDate, ParkingProvider parkingProvider, Date beginDate, ParkingSpot parkingSpot, Guard guard,
			List<Bill> bill, List<Vehicle> vehicles) {
		super();
		this.endDate = endDate;
		this.beginDate = beginDate;
		this.parkingProvider = parkingProvider;
		this.parkingSpot = parkingSpot;
		this.guard = guard;
		this.bills = bill;
		this.vehicles = vehicles;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the parkingProvider
	 */
	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	/**
	 * @param parkingProvider the parkingProvider to set
	 */
	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}

	/**
	 * @return the parkingSpot
	 */
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	/**
	 * @param parkingSpot the parkingSpot to set
	 */
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	/**
	 * @return the guard
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * @param guard the guard to set
	 */
	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	/**
	 * @return the bill
	 */
	public List<Bill> getBills() {
		return bills;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBills(List<Bill> bill) {
		this.bills = bill;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @param vehicle
	 */
	public void addOneVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
}
