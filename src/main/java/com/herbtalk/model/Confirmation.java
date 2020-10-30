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
 * This class represents the confirmation mappings between strains and symptoms.
 * It maps to the join table "confirmation" in the database. It provides getters
 * and setters for the different attributes associated with the confirmations.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "Confirmation")
public class Confirmation {

	@Id
	@Column(name = "confirmation_id")
	private int confirmationID;

	@ManyToOne
	@JoinColumn(name = "strain_use_id")
	@JsonBackReference
	private StrainUse strainUse;

	@ManyToOne
	@JoinColumn(name = "symptom_id")
	@JsonManagedReference
	private Symptom symptom;

	@Column(columnDefinition = "TINYINT(4)", name = "confirmation")
	private boolean confirmation;

	public Confirmation() {
		super();
	}

	public Confirmation(int confirmationID, StrainUse strainUse, Symptom symptom, boolean confirmation) {
		super();
		this.confirmationID = confirmationID;
		this.strainUse = strainUse;
		this.symptom = symptom;
		this.confirmation = confirmation;
	}

	public int getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(int confirmationID) {
		this.confirmationID = confirmationID;
	}

	public StrainUse getStrainUse() {
		return strainUse;
	}

	public void setStrainUse(StrainUse strainUse) {
		this.strainUse = strainUse;
	}

	public Symptom getSymptom() {
		return symptom;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "Confirmation [confirmationID=" + confirmationID + ", strainUse=" + strainUse + ", symptom=" + symptom
				+ ", confirmation=" + confirmation + "]";
	}
}
