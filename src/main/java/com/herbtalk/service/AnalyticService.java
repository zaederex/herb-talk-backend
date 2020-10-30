package com.herbtalk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.herbtalk.model.Comment;
import com.herbtalk.model.Strain;
import com.herbtalk.model.StrainLike;
import com.herbtalk.model.StrainMapper;
import com.herbtalk.model.StrainRating;
import com.herbtalk.model.User;
import com.herbtalk.model.UserMapper;
import com.herbtalk.repository.CommentRepository;
import com.herbtalk.repository.StrainLikeRepository;
import com.herbtalk.repository.StrainRatingRepository;

/**
 * 
 * This class implements the interface IAnalyticalService.
 * 
 * @author zoheb.nawaz
 *
 */
@Repository
public class AnalyticService implements IAnalyticalService {

	@Autowired
	private StrainLikeRepository strainLikeRepo;

	@Autowired
	private StrainRatingRepository strainRatingRepo;

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public List<UserMapper> getMostLikingUsers() {
		Map<User, Integer> userMap = new HashMap<>();
		Iterable<StrainLike> strainLikes = strainLikeRepo.findAll();
		for (StrainLike like : strainLikes) {
			User currentUser = like.getUser();
			if (userMap.containsKey(currentUser)) {
				userMap.put(currentUser, userMap.get(currentUser) + 1);
			} else {
				userMap.put(currentUser, 1);
			}
		}
		List<UserMapper> mapperList = new ArrayList<>();
		userMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> mapperList.add(new UserMapper(x.getKey(), x.getValue())));
		return mapperList;
	}

	@Override
	public List<UserMapper> getMostRatingUsers() {
		Map<User, Integer> userMap = new HashMap<>();
		Iterable<StrainRating> strainRatings = strainRatingRepo.findAll();
		for (StrainRating rating : strainRatings) {
			User currentUser = rating.getUser();
			if (userMap.containsKey(currentUser)) {
				userMap.put(currentUser, userMap.get(currentUser) + 1);
			} else {
				userMap.put(currentUser, 1);
			}
		}
		List<UserMapper> mapperList = new ArrayList<>();
		userMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> mapperList.add(new UserMapper(x.getKey(), x.getValue())));
		return mapperList;
	}

	@Override
	public List<UserMapper> getMostCommentingUsers() {
		Map<User, Integer> userMap = new HashMap<>();
		Iterable<Comment> comments = commentRepo.findAll();
		for (Comment comment : comments) {
			User currentUser = comment.getUser();
			if (userMap.containsKey(currentUser)) {
				userMap.put(currentUser, userMap.get(currentUser) + 1);
			} else {
				userMap.put(currentUser, 1);
			}
		}
		List<UserMapper> mapperList = new ArrayList<>();
		userMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> mapperList.add(new UserMapper(x.getKey(), x.getValue())));
		return mapperList;
	}

	@Override
	public List<StrainMapper> getMostLikedStrains() {
		Map<Strain, Double> strainMap = new HashMap<>();

		Iterable<StrainLike> strainLikes = strainLikeRepo.findAll();
		for (StrainLike like : strainLikes) {
			Strain currentStrain = like.getStrain();
			if (strainMap.containsKey(currentStrain)) {
				strainMap.put(currentStrain, strainMap.get(currentStrain) + 1);
			} else {
				strainMap.put(currentStrain, (double) 1);
			}
		}
		List<StrainMapper> mapperList = new ArrayList<>();
		strainMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> mapperList.add(new StrainMapper(x.getKey(), x.getValue())));
		return mapperList;
	}

	@Override
	public List<StrainMapper> getHighestRatedStrains() {
		Iterable<StrainRating> strains = strainRatingRepo.findAll();
		Map<Strain, Double> strainMap = new HashMap<>();

		for (StrainRating rating : strains) {
			if (!strainMap.containsKey(rating.getStrain())) {
				strainMap.put(rating.getStrain(),
						strainRatingRepo.getAvgStrainRating(rating.getStrain().getstrainId()));
			}

		}

		List<StrainMapper> mapperList = new ArrayList<>();
		strainMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> mapperList.add(new StrainMapper(x.getKey(), x.getValue())));
		return mapperList;
	}
}