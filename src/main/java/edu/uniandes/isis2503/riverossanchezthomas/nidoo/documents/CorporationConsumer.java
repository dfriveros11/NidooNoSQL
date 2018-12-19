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

/**
 * @author TDJ
 */
@Document
public class CorporationConsumer implements Serializable {
	/**
	 * Serial number
	 */
	private static final long serialVersionUID = -6426445484352143044L;

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
	 * Name of the representant of the Corporation
	 */
	private String representant;

	/**
	 * Consumers of a company
	 */
	@JsonManagedReference
	@DBRef(lazy = true)
	private List<ParkingConsumer> parkingConsumers;

	/**
	 * 
	 */
	public CorporationConsumer() {
	}

	/**
	 * Constructor for the PK that it´s the id
	 * 
	 * @param id
	 */
	public CorporationConsumer(String id) {
		this.id=id;
	}

	/**
	 * Constructor of the class Corporation Consumer
	 * 
	 * @param name
	 * @param password
	 * @param nickName
	 * @param email
	 */
	@PersistenceConstructor
	public CorporationConsumer(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, String representant, List<ParkingConsumer> parkingConsumer) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.representant = representant;
		this.parkingConsumers = parkingConsumer;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the representant
	 */
	public String getRepresentant() {
		return representant;
	}

	/**
	 * @param representant the representant to set
	 */
	public void setRepresentant(String representant) {
		this.representant = representant;
	}

	/**
	 * @return the consumers
	 */
	public List<ParkingConsumer> getParkingConsumers() {
		return parkingConsumers;
	}

	/**
	 * @param consumers the consumers to set
	 */
	public void setParkingConsumers(List<ParkingConsumer> parkingConsumers) {
		this.parkingConsumers = parkingConsumers;
	}
}
