package com.herbtalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.herbtalk.model.Comment;
import com.herbtalk.repository.CommentRepository;

/**
 * 
 * This class implements the interface ICommentService.
 * 
 * @author zoheb.nawaz
 *
 */
@Repository
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepository repository;

	@Override
	public Iterable<Comment> getAllComments() {
		return repository.findAll();
	}

	@Override
	public void addComment(String content, Integer strainUseId, Integer userId) {
		repository.addComment(content, strainUseId, userId);
	}
}
