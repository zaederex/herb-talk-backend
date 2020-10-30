package com.herbtalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents a like posted by a user for a strain. It maps to the
 * table "strain_like" in the database. It provides getters and setters for the
 * different attributes associated with the likes.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "strain_like")
public class StrainLike {

	@Id
	@Column(name = "strain_like_id")
	private int strainLikeId;

	@ManyToOne
	@JoinColumn(name = "strain_id", insertable = false, updatable = false)
	@JsonBackReference
	private Strain strain;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@JsonBackReference
	private User user;

	public StrainLike() {
		super();
	}

	public StrainLike(User user, Strain strain) {
		super();
		this.user = user;
		this.strain = strain;
	}

	public int getStrainLikeId() {
		return strainLikeId;
	}

	public void setStrainLikeId(int strainLikeId) {
		this.strainLikeId = strainLikeId;
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
}
