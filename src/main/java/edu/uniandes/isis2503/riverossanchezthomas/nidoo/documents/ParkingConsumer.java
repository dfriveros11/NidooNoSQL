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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class ParkingConsumer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 277595069729619742L;

	
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
	
	@Indexed(unique = true)
	private int creditCard;

	@JsonBackReference
	@DBRef(lazy = true)
	private CorporationConsumer corporativeConsumer;

	@JsonManagedReference
	@DBRef(lazy = true)
	private List<Vehicle> vehicles;

	public ParkingConsumer() {
	}

	public ParkingConsumer(String id) {
		this.id=id;
	}

	@PersistenceConstructor
	public ParkingConsumer(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int creditCard, List<Vehicle> vehicles, CorporationConsumer corporativeConsumer) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.creditCard = creditCard;
		this.vehicles = vehicles;
		this.corporativeConsumer = corporativeConsumer;
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

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the corporativeConsumer
	 */
	public CorporationConsumer getCorporativeConsumer() {
		return corporativeConsumer;
	}

	/**
	 * @param corporativeConsumer the corporativeConsumer to set
	 */
	public void setCorporativeConsumer(CorporationConsumer corporativeConsumer) {
		this.corporativeConsumer = corporativeConsumer;
	}

}
