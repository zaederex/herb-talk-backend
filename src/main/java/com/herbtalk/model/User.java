package com.herbtalk.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.herbtalk.util.EncryptionUtil;

/**
 * This class represents a user of the application. It maps to the table "user"
 * in the database. It provides getters and setters for the different attributes
 * associated with the user.
 * 
 * @author zoheb.nawaz
 *
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	@JsonIgnoreProperties
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private Set<StrainUse> usedStrains;

	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private Set<VendorRating> ratings;

	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private Set<Comment> comments;

	public User() {
		this.userName = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.dob = null;
		this.gender = null;
		this.usedStrains = new HashSet<StrainUse>();
	}

	private User(String userName, String password, String firstName, String lastName, LocalDate dob, Gender gender) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.usedStrains = new HashSet<StrainUse>();
	}

	public static UserBuilder getBuilder() {
		return new UserBuilder();
	}

	public static class UserBuilder {
		private String userName;
		private String password;
		private String firstName;
		private String lastName;
		private LocalDate dob;
		private Gender gender;

		public UserBuilder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public UserBuilder password(String password) {
			try {
				this.password = EncryptionUtil.encrypt(password, "blowfish");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder dob(String dob) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
			this.dob = LocalDate.parse(dob, formatter);
			return this;
		}

		public UserBuilder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public User build() {
			return new User(userName, password, firstName, lastName, dob, gender);
		}
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<StrainUse> getUsedStrains() {
		return usedStrains;
	}

	public Set<VendorRating> getRatings() {
		return ratings;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setUsedStrains(Set<StrainUse> usedStrains) {
		this.usedStrains = usedStrains;
	}

	public void setRatings(Set<VendorRating> ratings) {
		this.ratings = ratings;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
}