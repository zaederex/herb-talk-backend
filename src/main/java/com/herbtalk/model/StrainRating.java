package com.herbtalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents a rating posted by a user for a strain. It maps to the
 * table "strain_rating" in the database. It provides getters and setters for
 * the different attributes associated with the likes.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "strain_rating")
public class StrainRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "strain_rating_id")
	private Integer strainRatingId;

	@ManyToOne
	@JoinColumn(name = "strain_id")
	@JsonBackReference
	private Strain strain;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	@OneToOne
	@JoinColumn(name = "strain_use_id", referencedColumnName = "strain_use_id")
	@JsonBackReference
	private StrainUse strainUse;

	@Column(name = "rating")
	private Integer rating;

	public StrainRating() {
		super();
	}

	public StrainRating(Integer strainRatingId, Strain strain, User user, int rating, StrainUse strainUse) {
		super();
		this.strainRatingId = strainRatingId;
		this.strain = strain;
		this.user = user;
		this.rating = rating;
		this.strainUse = strainUse;
	}

	public Integer getstrainRatingId() {
		return strainRatingId;
	}

	public void setstrainRatingId(int strainRatingId) {
		this.strainRatingId = strainRatingId;
	}

	public Strain getStrain() {
		return strain;
	}

	public void setStrain(Strain strain) {
		this.strain = strain;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public StrainUse getStrainUse() {
		return strainUse;
	}

	public void setStrainUse(StrainUse strainUse) {
		this.strainUse = strainUse;
	}

	@Override
	public String toString() {
		return "StrainRating [strainRatingId=" + strainRatingId + ", strain=" + strain + ", user=" + user + ", rating="
				+ rating + "]";
	}
}