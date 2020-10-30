package com.herbtalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herbtalk.model.StrainLike;
import com.herbtalk.repository.StrainLikeRepository;
import com.herbtalk.service.IStrainLikeService;

/**
 * 
 * This class defines API end points for different queries related to different
 * strains stored in the database.
 * 
 * @author zoheb.nawaz
 * 
 */
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/like")
public class StrainLikeController {

	@Autowired
	private IStrainLikeService strainLikeService;

	@Autowired
	private StrainLikeRepository strainLikeRepo;

	/**
	 * Return a strain based on the strain ID.
	 * 
	 * @param strainId ID of the strain being searched
	 * @return strain associated with the specified ID
	 */
	@GetMapping(path = "/strain/{strainId}")
	public @ResponseBody Integer getStrainLikeCount(@PathVariable("strainId") Integer strainId) {
		return strainLikeService.getStrainLikeCount(strainId);
	}

	/**
	 * Return a like associated with a strain and user. Would help to track if a
	 * user has already liked a strain.
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the user
	 * @return tuple mapped by the strain and user
	 */
	@GetMapping(path = "/strain/liked/{strainId}")
	public @ResponseBody StrainLike isStrainLiked(@PathVariable("strainId") Integer strainId,
			@RequestParam("userId") Integer userId) {
		return strainLikeRepo.isLiked(strainId, userId);
	}

	/**
	 * Add a like to a strain by a user.
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the user
	 */
	@PostMapping(path = "/strain/{strainId}")
	public void likeStrain(@PathVariable("strainId") Integer strainId, @RequestParam("userId") Integer userId) {
		strainLikeService.likeStrain(strainId, userId);
	}

	/**
	 * Remove a like for a strain by a user.
	 * 
	 * @param strainId ID of the strain
	 * @param userId   ID of the user
	 */
	@DeleteMapping(path = "/strain/{strainId}")
	public void unlikeStrain(@PathVariable("strainId") Integer strainId, @RequestParam("userId") Integer userId) {
		strainLikeService.unlikeStrain(strainId, userId);
	}
}