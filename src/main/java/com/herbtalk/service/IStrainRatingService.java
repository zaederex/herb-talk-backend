package com.herbtalk.service;

import com.herbtalk.model.StrainRating;

/**
 * This class defines methods to support custom queries related to strain
 * ratings.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IStrainRatingService {
	/**
	 * Returns average of all rating given for a strain.
	 * 
	 * @param strainId ID of the strain
	 * @return average user rating
	 */
	Double getAvgStrainRating(Integer strainId);

	/**
	 * Return rating associated with a specific user exeperience.
	 * 
	 * @param strainUseId ID of the user experience
	 * @return rating
	 */
	Integer getRatingOfUse(Integer strainUseId);

	/**
	 * Add a rating posted by a user for a strain
	 * 
	 * @param strainId ID of the strain
	 * @param userId ID of the user
	 * @param strainUseId ID of the experience
	 * @param rating rating posted by the user
	 * @return
	 */
	StrainRating addStrainRating(Integer strainId, Integer userId, Integer strainUseId, Integer rating);
}