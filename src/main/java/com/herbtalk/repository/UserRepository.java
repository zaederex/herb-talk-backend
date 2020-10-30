package com.herbtalk.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herbtalk.model.User;


/**
 * This interface represents the Spring Data repository for the table "user".
 * 
 * @author zoheb.nawaz
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String username);
}
