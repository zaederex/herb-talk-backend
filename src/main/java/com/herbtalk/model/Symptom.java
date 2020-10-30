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
 * This class represents a symptom associated with a strain. It maps to the
 * table "symptom" in the database. It provides getters and setters for the
 * different attributes associated with the symptom.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "symptom")
public class Symptom {

	@Id
	@Column(name = "symptom_id")
	private int symptomId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@ManyToMany(mappedBy = "symptoms")
	@JsonBackReference
	private Set<Strain> strainSet;

	@OneToMany(mappedBy = "symptom")
	@JsonBackReference
	private Set<Confirmation> confirmations;

	public Symptom() {
		super();
	}

	public Symptom(int symptomId, String name, String type, Set<Strain> strainSet, Set<Confirmation> confirmations) {
		super();
		this.symptomId = symptomId;
		this.name = name;
		this.type = type;
		this.strainSet = strainSet;
		this.confirmations = confirmations;
	}

	public int getsymptomId() {
		return symptomId;
	}

	public void setsymptomId(int symptomId) {
		this.symptomId = symptomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Strain> getStrainSet() {
		return strainSet;
	}

	public void setStrainSet(Set<Strain> strainSet) {
		this.strainSet = strainSet;
	}

	public Set<Confirmation> getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(Set<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}

	@Override
	public String toString() {
		return "Symptom [symptomId=" + symptomId + ", name=" + name + ", type=" + type + ", strainSet=" + strainSet
				+ ", confirmations=" + confirmations + "]";
	}
}