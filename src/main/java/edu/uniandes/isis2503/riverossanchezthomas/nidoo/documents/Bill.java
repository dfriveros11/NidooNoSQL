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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Document
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id of the Bill
	 */
	@Id
	private String id;

	/**
	 * Creation date of the bill
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Indexed(direction = IndexDirection.ASCENDING)
	private Date creationDate;

	/**
	 * Total price of the Bill
	 */
	private Double totalPrice;

	/**
	 * The refund of the booking
	 */
	@JsonManagedReference(value = "billRefund")
	@DBRef(lazy = true)
	private List<Refund> refunds;

	/**
	 * the booking of the bill
	 */
	@JsonBackReference(value = "bookingBill")
	@DBRef(lazy = false)
	private Booking booking;

	public Bill() {
	}

	/**
	 * 
	 * @param id
	 */
	public Bill(String id) {
		super();
		this.id = id;
	}

	@PersistenceConstructor
	public Bill(Double totalPrice, Date creationDate, List<Refund> refunds, Booking booking) {
		super();
		this.totalPrice = totalPrice;
		this.creationDate = creationDate;
		this.booking = booking;
		this.refunds = refunds;
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
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the refunds
	 */
	public List<Refund> getRefunds() {
		return refunds;
	}

	/**
	 * @param refunds the refunds to set
	 */
	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
