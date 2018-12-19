package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class Parking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	/**
	 * Name of the Parking
	 */
	@NotNull
	private String name;

	/**
	 * Addres of the parking
	 */
	@NotNull
	@Size(max = 50)
	private String address;

	/**
	 * Parking provider in charge
	 */
	@JsonBackReference(value = "parkingParkingSpot")
	@DBRef(lazy = false)
	private ParkingProvider parkingProvider;

	/**
	 * List of guards
	 */
	@JsonManagedReference
	@DBRef(lazy = true)
	private List<Guard> guards;

	/**
	 * List of parking spots
	 */
	@JsonManagedReference(value = "parkingParkingSpots")
	@DBRef(lazy = true)
	private List<ParkingSpot> parkingspots;

	public Parking() {
	}

	public Parking(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 * @param address
	 * @param parkingProvider
	 * @param parkingspots
	 * @param guards
	 */
	public Parking(@NotNull String name, @NotNull String address, @NotNull ParkingProvider parkingProvider,
			List<ParkingSpot> parkingspots, List<Guard> guards) {
		super();
		this.name = name;
		this.address = address;
		this.parkingProvider = parkingProvider;
		this.parkingspots = parkingspots;
		this.guards = guards;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}

	/**
	 * @return the parkingspots
	 */
	public List<ParkingSpot> getParkingspots() {
		return parkingspots;
	}

	/**
	 * @param parkingspots the parkingspots to set
	 */
	public void setParkingspots(List<ParkingSpot> parkingspots) {
		this.parkingspots = parkingspots;
	}

	/**
	 * @return the guards
	 */
	public List<Guard> getGuards() {
		return guards;
	}

	/**
	 * @param guards the guards to set
	 */
	public void setGuards(List<Guard> guards) {
		this.guards = guards;
	}

}
