package com.herbtalk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herbtalk.model.Gender;
import com.herbtalk.model.User;
import com.herbtalk.repository.UserRepository;
import com.herbtalk.util.EncryptionUtil;

/**
 * 
 * This class defines API end points for different queries related to user
 * details.
 * 
 * @author zoheb.nawaz
 * 
 */
@Controller
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" }, allowCredentials = "true")
@RequestMapping(path = "/api/user")
public class UserInfoController {

	@Autowired
	private UserRepository repository;

	/**
	 * Query the database to return all users.
	 * 
	 * @return list of users
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	/**
	 * Return info related to a user.
	 * 
	 * @param userId ID of the user
	 * @return user info
	 */
	@GetMapping(path = "/get/{userId}")
	public @ResponseBody Optional<User> getUser(@PathVariable Integer userId) {
		return repository.findById(userId);
	}

	/**
	 * Add a user to the database.
	 * 
	 * @param user_name  username
	 * @param password   password of the user
	 * @param first_name first name of the user
	 * @param last_name  last name of the user
	 * @param dob        date of birth of the user
	 * @param gender     gender of the user
	 * @return the resultant user object
	 */
	@PostMapping(value = "/add")
	public @ResponseBody User addNewUser(@RequestParam String user_name, @RequestParam String password,
			@RequestParam String first_name, @RequestParam String last_name, @RequestParam String dob,
			@RequestParam String gender) {
		User user = User.getBuilder().userName(user_name).password(password).firstName(first_name).lastName(last_name)
				.dob(dob).gender(Gender.getGenderByChar(gender)).build();
		repository.save(user);
		return user;
	}

	/**
	 * Delete the specified user from the database.
	 * 
	 * @param userId ID of the user to be deleted
	 * @return status of deletion
	 */
	@PostMapping(value = "/delete")
	public @ResponseBody String removeUser(@RequestParam Integer userId) {
		repository.deleteById(userId);
		return "User deleted";
	}

	/**
	 * Validate user details and return the user.
	 * 
	 * @param username user name of the user
	 * @param password password of the user
	 * @return user when credentials are correct, else null
	 */
	@PostMapping(value = "/login")
	public @ResponseBody User login(@RequestParam String username, @RequestParam String password) {
		Optional<User> user = repository.findByUserName(username);
		if (user.isPresent()) {
			if (EncryptionUtil.encrypt(password, "blowfish").equals(user.get().getPassword())) {
				return user.get();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Add a user to the database.
	 * 
	 * @param user_name  username
	 * @param password   password of the user
	 * @param first_name first name of the user
	 * @param last_name  last name of the user
	 * @param dob        date of birth of the user
	 * @param gender     gender of the user
	 * @return the resultant user object
	 */
	@PostMapping(value = "/register")
	public @ResponseBody User register(@RequestParam("userName") String username,
			@RequestParam("password") String password, @RequestParam("confPassword") String confirmPassword,
			@RequestParam("firstName") String first_name, @RequestParam("lastName") String last_name,
			@RequestParam("dob") String dob, @RequestParam("gender") String gender) {
		Optional<User> user = repository.findByUserName(username);
		if (user.isPresent()) {
			return null;
		} else {
			if (!password.equals(confirmPassword)) {
				return null;
			} else {
				return addNewUser(username, password, first_name, last_name, dob, gender);
			}
		}
	}
}