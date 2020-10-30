package com.herbtalk.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herbtalk.model.StrainMapper;
import com.herbtalk.model.UserMapper;
import com.herbtalk.service.IAnalyticalService;

/**
 * 
 * This class defines API end points for different analytical queries such as
 * determining most active users based on likes, comments and ratings and most
 * popular strains based on average rating and total number of likes.
 * 
 * @author zoheb.nawaz
 * 
 */
@Controller
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/analysis")
public class AnalysisController {

	@Autowired
	IAnalyticalService service;

	/**
	 * Return top 5 users based on number of likes.
	 * 
	 * @return most active users in terms of strain likes
	 */
	@GetMapping(path = "/userlikes")
	public @ResponseBody Iterable<UserMapper> getMostLikingUsers() {
		List<UserMapper> list = service.getMostLikingUsers();
		List<UserMapper> returnList = new LinkedList<>();
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		} else {
			for (int i = 0; i < 5; i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		}
	}

	/**
	 * Return top 5 users based on number of ratings.
	 * 
	 * @return most active users in terms of strain ratings
	 */
	@GetMapping(path = "/userratings")
	public @ResponseBody Iterable<UserMapper> getMostRatingsUsers() {
		List<UserMapper> list = service.getMostRatingUsers();
		List<UserMapper> returnList = new LinkedList<>();
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		} else {
			for (int i = 0; i < 5; i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		}
	}

	/**
	 * Return top 5 users based on number of comments posted.
	 * 
	 * @return most active users in terms of comments
	 */
	@GetMapping(path = "/usercomments")
	public @ResponseBody Iterable<UserMapper> getMostCommentsUsers() {
		List<UserMapper> list = service.getMostCommentingUsers();
		List<UserMapper> returnList = new LinkedList<>();
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		} else {
			for (int i = 0; i < 5; i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		}
	}

	/**
	 * Return top 5 strains based on number of likes.
	 * 
	 * @return most liked strains
	 */
	@GetMapping(path = "/strainlikes")
	public @ResponseBody Iterable<StrainMapper> getMostLikedStrains() {
		List<StrainMapper> list = service.getMostLikedStrains();
		List<StrainMapper> returnList = new LinkedList<>();
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		} else {
			for (int i = 0; i < 5; i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		}
	}

	/**
	 * Return top 5 strains based on average rating.
	 * 
	 * @return highest rated strains
	 */
	@GetMapping(path = "/strainratings")
	public @ResponseBody Iterable<StrainMapper> getHighestRatedStrains() {
		List<StrainMapper> list = service.getHighestRatedStrains();
		List<StrainMapper> returnList = new LinkedList<>();
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		} else {
			for (int i = 0; i < 5; i++) {
				returnList.add(list.get(list.size() - i - 1));
			}
			return returnList;
		}
	}
}