package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class ParkingSpot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int number;

	@JsonBackReference(value = "parkingSpotsParkingProvider")
	@DBRef(lazy = false)
	private ParkingProvider parkingProvider;

	@JsonBackReference(value = "parkingParkingSpots")
	@DBRef(lazy = false)
	private Parking parking;

	@JsonManagedReference(value = "parkingSpotsBooking")
	@DBRef(lazy = true)
	private List<Booking> bookings;

	public ParkingSpot() {
	}

	public ParkingSpot(String id) {
		this.id = id;
	}

	@PersistenceConstructor
	public ParkingSpot(int number, @NotNull ParkingProvider parkingProvider, @NotNull Parking parking,
			List<Booking> bookings) {
		super();
		this.number = number;
		this.parkingProvider = parkingProvider;
		this.parking = parking;
		this.bookings = bookings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}

	/**
	 * @return the parking
	 */
	public Parking getParking() {
		return parking;
	}

	/**
	 * @param parking the parking to set
	 */
	public void setParking(Parking parking) {
		this.parking = parking;
	}

	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
