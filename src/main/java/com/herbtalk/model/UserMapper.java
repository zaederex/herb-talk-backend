package com.herbtalk.model;

/**
 * This class represents the mapper associated with various aggregation queries
 * related to users.
 * 
 * @author zoheb.nawaz
 *
 */
public class UserMapper {

	private User user;
	private Integer count;

	public UserMapper() {
		super();
	}

	public UserMapper(User user, Integer count) {
		super();
		this.user = user;
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public Integer getCount() {
		return count;
	}
}
