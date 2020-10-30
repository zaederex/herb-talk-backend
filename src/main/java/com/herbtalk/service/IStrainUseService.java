package com.herbtalk.service;

import com.herbtalk.model.StrainUse;

/**
 * This class defines methods to support custom queries related to strain use
 * (experiences).
 * 
 * @author zoheb.nawaz
 *
 */
public interface IStrainUseService {

	/**
	 * Get all user experiences.
	 * 
	 * @param strainId ID of the strain
	 * @return list of user experiences
	 */
	Iterable<StrainUse> getStrainUses(Integer strainId);

	/**
	 * Add a user experience to the database.
	 * 
	 * @param description comment describing the experience
	 * @param strainId    ID of the strain
	 * @param userId      ID of the user
	 * @return added strain use
	 */
	StrainUse addUse(String description, Integer strainId, Integer userId);
}
