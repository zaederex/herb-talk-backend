package com.herbtalk.service;

/**
 * This class defines methods to support custom queries related to strain likes.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IStrainLikeService {

	/**
	 * Return number of likes associated with a strain.
	 * 
	 * @param strainId ID of the strain
	 * @return number of likes associated with the strain
	 */
	Integer getStrainLikeCount(Integer strainId);

	/**
	 * Like a strain.
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the liker
	 */
	void likeStrain(Integer strainId, Integer userId);

	/**
	 * Unlike a strain
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the unliker
	 */
	void unlikeStrain(Integer strainId, Integer userId);
}
