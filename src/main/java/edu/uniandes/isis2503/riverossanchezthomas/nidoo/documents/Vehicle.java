package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8142842788363489374L;

	@Id
	private String id;

	@Indexed(unique = true)
	@Size(max = 50)
	private String lincensePlate;

	private String carModel;

	private String carBrand;

	@JsonBackReference
	@DBRef(lazy = true)
	private ParkingConsumer parkingConsumer;

	@JsonIgnoreProperties("vehicles")
	@DBRef(lazy = true)
	private List<Booking> bookings;

	public Vehicle() {
	}

	public Vehicle(String id) {
		this.id = id;
	}

	@PersistenceConstructor
	public Vehicle(String lincensePlate, String carModel, String carBrand, ParkingConsumer parkingConsumer,
			List<Booking> bookings) {
		super();
		this.lincensePlate = lincensePlate;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.parkingConsumer = parkingConsumer;
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
	 * @return the lincensePlate
	 */
	public String getLincensePlate() {
		return lincensePlate;
	}

	/**
	 * @param lincensePlate the lincensePlate to set
	 */
	public void setLincensePlate(String lincensePlate) {
		this.lincensePlate = lincensePlate;
	}

	/**
	 * @return the carModel
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * @param carModel the carModel to set
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	/**
	 * @return the carBrand
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * @param carBrand the carBrand to set
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * @return the parkingConsumer
	 */
	public ParkingConsumer getParkingConsumer() {
		return parkingConsumer;
	}

	/**
	 * @param parkingConsumer the parkingConsumer to set
	 */
	public void setParkingConsumer(ParkingConsumer parkingConsumer) {
		this.parkingConsumer = parkingConsumer;
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

	/**
	 * @param booking
	 */
	public void addOneBooking(Booking booking) {
		bookings.add(booking);
	}

}
