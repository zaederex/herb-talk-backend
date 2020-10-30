package com.herbtalk.service;

import java.util.List;

import com.herbtalk.model.StrainMapper;
import com.herbtalk.model.UserMapper;

/**
 * This class defines methods to support various analytical queries.
 * 
 * @author zoheb.nawaz
 *
 */
public interface IAnalyticalService {

	/**
	 * Return a list of mapping objects of users with most likes and the number of
	 * likes posted by them.
	 * 
	 * @return list of mapping object
	 */
	List<UserMapper> getMostLikingUsers();

	/**
	 * Return a list of mapping objects of users with most ratings and the number of
	 * ratings posted by them.
	 * 
	 * @return list of mapping object
	 */
	List<UserMapper> getMostRatingUsers();

	/**
	 * Return a list of mapping objects of users with most comments and the number
	 * of comments posted by them.
	 * 
	 * @return list of mapping object
	 */
	List<UserMapper> getMostCommentingUsers();

	/**
	 * Return a list of mapping objects of strains with most likes and the number of
	 * likes associated.
	 * 
	 * @return list of mapping object
	 */
	List<StrainMapper> getMostLikedStrains();

	/**
	 * Return a list of mapping objects of strains with highest average ratings and
	 * the average ratings.
	 * 
	 * @return list of mapping object
	 */
	List<StrainMapper> getHighestRatedStrains();
}
