package com.herbtalk.repository;

import org.springframework.data.repository.CrudRepository;

import com.herbtalk.model.Race;


/**
 * This interface represents the Spring Data repository for the table "race".
 * 
 * @author zoheb.nawaz
 *
 */
public interface RaceRepository extends CrudRepository<Race, Integer> {

}
