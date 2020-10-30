package com.herbtalk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents the Strain of marijuana. It maps to the join table
 * "strain" in the database. It provides getters and setters for the different
 * attributes associated with the strains.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "strain")
public class Strain {

	@Id
	@Column(name = "strain_id")
	private int strainId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "strain")
	@JsonBackReference
	private Set<StrainUse> usedStrains;

	@ManyToOne
	@JoinColumn(name = "race_id", nullable = false)
	@JsonManagedReference
	private Race race;

	@ManyToMany
	@JoinTable(name = "strain_has_flavor", joinColumns = @JoinColumn(name = "strain_id"), inverseJoinColumns = @JoinColumn(name = "flavor_id"))
	@JsonManagedReference
	private Set<Flavor> flavors;

	@ManyToMany
	@JoinTable(name = "known_symptom", joinColumns = @JoinColumn(name = "strain_id"), inverseJoinColumns = @JoinColumn(name = "symptom_id"))
	@JsonManagedReference
	private Set<Symptom> symptoms;

	@ManyToMany(mappedBy = "strainsSold")
	@JsonBackReference
	private Set<Vendor> vendorSet;

	@OneToMany(mappedBy = "strain")
	private Set<StrainLike> strainLikes;

	@Column(name = "description")
	private String description;

	public Strain() {
		super();
	}

	public Strain(int strainId, Race race, Set<Flavor> flavors, Set<Symptom> symptoms, String description,
			Set<StrainLike> strainLikes) {
		super();
		this.strainId = strainId;
		this.race = race;
		this.flavors = flavors;
		this.symptoms = symptoms;
		this.description = description;
		this.strainLikes = strainLikes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getstrainId() {
		return strainId;
	}

	public void setstrainId(int strainId) {
		this.strainId = strainId;
	}

	public Set<StrainUse> getUsedStrains() {
		return usedStrains;
	}

	public void setUsedStrains(Set<StrainUse> usedStrains) {
		this.usedStrains = usedStrains;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Set<Flavor> getFlavors() {
		return flavors;
	}

	public void setFlavors(Set<Flavor> flavors) {
		this.flavors = flavors;
	}

	public Set<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public Set<Vendor> getVendorSet() {
		return vendorSet;
	}

	public void setVendorSet(Set<Vendor> vendorSet) {
		this.vendorSet = vendorSet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStrainLikes(Set<StrainLike> strainLikes) {
		this.strainLikes = strainLikes;
	}

	public Set<StrainLike> getStrainLikes() {
		return strainLikes;
	}

	@Override
	public String toString() {
		return "Strain [strainId=" + strainId + ", usedStrains=" + usedStrains + ", race=" + race + ", flavors="
				+ flavors + ", symptoms=" + symptoms + ", vendorSet=" + vendorSet + ", description=" + description
				+ "]";
	}
}