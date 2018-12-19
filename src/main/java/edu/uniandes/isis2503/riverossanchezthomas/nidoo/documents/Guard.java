package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author TDJ
 */
@Document
public class Guard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of the Guard
	 */
	@Id
	private String id;

	/**
	 * Email of the guard
	 */
	@Indexed(unique = true)
	private String email;

	/**
	 * phone of the guard
	 */
	private int phone;

	/**
	 * Parking that is under the care of the guard
	 */
	@JsonBackReference
	@DBRef(lazy = true)
	private Parking parking;

	@JsonManagedReference(value = "guardBooking")
	@DBRef(lazy = false)
	private List<Booking> bookings;

	public Guard() {
	}

	public Guard(String id) {
		this.id = id;
	}

	/**
	 * Constructor of the Guard
	 * 
	 * @param email
	 * @param phone
	 * @param parking
	 */
	@PersistenceConstructor
	public Guard(String email, int phone, @NotNull Parking parking, List<Booking> bookings) {
		super();
		this.email = email;
		this.phone = phone;
		this.parking = parking;
		this.bookings = bookings;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the parkingG
	 */
	public Parking getParking() {
		return parking;
	}

	/**
	 * @param parkingG the parkingG to set
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
