/**
 * 
 */
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
 * This class represents the confirmation mappings between strains and flavors.
 * It maps to the join table "flavor_confirmation" in the database. It provides
 * getters and setters for the different attributes associated with the flavor
 * confirmations.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "flavor_confirmation")
public class FlavorConfirmation {

	@Id
	@Column(name = "flavor_confirmation_id")
	private int flavorConfirmationID;

	@ManyToOne
	@JoinColumn(name = "strain_use_id")
	@JsonBackReference
	private StrainUse strainUse;

	@ManyToOne
	@JoinColumn(name = "flavor_id")
	@JsonManagedReference
	private Flavor flavor;

	@Column(columnDefinition = "TINYINT(4)", name = "confirmation")
	private boolean confirmation;

	public FlavorConfirmation() {
		super();
	}

	public FlavorConfirmation(int confirmationID, StrainUse strainUse, Flavor flavor, boolean confirmation) {
		super();
		this.flavorConfirmationID = confirmationID;
		this.strainUse = strainUse;
		this.flavor = flavor;
		this.confirmation = confirmation;
	}

	public int getFlavorConfirmationID() {
		return flavorConfirmationID;
	}

	public void setFlavorConfirmationID(int confirmationID) {
		this.flavorConfirmationID = confirmationID;
	}

	public StrainUse getStrainUse() {
		return strainUse;
	}

	public void setStrainUse(StrainUse strainUse) {
		this.strainUse = strainUse;
	}

	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "Confirmation [confirmationID=" + flavorConfirmationID + ", strainUse=" + strainUse + ", symptom="
				+ flavor + ", confirmation=" + confirmation + "]";
	}
}