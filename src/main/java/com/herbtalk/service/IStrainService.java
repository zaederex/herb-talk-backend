package com.herbtalk.service;

import java.util.Optional;
import java.util.Set;

import com.herbtalk.model.Strain;
import com.herbtalk.model.Symptom;

/**
 * This class defines methods to support custom queries related to strains.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IStrainService {
	/**
	 * Add a rating associated with a strain.
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the user
	 * @param rating   rating to be posted
	 */
	void addRating(Integer strainId, Integer userId, Integer rating);

	/**
	 * Get all strains stored in the database.
	 * 
	 * @return list of strain
	 */
	Iterable<Strain> getAllStrains();

	/**
	 * Get all strains containing the passed name.
	 * 
	 * @param name string that needs to be present in the strain name
	 * @return list of strains that match the pattern
	 */
	Iterable<Strain> queryStrainName(String name);

	/**
	 * Get a particular strain from the database.
	 * 
	 * @param strainId ID of the strain.
	 * @return strain if present
	 */
	Optional<Strain> getStrainById(Integer strainId);

	/**
	 * Get all symptoms associated with a strain.
	 * 
	 * @param strainId ID of the strain
	 * @return set of symptoms
	 */
	Set<Symptom> getEffects(Integer strainId);
}
