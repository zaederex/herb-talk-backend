package com.herbtalk.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents an experience related to a strain posted by a user for
 * a strain. It maps to the table "strain_use" in the database. It provides
 * getters and setters for the different attributes associated with the
 * experience.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "strain_use")
public class StrainUse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "strain_use_id")
	private int strainUseId;

	@ManyToOne
	@JoinColumn(name = "strain_id")
	@JsonManagedReference
	private Strain strain;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	@Column(name = "description")
	private String description;

	@OneToOne(mappedBy = "strainUse")
	@JsonManagedReference
	private StrainRating strainRating;

	@OneToMany(mappedBy = "strainUse")
	@JsonManagedReference
	private Set<Confirmation> confirmations;

	@OneToMany(mappedBy = "strainUse")
	@JsonManagedReference
	private Set<FlavorConfirmation> flavorConfirmations;

	@OneToMany(mappedBy = "strainUse")
	@JsonManagedReference
	private Set<Comment> comments;

	public StrainUse() {
		super();
	}

	public StrainUse(int strainUseId, Strain strain, User user, StrainRating strainRating,
			Set<Confirmation> confirmations, Set<FlavorConfirmation> flavorConfirmations, String description,
			Set<Comment> comments) {
		super();
		this.strainUseId = strainUseId;
		this.strain = strain;
		this.user = user;
		this.confirmations = confirmations;
		this.strainRating = strainRating;
		this.description = description;
		this.flavorConfirmations = flavorConfirmations;
		this.comments = comments;
	}

	public int getStrainUseId() {
		return strainUseId;
	}

	public void setStrainUseId(int strainUseId) {
		this.strainUseId = strainUseId;
	}

	public Set<Comment> getComments() {
		return new HashSet<Comment>(comments);
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
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

	public Set<Confirmation> getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(Set<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}

	public Set<FlavorConfirmation> getFlavorConfirmations() {
		return flavorConfirmations;
	}

	public void setFlavorConfirmations(Set<FlavorConfirmation> flavorConfirmations) {
		this.flavorConfirmations = flavorConfirmations;
	}

	public StrainRating getStrainRating() {
		return strainRating;
	}

	public void setStrainRating(StrainRating strainRating) {
		this.strainRating = strainRating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "StrainUse [strainUseId=" + strainUseId + ", strain=" + strain + ", user=" + user + ", confirmations="
				+ confirmations + "]";
	}
}