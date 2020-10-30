package com.herbtalk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents the address of a vendor. It maps to the "address" table
 * in the database. It provides getters and setters for the different attributes
 * associated with the addresses.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int addressID;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@OneToMany(mappedBy = "address")
	@JsonBackReference
	private Set<Vendor> vendor;

	/**
	 * Default constructor.
	 */
	public Address() {
		super();
	}

	/**
	 * Constructs the address with the specified parameters.
	 * 
	 * @param addressID ID of the address
	 * @param street    street of the address
	 * @param city      city of the address
	 * @param state     state of the address
	 * @param vendor    set of vendors located at this address
	 */
	public Address(int addressID, String street, String city, String state, Set<Vendor> vendor) {
		super();
		this.addressID = addressID;
		this.street = street;
		this.city = city;
		this.state = state;
		this.vendor = vendor;
	}

	/**
	 * Get address ID.
	 * 
	 * @return address ID
	 */
	public int getAddressID() {
		return addressID;
	}

	/**
	 * Set address ID.
	 * 
	 * @param addressID id of the address
	 */
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	/**
	 * Get the street associated with the address.
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Get the city associated with the address.
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the state associated with the address.
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get set of vendors located at the address.
	 * 
	 * @return set of vendors
	 */
	public Set<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", vendor=" + vendor + "]";
	}
}