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

import com.herbtalk.model.Comment;
import com.herbtalk.repository.CommentRepository;
import com.herbtalk.service.ICommentService;

/**
 * 
 * This class defines API end points for different queries related to comments
 * posted on different experiences by different users.
 * 
 * @author zoheb.nawaz
 * 
 */
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/comment")
public class CommentController {

	@Autowired
	private ICommentService service;

	@Autowired
	private CommentRepository CommentRepository;

	/**
	 * Return all entries part of the comment table.
	 * 
	 * @return all comments stored in the database
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Comment> getAllComments() {
		return service.getAllComments();
	}

	/**
	 * Return all comments associated with the specified strain use (experience).
	 * 
	 * @param strainUseId ID of the strain use
	 * @return all comments associated with the given strain ID
	 */
	@GetMapping(path = "/use/{strainUseId}")
	public @ResponseBody Iterable<Comment> getCommentsOfStrainUse(@PathVariable("strainUseId") Integer strainUseId) {
		return CommentRepository.getCommentsOfUse(strainUseId);
	}

	/**
	 * Post a comment related to a specific strain use.
	 * 
	 * @param strainUseId ID of the strain
	 * @param userId      ID of the user posting the comment
	 * @param content     the content of the comment
	 */
	@PostMapping(path = "/{strainUseId}")
	public void addComment(@RequestBody String content, @PathVariable("strainUseId") Integer strainUseId,
			@RequestParam("userId") Integer userId) {
		service.addComment(content, strainUseId, userId);
	}
}