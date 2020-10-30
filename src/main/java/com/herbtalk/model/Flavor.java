package com.herbtalk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents the flavor associated with strains. It maps to the
 * table "flavor" in the database. It provides getters and setters for the
 * different attributes associated with the flavors.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "flavor")
public class Flavor {

	@Id
	@Column(name = "flavor_id")
	private int flavorId;

	@ManyToMany(mappedBy = "flavors")
	@JsonBackReference
	private Set<Strain> strains;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "flavor")
	@JsonBackReference
	private Set<FlavorConfirmation> flavorConfirmations;

	public Flavor() {
		super();
	}

	public Flavor(int flavorId, Set<Strain> strains, String name) {
		super();
		this.flavorId = flavorId;
		this.strains = strains;
		this.name = name;
	}

	public int getflavorId() {
		return flavorId;
	}

	public void setflavorId(int flavorId) {
		this.flavorId = flavorId;
	}

	public Set<Strain> getStrains() {
		return strains;
	}

	public void setStrains(Set<Strain> strains) {
		this.strains = strains;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FlavorConfirmation> getFlavorConfirmations() {
		return flavorConfirmations;
	}

	public void setFlavorConfirmations(Set<FlavorConfirmation> confirmations) {
		this.flavorConfirmations = confirmations;
	}

	@Override
	public String toString() {
		return "Flavor [flavorId=" + flavorId + ", strains=" + strains + ", name=" + name + "]";
	}
}