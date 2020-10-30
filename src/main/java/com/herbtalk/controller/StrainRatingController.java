package com.herbtalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herbtalk.model.StrainRating;
import com.herbtalk.service.IStrainRatingService;

/**
 * 
 * This class defines API end points for different queries related to strain
 * ratings posted by the different users.
 * 
 * @author zoheb.nawaz
 * 
 */
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/rating")
public class StrainRatingController {

	@Autowired
	IStrainRatingService strainRatingService;

	/**
	 * Return the average of all ratings associated with the specified strain.
	 * 
	 * @param strainId ID of the strain
	 * @return average rating
	 */
	@GetMapping(path = "/strain/{strainId}")
	public @ResponseBody Double getAvgStrainRating(@PathVariable("strainId") Integer strainId) {
		return strainRatingService.getAvgStrainRating(strainId);
	}

	/**
	 * Return the rating associated with a specific use (experience) of a user.
	 * 
	 * @param strainUseId ID of the strain use
	 * @return rating
	 */
	@GetMapping(path = "/use/{strainUseId}")
	public @ResponseBody Integer getRatingOfUse(@PathVariable("strainUseId") Integer strainUseId) {
		return strainRatingService.getRatingOfUse(strainUseId);
	}

	/**
	 * Add a rating for a strain by the user.
	 * 
	 * @param strainId    ID of the strain
	 * @param userId      ID of the user
	 * @param strainUseId ID of the experience
	 * @param rating      rating to be added
	 * @return rating added
	 */
	@PostMapping(path = "/strain/{strainId}")
	public @ResponseBody StrainRating addStrainRating(@PathVariable("strainId") Integer strainId,
			@RequestParam("userId") Integer userId, @RequestParam("strainUseId") Integer strainUseId,
			@RequestBody Integer rating) {
		return strainRatingService.addStrainRating(strainId, userId, strainUseId, rating);
	}
}