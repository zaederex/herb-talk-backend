package com.herbtalk.service;

import com.herbtalk.model.FlavorConfirmation;

/**
 * This class defines methods to support custom queries related to flavor
 * confirmations.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IFlavorConfirmationService {

	/**
	 * Return all flavor confirmations stored in the database.
	 * 
	 * @return list of all flavor confirmations
	 */
	Iterable<FlavorConfirmation> getAllConfirmations();

	/**
	 * Get all flavor confirmations associated with a strain
	 * 
	 * @param strainID ID of the strain
	 * @return list of all flavor confirmations
	 */
	Iterable<FlavorConfirmation> getFlavorConfirmationsForAStrain(Integer strainID);

	/**
	 * Add a flavor confirmation to the database.
	 * 
	 * @param strainUseId  ID of the experience
	 * @param flavorId     ID of the flavor
	 * @param confirmation true for positive confirmation, else false
	 */
	void addConfirmation(Integer strainUseId, Integer flavorId, boolean confirmation);
}