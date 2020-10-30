package com.herbtalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents a rating posted by a user for a vendor. It maps to the
 * table "vendor_rating" in the database. It provides getters and setters for
 * the different attributes associated with the vendor rating.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "vendor_rating")
public class VendorRating {

	@Id
	@Column(name = "vendor_rating_id")
	private int vendorRatingID;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	@JsonBackReference
	private Vendor vendor;

	@Column(name = "rating")
	private int rating;

	public VendorRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorRating(int vendorRatingID, User user, Vendor vendor, int rating) {
		super();
		this.vendorRatingID = vendorRatingID;
		this.user = user;
		this.vendor = vendor;
		this.rating = rating;
	}

	public int getVendorRatingID() {
		return vendorRatingID;
	}

	public void setVendorRatingID(int vendorRatingID) {
		this.vendorRatingID = vendorRatingID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "VendorRating [vendorRatingID=" + vendorRatingID + ", user=" + user + ", vendor=" + vendor + ", rating="
				+ rating + "]";
	}
}