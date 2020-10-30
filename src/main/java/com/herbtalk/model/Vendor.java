package com.herbtalk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.herbtalk.util.EncryptionUtil;

/**
 * This class represents a vendor of strains. It maps to the table "vendor" in
 * the database. It provides getters and setters for the different attributes
 * associated with the vendor.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	private int vendorId;

	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "contact")
	private String contact;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@JsonManagedReference
	private Address address;

	@ManyToMany
	@JoinTable(name = "strain_sold", joinColumns = @JoinColumn(name = "vendor_id"), inverseJoinColumns = @JoinColumn(name = "strain_id"))
	@JsonManagedReference
	private Set<Strain> strainsSold;

	@OneToMany(mappedBy = "vendor")
	@JsonManagedReference
	private Set<VendorRating> ratings;

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(int vendorId, String vendorName, String contact, Address address, Set<Strain> strainsSold,
			Set<VendorRating> ratings, String password) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.contact = contact;
		this.address = address;
		this.strainsSold = strainsSold;
		this.ratings = ratings;
		this.password = password;
	}

	public int getvendorId() {
		return vendorId;
	}

	public void setvendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Strain> getStrainsSold() {
		return strainsSold;
	}

	public void setStrainsSold(Set<Strain> strainsSold) {
		this.strainsSold = strainsSold;
	}

	public Set<VendorRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<VendorRating> ratings) {
		this.ratings = ratings;
	}

	public void setPassword(String password) {
		try {
			this.password = EncryptionUtil.encrypt(password, "blowfish");
		} catch (Exception e) {
			e.printStackTrace();
			this.password = "";
		}
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", contact=" + contact + ", address="
				+ address + ", strainsSold=" + strainsSold + ", ratings=" + ratings + "]";
	}

}
