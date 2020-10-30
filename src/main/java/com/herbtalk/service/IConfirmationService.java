package com.herbtalk.service;

import com.herbtalk.model.Confirmation;

/**
 * This class defines methods to support custom queries related to symptom
 * confirmations.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IConfirmationService {

	/**
	 * Get all confirmations stored in the database.
	 * 
	 * @return list of confirmations
	 */
	Iterable<Confirmation> getAllConfirmations();

	/**
	 * Return a list of all confirmation associated with a given strain.
	 * 
	 * @param strainID ID of the strain
	 * @return list of confirmations
	 */
	Iterable<Confirmation> getConfirmationsForStrain(Integer strainID);

	/**
	 * Add a symptom confirmation for a given strain use (experience).
	 * 
	 * @param strainUseId  ID of the experience
	 * @param userId       ID of the user
	 * @param confirmation true if positive confirmation, else false
	 * @param symptomId    ID of the symptom
	 */
	void addConfirmation(Integer strainUseId, Integer userId, boolean confirmation, Integer symptomId);
}