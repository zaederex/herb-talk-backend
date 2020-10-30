package com.herbtalk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class represents the race of a strain. It maps to the table "race" in
 * the database. It provides getters and setters for the different attributes
 * associated with the race of a strain.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "race")
public class Race {

	@Id
	@Column(name = "race_id")
	private int raceID;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "race")
	@JsonBackReference
	private Set<Strain> strain;

	public Race() {
		super();
	}

	public Race(int raceID, String name, Set<Strain> strain) {
		super();
		this.raceID = raceID;
		this.name = name;
		this.strain = strain;
	}

	public int getRaceID() {
		return raceID;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Strain> getStrain() {
		return strain;
	}

	public void setStrain(Set<Strain> strain) {
		this.strain = strain;
	}

	@Override
	public String toString() {
		return "Race [raceID=" + raceID + ", name=" + name + ", strain=" + strain + "]";
	}

}
