package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.Comment;


/**
 * This interface represents the Spring Data repository for the table "comment".
 * 
 * @author zoheb.nawaz
 *
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query(value = "select * from comment where strain_use_id = :strainUseId", nativeQuery = true)
	Iterable<Comment> getCommentsOfUse(@Param("strainUseId") Integer strainUseId);

	@Transactional
	@Modifying
	@Query(value = "insert into comment (content, strain_use_id, user_id) values (:content, :strainUseId, :userId)", nativeQuery = true)
	void addComment(@Param("content") String content, @Param("strainUseId") Integer strainUseId,
			@Param("userId") Integer userId);
}
