package edu.uniandes.isis2503.riverossanchezthomas.nidoo.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Refund implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of the refund
	 */
	@Id
	private String id;

	/**
	 * Description of the refund
	 */
	private String description;

	/**
	 * Date of the creation of the refund
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creationDate;

	@JsonBackReference(value = "billRefund")
	@DBRef(lazy = true)
	private Bill bill;

	public Refund() {
	}

	/**
	 * 
	 * @param id
	 */
	public Refund(String id) {
		super();
		this.id = id;
	}

	/**
	 * Constructor of the refund
	 * 
	 * @param description
	 */
	@PersistenceConstructor
	public Refund(String description, Date creationDate, Bill bill) {
		super();
		this.description = description;
		this.creationDate = creationDate;
		this.bill = bill;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
