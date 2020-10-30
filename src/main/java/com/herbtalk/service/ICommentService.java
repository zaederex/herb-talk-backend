package com.herbtalk.service;

import com.herbtalk.model.Comment;

/**
 * This class defines methods to support custom queries related to comments.
 * 
 * @author zoheb.nawaz
 *
 */
public interface ICommentService {

	/**
	 * Return all comments stored in the database.
	 * 
	 * @return list of comments
	 */
	Iterable<Comment> getAllComments();

	/**
	 * Add a comment to the database.
	 * 
	 * @param content     content of the comment
	 * @param strainUseId ID of the experience (strain use)
	 * @param userId      ID of the user posting the comment
	 */
	void addComment(String content, Integer strainUseId, Integer userId);
}
