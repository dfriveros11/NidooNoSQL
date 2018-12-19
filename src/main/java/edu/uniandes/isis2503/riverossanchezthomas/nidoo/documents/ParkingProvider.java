package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class ParkingProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1881745545916460501L;

	
	@Id
	private String id;

	@NotNull
	private String name;

	@NotNull
	private String password;

	@NotNull
	private String nickName;

	@NotNull
	@Indexed(unique = true)
	@Size(max = 50)
	private String email;
	
	/**
	 * Account numbre of the parking provider
	 */
	@Indexed(unique = true)
	private int accountNumber;

	@JsonManagedReference(value = "parkingSpotsParkingProvider")
	@DBRef(lazy = true)
	private List<ParkingSpot> parkingspots;

	@JsonManagedReference(value = "parkingParkingSpot")
	@DBRef(lazy = true)
	private List<Parking> parkings;

	@JsonManagedReference(value = "ParkningProviderbookings")
	@DBRef(lazy = true)
	private List<Booking> bookings;

	public ParkingProvider() {
	}

	public ParkingProvider(String id) {
		this.id = id;
	}

	@PersistenceConstructor
	public ParkingProvider(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int accountNumber, List<ParkingSpot> parkingspots, List<Parking> parkings,
			List<Booking> bookings) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.accountNumber = accountNumber;
		this.parkingspots = parkingspots;
		this.parkings = parkings;
		this.bookings = bookings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<ParkingSpot> getParkingspots() {
		return parkingspots;
	}

	public void setParkingspots(List<ParkingSpot> parkingspots) {
		this.parkingspots = parkingspots;
	}

	public List<Parking> getParkings() {
		return parkings;
	}

	public void setParkings(List<Parking> parkings) {
		this.parkings = parkings;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
