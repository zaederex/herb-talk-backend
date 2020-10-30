package com.herbtalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents the Comments posted by different users on a user
 * experience. It maps to the "comment" table in the database. It provides
 * getters and setters for the different attributes associated with the
 * comments.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "comment_id")
	private int commentId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "strain_use_id")
	@JsonBackReference
	private StrainUse strainUse;

	@Column(name = "content")
	private String content;

	public Comment() {
		super();
	}

	public Comment(int commentId, User user, StrainUse strain, String content) {
		super();
		this.commentId = commentId;
		this.user = user;
		this.strainUse = strain;
		this.content = content;
	}

	public int getcommentId() {
		return commentId;
	}

	public void setcommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StrainUse getStrainUse() {
		return strainUse;
	}

	public void setStrainUse(StrainUse strainUse) {
		this.strainUse = strainUse;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", user=" + user + ", strain=" + strainUse + ", content=" + content
				+ "]";
	}
}